package org.apache.bookkeeper.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.bookkeeper.client.api.LedgerEntries;
import org.apache.bookkeeper.common.concurrent.FutureUtils;
import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.meta.LedgerManager;
import org.apache.bookkeeper.proto.checksum.DigestManager;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LedgerHandleTest extends BookKeeperClusterTestCase {

    static final Logger LOG = LoggerFactory.getLogger(LedgerHandleTest.class);

    public LedgerHandleTest() {
        super(3, 5);
    }

    private static Stream<Arguments> provideDataCreateLedgerTest() {
        byte[] password = "password".getBytes(); // Meaningful password
        byte[] emptyPassword = new byte[]{};
        return Stream.of(
                Arguments.of(BookKeeper.DigestType.MAC, emptyPassword), // Empty password
                Arguments.of(BookKeeper.DigestType.MAC, password), // password
                Arguments.of(BookKeeper.DigestType.CRC32, emptyPassword),
                Arguments.of(BookKeeper.DigestType.CRC32, password),
                Arguments.of(BookKeeper.DigestType.CRC32C, emptyPassword),
                Arguments.of(BookKeeper.DigestType.CRC32C, password),
                Arguments.of(BookKeeper.DigestType.DUMMY, emptyPassword),
                Arguments.of(BookKeeper.DigestType.DUMMY, password)
        );
    }

    private static Stream<Arguments> provideInvalidDataCreateLedgerTest() {
        return Stream.of(
                Arguments.of(BookKeeper.DigestType.MAC, null),
                Arguments.of(BookKeeper.DigestType.CRC32, null),
                Arguments.of(BookKeeper.DigestType.CRC32C, null),
                Arguments.of(BookKeeper.DigestType.DUMMY, null)
        );
    }

    private static Stream<Arguments> provideDataAsyncCloseTest() {
        final CompletableFuture<Void> closePromise = new CompletableFuture<>();
        AsyncCallback.CloseCallback cb = (rc, lh, ctx) -> {
            if (BKException.Code.OK != rc) {
                FutureUtils.completeExceptionally(closePromise, BKException.create(rc));
            } else {
                FutureUtils.complete(closePromise, null);
            }
        };
        String strCtx = "Test String";
        return Stream.of(
                // CloseCallback, ctx
                Arguments.of(cb, null), // cb "valid", null
                Arguments.of(cb, 0), // primitive
                Arguments.of(cb, strCtx), // String
                Arguments.of(null, null) // it works without cb
        );
    }

    private static Stream<Arguments> provideDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(0L, 0L), // Reads only the first entry
                Arguments.of(1L, 2L), // Reads entries with ID 1 and 2
                Arguments.of(0L, 99L), // Reads all entries
                Arguments.of(99L, 99L) // Reads only the last entry
        );
    }

    private static Stream<Arguments> provideInvalidDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(-1L, 1L), // Exception (invalid value for `firstEntry`)
                Arguments.of(0L, -1L), // Exception (invalid value for `lastEntry`)
                Arguments.of(2L, 1L),  // Exception (invalid value for `firstEntry` > `lastEntry`)
                Arguments.of(0L, 100L),  // Exception (invalid value for `lastEntry`)
                Arguments.of(100L, 99L)   // Exception (invalid value for `firstEntry`)
        );
    }

    private static Stream<Arguments> provideDataBatchReadEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, expectedEntries, batchReadEnabled
                Arguments.of(0L, 0, defaultSize, 100, true),
                // Arguments.of(0L, 0, defaultSize, 0, false), // only startEntry or all entries?
                Arguments.of(1L, 3, defaultSize, 3, true), // entries with ID 1, 2, 3
                Arguments.of(1L, 3, defaultSize, 3, false),
                Arguments.of(99, 2, defaultSize, 1, true), // only entries ID 4
                Arguments.of(99L, 2, defaultSize, 1, false),
                Arguments.of(0L, 101, defaultSize, 100, true), // all entries
                Arguments.of(0L, 101, defaultSize, 100, false),
                Arguments.of(0L, 100, -1L, 100, true), // default `maxSize` -> all entries
                Arguments.of(0L, 100, -1L, 100, false),
                Arguments.of(0L, 100, 0L, 100, true),
                Arguments.of(0L, 100, 0L, 100, false),
                Arguments.of(0L, 100, 1L, 1, true), // if maxSize < entrySize -> only startEntry
                Arguments.of(0L, 100, 1L, 100, false), // all entries
                Arguments.of(2L, 100, defaultSize, 98, true), // entries with ID 2, 3, 4
                Arguments.of(2L, 100, defaultSize, 98, false),
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, true), // maxSize > default
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, false)
        );
    }

    private static Stream<Arguments> provideInvalidDataBatchReadEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, expectedEntries, batchReadEnabled
                //Arguments.of(-1L, 1, defaultSize, 0, true, true), // Exception (valore non valido per `startEntry`)
                // Arguments.of(-1L, 1, defaultSize, 0, true, false),
                Arguments.of(100L, 1, defaultSize, 0, true), // startEntry > lastEntry -> exception
                Arguments.of(100L, 1, defaultSize, 0, false)
        );
    }

    private static Stream<Arguments> provideDataBatchReadEntriesNoEntriesTest() {
        return Stream.of(
                Arguments.of(true),
                Arguments.of(false)
        );
    }

    private static Stream<byte[]> provideDataAddEntry1Test() {
        byte[] emptyData = new byte[]{};
        byte[] testData = "Test String".getBytes();
        return Stream.of(
                emptyData,
                testData
        );
    }

    private static Stream<Arguments> provideDataAddEntry2Test() {
        byte[] emptyData = new byte[]{};
        byte[] testData = "Test String".getBytes();

        return Stream.of(
                Arguments.of(emptyData, 0, 0), // Test with an empty array
                Arguments.of(testData, 0, testData.length), // Test with meaningful data
                Arguments.of(testData, 0, 5), // Test with an initial portion
                Arguments.of(testData, 5, testData.length - 5), // Test with a final portion
                Arguments.of(testData, 3, 4) // Test with an intermediate portion
        );
    }

    private static Stream<Arguments> provideInvalidDataAddEntry2Test() {
        byte[] data = "Test data".getBytes();

        return Stream.of(
                Arguments.of(data, -1, 5), // Negative offset
                Arguments.of(data, 0, data.length + 1), // Length greater than data size
                Arguments.of(data, data.length - 2, 3), // Offset and length exceeding data limits
                Arguments.of(data, data.length + 1, 1), // Offset beyond the end of the array
                Arguments.of(data, 0, -1), // Negative length
                Arguments.of(null, 0, 5) // Null data
        );
    }

    private static Stream<ByteBuf> provideDataAppendAsyncTest() {
        byte[] emptyData = new byte[]{};
        byte[] testData = "Test String".getBytes();

        return Stream.of(Unpooled.wrappedBuffer(emptyData), Unpooled.wrappedBuffer(testData), Unpooled.buffer());
    }

    // createLedger

    @ParameterizedTest
    @MethodSource("provideDataCreateLedgerTest")
    void createLedgerTest(BookKeeper.DigestType digestType, byte[] password) throws Exception {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());

        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            try (LedgerHandle ledgerHandle = bookKeeper.createLedger(digestType, password)) {
                assertNotNull(ledgerHandle);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataCreateLedgerTest")
    void createLedgerInvalidPasswordTest(BookKeeper.DigestType digestType, byte[] password) throws
            BKException, IOException, InterruptedException {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            assertThrows(Exception.class, () -> bookKeeper.createLedger(digestType, password));
        }
    }

    // getId

    @Test
    void getIdTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            long ledgerId = lh.getId();
            try {
                LedgerManager ledgerManager = bkc.getLedgerManager();
                LedgerManager.LedgerRangeIterator ledgersIterator = ledgerManager.getLedgerRanges(5000);
                while (ledgersIterator.hasNext()) {
                    LedgerManager.LedgerRange ledgerRange = ledgersIterator.next();
                    Set<Long> ledgersId = ledgerRange.getLedgers();
                    if (ledgersId.contains(ledgerId)) {
                        break;
                    } else {
                        ledgerId = ledgerRange.getLedgers().iterator().next();
                    }
                }
            } catch (NullPointerException | IOException e) {
                LOG.error("e.getMessage()", e);
            }
            assertTrue(ledgerId >= 0, "Ledger ID should be equal or greater than zero");
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // getLastAddConfirmed

    @Test
    void getLastAddConfirmed() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 5; i++) {
                try {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                } catch (BKException | InterruptedException e) {
                    LOG.error("LedgerHandle addEntry failed", e);
                }
            }
            long lastAddConfirmed = lh.getLastAddConfirmed();
            Enumeration<LedgerEntry> entries = lh.readEntries(0, lastAddConfirmed);
            long count = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= lastAddConfirmed);
                count++;
            }
            assertEquals(count - 1, lastAddConfirmed);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }

        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            long lastAddConfirmed = lh.getLastAddConfirmed();
            assertEquals(-1, lastAddConfirmed);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // getLastAddPushed

    @Test
    void getLastAddPushed() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 5; i++) {
                try {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                } catch (BKException | InterruptedException e) {
                    LOG.error("LedgerHandle addEntry failed", e);
                }
            }
            long lastAddPushed = lh.getLastAddPushed();
            Enumeration<LedgerEntry> entries = lh.readEntries(0, lastAddPushed);
            long count = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= lastAddPushed);
                count++;
            }
            assertEquals(count - 1, lastAddPushed);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }

        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            long lastAddPushed = lh.getLastAddPushed();
            assertEquals(-1, lastAddPushed);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // getLedgerKey

    @Test
    void getLedgerKey() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            byte[] key = lh.getLedgerKey();
            try {
                byte[] generatedKey = DigestManager.generateMasterKey("password".getBytes());
                int keyLength = generatedKey.length;
                for (int i = 0; i < keyLength; i++) {
                    assertEquals(key[i], generatedKey[i]);
                }
            } catch (NoSuchAlgorithmException e) {
                LOG.error("Failed to generate key", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // getNumBookies

    @Test
    void getNumBookies() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertEquals(3, lh.getNumBookies());
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // getLength

    @Test
    void getLengthTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertEquals(0, lh.getLength());
            try {
                lh.addEntry("TestEntry".getBytes());
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            assertEquals("TestEntry".length(), lh.getLength());
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // close

    @Test
    void closeTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 5; i++) {
                try {
                    lh.addEntry(("Entry " + i).getBytes());
                } catch (BKException | InterruptedException e) {
                    LOG.error("LedgerHandle addEntry failed", e);
                }
            }
            try {
                assertFalse(lh.isClosed());
                lh.close();
                assertTrue(lh.isClosed());
                Enumeration<LedgerEntry> entries = lh.readEntries(0, 4);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= 4);
                    count++;
                }
                assertEquals(5, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("readEntries  failed", e);
            }
            assertThrows(BKException.class, () -> lh.addEntry(("Entry " + 5).getBytes()));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // closeAsync

    @Test
    void closeAsync1Test() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 5; i++) {
                try {
                    lh.addEntry(("Entry " + i).getBytes());
                } catch (BKException | InterruptedException e) {
                    LOG.error("LedgerHandle addEntry failed", e);
                }
            }
            try {
                assertFalse(lh.isClosed());
                CompletableFuture<Void> future = lh.closeAsync();
                future.join();
                assertTrue(lh.isClosed());
                Enumeration<LedgerEntry> entries = lh.readEntries(0, 4);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= 4);
                    count++;
                }
                assertEquals(5, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("readEntries   failed", e);
            }
            assertThrows(BKException.class, () -> lh.addEntry(("Entry " + 5).getBytes()));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void closeAsync2Test() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertFalse(lh.isClosed());
            lh.closeAsync();
            assertThrows(BKException.class, () -> lh.addEntry(("Test Entry").getBytes()));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // asyncClose

    @ParameterizedTest
    @MethodSource("provideDataAsyncCloseTest")
    void asyncClose1Test(AsyncCallback.CloseCallback cb, Object ctx) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 5; i++) {
                try {
                    lh.addEntry(("Entry " + i).getBytes());
                } catch (BKException | InterruptedException e) {
                    LOG.error("LedgerHandle addEntry failed", e);
                }
            }
            try {
                assertFalse(lh.isClosed());
                lh.asyncClose(cb, ctx);
                while (!lh.isClosed()) {
                    // wait until lh is closed
                }
                Enumeration<LedgerEntry> entries = lh.readEntries(0, 4);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= 4);
                    count++;
                }
                assertEquals(5, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("readEntries  failed", e);
            }
            assertThrows(BKException.class, () -> lh.addEntry(("Entry " + 5).getBytes()));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataAsyncCloseTest")
    void asyncClose2Test(AsyncCallback.CloseCallback cb, Object ctx) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertFalse(lh.isClosed());
            lh.asyncClose(cb, ctx);
            assertThrows(BKException.class, () -> lh.addEntry(("Test Entry").getBytes()));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    //readEntries

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readEntriesTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(firstEntry, lastEntry);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= firstEntry && entry.getEntryId() <= lastEntry);
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("readEntries  failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readEntriesInvalidParametersTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            assertThrows(BKException.class, () -> lh.readEntries(firstEntry, lastEntry));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void readEntriesNoEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertThrows(BKException.class, () -> lh.readEntries(0, 99));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // batchReadEntries

    @ParameterizedTest
    @MethodSource("provideDataBatchReadEntriesTest")
    void batchReadEntriesTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                              boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                // Add 5 entries to the ledger with IDs from 0 to 4
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
                Enumeration<LedgerEntry> entries = lh.batchReadEntries(startEntry, maxCount, maxSize);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= startEntry);
                    assertArrayEquals(("Entry " + (count + startEntry)).getBytes(), entry.getEntry());
                    count++;
                }
                assertEquals(expectedEntries, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("batchReadEntries failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchReadEntriesTest")
    void batchReadEntriesInvalidParametersTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                                               boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
                assertThrows(BKException.class, () -> lh.batchReadEntries(startEntry, maxCount, maxSize));
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataBatchReadEntriesNoEntriesTest")
    void batchReadEntriesNoEntriesTest(boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                assertThrows(BKException.class, () -> lh.batchReadEntries(0, 100, -1));
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    // readUnconfirmedEntries

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readUnconfirmedEntriesTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 100; i++) {
                lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                    // I don't care when it is completed and if it is completed
                }, null);
            }
            assertTrue(lh.lastAddConfirmed < 99);
            System.out.println("Last add confirmed: " + lh.lastAddConfirmed);
            System.out.println("Last add pushed: " + lh.lastAddPushed);
            try {
                Enumeration<LedgerEntry> entries = lh.readUnconfirmedEntries(firstEntry, lastEntry);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertArrayEquals(("Entry " + (count + firstEntry)).getBytes(), entry.getEntry());
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= 99);
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (BKException | InterruptedException e) {
                LOG.error("readUnconfirmedEntries failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readUnconfirmedEntriesInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 100; i++) {
                lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                    // I don't care when it is completed and if it is completed
                }, null);
            }
            assertTrue(lh.lastAddConfirmed < 99);
            assertThrows(BKException.class, () -> lh.readUnconfirmedEntries(firstEntry, lastEntry));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void readUnconfirmedEntriesTestNoEntry() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertTrue(lh.lastAddConfirmed < 99);
            assertThrows(BKException.class, () -> lh.readUnconfirmedEntries(0, 99));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // batchReadUnconfirmedEntries

    @ParameterizedTest
    @MethodSource("provideDataBatchReadEntriesTest")
    void batchReadUnconfirmedEntriesTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                                         boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                for (int i = 0; i < 100; i++) {
                    lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                        // I don't care when it is completed and if it is completed
                    }, null);
                }
                assertTrue(lh.lastAddConfirmed < 99);
                System.out.println("Last add confirmed: " + lh.lastAddConfirmed);
                System.out.println("Last add pushed: " + lh.lastAddPushed);
                try {
                    Enumeration<LedgerEntry> entries = lh.batchReadUnconfirmedEntries(startEntry, maxCount, maxSize);
                    int count = 0;
                    while (entries.hasMoreElements()) {
                        LedgerEntry entry = entries.nextElement();
                        assertTrue(entry.getEntryId() >= startEntry);
                        assertArrayEquals(("Entry " + (count + startEntry)).getBytes(), entry.getEntry());
                        count++;
                    }
                    assertEquals(expectedEntries, count);
                } catch (BKException | InterruptedException e) {
                    LOG.error("Failed batchReadUnconfirmedEntries", e);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchReadEntriesTest")
    void batchReadUnconfirmedEntriesInvalidParametersTest(long startEntry, int maxCount, long maxSize,
                                                          int expectedEntries, boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                for (int i = 0; i < 100; i++) {
                    lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                        // I don't care when it is completed and if it is completed
                    }, null);
                }
                assertTrue(lh.lastAddConfirmed < 99);
                assertThrows(BKException.class, () -> lh.batchReadUnconfirmedEntries(startEntry, maxCount, maxSize));
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataBatchReadEntriesNoEntriesTest")
    void batchReadUnconfirmedEntriesNoEntriesTest(boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                assertTrue(lh.lastAddConfirmed < 99);
                assertThrows(BKException.class, () -> lh.batchReadUnconfirmedEntries(0, 100, -1));
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    // readAsync

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readAsyncTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            try {
                CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
                LedgerEntries entries = future.join();
                int count = 0;
                Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                        assertTrue(entry.getEntryId() >= firstEntry && entry.getEntryId() <= lastEntry);
                    }
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (RuntimeException e) {
                LOG.error("readAsync failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readAsyncInvalidParametersTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {

                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void readAsyncNoEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            CompletableFuture<LedgerEntries> future = lh.readAsync(0, 99);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // batchReadAsync

    @ParameterizedTest
    @MethodSource("provideDataBatchReadEntriesTest")
    void batchReadAsyncEntriesTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                                   boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                try {
                    for (int i = 0; i < 100; i++) {
                        lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                    }
                } catch (BKException | InterruptedException e) {
                    LOG.error("addEntry failed", e);
                }
                try {
                    CompletableFuture<LedgerEntries> future = lh.batchReadAsync(startEntry, maxCount, maxSize);
                    LedgerEntries entries = future.join();
                    Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
                    int count = 0;
                    while (iterator.hasNext()) {
                        try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                            assertTrue(entry.getEntryId() >= startEntry);
                            assertArrayEquals(("Entry " + (count + startEntry)).getBytes(), entry.getEntryBytes());
                        }
                        count++;
                    }
                    assertEquals(expectedEntries, count);
                } catch (CancellationException | CompletionException e) {
                    LOG.error("batchReadAsync failed", e);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchReadEntriesTest")
    void batchReadAsyncInvalidParametersTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                                             boolean batchReadEnabled) {
        ClientConfiguration conf;
        if (batchReadEnabled) {
            conf = new ClientConfiguration().setUseV2WireProtocol(true);
            conf.setBatchReadEnabled(true);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        } else {
            conf = new ClientConfiguration();
            conf.setBatchReadEnabled(false);
            conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());
        }
        try (BookKeeper bkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.MAC, "password".getBytes())) {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
                CompletableFuture<LedgerEntries> future = lh.batchReadAsync(startEntry, maxCount, maxSize);
                assertThrows(CompletionException.class, future::join);
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle creation failed", e);
            }
        } catch (BKException | InterruptedException | IOException e) {
            LOG.error("BookKeeper client init failed", e);
        }
    }

    // readUnconfirmedAsync

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readUnconfirmedAsyncTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 100; i++) {
                lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                    // I don't care when it is completed and if it is completed
                }, null);
            }
            assertTrue(lh.lastAddConfirmed < 99);
            assertEquals(99, lh.lastAddPushed);
            try {
                CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
                LedgerEntries entries = future.join();
                int count = 0;
                Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                        assertTrue(entry.getEntryId() >= firstEntry && entry.getEntryId() <= lastEntry);
                    }
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (RuntimeException e) {
                LOG.error("readAsync failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readUnconfirmedAsyncInvalidParametersTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            for (int i = 0; i < 100; i++) {
                lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                    // I don't care when it is completed and if it is completed
                }, null);
            }
            assertTrue(lh.lastAddConfirmed < 99);
            assertEquals(99, lh.lastAddPushed);
            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // readLastEntry

    @Test
    void readLastEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.DUMMY, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                LOG.error("LedgerHandle addEntry failed", e);
            }
            try {
                LedgerEntry entry = lh.readLastEntry();
                assertArrayEquals(("Entry " + 99).getBytes(), entry.getEntry());
                assertEquals(99, entry.getEntryId());
            } catch (BKException | InterruptedException e) {
                LOG.error("readLastEntry failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void readLastEntryNoEntriesTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.DUMMY, "password".getBytes())) {
            try {
                LedgerEntry entry = lh.readLastEntry();
                assertEquals(-1, entry.getEntryId());
            } catch (BKException | InterruptedException e) {
                LOG.error("readLastEntry failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // addEntry

    @ParameterizedTest
    @MethodSource("provideDataAddEntry1Test")
    void addEntry1Test(byte[] data) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                long entryId = lh.addEntry(data);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (BKException | InterruptedException e) {
                LOG.error("addEntry failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @Test
    void addEntry1NullTest() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertThrows(NullPointerException.class, () -> lh.addEntry(null));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataAddEntry2Test")
    void addEntry2Test(byte[] data, int offset, int length) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                long entryId = lh.addEntry(data, offset, length);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (BKException | InterruptedException e) {
                LOG.error("addEntry failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataAddEntry2Test")
    void addEntry2InvalidParametersTest(byte[] data, int offset, int length) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            assertThrows(Exception.class, () -> lh.addEntry(data, offset, length));
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }

    // appendAsync

    @ParameterizedTest
    @MethodSource("provideDataAppendAsyncTest")
    void appendAsyncTest(ByteBuf data) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                CompletableFuture<Long> future = lh.appendAsync(data);
                Long entryId = future.join();
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (CancellationException | CompletionException e) {
                LOG.error("appendAsync failed", e);
            }
        } catch (BKException | InterruptedException e) {
            LOG.error("LedgerHandle creation failed", e);
        }
    }
}

package org.apache.bookkeeper.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.bookkeeper.client.AsyncCallback.CloseCallback;
import org.apache.bookkeeper.client.BookKeeper.DigestType;
import org.apache.bookkeeper.client.api.LedgerEntries;
import org.apache.bookkeeper.common.concurrent.FutureUtils;
import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.meta.LedgerManager;
import org.apache.bookkeeper.proto.checksum.DigestManager;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(5)
class LedgerHandleTest extends BookKeeperClusterTestCase {
    private static final String PASSWORD = "password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes();
    private static final DigestType DIGEST_TYPE = DigestType.MAC;
    private static final String VALID_STRING = "Test Entry";
    private static final byte[] VALID_STRING_BYTES = VALID_STRING.getBytes();
    private static final int NUM_BOOKIES = 5;
    private static final int NUM_ENTRIES = 100;

    public LedgerHandleTest() {
        super(NUM_BOOKIES);
    }

    private static Stream<Arguments> provideDataCreateLedgerTest() {
        byte[] emptyPassword = new byte[]{};
        return Stream.of(
                Arguments.of(DigestType.MAC, emptyPassword), // Empty password
                Arguments.of(DigestType.MAC, PASSWORD_BYTES), // password
                Arguments.of(DigestType.CRC32, emptyPassword),
                Arguments.of(DigestType.CRC32, PASSWORD_BYTES),
                Arguments.of(DigestType.CRC32C, emptyPassword),
                Arguments.of(DigestType.CRC32C, PASSWORD_BYTES),
                Arguments.of(DigestType.DUMMY, emptyPassword),
                Arguments.of(DigestType.DUMMY, PASSWORD_BYTES)
        );
    }

    private static Stream<Arguments> provideInvalidDataCreateLedgerTest() {
        return Stream.of(
                Arguments.of(DigestType.MAC, null),
                Arguments.of(DigestType.CRC32, null),
                Arguments.of(DigestType.CRC32C, null),
                Arguments.of(DigestType.DUMMY, null)
        );
    }

    private static Stream<Arguments> provideDataAsyncCloseTest() {
        final CompletableFuture<Void> closePromise = new CompletableFuture<>();
        CloseCallback cb = (rc, lh, ctx) -> {
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
                Arguments.of(0, 0), // Reads only the first entry
                Arguments.of(0, 1), // Reads the first two entries
                Arguments.of(0, NUM_ENTRIES/2 - 1), // Reads the first half of the entries
                Arguments.of(NUM_ENTRIES/2, NUM_ENTRIES - 1), // Reads the second half of the entries
                Arguments.of(0, NUM_ENTRIES - 1), // Reads all entries
                Arguments.of(NUM_ENTRIES - 1, NUM_ENTRIES - 1) // Reads only the last entry
        );
    }

    private static Stream<Arguments> provideInvalidDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(-1L, -1L), // Exception (invalid value for 'firstEntry' and 'lastEntry'
                Arguments.of(-1L, 0L), // Exception (invalid value for `firstEntry`)
                Arguments.of(0L, -1L), // Exception (invalid value for `lastEntry`)
                Arguments.of(NUM_ENTRIES - 1, NUM_ENTRIES/2),
                Arguments.of(0L, NUM_ENTRIES),  // Exception (invalid value for `lastEntry`)
                Arguments.of(NUM_ENTRIES, NUM_ENTRIES - 1), // Exception (invalid value for `firstEntry`)
                Arguments.of(NUM_ENTRIES, NUM_ENTRIES),
                Arguments.of(NUM_ENTRIES, NUM_ENTRIES + 1),
                Arguments.of(NUM_ENTRIES + 1, NUM_ENTRIES)
        );
    }

    private static Stream<Arguments> provideDataBatchReadEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, expectedEntries, batchReadEnabled
                Arguments.of(0L, 0, defaultSize, NUM_ENTRIES, true),
                // Arguments.of(0L, 0, defaultSize, NUM_ENTRIES, false), // only startEntry or all entries? TODO
                Arguments.of(1L, 25, defaultSize, 25, true), // entries with ID 1, 2, 3
                Arguments.of(1L, 25, defaultSize, 25, false),
                Arguments.of(NUM_ENTRIES - 1, 2, defaultSize, 1, true), // only entries ID 4
                Arguments.of(NUM_ENTRIES - 1, 2, defaultSize, 1, false),
                Arguments.of(0L, NUM_ENTRIES + 1, defaultSize, NUM_ENTRIES, true), // all entries
                Arguments.of(0L, NUM_ENTRIES + 1, defaultSize, NUM_ENTRIES, false),
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, true), // default `maxSize` -> all entries
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, false),
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, true),
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, false),
                Arguments.of(0L, NUM_ENTRIES, 1L, 1, true), // if maxSize < entrySize -> only startEntry
                Arguments.of(0L, NUM_ENTRIES, 1L, NUM_ENTRIES, false), // all entries
                Arguments.of(2L, NUM_ENTRIES, defaultSize, NUM_ENTRIES - 2, true), // entries with ID 2, 3, 4
                Arguments.of(2L, NUM_ENTRIES, defaultSize, NUM_ENTRIES - 2, false),
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, true), // maxSize > default
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, false)
        );
    }

    private static Stream<Arguments> provideInvalidDataBatchReadEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, batchReadEnabled
                // Arguments.of(-1L, 1, defaultSize, true), // Exception (valore non valido per `startEntry`) TODO
                // Arguments.of(-1L, 1, defaultSize, false), // TODO
                Arguments.of(NUM_ENTRIES, 1, defaultSize, true), // startEntry > lastEntry -> exception
                Arguments.of(NUM_ENTRIES, 1, defaultSize, false)
        );
    }

    private static Stream<Arguments> provideDataBatchReadEntriesNoEntriesTest() {
        return Stream.of(
                Arguments.of(true),
                Arguments.of(false)
        );
    }

    private static Stream<Arguments> provideDataBatchReadUnconfirmedEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, expectedEntries, batchReadEnabled
                Arguments.of(0L, 0, defaultSize, NUM_ENTRIES, true),
                // Arguments.of(0L, 0, defaultSize, 0, false), // only startEntry or all entries? TODO
                Arguments.of(1L, 25, defaultSize, 25, true), // entries with ID 1, 2, 3
                Arguments.of(1L, 25, defaultSize, 25, false),
                Arguments.of(NUM_ENTRIES - 1, 2, defaultSize, 1, true), // only entries ID 4
                // Arguments.of(NUM_ENTRIES - 1, 2, defaultSize, 1, false), // TODO
                Arguments.of(0L, 101, defaultSize, NUM_ENTRIES, true), // all entries
                // Arguments.of(0L, 101, defaultSize, NUM_ENTRIES, false), // TODO
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, true), // default `maxSize` -> all entries
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, false),
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, true),
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, false),
                Arguments.of(0L, NUM_ENTRIES, 1L, 1, true), // if maxSize < entrySize -> only startEntry
                Arguments.of(0L, NUM_ENTRIES, 1L, NUM_ENTRIES, false), // all entries
                Arguments.of(2L, NUM_ENTRIES, defaultSize, NUM_ENTRIES - 2, true), // entries with ID 2, 3, 4
                // Arguments.of(2L, NUM_ENTRIES, defaultSize, NUM_ENTRIES - 2, false), // TODO
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, true), // maxSize > default
                Arguments.of(0L, 5, Long.MAX_VALUE, 5, false)
        );
    }

    private static Stream<Arguments> provideInvalidDataBatchUnconfirmedReadEntriesTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, batchReadEnabled
                Arguments.of(-1L, 1, defaultSize, true), // Exception (valore non valido per `startEntry`) TODO
                Arguments.of(-1L, 1, defaultSize, false), // TODO
                Arguments.of(NUM_ENTRIES, 1, defaultSize, true), // startEntry > lastEntry -> exception
                Arguments.of(NUM_ENTRIES, 1, defaultSize, false)
        );
    }

    private static Stream<Arguments> provideInvalidDataBatchReadAsyncTest() {
        long defaultSize = 5 * 1024 * 1024;
        return Stream.of(
                // startEntry, maxCount, maxSize, batchReadEnabled
                Arguments.of(-1L, 1, defaultSize, true), // Exception (valore non valido per `startEntry`)
                Arguments.of(-1L, 1, defaultSize, false),
                Arguments.of(NUM_ENTRIES, 1, defaultSize, true), // startEntry > lastEntry -> exception
                Arguments.of(NUM_ENTRIES, 1, defaultSize, false)
        );
    }

    private static Stream<byte[]> provideDataAddEntry1Test() {
        byte[] emptyData = new byte[]{};
        return Stream.of(
                emptyData,
                VALID_STRING_BYTES
        );
    }

    private static Stream<Arguments> provideDataAddEntry2Test() {
        byte[] emptyData = new byte[]{};
        byte[] testData = VALID_STRING_BYTES;

        return Stream.of(
                Arguments.of(emptyData, 0, 0), // Test with an empty array
                Arguments.of(testData, 0, testData.length), // Test with meaningful data
                Arguments.of(testData, 0, 5), // Test with an initial portion
                Arguments.of(testData, testData.length / 2, testData.length / 2), // Test with a final portion
                Arguments.of(testData, 3, 4) // Test with an intermediate portion
        );
    }

    private static Stream<Arguments> provideInvalidDataAddEntry2Test() {
        byte[] emptyData = new byte[]{};
        byte[] testData = VALID_STRING_BYTES;

        return Stream.of(
                Arguments.of(emptyData, 0, 1),
                Arguments.of(testData, 0, -1),
                Arguments.of(testData, -1, 5), // Negative offset
                Arguments.of(testData, 0, testData.length + 1), // Length greater than data size
                Arguments.of(testData, testData.length - 1, 3), // Offset and length exceeding data limits
                Arguments.of(testData, testData.length, 1), // Offset beyond the end of the array
                Arguments.of(testData, 0, -1), // Negative length
                Arguments.of(null, 0, 5) // Null data
        );
    }

    private static Stream<ByteBuf> provideDataAppendAsyncTest() {
        byte[] emptyData = new byte[]{};

        return Stream.of(Unpooled.wrappedBuffer(emptyData), Unpooled.wrappedBuffer(VALID_STRING_BYTES), Unpooled.buffer());
    }

    // createLedger

    @ParameterizedTest
    @MethodSource("provideDataCreateLedgerTest")
    void createLedgerTest(DigestType digestType, byte[] password) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(digestType, password)) {
            assertNotNull(lh);
            assertTrue(lh.isHandleWritable());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataCreateLedgerTest")
    void createLedgerInvalidPasswordTest(DigestType digestType, byte[] password) {
        assertThrows(NullPointerException.class, () -> bkc.createLedger(digestType, password));
    }

    // getId

    @Test
    void getIdTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            long ledgerId = lh.getId();
            assertTrue(ledgerId >= 0, "Ledger ID should be equal or greater than zero");
            try {
                LedgerManager ledgerManager = bkc.getLedgerManager();
                LedgerManager.LedgerRangeIterator ledgersIterator = ledgerManager.getLedgerRanges(5000);
                boolean found = false;
                while (ledgersIterator.hasNext()) {
                    LedgerManager.LedgerRange ledgerRange = ledgersIterator.next();
                    Set<Long> ledgersId = ledgerRange.getLedgers();
                    for (Long id : ledgersId) {
                        if (ledgerId == id) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    } else {
                        ledgerId = ledgerRange.getLedgers().iterator().next();
                    }
                }
                assertTrue(found);
            } catch (NullPointerException | IOException e) {
                fail(e.getMessage());
            }
            LedgerHandle lh2 = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
            assertNotEquals(lh.getId(), lh2.getId());
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // getLastAddConfirmed

    @Test
    void getLastAddConfirmedTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(-1, lh.getLastAddConfirmed());
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            long lastAddConfirmed = lh.getLastAddConfirmed();
            assertEquals(NUM_ENTRIES - 1, lastAddConfirmed);
            Enumeration<LedgerEntry> entries = lh.readEntries(0, lastAddConfirmed);
            long count = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= lastAddConfirmed);
                count++;
            }
            assertEquals(lastAddConfirmed + 1, count);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // getLastAddPushed

    @Test
    void getLastAddPushedSyncTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(-1, lh.getLastAddPushed());
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            long lastAddPushed = lh.getLastAddPushed();
            Enumeration<LedgerEntry> entries = lh.readEntries(0, lastAddPushed);
            long count = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= lastAddPushed);
                count++;
            }
            assertEquals(lastAddPushed, count - 1);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void getLastAddPushedAsyncTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(-1, lh.getLastAddPushed());
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.appendAsync(("Entry " + i).getBytes());
            }
            assertEquals(NUM_ENTRIES - 1, lh.getLastAddPushed());
            assertTrue(lh.getLastAddPushed() > lh.getLastAddConfirmed());
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // getLedgerKey

    @Test
    void getLedgerKeyTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] key = lh.getLedgerKey();
            try {
                byte[] generatedKey = DigestManager.generateMasterKey(PASSWORD_BYTES);
                assertArrayEquals(generatedKey, key);
            } catch (NoSuchAlgorithmException e) {
                fail("Failed to generate key: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // getNumBookies

    @Test
    void getNumBookies() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(3, lh.getNumBookies());
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // getLength

    @Test
    void getLengthTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(0, lh.getLength());
            try {
                lh.addEntry(VALID_STRING_BYTES);
                assertEquals(VALID_STRING_BYTES.length, lh.getLength());
                lh.addEntry(VALID_STRING_BYTES);
                assertEquals(VALID_STRING_BYTES.length * 2L, lh.getLength());
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // close

    @Test
    void closeTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            assertFalse(lh.isClosed());
            try {
                lh.close();
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle close failed: " + e.getMessage());
            }
            assertTrue(lh.isClosed());
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(0, NUM_ENTRIES - 1);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= NUM_ENTRIES - 1);
                    count++;
                }
                assertEquals(NUM_ENTRIES, count);
            } catch (BKException | InterruptedException e) {
                fail("readEntries  failed: " + e.getMessage());
            }
            assertThrows(BKException.BKLedgerClosedException.class, () -> lh.addEntry(("Entry " + 100).getBytes()));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // closeAsync

    @Test
    void closeAsync1Test() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            assertFalse(lh.isClosed());
            CompletableFuture<Void> future = lh.closeAsync();
            try {
                future.join();
            } catch (CancellationException | CompletionException e) {
                fail(e.getMessage());
            }
            assertTrue(lh.isClosed());
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(0, NUM_ENTRIES - 1);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= NUM_ENTRIES - 1);
                    count++;
                }
                assertEquals(NUM_ENTRIES, count);
            } catch (BKException | InterruptedException e) {
                fail("readEntries   failed: " + e.getMessage());
            }
            assertThrows(BKException.BKLedgerClosedException.class, () -> lh.addEntry(("Entry " + 100).getBytes()));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void closeAsync2Test() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertFalse(lh.isClosed());
            lh.closeAsync();
            assertThrows(BKException.BKLedgerClosedException.class, () -> lh.addEntry(VALID_STRING_BYTES));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // asyncClose

    @ParameterizedTest
    @MethodSource("provideDataAsyncCloseTest")
    void asyncClose1Test(CloseCallback cb, Object ctx) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            assertFalse(lh.isClosed());
            lh.asyncClose(cb, ctx);
            while (true) {
                if (lh.isClosed()) break;
            }
            assertTrue(lh.isClosed());
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(0, NUM_ENTRIES - 1);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= NUM_ENTRIES - 1);
                    count++;
                }
                assertEquals(NUM_ENTRIES, count);
            } catch (BKException | InterruptedException e) {
                fail("readEntries  failed: " + e.getMessage());
            }
            assertThrows(BKException.BKLedgerClosedException.class, () -> lh.addEntry(("Entry " + 5).getBytes()));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataAsyncCloseTest")
    void asyncClose2Test(AsyncCallback.CloseCallback cb, Object ctx) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertFalse(lh.isClosed());
            lh.asyncClose(cb, ctx);
            assertThrows(BKException.BKLedgerClosedException.class, () -> lh.addEntry(VALID_STRING_BYTES));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    //readEntries

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readEntriesTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(firstEntry, lastEntry);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    long entryId = entry.getEntryId();
                    assertArrayEquals(("Entry " + entryId).getBytes(), entry.getEntry());
                    assertEquals(firstEntry + count, entry.getEntryId());
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (BKException | InterruptedException e) {
                fail("readEntries  failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readEntriesInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            BKException e = assertThrows(BKException.class, () -> lh.readEntries(firstEntry, lastEntry));
            if (lastEntry < NUM_ENTRIES || (firstEntry > lastEntry)) {
                assertEquals(BKException.Code.IncorrectParameterException, e.getCode());
            } else {
                assertEquals(BKException.Code.ReadException, e.getCode());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void readEntriesNoEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(BKException.BKReadException.class, () -> lh.readEntries(0, NUM_ENTRIES - 1));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
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
                fail("batchReadEntries failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchReadEntriesTest")
    void batchReadEntriesInvalidParametersTest(long startEntry, int maxCount, long maxSize, boolean batchReadEnabled) {
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
                assertThrows(BKException.BKReadException.class, () -> lh.batchReadEntries(startEntry, maxCount, maxSize));
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                assertThrows(BKException.BKReadException.class, () -> lh.batchReadEntries(0, NUM_ENTRIES, -1));
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    // readUnconfirmedEntries

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readUnconfirmedEntriesTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.appendAsync(("Entry " + i).getBytes());
            }
            assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
            try {
                Enumeration<LedgerEntry> entries = lh.readUnconfirmedEntries(firstEntry, lastEntry);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertArrayEquals(("Entry " + (count + firstEntry)).getBytes(), entry.getEntry());
                    assertTrue(entry.getEntryId() >= 0 && entry.getEntryId() <= NUM_ENTRIES - 1);
                    count++;
                }
                assertEquals(lastEntry - firstEntry + 1, count);
            } catch (BKException | InterruptedException e) {
                fail("readUnconfirmedEntries failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readUnconfirmedEntriesInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.appendAsync(("Entry " + i).getBytes());
            }
            assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
            BKException e = assertThrows(BKException.class, () -> lh.readUnconfirmedEntries(firstEntry, lastEntry));
            if (lastEntry < NUM_ENTRIES || (firstEntry > lastEntry)) {
                assertEquals(BKException.Code.IncorrectParameterException, e.getCode());
            } else if (firstEntry > lh.lastAddPushed || lastEntry > lh.lastAddPushed) {
                assertEquals(BKException.Code.NoSuchEntryException, e.getCode());
            } else {
                assertEquals(BKException.Code.ReadException, e.getCode());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void readUnconfirmedEntriesTestNoEntry() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
            assertThrows(BKException.class, () -> lh.readUnconfirmedEntries(0, NUM_ENTRIES - 1));
            // expected ReadException but actual NoSuchLedgerExistsException
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // batchReadUnconfirmedEntries

    @ParameterizedTest
    @MethodSource("provideDataBatchReadUnconfirmedEntriesTest")
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.appendAsync(("Entry " + i).getBytes());
                }
                assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
                assertEquals(NUM_ENTRIES - 1, lh.lastAddPushed);
                try {
                    Enumeration<LedgerEntry> entries = lh.batchReadUnconfirmedEntries(startEntry, maxCount, maxSize);
                    int count = 0;
                    while (entries.hasMoreElements()) {
                        LedgerEntry entry = entries.nextElement();
                        assertTrue(entry.getEntryId() >= startEntry);
                        assertArrayEquals(("Entry " + (count + startEntry)).getBytes(), entry.getEntry());
                        count++;
                    }
                    assertTrue(count <= expectedEntries);
                } catch (BKException | InterruptedException e) {
                    fail("Failed batchReadUnconfirmedEntries: " + e.getMessage());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchUnconfirmedReadEntriesTest")
    void batchReadUnconfirmedEntriesInvalidParametersTest(long startEntry, int maxCount, long maxSize, boolean batchReadEnabled) {
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.appendAsync(("Entry " + i).getBytes());
                }
                assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
                if (startEntry < 0) {
                    assertThrows(BKException.BKIncorrectParameterException.class, () -> lh.batchReadUnconfirmedEntries(startEntry, maxCount, maxSize));
                } else {
                    assertThrows(BKException.BKNoSuchEntryException.class, () -> lh.batchReadUnconfirmedEntries(startEntry, maxCount, maxSize));
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
                assertThrows(BKException.class, () -> lh.batchReadUnconfirmedEntries(0, NUM_ENTRIES, -1));
                // expected ReadException but actual NoSuchLedgerExistsException
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    // readAsync

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readAsyncTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
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
                fail("readAsync failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readAsyncInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {

                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void readAsyncNoEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            CompletableFuture<LedgerEntries> future = lh.readAsync(0, NUM_ENTRIES - 1);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                try {
                    for (int i = 0; i < NUM_ENTRIES; i++) {
                        lh.addEntry(("Entry " + i).getBytes());
                    }
                } catch (BKException | InterruptedException e) {
                    fail("addEntry failed: " + e.getMessage());
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
                    fail("batchReadAsync failed: " + e.getMessage());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataBatchReadAsyncTest")
    void batchReadAsyncInvalidParametersTest(long startEntry, int maxCount, long maxSize, boolean batchReadEnabled) {
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
                CompletableFuture<LedgerEntries> future = lh.batchReadAsync(startEntry, maxCount, maxSize);
                assertThrows(CompletionException.class, future::join);
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle creation failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

    // readUnconfirmedAsync

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readUnconfirmedAsyncTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.appendAsync(("Entry " + i).getBytes());
            }
            assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
            assertEquals(NUM_ENTRIES - 1, lh.lastAddPushed);
            try {
                CompletableFuture<LedgerEntries> future = lh.readUnconfirmedAsync(firstEntry, lastEntry);
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
            } catch (CancellationException | CompletionException e) {
                fail("readUnconfirmedAsync failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readUnconfirmedAsyncInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.asyncAddEntry(("Entry " + i).getBytes(), (rc, lh1, entryId, ctx) -> {
                    // I don't care when it is completed and if it is completed
                }, null);
            }
            assertTrue(lh.lastAddConfirmed < NUM_ENTRIES - 1);
            assertEquals(NUM_ENTRIES - 1, lh.lastAddPushed);
            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            assertThrows(CompletionException.class, future::join);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // readLastEntry

    @Test
    void readLastEntryTest() {
        try (LedgerHandle lh = bkc.createLedger(DigestType.DUMMY, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            try {
                LedgerEntry entry = lh.readLastEntry();
                assertArrayEquals(("Entry " + (NUM_ENTRIES - 1)).getBytes(), entry.getEntry());
                assertEquals(NUM_ENTRIES - 1, entry.getEntryId());
            } catch (BKException | InterruptedException e) {
                fail("readLastEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void readLastEntryNoEntriesTest() {
        try (LedgerHandle lh = bkc.createLedger(DigestType.DUMMY, PASSWORD_BYTES)) {
            assertThrows(BKException.BKNoSuchEntryException.class, lh::readLastEntry);
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // addEntry

    @ParameterizedTest
    @MethodSource("provideDataAddEntry1Test")
    void addEntry1Test(byte[] data) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                long entryId = lh.addEntry(data);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (BKException | InterruptedException e) {
                fail("addEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void addEntry1NullTest() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(NullPointerException.class, () -> lh.addEntry(null));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataAddEntry2Test")
    void addEntry2Test(byte[] data, int offset, int length) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                long entryId = lh.addEntry(data, offset, length);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (BKException | InterruptedException e) {
                fail("addEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataAddEntry2Test")
    void addEntry2InvalidParametersTest(byte[] data, int offset, int length) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(Exception.class, () -> lh.addEntry(data, offset, length));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    void addEntry3Test() {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            BKException illegalOpException = BKException.create(BKException.Code.IllegalOpException);
            assertThrows(illegalOpException.getClass(), () -> lh.addEntry(0, VALID_STRING_BYTES));
            assertThrows(illegalOpException.getClass(), () -> lh.addEntry(0, VALID_STRING_BYTES, 0, VALID_STRING_BYTES.length));
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // appendAsync

    @ParameterizedTest
    @MethodSource("provideDataAppendAsyncTest")
    void appendAsyncTest(ByteBuf data) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                CompletableFuture<Long> future = lh.appendAsync(data);
                Long entryId = future.join();
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (CancellationException | CompletionException e) {
                fail("appendAsync failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

}

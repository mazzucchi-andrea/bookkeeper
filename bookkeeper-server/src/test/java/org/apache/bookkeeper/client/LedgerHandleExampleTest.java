package org.apache.bookkeeper.client;

import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.proto.checksum.DigestManager;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LedgerHandleExampleTest extends BookKeeperClusterTestCase {

    public LedgerHandleExampleTest() {
        super(5);
    }

    private static Stream<Arguments> provideDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(0L, 0L), // Reads only the first entry
                Arguments.of(1L, 2L), // Reads entries with ID 1 and 2
                Arguments.of(0L, 99L), // Reads all entries
                Arguments.of(99L, 99L) // Reads only the last entry
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


    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readEntriesTest(Long firstEntry, Long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < 100; i++) {
                    lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
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
                fail("readEntries  failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

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
                fail("batchReadEntries failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }

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
                fail("Failed to generate key: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }
}

package org.apache.bookkeeper.client;

import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LedgerHandleBatchReadEntriesTest extends BookKeeperClusterTestCase {
    private final long startEntry;
    private final int maxCount;
    private final long maxSize;
    private final int expectedEntries;
    private final boolean expectException;
    private final boolean batchReadEnabled;

    public LedgerHandleBatchReadEntriesTest(long startEntry, int maxCount, long maxSize, int expectedEntries,
                                            boolean expectException, boolean batchReadEnabled) {
        super(5, 3, 30);
        this.startEntry = startEntry;
        this.maxCount = maxCount;
        this.maxSize = maxSize;
        this.expectedEntries = expectedEntries;
        this.expectException = expectException;
        this.batchReadEnabled = batchReadEnabled;
    }

    @Parameters
    public static Collection<Object[]> getTestParams() {
        long defaultSize = 5 * 1024 * 1024;
        return Arrays.asList(new Object[][]{
                // startEntry, maxCount, maxSize, expectedEntries, expectedException,
                // batchReadEnabled
                //{ -1L, 1, defaultSize, 0, true, true }, // 0 Exception (valore non valido per `startEntry`)
                //{ -1L, 1, defaultSize, 0, true, false },
                {0L, 0, defaultSize, 5, false, true}, // 2
                //{ 0L, 0, defaultSize, 0, false, false }, // 3 only startEntry or all entries?
                {1L, 3, defaultSize, 3, false, true}, // 4 entries with ID 1, 2, 3
                {1L, 3, defaultSize, 3, false, false},
                {4L, 2, defaultSize, 1, false, true}, // 6 only entry ID 4
                {4L, 2, defaultSize, 1, false, false},
                {5L, 1, defaultSize, 0, true, true}, // 8 startEntry > lastEntry -> exception
                {5L, 1, defaultSize, 0, true, false},
                {0L, 6, defaultSize, 5, false, true}, // 10 all entries
                {0L, 6, defaultSize, 5, false, false},
                {0L, 5, -1L, 5, false, true}, // 12 default `maxSize` -> all entries
                {0L, 5, -1L, 5, false, false},
                {0L, 5, 0L, 5, false, true},
                {0L, 5, 0L, 5, false, false},
                {0L, 5, 1L, 1, false, true}, // 16 if maxSize < entrySize -> only startEntry
                {0L, 5, 1L, 5, false, false}, // 17 all entries
                {2L, 5, defaultSize, 3, false, true}, // 18 entries with ID 2, 3, 4
                {2L, 5, defaultSize, 3, false, false},
                {0L, 5, Long.MAX_VALUE, 5, false, true}, // 20 maxSize > default
                {0L, 5, Long.MAX_VALUE, 5, false, false}
        });
    }

    @Test
    public void testBatchReadEntries() {
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
            try (LedgerHandle lh = bkc.createLedger(3, 3, BookKeeper.DigestType.DUMMY, "password".getBytes())) {
                // Aggiungi 5 entry al ledger con ID da 0 a 4
                for (int i = 0; i < 5; i++) {
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
                if (!expectException) {
                    fail("Unexpected exception: " + e.getMessage());
                }
            }
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeper client init failed: " + e.getMessage());
        }
    }
}
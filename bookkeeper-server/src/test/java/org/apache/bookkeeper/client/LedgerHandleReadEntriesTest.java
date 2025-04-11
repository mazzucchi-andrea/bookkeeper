package org.apache.bookkeeper.client;

import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LedgerHandleReadEntriesTest extends BookKeeperClusterTestCase {
    private final Long firstEntry;
    private final Long lastEntry;
    private final boolean expectedSuccess;
    private final boolean addEntries;

    public LedgerHandleReadEntriesTest(Long firstEntry, Long lastEntry, boolean expectedSuccess, boolean addEntries) {
        super(5, 3, 30);
        this.firstEntry = firstEntry;
        this.lastEntry = lastEntry;
        this.expectedSuccess = expectedSuccess;
        this.addEntries = addEntries;
    }

    @Parameters
    public static Collection<Object[]> getTestParams() {
        return Arrays.asList(new Object[][]{
                {-1L, 1L, false, true}, // Exception (invalid value for `firstEntry`)
                {0L, -1L, false, true}, // Exception (invalid value for `lastEntry`)
                {0L, 0L, true, true}, // Reads only the first entry
                {1L, 2L, true, true}, // Reads entries with ID 1 and 2
                {0L, 4L, true, true}, // Reads all entries
                {4L, 4L, true, true}, // Reads only the last entry
                {2L, 1L, false, true}, // Exception (invalid value for `firstEntry` > `lastEntry`)
                {0L, 5L, false, true}, // Exception (invalid value for `lastEntry`)
                {5L, 4L, false, true}, // Exception (invalid value for `firstEntry`)
                {0L, 0L, false, false} // Reads from an empty ledger
        });
    }

    @Test
    public void testReadEntries() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.DUMMY, "password".getBytes())) {
            if (addEntries) {
                for (int i = 0; i < 5; i++) {
                    try {
                        lh.addEntry(("Entry " + i).getBytes(), 0, ("Entry " + i).getBytes().length);
                    } catch (BKException | InterruptedException e) {
                        fail("LedgerHandle addEntry failed");
                    }
                }
            }
            try {
                Enumeration<LedgerEntry> entries = lh.readEntries(firstEntry, lastEntry);
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertTrue(entry.getEntryId() >= firstEntry && entry.getEntryId() <= lastEntry);
                    count++;
                }
                if (expectedSuccess) {
                    assertEquals(lastEntry - firstEntry + 1, count);
                } else {
                    if (addEntries) {
                        fail("Expected exception for invalid parameters");
                    } else {
                        assertEquals(0, count);
                    }
                }
            } catch (BKException | InterruptedException e) {
                if (expectedSuccess) {
                    fail("Unexpected exception: " + e.getMessage());
                }
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed");
        }
    }
}

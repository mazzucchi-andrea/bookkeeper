package org.apache.bookkeeper.client;

import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LedgerHandleAddEntryTest extends BookKeeperClusterTestCase {
    private final byte[] data;
    private final int offset;
    private final int length;
    private final boolean expectedSuccess;

    public LedgerHandleAddEntryTest(byte[] data, int offset, int length, boolean expectedSuccess) {
        super(5, 3, 30);
        this.data = data;
        this.offset = offset;
        this.length = length;
        this.expectedSuccess = expectedSuccess;
    }

    @Parameters
    public static Collection<Object[]> getTestParams() {
        return Arrays.asList(new Object[][]{
                {"Test".getBytes(), 0, 4, true}, // 0 Adds the entire string "Test"
                {"Test".getBytes(), 1, 3, true}, // Adds "est"
                {"Test".getBytes(), 0, 0, true}, // 2 No data to add, but should not throw exceptions
                {"Test".getBytes(), -1, 1, false}, // Invalid offset
                {"Test".getBytes(), 0, 5, false}, // 4 Invalid length
                {"Test".getBytes(), 4, 1, false}, // Offset beyond the length of the string
                {null, 0, 1, false}, // 6 Null data
                {new byte[]{}, 0, 0, true}, // Empty data
                {"Test".getBytes(), 0, -1, false} // 8 Negative length
        });
    }

    @Test
    public void testAddEntry() {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.DUMMY, "password".getBytes())) {
            try {
                long entryId = lh.addEntry(data, offset, length);
                assertTrue(entryId >= 0); // A valid entryId is greater than or equal to 0
            } catch (ArrayIndexOutOfBoundsException | BKException | InterruptedException | NullPointerException e) {
                if (expectedSuccess) {
                    fail("Unexpected exception: " + e.getMessage());
                }
            }
        } catch (BKException | InterruptedException e) {
            fail("createLedger failed: " + e.getMessage());
        }
    }
}

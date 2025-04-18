package org.apache.bookkeeper.client;

import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class LedgerHandleAddEntryTest extends BookKeeperClusterTestCase {

    public LedgerHandleAddEntryTest() {
        super(3);
    }

    private static Collection<Object[]> provideTestData() {
        byte[] emptyData = new byte[]{}; // Empty array
        byte[] testData = "Test String".getBytes(); // Meaningful data

        return Arrays.asList(new Object[][]{
                {emptyData, 0, 0}, // Test with an empty array
                {testData, 0, testData.length}, // Test with meaningful data
                {testData, 0, 5}, // Test with an initial portion
                {testData, 5, testData.length - 5}, // Test with a final portion
                {testData, 3, 4} // Test with an intermediate portion
        });
    }

    private static Collection<Object[]> provideInvalidTestData() {
        byte[] data = "Test data".getBytes(); // Test data

        return Arrays.asList(new Object[][]{
                {data, -1, 5}, // Negative offset
                {data, 0, data.length + 1}, // Length greater than data size
                {data, data.length - 2, 3}, // Offset and length exceeding data limits
                {data, data.length + 1, 1}, // Offset beyond the end of the array
                {data, 0, -1}, // Negative length
                {null, 0, 5} // Null data
        });
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testAddEntry(byte[] data, int offset, int length) throws Exception {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());

        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            try (LedgerHandle ledgerHandle = bookKeeper.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
                long entryId = ledgerHandle.addEntry(data, offset, length);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTestData")
    void testAddEntryInvalidParameters(byte[] data, int offset, int length) {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());

        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            try (LedgerHandle ledgerHandle = bookKeeper.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
                assertThrows(Exception.class, () -> ledgerHandle.addEntry(data, offset, length));
            }
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.getMessage());
        }
    }
}

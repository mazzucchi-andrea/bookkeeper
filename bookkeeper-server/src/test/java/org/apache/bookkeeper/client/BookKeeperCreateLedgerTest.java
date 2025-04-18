package org.apache.bookkeeper.client;

import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class BookKeeperCreateLedgerTest extends BookKeeperClusterTestCase {

    public BookKeeperCreateLedgerTest() {
        super(3);
    }

    private static Collection<Object[]> provideTestData() {
        byte[] password = "password".getBytes(); // Meaningful password

        return Arrays.asList(new Object[][]{
                {BookKeeper.DigestType.MAC, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.MAC, password}, // Meaningful password

                {BookKeeper.DigestType.CRC32, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.CRC32, password}, // Meaningful password

                {BookKeeper.DigestType.CRC32C, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.CRC32C, password}, // Meaningful password

                {BookKeeper.DigestType.DUMMY, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.DUMMY, password} // Meaningful password
        });
    }

    private static Collection<Object[]> provideInvalidTestData() {
        return Arrays.asList(new Object[][]{
                {BookKeeper.DigestType.MAC, null}, // Null password
                {BookKeeper.DigestType.CRC32, null}, // Null password
                {BookKeeper.DigestType.CRC32C, null}, // Null password
                {BookKeeper.DigestType.DUMMY, null} // Null password
        });
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testCreateLedger(BookKeeper.DigestType digestType, byte[] password) throws Exception {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());

        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            try (LedgerHandle ledgerHandle = bookKeeper.createLedger(digestType, password)) {
                assertNotNull(ledgerHandle);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTestData")
    void testCreateLedgerInvalidPassword(BookKeeper.DigestType digestType, byte[] password) {
        ClientConfiguration conf = new ClientConfiguration();
        conf.setMetadataServiceUri(zkUtil.getMetadataServiceUri());

        try (BookKeeper bookKeeper = new BookKeeper(conf)) {
            assertThrows(Exception.class, () -> bookKeeper.createLedger(digestType, password));
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.getMessage());
        }
    }
}
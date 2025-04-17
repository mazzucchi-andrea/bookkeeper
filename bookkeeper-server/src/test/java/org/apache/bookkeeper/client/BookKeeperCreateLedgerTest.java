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
        byte[] mediumPassword = new byte[8];
        byte[] longPassword = new byte[256];
        Arrays.fill(mediumPassword, (byte) 0x2A); // Fill with repeated value
        Arrays.fill(longPassword, (byte) 0x3F); // Fill with repeated value

        return Arrays.asList(new Object[][]{
                {BookKeeper.DigestType.MAC, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.MAC, new byte[]{0x01}}, // Single byte password
                {BookKeeper.DigestType.MAC, mediumPassword}, // Medium length password
                {BookKeeper.DigestType.MAC, longPassword}, // Long password
                {BookKeeper.DigestType.MAC, new byte[]{(byte) 0xFF}}, // Password with a special character

                {BookKeeper.DigestType.CRC32, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.CRC32, new byte[]{0x01}}, // Single byte password
                {BookKeeper.DigestType.CRC32, mediumPassword}, // Medium length password
                {BookKeeper.DigestType.CRC32, longPassword}, // Long password
                {BookKeeper.DigestType.CRC32, new byte[]{(byte) 0xFF}}, // Password with a special character

                {BookKeeper.DigestType.CRC32C, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.CRC32C, new byte[]{0x01}}, // Single byte password
                {BookKeeper.DigestType.CRC32C, mediumPassword}, // Medium length password
                {BookKeeper.DigestType.CRC32C, longPassword}, // Long password
                {BookKeeper.DigestType.CRC32C, new byte[]{(byte) 0xFF}}, // Password with a special character

                {BookKeeper.DigestType.DUMMY, new byte[]{}}, // Empty password
                {BookKeeper.DigestType.DUMMY, new byte[]{0x01}}, // Single byte password
                {BookKeeper.DigestType.DUMMY, mediumPassword}, // Medium length password
                {BookKeeper.DigestType.DUMMY, longPassword}, // Long password
                {BookKeeper.DigestType.DUMMY, new byte[]{(byte) 0xFF}} // Password with a special character
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

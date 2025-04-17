package org.apache.bookkeeper.client;

import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookKeeperCreateLedgerTest extends BookKeeperClusterTestCase {

    public BookKeeperCreateLedgerTest() {
        super(3);
    }

    private static Collection<Object[]> provideTestData() {
        byte[] mediumPassword = new byte[8];
        byte[] longPassword = new byte[256];
        Arrays.fill(mediumPassword, (byte) 0x2A);
        Arrays.fill(longPassword, (byte) 0x3F);

        return Arrays.asList(new Object[][]{
                {BookKeeper.DigestType.MAC, new byte[]{}},
                {BookKeeper.DigestType.MAC, new byte[]{0x01}},
                {BookKeeper.DigestType.MAC, mediumPassword},
                {BookKeeper.DigestType.MAC, longPassword},
                {BookKeeper.DigestType.MAC, new byte[]{(byte) 0xFF}},

                {BookKeeper.DigestType.CRC32, new byte[]{}},
                {BookKeeper.DigestType.CRC32, new byte[]{0x01}},
                {BookKeeper.DigestType.CRC32, mediumPassword},
                {BookKeeper.DigestType.CRC32, longPassword},
                {BookKeeper.DigestType.CRC32, new byte[]{(byte) 0xFF}},

                {BookKeeper.DigestType.CRC32C, new byte[]{}},
                {BookKeeper.DigestType.CRC32C, new byte[]{0x01}},
                {BookKeeper.DigestType.CRC32C, mediumPassword},
                {BookKeeper.DigestType.CRC32C, longPassword},
                {BookKeeper.DigestType.CRC32C, new byte[]{(byte) 0xFF}},

                {BookKeeper.DigestType.DUMMY, new byte[]{}},
                {BookKeeper.DigestType.DUMMY, new byte[]{0x01}},
                {BookKeeper.DigestType.DUMMY, mediumPassword},
                {BookKeeper.DigestType.DUMMY, longPassword},
                {BookKeeper.DigestType.DUMMY, new byte[]{(byte) 0xFF}}
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
}

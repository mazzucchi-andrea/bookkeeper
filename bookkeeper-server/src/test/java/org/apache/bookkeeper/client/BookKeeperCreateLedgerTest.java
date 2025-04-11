package org.apache.bookkeeper.client;

import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BookKeeperCreateLedgerTest extends BookKeeperClusterTestCase {
    private final BookKeeper.DigestType digestType;
    private final byte[] password;
    private final boolean expectedSuccess;

    public BookKeeperCreateLedgerTest(BookKeeper.DigestType digestType, byte[] password, boolean expectedSuccess) {
        super(5, 3, 30);
        this.digestType = digestType;
        this.password = password;
        this.expectedSuccess = expectedSuccess;
    }

    @Parameters
    public static Collection<Object[]> getTestParams() {
        byte[] emptyArray = new byte[]{};
        byte[] validPassword = "password".getBytes();
        return Arrays.asList(new Object[][]{
                {BookKeeper.DigestType.MAC, validPassword, true},
                {BookKeeper.DigestType.CRC32, validPassword, true},
                {BookKeeper.DigestType.CRC32C, validPassword, true},
                {BookKeeper.DigestType.DUMMY, validPassword, true},
                {BookKeeper.DigestType.MAC, null, false},
                {BookKeeper.DigestType.CRC32, emptyArray, true},
                {null, validPassword, false}
        });
    }

    @Test
    public void createLedgerTest() {
        // Creates a new ledger. Default of 3 servers, and quorum of 2 servers.
        try (LedgerHandle lh = bkc.createLedger(digestType, password)) {
            assertNotNull(lh);

            assertEquals(expectedSuccess, lh.isHandleWritable());

            assertEquals(3, lh.getLedgerMetadata().getEnsembleSize());

            assertEquals(2, lh.getLedgerMetadata().getAckQuorumSize());

            assertEquals(2, lh.getLedgerMetadata().getWriteQuorumSize());

            if (digestType == BookKeeper.DigestType.MAC) {
                assertArrayEquals(lh.getLedgerMetadata().getPassword(), password);
            }
        } catch (BKException | InterruptedException | NullPointerException e) {
            assertFalse("Unexpected exception: " + e.getMessage(), expectedSuccess);
        }
    }
}

package org.apache.bookkeeper.client;

import org.apache.bookkeeper.client.api.LedgerMetadata;
import org.apache.bookkeeper.net.BookieId;
import org.apache.bookkeeper.replication.ReplicationException;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.apache.zookeeper.KeeperException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@Timeout(120)
class BookKeeperAdminAutoRecoveryEnabledTest extends BookKeeperClusterTestCase {

    private static final String PASSWORD = "password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes();
    private static final BookKeeper.DigestType DIGEST_TYPE = BookKeeper.DigestType.MAC;
    private static final int NUM_BOOKIES = 3;

    public BookKeeperAdminAutoRecoveryEnabledTest() {
        super(NUM_BOOKIES);
        int lostBookieRecoveryDelayInitValue = 1800;
        baseConf.setLostBookieRecoveryDelay(lostBookieRecoveryDelayInitValue);
        baseConf.setOpenLedgerRereplicationGracePeriod(String.valueOf(30000));
        setAutoRecoveryEnabled(true);
    }

    private static Stream<Arguments> provideDataDecommissionBookieTest() {
        return Stream.of(
                // boolean running, boolean readOnly
                Arguments.of(true, true),
                Arguments.of(false, false),
                Arguments.of(true, false),
                Arguments.of(false, true)

        );
    }

    // decommissionBookie

    @ParameterizedTest
    @MethodSource("provideDataDecommissionBookieTest")
    void decommissionBookieTest(boolean running, boolean readOnly) {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        LedgerHandle lh;
        try {
            lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        } catch (BKException | InterruptedException e) {
            fail("Unable to create ledger: " + e.getMessage());
            return;
        }
        LedgerMetadata lm = bkAdmin.getLedgerMetadata(lh);
        BookieId bookieId = lm.getAllEnsembles().get(0L).get(0);
        if (readOnly){
            try {
                setBookieToReadOnly(bookieId);
            } catch (Exception e) {
                fail("Unable to set bookie readOnly: " + e.getMessage());
            }
        }
        if (!running) {
            shutdownBookie(bookieId);
            try {
                bkAdmin.decommissionBookie(bookieId);
            } catch (ReplicationException.CompatibilityException | ReplicationException.UnavailableException |
                     BKException | IOException | InterruptedException | ReplicationException.BKAuditException |
                     KeeperException | TimeoutException e) {
                fail("Unable to decommission bookie: " + e.getMessage());
            }
        } else {
            assertThrows(Exception.class, () -> bkAdmin.decommissionBookie(bookieId));
        }
    }

    @Test
    void decommissionBookieNoLedgerTest() throws ReplicationException.CompatibilityException, ReplicationException.UnavailableException, BKException, IOException, InterruptedException, ReplicationException.BKAuditException, KeeperException, TimeoutException {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        BookieId bookieId;
        try {
            bookieId = servers.get(0).getServer().getBookieId();
        } catch (UnknownHostException e) {
            fail("Unable to get BookieId: " + e.getMessage());
            return;
        }
        shutdownBookie(bookieId);
        bkAdmin.decommissionBookie(bookieId);
    }

    // utils

    private void shutdownBookie(BookieId bookieId) {
        try {
            for (ServerTester server : servers) {
                if (server.getServer().getBookieId().equals(bookieId)) {
                    server.shutdown();
                }
            }
        } catch (Exception e) {
            fail("Unable to shutdown Bookie: " + e.getMessage());
        }
    }
}

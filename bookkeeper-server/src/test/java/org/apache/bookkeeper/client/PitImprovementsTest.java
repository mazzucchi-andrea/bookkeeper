package org.apache.bookkeeper.client;

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
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PitImprovementsTest extends BookKeeperClusterTestCase {
    private static final String PASSWORD = "password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes();
    private static final BookKeeper.DigestType DIGEST_TYPE = BookKeeper.DigestType.MAC;
    private static final String VALID_STRING = "Test Entry";
    private static final byte[] VALID_STRING_BYTES = VALID_STRING.getBytes();
    private static final int NUM_BOOKIES = 5;
    private static final int NUM_ENTRIES = 10;

    public PitImprovementsTest() {
        super(NUM_BOOKIES);
        baseConf.setLostBookieRecoveryDelay(1800);
        baseConf.setOpenLedgerRereplicationGracePeriod(String.valueOf(30000));
    }

    private static Stream<Arguments> provideDataAddEntryTest() {
        byte[] testData = VALID_STRING_BYTES;

        return Stream.of(
                // byte[] data, int offset, int length
                Arguments.of(testData, 0, 1),
                Arguments.of(testData, testData.length - 1, 1)
        );
    }

    private static Stream<Arguments> provideDataDecommissionBookieTest() {
        return Stream.of(
                // boolean readOnly
                Arguments.of(false),
                Arguments.of(true)
        );
    }

    private static Stream<Arguments> provideDataGetLedgerPropertiesTest() {
        return Stream.of(
                // int numEntries
                Arguments.of(5),
                Arguments.of(10)
        );
    }

    private static Stream<Arguments> provideDataAddEntryBookiesTest() {
        return Stream.of(
                // int numBookies
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(5)
        );
    }

    @Test
    @Timeout(5)
    void adminCloseTest() {
        BookKeeperAdmin bkAdmin;
        try {
            bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString());
            try {
                bkAdmin.close();
            } catch (BKException | InterruptedException e) {
                fail("Unable to close BookKeeperAdmin");
            }
        } catch (IOException | InterruptedException | BKException e) {
            fail("Unable to create BookKeeperAdmin: " + e.getMessage());
        }
    }

    @Timeout(5)
    @ParameterizedTest
    @MethodSource("provideDataAddEntryTest")
    void addEntryTest(byte[] data, int offset, int length) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                long entryId = lh.addEntry(data, offset, length);
                assertTrue(entryId >= 0, "Entry ID should be equal or greater than zero");
            } catch (BKException | InterruptedException e) {
                fail("addEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Timeout(5)
    @ParameterizedTest
    @MethodSource("provideDataAddEntryBookiesTest")
    void addEntryWithReadOnlyBookiesTest(int numBookies) {
        try (LedgerHandle lh = bkc.createLedger(NUM_BOOKIES, NUM_BOOKIES, DIGEST_TYPE, PASSWORD_BYTES)) {
            List<BookieId> bookieIds = lh.getCurrentEnsemble();
            for (int i = 0; i < numBookies; i++) {
                setBookieToReadOnly(bookieIds.get(i));
            }
            assertThrows(Exception.class, () -> lh.addEntry(VALID_STRING_BYTES));
        } catch (Exception e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Timeout(120)
    @ParameterizedTest
    @MethodSource("provideDataDecommissionBookieTest")
    void decommissionBookieTest(boolean readOnly) {
        setAutoRecoveryEnabled(true);
        try {
            restartBookies();
        } catch (Exception e) {
            fail("BookKeeperCluster restart failed: " + e.getMessage());
        }
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        LedgerHandle lh = null;
        try {
            lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("Unable to create LedgerHandle: " + e.getMessage());
        }
        BookieId bookieId = lh.getCurrentEnsemble().get(0);
        if (readOnly) {
            try {
                setBookieToReadOnly(bookieId);
            } catch (Exception e) {
                fail("Unable to set bookie readOnly: " + e.getMessage());
            }
        }
        shutdownBookie(bookieId);
        try {
            bkAdmin.decommissionBookie(bookieId);
        } catch (ReplicationException.CompatibilityException | ReplicationException.UnavailableException |
                 BKException | IOException | InterruptedException | ReplicationException.BKAuditException |
                 KeeperException | TimeoutException e) {
            fail("Unable to decommission bookie: " + e.getMessage());
        }
        Enumeration<LedgerEntry> entries = null;
        try {
            entries = lh.readEntries(0, NUM_ENTRIES - 1);
        } catch (InterruptedException | BKException e) {
            fail("readEntries failed: " + e.getMessage());
        }
        int count = 0;
        while (entries.hasMoreElements()) {
            LedgerEntry entry = entries.nextElement();
            long entryId = entry.getEntryId();
            assertEquals(entryId, count);
            assertArrayEquals(("Entry " + count).getBytes(), entry.getEntry());
            count++;
        }
        assertEquals(NUM_ENTRIES, count);
    }

    @Timeout(5)
    @ParameterizedTest
    @MethodSource("provideDataGetLedgerPropertiesTest")
    void getLedgerPropertiesTest(int numEntries) {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            try {
                for (int i = 0; i < numEntries; i++) {
                    lh.addEntry(VALID_STRING_BYTES);
                }
            } catch (BKException | InterruptedException e) {
                fail("Unable to addEntry to the ledger: " + e.getMessage());
            }
            assertTrue(lh.getId() >= 0, "Ledger ID should be non-negative");
            assertEquals(numEntries - 1, lh.getLastAddConfirmed(), "Last add confirmed should match");
            assertEquals((long) numEntries * VALID_STRING_BYTES.length, lh.getLength(), "Ledger length should match number of entries");
            assertNotNull(lh.getLedgerKey(), "Ledger key should not be null");
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @Test
    @Timeout(5)
    void ledgerReadAfterBookieFailureTest() {
        try (LedgerHandle lh = bkc.createLedger(3, 2, DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < NUM_ENTRIES; i++) {
                lh.addEntry(("Entry " + i).getBytes());
            }
            List<BookieId> ensemble = lh.getCurrentEnsemble();
            assertEquals(3, ensemble.size());
            BookieId bookieToShutdown = ensemble.get(0);
            shutdownBookie(bookieToShutdown);
            try (LedgerHandle readLh = bkc.openLedger(lh.getId(), DIGEST_TYPE, PASSWORD_BYTES)) {
                assertEquals(lh.getLastAddConfirmed(), readLh.getLastAddConfirmed());
                Enumeration<LedgerEntry> entries = readLh.readEntries(0, readLh.getLastAddConfirmed());
                int count = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertArrayEquals(("Entry " + count).getBytes(), entry.getEntry());
                    count++;
                }
                assertEquals(NUM_ENTRIES, count);
            } catch (BKException | InterruptedException e) {
                fail("Failed to open ledger for reading: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("Failed to create ledger: " + e.getMessage());
        }
    }

    @Test
    @Timeout(5)
    void concurrentReadWriteOperationsTest() {
        try (LedgerHandle lh = bkc.createLedger(3, 2, DIGEST_TYPE, PASSWORD_BYTES)) {
            for (int i = 0; i < 10; i++) {
                lh.addEntry(("Entry " + i).getBytes());
            }
            Thread writerThread = new Thread(() -> {
                try {
                    for (int i = 0; i < 20; i++) {
                        lh.addEntry(("Concurrent " + i).getBytes());
                        Thread.sleep(50);
                    }
                } catch (Exception e) {
                    fail("Writer thread failed: " + e.getMessage());
                }
            });
            Thread readerThread = new Thread(() -> {
                try {
                    for (int i = 0; i < 5; i++) {
                        long lastEntry = lh.getLastAddConfirmed();
                        if (lastEntry >= 0) {
                            Enumeration<LedgerEntry> entries = lh.readEntries(0, lastEntry);
                            while (entries.hasMoreElements()) {
                                LedgerEntry entry = entries.nextElement();
                                byte[] data = entry.getEntry();
                                assertNotNull(data, "Entry data should not be null");
                            }
                        }
                        Thread.sleep(200);
                    }
                } catch (Exception e) {
                    fail("Reader thread failed: " + e.getMessage());
                }
            });
            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();

            long finalEntryCount = lh.getLastAddConfirmed() + 1; // +1 because entry IDs start at 0
            assertEquals(30, finalEntryCount);

            Enumeration<LedgerEntry> entries = lh.readEntries(0, lh.getLastAddConfirmed());
            int count = 0;
            while (entries.hasMoreElements()) {
                entries.nextElement();
                count++;
            }
            assertEquals(finalEntryCount, count);
        } catch (BKException | InterruptedException e) {
            fail("Test failed: " + e.getMessage());
        }
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

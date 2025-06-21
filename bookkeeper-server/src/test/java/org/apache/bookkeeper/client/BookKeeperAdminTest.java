package org.apache.bookkeeper.client;

import org.apache.bookkeeper.client.api.LedgerMetadata;
import org.apache.bookkeeper.net.BookieId;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.apache.bookkeeper.test.TestStatsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(120)
class BookKeeperAdminTest extends BookKeeperClusterTestCase {
    private static final String PASSWORD = "password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes();
    private static final BookKeeper.DigestType DIGEST_TYPE = BookKeeper.DigestType.MAC;
    private static final String VALID_STRING = "Test Entry";
    private static final int NUM_BOOKIES = 5;
    private static final int NUM_ENTRIES = 100;

    public BookKeeperAdminTest() {
        super(NUM_BOOKIES);
    }

    private static Stream<Arguments> provideDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(0, 0, 1), // Reads only the first entry
                Arguments.of(0, 1, 2), // Reads the first two entries
                Arguments.of(0, NUM_ENTRIES / 2 - 1, NUM_ENTRIES / 2)//, // Reads the first half of the entries
//                Arguments.of(NUM_ENTRIES / 2, NUM_ENTRIES - 1, NUM_ENTRIES / 2), // Reads the second half of the entries
//                Arguments.of(0, NUM_ENTRIES - 1, NUM_ENTRIES), // Reads all entries
//                Arguments.of(NUM_ENTRIES - 1, NUM_ENTRIES - 1, 1), // Reads only the last entry
//                Arguments.of(0, -1, NUM_ENTRIES)
        );
    }

    private static Stream<Arguments> provideInvalidDataReadEntriesTest() {
        return Stream.of(
                Arguments.of(-1L, -1L), // Exception (invalid value for 'firstEntry' and 'lastEntry'
                Arguments.of(-1L, 0L)//, // Exception (invalid value for `firstEntry`)
//                Arguments.of(0L, -1L), // Exception (invalid value for `lastEntry`)
//                Arguments.of(NUM_ENTRIES - 1, NUM_ENTRIES/2),
//                Arguments.of(0L, NUM_ENTRIES),  // Exception (invalid value for `lastEntry`)
//                Arguments.of(NUM_ENTRIES, NUM_ENTRIES - 1), // Exception (invalid value for `firstEntry`)
//                Arguments.of(NUM_ENTRIES, NUM_ENTRIES),
//                Arguments.of(NUM_ENTRIES, NUM_ENTRIES + 1),
//                Arguments.of(NUM_ENTRIES + 1, NUM_ENTRIES),
//                Arguments.of(0, -2)
        );
    }

    // constructor

    @Test
    void bookkeeperAdminZkTest() throws BKException, IOException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            Collection<BookieId> bookies = bkAdmin.getAllBookies();
            assertEquals(NUM_BOOKIES, bookies.size());
        }
    }

    @Test
    void bookkeeperAdminClientConfig() throws BKException, IOException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(baseClientConf)) {
            Collection<BookieId> bookies = bkAdmin.getAllBookies();
            assertEquals(NUM_BOOKIES, bookies.size());
        }
    }

    @Test
    void bookkeeperAdminClientConfig2() throws BKException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc, baseClientConf)) {
            Collection<BookieId> bookies = bkAdmin.getAllBookies();
            assertEquals(NUM_BOOKIES, bookies.size());
        }
    }

    @Test
    void bookkeeperAdminClient() throws BKException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc)) {
            Collection<BookieId> bookies = bkAdmin.getAllBookies();
            assertEquals(NUM_BOOKIES, bookies.size());
        }
    }

    @Test
    void bookkeeperAdminStats() throws BKException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc, new TestStatsProvider().getStatsLogger("/tmp/bookkeeper/test"), baseClientConf)) {
            Collection<BookieId> bookies = bkAdmin.getAllBookies();
            assertEquals(NUM_BOOKIES, bookies.size());
        }
    }

    @Test
    void bookkeeperAdminClosedClient() {
        try {
            bkc.close();
        } catch (BKException | InterruptedException e) {
            fail("BookKeeper client closed failed: " + e.getMessage());
        }
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        assertThrows(BKException.class, bkAdmin::getAllBookies);
    }

    // getAvailableBookies

    @Test
    void getAvailableBookiesTest() {
        Collection<BookieId> allBookies, availableBookies;
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            try {
                allBookies = bkAdmin.getAllBookies();
            } catch (BKException e) {
                fail("Unable to get all bookies: " + e.getMessage());
                return;
            }
            assertEquals(NUM_BOOKIES, allBookies.size());
            shutdownBookie();
            try {
                availableBookies = bkAdmin.getAvailableBookies();
            } catch (BKException e) {
                fail("Unable to get available bookies: " + e.getMessage());
                return;
            }
            assertEquals(NUM_BOOKIES - 1, availableBookies.size());
        } catch (IOException | InterruptedException | BKException e) {
            fail("Unable to create BookKeeperAdmin: " + e.getMessage());
        }
    }

    // getAllBookies

    @Test
    void getAllBookiesTest() {
        Collection<BookieId> allBookies;
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            try {
                allBookies = bkAdmin.getAllBookies();
            } catch (BKException e) {
                fail("Unable to get all bookies: " + e.getMessage());
                return;
            }
            assertEquals(NUM_BOOKIES, allBookies.size());
        } catch (IOException | InterruptedException | BKException e) {
            fail("Unable to create BookKeeperAdmin: " + e.getMessage());
        }
    }

    // getReadOnlyBookies

    @Test
    void getReadOnlyBookiesTest() {
        Collection<BookieId> allBookies, readOnlyBookies;
        try (BookKeeperAdmin admin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            // get all bookies before set one bookie to read-only
            try {
                allBookies = admin.getAllBookies();
                assertEquals(NUM_BOOKIES, allBookies.size());
            } catch (BKException e) {
                fail("Unable to get all bookies: " + e.getMessage());
                return;
            }
            try {
                readOnlyBookies = admin.getReadOnlyBookies();
                assertEquals(0, readOnlyBookies.size());
            } catch (BKException e) {
                fail("Unable to get read-only bookies: " + e.getMessage());
                return;
            }
            try {
                setReadOnlyBookie();
            } catch (Exception e) {
                fail("Unable to set read-only bookie");
            }
            try {
                readOnlyBookies = admin.getReadOnlyBookies();
                assertEquals(1, readOnlyBookies.size());
            } catch (BKException e) {
                fail("Unable to get read-only bookies: " + e.getMessage());
                return;
            }
            assertNotEquals(allBookies, readOnlyBookies);
        } catch (BKException | InterruptedException | IOException e) {
            fail("BookKeeperAdmin should not throw exception in this test");
        }
    }

    // openLedger

    @Test
    void openLedgerTest() throws BKException, IOException, InterruptedException {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString());
        // create a ledger handle
        LedgerHandle lh1 = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        // write an entry to test later
        lh1.addEntry(VALID_STRING.getBytes());
        LedgerEntry entry1 = lh1.readLastEntry();
        SortedMap<Long, LedgerMetadata> ledgerMetaMap = bkAdmin.getLedgersContainBookies(new HashSet<>(bkAdmin.getAllBookies()));
        List<Long> ledgerIds = new ArrayList<>();
        for (LedgerMetadata ledgerMeta : ledgerMetaMap.values()) {
            ledgerIds.add(ledgerMeta.getLedgerId());
        }
        // there is only one ledger in the cluster with one
        LedgerHandle alh = bkAdmin.openLedger(ledgerIds.get(0));
        LedgerEntry entry = alh.readLastEntry();

        assertEquals(lh1.getId(), alh.getId());
        assertEquals(entry1.getEntryId(), entry.getEntryId());
        assertArrayEquals(entry1.getEntry(), entry.getEntry());

        alh.close();
        lh1.close();
        bkAdmin.close();
    }

    @Test
    void openLedgerInvalidIdTest() throws BKException, IOException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            assertThrows(BKException.class, () -> bkAdmin.openLedger(-1));
        }
    }

    // asyncOpenLedger

    @Test
    void asyncOpenLedgerTest() throws BKException, IOException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            LedgerHandle lh1 = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
            lh1.addEntry(VALID_STRING.getBytes());
            LedgerEntry entry1 = lh1.readLastEntry();

            MyOpenCallback cb = new MyOpenCallback();
            bkAdmin.asyncOpenLedger(lh1.getId(), cb, null);

            cb.lock.await();

            LedgerHandle alh = cb.getLedger();
            LedgerEntry entry = alh.readLastEntry();

            assertEquals(lh1.getId(), alh.getId());
            assertEquals(entry1.getEntryId(), entry.getEntryId());
            assertArrayEquals(entry1.getEntry(), entry.getEntry());

            alh.close();
            lh1.close();
        }
    }

    // readEntries

    @Test
    void asyncOpenLedgerInvalidIdTest() throws BKException, IOException, InterruptedException {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            LedgerHandle lh1 = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
            lh1.addEntry(VALID_STRING.getBytes());

            MyOpenCallback cb = new MyOpenCallback();
            bkAdmin.asyncOpenLedger(-1, cb, null);

            cb.lock.await();

            LedgerHandle alh = cb.getLedger();
            assertNull(alh);

            lh1.close();
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataReadEntriesTest")
    void readEntriesTest(long firstEntry, long lastEntry, int expectedEntries) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
                assertEquals(NUM_ENTRIES - 1, lh.lastAddConfirmed);
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
                try {
                    int count = 0;
                    Iterable<LedgerEntry> entries = bkAdmin.readEntries(lh.getId(), firstEntry, lastEntry);
                    for (LedgerEntry entry : entries) {
                        long entryId = entry.getEntryId();
                        assertArrayEquals(("Entry " + entryId).getBytes(), entry.getEntry());
                        count++;
                    }
                    assertEquals(expectedEntries, count);
                } catch (BKException | InterruptedException e) {
                    fail("Unable to read entries: " + e.getMessage());
                }
            } catch (BKException | InterruptedException | IOException e) {
                fail("Unable to create BookKeeperAdmin: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDataReadEntriesTest")
    void readEntriesInvalidParametersTest(long firstEntry, long lastEntry) {
        try (LedgerHandle lh = bkc.createLedger(BookKeeper.DigestType.MAC, "password".getBytes())) {
            try {
                for (int i = 0; i < NUM_ENTRIES; i++) {
                    lh.addEntry(("Entry " + i).getBytes());
                }
            } catch (BKException | InterruptedException e) {
                fail("LedgerHandle addEntry failed: " + e.getMessage());
            }
            try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
                if (firstEntry < 0) {
                    assertThrows(IllegalArgumentException.class, () -> bkAdmin.readEntries(lh.getId(), firstEntry, lastEntry));
                } else {
                    assertThrows(BKException.class, () -> bkAdmin.readEntries(lh.getId(), firstEntry, lastEntry));
                }
            } catch (BKException | InterruptedException | IOException e) {
                fail("Unable to create BookKeeperAdmin: " + e.getMessage());
            }
        } catch (BKException | InterruptedException e) {
            fail("LedgerHandle creation failed: " + e.getMessage());
        }
    }

    // utils

    private void shutdownBookie() {
        try {
            servers.get(0).shutdown();
        } catch (Exception e) {
            fail("Unable to shutdown Bookie: " + e.getMessage());
        }
    }

    private void setReadOnlyBookie() throws Exception {
        setBookieToReadOnly(servers.get(0).getServer().getBookieId());
    }

    public static class MyOpenCallback implements AsyncCallback.OpenCallback {
        LedgerHandle openedLedger;
        CountDownLatch lock = new CountDownLatch(1);

        @Override
        public void openComplete(int rc, LedgerHandle lh, Object ctx) {
            if (rc == BKException.Code.OK) {
                openedLedger = lh;
            }
            lock.countDown();
        }

        public LedgerHandle getLedger() {
            return openedLedger;
        }
    }
}

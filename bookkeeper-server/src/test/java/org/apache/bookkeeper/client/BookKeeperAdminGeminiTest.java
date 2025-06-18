package org.apache.bookkeeper.client;

import org.apache.bookkeeper.client.AsyncCallback.OpenCallback;
import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.net.BookieId;
import org.apache.bookkeeper.stats.NullStatsLogger;
import org.apache.bookkeeper.stats.StatsLogger;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(120)
class BookKeeperAdminGeminiTest extends BookKeeperClusterTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(BookKeeperAdminGeminiTest.class);
    private static final String PASSWORD = "test_password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes(StandardCharsets.UTF_8);
    private static final BookKeeper.DigestType DIGEST_TYPE = BookKeeper.DigestType.MAC;
    private static final int NUM_BOOKIES = 3; // Default number of bookies for tests

    public BookKeeperAdminGeminiTest() {
        super(NUM_BOOKIES);
        // Configure auto-recovery to be enabled for cluster tests
        setAutoRecoveryEnabled(true);
    }

    // --- Constructor Tests ---

    private static Stream<Arguments> decommissionBookieTestCases() {
        return Stream.of(
                Arguments.of(true),  // Decommission a running bookie
                Arguments.of(false) // Decommission a shutdown bookie
        );
    }

    @Test
    @DisplayName("Test BookKeeperAdmin constructor with zkServers string")
    void testConstructorWithZkServers() throws Exception {
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(zkUtil.getZooKeeperConnectString())) {
            assertNotNull(bkAdmin);
            assertNotNull(bkAdmin.getConf());
            assertTrue(bkAdmin.getConf().getMetadataServiceUri().contains(zkUtil.getZooKeeperConnectString()));
        }
    }

    @Test
    @DisplayName("Test BookKeeperAdmin constructor with ClientConfiguration")
    void testConstructorWithClientConfiguration() throws Exception {
        ClientConfiguration conf = newClientConfiguration();
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(conf)) {
            assertNotNull(bkAdmin);
            assertEquals(conf, bkAdmin.getConf());
        }
    }

    @Test
    @DisplayName("Test BookKeeperAdmin constructor with BookKeeper, StatsLogger, ClientConfiguration")
    void testConstructorWithBkcStatsLoggerConf() throws Exception {
        // bkc is initialized in super.setUp()
        assertNotNull(bkc);
        StatsLogger statsLogger = NullStatsLogger.INSTANCE;
        ClientConfiguration conf = newClientConfiguration();
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc, statsLogger, conf)) {
            assertNotNull(bkAdmin);
        }
    }

    @Test
    @DisplayName("Test BookKeeperAdmin constructor with BookKeeper and ClientConfiguration")
    void testConstructorWithBkcConf() throws Exception {
        assertNotNull(bkc);
        ClientConfiguration conf = newClientConfiguration();
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc, conf)) {
            assertNotNull(bkAdmin);
        }
    }

    // --- decommissionBookie(BookieId bookieAddress) Tests ---

    @Test
    @DisplayName("Test BookKeeperAdmin constructor with only BookKeeper instance")
    void testConstructorWithOnlyBkc() throws Exception {
        assertNotNull(bkc);
        try (BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc)) {
            assertNotNull(bkAdmin);
            // The default configuration should be available from bkc
            assertNotNull(bkAdmin.getConf());
        }
    }

    @ParameterizedTest
    @MethodSource("decommissionBookieTestCases")
    @DisplayName("Test decommissionBookie with various bookie states")
    void testDecommissionBookie(boolean running) throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        LedgerHandle lh;
        try {
            lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES); // Create a ledger to ensure bookies are used
        } catch (BKException | InterruptedException e) {
            fail("Unable to create ledger: " + e.getMessage());
            return;
        }

        // Ensure there's at least one bookie to decommission
        assertFalse(servers.isEmpty(), "No bookies available to decommission.");

        // Get a bookie to test with
        BookieId bookieToDecommission = servers.get(0).getServer().getBookieId();

        if (!running) {
            // Simulate bookie shutdown for the 'not running' case
            shutdownBookie(bookieToDecommission);
            LOG.info("Attempting to decommission a non-running bookie: {}", bookieToDecommission);
            assertDoesNotThrow(() -> bkAdmin.decommissionBookie(bookieToDecommission),
                    "Decommissioning a non-running bookie should not throw an exception directly related to its state.");
            // Re-check available bookies to ensure it's gone from available
            Collection<BookieId> availableBookies = bkAdmin.getAvailableBookies();
            assertFalse(availableBookies.contains(bookieToDecommission),
                    "Decommissioned bookie should not be in available bookies.");
        } else {
            LOG.info("Attempting to decommission a running bookie: {}", bookieToDecommission);
            assertThrows(Exception.class, () -> bkAdmin.decommissionBookie(bookieToDecommission));
        }
        lh.close();
    }

    @Test
    @DisplayName("Test decommissionBookie with a non-existent BookieId")
    void testDecommissionNonExistentBookie() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        BookieId nonExistentBookie = BookieId.parse("nonexistent-host:8000");
        // Expecting no exception, as the system would simply not find it to decommission.
        assertDoesNotThrow(() -> bkAdmin.decommissionBookie(nonExistentBookie));
    }

    @Test
    @DisplayName("Test decommissionBookie with null BookieId")
    void testDecommissionNullBookieId() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        assertThrows(NullPointerException.class, () -> bkAdmin.decommissionBookie(null));
    }

    // Helper method adapted from BookKeeperAdminExampleTest
    private void shutdownBookie(BookieId bookieId) {
        try {
            for (ServerTester server : servers) {
                if (server.getServer().getBookieId().equals(bookieId)) {
                    server.shutdown();
                    LOG.info("Shut down bookie: {}", bookieId);
                    return;
                }
            }
            LOG.warn("Bookie {} not found to shut down.", bookieId);
        } catch (Exception e) {
            fail("Unable to shutdown Bookie: " + e.getMessage());
        }
    }

    // --- getAvailableBookies() Tests ---

    @Test
    @DisplayName("Test getAvailableBookies with all bookies available")
    void testGetAvailableBookiesAllAvailable() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Collection<BookieId> availableBookies = bkAdmin.getAvailableBookies();
        assertEquals(NUM_BOOKIES, availableBookies.size(), "All initial bookies should be available.");
        assertTrue(availableBookies.containsAll(bookieAddresses()), "All actual bookies should be in available list.");
    }

    @Test
    @DisplayName("Test getAvailableBookies with some bookies unavailable")
    void testGetAvailableBookiesSomeUnavailable() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        BookieId bookieToShutdown = servers.get(0).getServer().getBookieId();
        shutdownBookie(bookieToShutdown);
        // Give some time for ZK watcher to update
        Collection<BookieId> availableBookies = bkAdmin.getAvailableBookies();
        assertEquals(NUM_BOOKIES - 1, availableBookies.size(), "One bookie should be unavailable.");
        assertFalse(availableBookies.contains(bookieToShutdown), "Shut down bookie should not be available.");
    }

    @Test
    @DisplayName("Test getAvailableBookies with no bookies available")
    void testGetAvailableBookiesNoneAvailable() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        stopAllBookies(false); // Stop all bookies without closing the client
        // Give some time for ZK watcher to update
        Collection<BookieId> availableBookies = bkAdmin.getAvailableBookies();
        assertTrue(availableBookies.isEmpty(), "No bookies should be available.");
    }

    // --- getAllBookies() Tests ---

    @Test
    @DisplayName("Test getAllBookies with all bookies available")
    void testGetAllBookiesAllAvailable() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Collection<BookieId> allBookies = bkAdmin.getAllBookies();
        assertEquals(NUM_BOOKIES, allBookies.size(), "All initial bookies should be returned.");
        assertTrue(allBookies.containsAll(bookieAddresses()), "All actual bookies should be in all bookies list.");
    }

    @Test
    @DisplayName("Test getAllBookies with some bookies unavailable")
    void testGetAllBookiesSomeUnavailable() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        BookieId bookieToShutdown = servers.get(0).getServer().getBookieId();
        shutdownBookie(bookieToShutdown);
        // getAllBookies should still return the shutdown bookie as it's part of the cluster metadata
        Collection<BookieId> allBookies = bkAdmin.getAllBookies();
        assertEquals(NUM_BOOKIES, allBookies.size(), "getAllBookies should return all bookies including unavailable.");
        assertTrue(allBookies.contains(bookieToShutdown), "Shut down bookie should still be in all bookies list.");
    }

    @Test
    @DisplayName("Test getAllBookies with no bookies running (but still in metadata)")
    void testGetAllBookiesNoneRunning() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        stopAllBookies(false); // Stop all bookies without closing the client
        Collection<BookieId> allBookies = bkAdmin.getAllBookies();
        assertEquals(NUM_BOOKIES, allBookies.size(), "getAllBookies should return all registered bookies even if stopped.");
        assertTrue(allBookies.containsAll(bookieAddresses()), "All actual bookies should be in all bookies list.");
    }

    // --- getReadOnlyBookies() Tests ---

    @Test
    @DisplayName("Test getReadOnlyBookies with no read-only bookies")
    void testGetReadOnlyBookiesNoneReadOnly() throws BKException {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Collection<BookieId> readOnlyBookies = bkAdmin.getReadOnlyBookies();
        assertTrue(readOnlyBookies.isEmpty(), "Initially, there should be no read-only bookies.");
    }

    private void setReadOnlyBookie() throws Exception {
        setBookieToReadOnly(servers.get(0).getServer().getBookieId());
    }

    @Test
    @DisplayName("Test getReadOnlyBookies with some bookies set to read-only (manual simulation)")
    void testGetReadOnlyBookiesSomeReadOnly() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        setReadOnlyBookie();
        Collection<BookieId> readOnlyBookies = bkAdmin.getReadOnlyBookies();
        assertEquals(1, readOnlyBookies.size(), "Only one bookie should be in read-only mode.");
    }


    // --- openLedger(final long lId) Tests ---

    @Test
    @DisplayName("Test openLedger with an existing ledger")
    void testOpenLedgerExisting() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        // Write some entries
        for (int i = 0; i < 10; i++) {
            lh.addEntry(("entry-" + i).getBytes(StandardCharsets.UTF_8));
        }
        long ledgerId = lh.getId();
        lh.close(); // Close the ledger before opening with admin

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        LedgerHandle adminLh = bkAdmin.openLedger(ledgerId);
        assertNotNull(adminLh);
        assertEquals(ledgerId, adminLh.getId());
        assertEquals(9, adminLh.getLastAddConfirmed()); // 0-indexed, so 10 entries means lastAddConfirmed is 9
        adminLh.close();
    }

    @Test
    @DisplayName("Test openLedger with a non-existent ledger")
    void testOpenLedgerNonExistent() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        long nonExistentLedgerId = 123456L; // Assuming this ID does not exist
        assertThrows(BKException.BKNoSuchLedgerExistsOnMetadataServerException.class, () -> bkAdmin.openLedger(nonExistentLedgerId));
    }

    @Test
    @DisplayName("Test openLedger with invalid ledger ID (negative)")
    void testOpenLedgerInvalidIdNegative() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        assertThrows(BKException.BKNoSuchLedgerExistsOnMetadataServerException.class, () -> bkAdmin.openLedger(-1L));
    }

    @Test
    @DisplayName("Test openLedger with invalid ledger ID (zero)")
    void testOpenLedgerInvalidIdZero() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        // Assuming ledger ID 0 is invalid or reserved
        assertThrows(BKException.BKNoSuchLedgerExistsOnMetadataServerException.class, () -> bkAdmin.openLedger(0L));
    }

    // --- asyncOpenLedger(final long lId, final OpenCallback cb, final Object ctx) Tests ---

    @Test
    @DisplayName("Test asyncOpenLedger with an existing ledger")
    void testAsyncOpenLedgerExisting() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<LedgerHandle> resultHandle = new AtomicReference<>();
        AtomicReference<Integer> resultCode = new AtomicReference<>();

        OpenCallback callback = (rc, ledgerHandle, ctx) -> {
            resultCode.set(rc);
            resultHandle.set(ledgerHandle);
            latch.countDown();
        };

        bkAdmin.asyncOpenLedger(ledgerId, callback, null);
        assertTrue(latch.await(5, TimeUnit.SECONDS));

        assertEquals(BKException.Code.OK, resultCode.get());
        assertNotNull(resultHandle.get());
        assertEquals(ledgerId, resultHandle.get().getId());
        resultHandle.get().close();
    }

    @Test
    @DisplayName("Test asyncOpenLedger with a non-existent ledger")
    void testAsyncOpenLedgerNonExistent() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        long nonExistentLedgerId = 987654L;

        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Integer> resultCode = new AtomicReference<>();

        OpenCallback callback = (rc, ledgerHandle, ctx) -> {
            resultCode.set(rc);
            assertNull(ledgerHandle);
            latch.countDown();
        };

        bkAdmin.asyncOpenLedger(nonExistentLedgerId, callback, null);
        assertTrue(latch.await(5, TimeUnit.SECONDS));

        assertEquals(BKException.Code.NoSuchLedgerExistsOnMetadataServerException, resultCode.get());
    }

    @Test
    @DisplayName("Test asyncOpenLedger with null callback")
    void testAsyncOpenLedgerNullCallback() throws Exception {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        long ledgerId = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES).getId();
        bkc.close(); // Close bkc to release ledger handle
        // This might not throw an NPE immediately, but could lead to issues later.
        // It's a boundary condition. The method signature allows null context.
        // The LedgerOpenOp.initiate() does not explicitly check for null callback.
        // Depending on internal implementation, it might proceed and log an error.
        // For this test, we expect no immediate exception, but acknowledge this might be an area for defensive coding.
        assertDoesNotThrow(() -> bkAdmin.asyncOpenLedger(ledgerId, null, null));
    }


    // --- readEntries(long ledgerId, long firstEntry, long lastEntry) Tests ---

    @Test
    @DisplayName("Test readEntries with valid range")
    void testReadEntriesValidRange() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        for (int i = 0; i < 10; i++) {
            lh.addEntry(("entry-" + i).getBytes(StandardCharsets.UTF_8));
        }
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 0, 4); // Read entries 0 to 4
        int count = 0;
        for (LedgerEntry entry : entries) {
            assertEquals(count, entry.getEntryId());
            assertEquals("entry-" + count, new String(entry.getEntry(), StandardCharsets.UTF_8));
            count++;
        }
        assertEquals(5, count, "Should read 5 entries (0 to 4).");
    }

    @Test
    @DisplayName("Test readEntries with lastEntry as -1 (read all from firstEntry)")
    void testReadEntriesReadAllFromFirstEntry() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        for (int i = 0; i < 10; i++) {
            lh.addEntry(("entry-" + i).getBytes(StandardCharsets.UTF_8));
        }
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 5, -1); // Read from entry 5 to end
        int count = 5;
        for (LedgerEntry entry : entries) {
            assertEquals(count, entry.getEntryId());
            assertEquals("entry-" + count, new String(entry.getEntry(), StandardCharsets.UTF_8));
            count++;
        }
        assertEquals(10, count, "Should read entries from 5 to 9.");
    }

    @Test
    @DisplayName("Test readEntries with firstEntry and lastEntry as boundary values (single entry)")
    void testReadEntriesSingleEntry() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        lh.addEntry("single_entry".getBytes(StandardCharsets.UTF_8));
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 0, 0);
        int count = 0;
        for (LedgerEntry entry : entries) {
            assertEquals(0, entry.getEntryId());
            assertEquals("single_entry", new String(entry.getEntry(), StandardCharsets.UTF_8));
            count++;
        }
        assertEquals(1, count, "Should read exactly one entry.");
    }

    @Test
    @DisplayName("Test readEntries with empty ledger")
    void testReadEntriesEmptyLedger() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        long ledgerId = lh.getId();
        lh.close(); // The ledger exists but is empty

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 0, -1);
        assertFalse(entries.iterator().hasNext(), "Should not return any entries for an empty ledger.");
    }

    @Test
    @DisplayName("Test readEntries with firstEntry out of bounds (too high)")
    void testReadEntriesFirstEntryOutOfBounds() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        lh.addEntry("entry_0".getBytes(StandardCharsets.UTF_8));
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 10, -1); // Ledger only has entry 0
        assertFalse(entries.iterator().hasNext(), "Should not find entries if firstEntry is too high.");
    }

    @Test
    @DisplayName("Test readEntries with ledgerId non-existent")
    void testReadEntriesNonExistentLedger() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        long nonExistentLedgerId = 1234567L;
        assertThrows(RuntimeException.class, () -> bkAdmin.readEntries(nonExistentLedgerId, 0, 0).iterator(),
                "Expected RuntimeException encapsulating BKException.Code.NoSuchLedgerExistsException");
    }

    @Test
    @DisplayName("Test readEntries with invalid ledgerId (negative)")
    void testReadEntriesInvalidLedgerIdNegative() {
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        assertThrows(IllegalArgumentException.class, () -> bkAdmin.readEntries(-1L, 0, 0));
    }

    @Test
    @DisplayName("Test readEntries with invalid firstEntry (negative)")
    void testReadEntriesInvalidFirstEntryNegative() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        long ledgerId = lh.getId();
        lh.close();
        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        assertThrows(IllegalArgumentException.class, () -> bkAdmin.readEntries(ledgerId, -1L, 0));
    }

    @Test
    @DisplayName("Test readEntries with firstEntry greater than lastEntry")
    void testReadEntriesFirstEntryGreaterThanLastEntry() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        lh.addEntry("entry_0".getBytes(StandardCharsets.UTF_8));
        lh.addEntry("entry_1".getBytes(StandardCharsets.UTF_8));
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 1, 0); // firstEntry > lastEntry
        assertFalse(entries.iterator().hasNext(), "Should return no entries if firstEntry > lastEntry.");
    }

    @Test
    @DisplayName("Test readEntries with lastEntry beyond lastAddConfirmed")
    void testReadEntriesLastEntryBeyondLastAddConfirmed() throws Exception {
        LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
        lh.addEntry("entry_0".getBytes(StandardCharsets.UTF_8));
        lh.addEntry("entry_1".getBytes(StandardCharsets.UTF_8)); // lastAddConfirmed = 1
        long ledgerId = lh.getId();
        lh.close();

        BookKeeperAdmin bkAdmin = new BookKeeperAdmin(bkc);
        Iterable<LedgerEntry> entries = bkAdmin.readEntries(ledgerId, 0, 5); // Read from 0 to 5, but only 0 and 1 exist
        int count = 0;
        for (LedgerEntry entry : entries) {
            assertEquals(count, entry.getEntryId());
            count++;
        }
        assertEquals(2, count, "Should only read existing entries up to lastAddConfirmed.");
    }
}
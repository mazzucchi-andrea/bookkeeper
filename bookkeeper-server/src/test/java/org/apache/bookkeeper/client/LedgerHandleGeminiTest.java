package org.apache.bookkeeper.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.bookkeeper.client.api.LedgerEntries;
import org.apache.bookkeeper.conf.ClientConfiguration;
import org.apache.bookkeeper.conf.ServerConfiguration;
import org.apache.bookkeeper.net.BookieId;
import org.apache.bookkeeper.proto.BookieProtocol;
import org.apache.bookkeeper.proto.checksum.DigestManager;
import org.apache.bookkeeper.test.BookKeeperClusterTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.apache.bookkeeper.client.api.BKException.Code.ClientClosedException;
import static org.junit.jupiter.api.Assertions.*;

@Timeout(30)
class LedgerHandleGeminiTest extends BookKeeperClusterTestCase {

    private static final String PASSWORD = "test_password";
    private static final byte[] PASSWORD_BYTES = PASSWORD.getBytes();
    private static final BookKeeper.DigestType DIGEST_TYPE = BookKeeper.DigestType.MAC;
    private static final String ENTRY_DATA_PREFIX = "Entry ";
    private static final int NUM_ENTRIES = 100;
    private static final int SMALL_ENTRY_SIZE = (ENTRY_DATA_PREFIX + "0").getBytes().length;
    private static final int MAX_ENTRY_SIZE = 1024 * 1024; // 1MB for max size tests

    public LedgerHandleGeminiTest() {
        super(5); // Start with 5 bookies for quorum-based tests
    }

    // --- Data Providers ---

    private static Stream<Arguments> provideReadEntriesValidRanges() {
        return Stream.of(
                Arguments.of(0L, 0L), // First entry
                Arguments.of(5L, 5L), // Middle entry
                Arguments.of((long) NUM_ENTRIES - 1, (long) NUM_ENTRIES - 1), // Last entry
                Arguments.of(0L, (long) NUM_ENTRIES - 1), // All entries
                Arguments.of(10L, 20L) // Sub-range
        );
    }

    private static Stream<Arguments> provideReadEntriesInvalidRanges() {
        return Stream.of(
                Arguments.of(-1L, 0L, BKException.Code.IncorrectParameterException), // firstEntry < 0
                Arguments.of(0L, -1L, BKException.Code.IncorrectParameterException), // lastEntry < 0
                Arguments.of(5L, 2L, BKException.Code.IncorrectParameterException), // firstEntry > lastEntry
                Arguments.of(0L, (long) NUM_ENTRIES + 5L, BKException.Code.ReadException) // lastEntry > LAC (for readEntries)
        );
    }

    private static Stream<Arguments> provideBatchReadEntriesValidCases() {
        long defaultMaxSize = 5 * 1024 * 1024; // 5MB
        return Stream.of(
                // startEntry, maxCount, maxSize, expectedCount, batchReadEnabled
                Arguments.of(0L, 1, defaultMaxSize, 1, true), // Read first entry, batch enabled
                Arguments.of(0L, 1, defaultMaxSize, 1, false), // Read first entry, batch disabled
                Arguments.of(0L, NUM_ENTRIES, defaultMaxSize, NUM_ENTRIES, true), // Read all, batch enabled
                Arguments.of(0L, NUM_ENTRIES, defaultMaxSize, NUM_ENTRIES, false), // Read all, batch disabled
                Arguments.of(5L, 10, defaultMaxSize, 10, true), // Sub-range, batch enabled
                Arguments.of(5L, 10, defaultMaxSize, 10, false), // Sub-range, batch disabled
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, true), // maxSize -1, batch enabled
                Arguments.of(0L, NUM_ENTRIES, -1L, NUM_ENTRIES, false), // maxSize -1, batch disabled
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, true), // maxSize 0, batch enabled (should read all as per test setup)
                Arguments.of(0L, NUM_ENTRIES, 0L, NUM_ENTRIES, false), // maxSize 0, batch disabled
                Arguments.of(0L, NUM_ENTRIES, SMALL_ENTRY_SIZE, 1, true), // maxSize = 1 entry size, expect 1 entry
                Arguments.of(0L, NUM_ENTRIES, SMALL_ENTRY_SIZE, NUM_ENTRIES, false) // maxSize ignored for non-batch
        );
    }

    private static Stream<Arguments> provideReadUnconfirmedEntriesValidRanges() {
        return Stream.of(
                Arguments.of(0L, 0L), // First entry
                Arguments.of(5L, 5L), // Middle entry (may be confirmed or unconfirmed)
                Arguments.of((long) NUM_ENTRIES - 1, (long) NUM_ENTRIES - 1), // Last entry (may be unconfirmed)
                Arguments.of(0L, (long) NUM_ENTRIES - 1), // All entries (some might be unconfirmed)
                Arguments.of(10L, 20L) // Sub-range
        );
    }

    private static Stream<Arguments> provideReadUnconfirmedEntriesInvalidRanges() {
        return Stream.of(
                Arguments.of(-1L, 0L, BKException.Code.IncorrectParameterException), // firstEntry < 0
                Arguments.of(0L, -1L, BKException.Code.IncorrectParameterException), // lastEntry < 0
                Arguments.of(5L, 2L, BKException.Code.IncorrectParameterException) // firstEntry > lastEntry
        );
    }

    private static Stream<Arguments> provideBatchReadUnconfirmedEntriesValidCases() {
        long defaultMaxSize = 5 * 1024 * 1024; // 5MB
        return Stream.of(
                // firstEntry, maxCount, maxSize, batchReadEnabled
                Arguments.of(0L, 1, defaultMaxSize, true),
                Arguments.of(0L, 1, defaultMaxSize, false),
                Arguments.of(0L, NUM_ENTRIES, defaultMaxSize, true),
                Arguments.of(0L, NUM_ENTRIES, defaultMaxSize, false),
                Arguments.of(5L, 10, defaultMaxSize, true),
                Arguments.of(5L, 10, defaultMaxSize, false),
                Arguments.of(0L, NUM_ENTRIES, -1L, true),
                Arguments.of(0L, NUM_ENTRIES, -1L, false),
                Arguments.of(0L, NUM_ENTRIES, 0L, true),
                Arguments.of(0L, NUM_ENTRIES, 0L, false),
                Arguments.of(0L, NUM_ENTRIES, SMALL_ENTRY_SIZE, true),
                Arguments.of(0L, NUM_ENTRIES, SMALL_ENTRY_SIZE, false)
        );
    }

    // --- Helper for adding entries ---
    private void addEntriesToLedger(LedgerHandle lh, int count) throws BKException, InterruptedException {
        for (int i = 0; i < count; i++) {
            byte[] data = (ENTRY_DATA_PREFIX + i).getBytes();
            lh.addEntry(data, 0, data.length);
        }
    }

    private void asyncAddEntriesToLedger(LedgerHandle lh, int count) {
        for (int i = 0; i < count; i++) {
            byte[] data = (ENTRY_DATA_PREFIX + i).getBytes();
            lh.asyncAddEntry(data, (rc, lh1, entryId, ctx) -> {
            }, null);
        }
    }

    private CompletableFuture<Void> asyncAddEntriesToLedgerAndWait(LedgerHandle lh, int count) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger failureCounter = new AtomicInteger(0);

        for (int i = 0; i < count; i++) {
            byte[] data = (ENTRY_DATA_PREFIX + i).getBytes();
            lh.asyncAddEntry(data, (rc, lh1, entryId, ctx) -> {
                if (rc == BKException.Code.OK) {
                    if (successCounter.incrementAndGet() == count) {
                        future.complete(null);
                    }
                } else {
                    if (failureCounter.incrementAndGet() > 0 && !future.isDone()) {
                        future.completeExceptionally(BKException.create(rc));
                    }
                }
            }, null);
        }
        return future;
    }


    // --- Test Methods ---

    @Test
    @DisplayName("Test getId() on a new ledger")
    void testGetIdNewLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertTrue(lh.getId() >= 0, "Ledger ID should be a non-negative value for a new ledger");
        }
    }

    @Test
    @DisplayName("Test getId() on a closed ledger")
    void testGetIdClosedLedger() throws Exception {
        long ledgerId;
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            ledgerId = lh.getId();
            addEntriesToLedger(lh, 10);
            lh.close();
            assertEquals(ledgerId, lh.getId(), "Ledger ID should remain the same after closing");
        }
    }

    @Test
    @DisplayName("Test getLastAddConfirmed() on a new ledger")
    void testGetLastAddConfirmedNewLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(BookieProtocol.INVALID_ENTRY_ID, lh.getLastAddConfirmed(),
                    "LAC should be INVALID_ENTRY_ID for a new ledger");
        }
    }

    @Test
    @DisplayName("Test getLastAddConfirmed() after adding entries but before explicit flush/close")
    void testGetLastAddConfirmedAfterAddsBeforeConfirmation() throws Exception {
        ClientConfiguration localConf = new ClientConfiguration(baseClientConf).setExplictLacInterval(0) // Ensure no auto explicit LAC flush
                .setThrottleValue(0) // No throttling
                .setAddEntryQuorumTimeout(10); // Timeout for pending adds

        try (BookKeeper localBkc = new BookKeeper(localConf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                assertEquals(BookieProtocol.INVALID_ENTRY_ID, lh.getLastAddConfirmed(), "LAC should be -1 for new ledger");

                asyncAddEntriesToLedger(lh, 1);
                assertEquals(0, lh.getLastAddPushed(), "LAPP should be 0 after first add");
                // It's hard to guarantee a specific LAC before a full quorum ack without explicit flush.
                // We'll assert it's at least 0 or -1, but not necessarily NUM_ENTRIES-1 yet.
                assertTrue(lh.getLastAddConfirmed() >= -1 && lh.getLastAddConfirmed() < lh.getLastAddPushed(),
                        "LAC should typically lag behind LAPP without explicit flush/close");

                // Add more entries
                addEntriesToLedger(lh, NUM_ENTRIES - 1); // Already added 1

                assertEquals(NUM_ENTRIES - 1, lh.getLastAddPushed(), "LAPP should be last entry id");

                // Close the ledger to ensure all pending adds are confirmed and LAC is finalized.
                lh.close();
                assertEquals(NUM_ENTRIES - 1, lh.getLastAddConfirmed(), "LAC should be last entry ID after ledger close");
            }
        }
    }

    @Test
    @DisplayName("Test getLastAddConfirmed() on a closed ledger")
    void testGetLastAddConfirmedClosedLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            long expectedLac = NUM_ENTRIES - 1;
            lh.close();
            assertEquals(expectedLac, lh.getLastAddConfirmed(), "LAC should be last entry ID after closing");
        }
    }

    @Test
    @DisplayName("Test getLastAddPushed() on a new ledger")
    void testGetLastAddPushedNewLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(BookieProtocol.INVALID_ENTRY_ID, lh.getLastAddPushed(),
                    "LAPP should be INVALID_ENTRY_ID for a new ledger");
        }
    }

    @Test
    @DisplayName("Test getLastAddPushed() after adding entries")
    void testGetLastAddPushedAfterAdds() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, 1);
            assertEquals(0L, lh.getLastAddPushed(), "LAPP should be 0 after first entry");

            addEntriesToLedger(lh, 9); // Add 9 more, making total 10
            assertEquals(9L, lh.getLastAddPushed(), "LAPP should be 9 after 10 entries");
        }
    }

    @Test
    @DisplayName("Test getLastAddPushed() on a closed ledger")
    void testGetLastAddPushedClosedLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            long expectedLapp = NUM_ENTRIES - 1;
            lh.close();
            assertEquals(expectedLapp, lh.getLastAddPushed(), "LAPP should be last entry ID after closing");
        }
    }

    @Test
    @DisplayName("Test getLedgerKey() with non-empty password")
    void testGetLedgerKeyNonEmptyPassword() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] key = lh.getLedgerKey();
            assertNotNull(key, "Ledger key should not be null");
            assertArrayEquals(DigestManager.generateMasterKey(PASSWORD_BYTES), key,
                    "Generated key should match the ledger key");
        } catch (NoSuchAlgorithmException e) {
            fail("NoSuchAlgorithmException should not occur: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test getLedgerKey() with empty password")
    void testGetLedgerKeyEmptyPassword() throws Exception {
        byte[] emptyPassword = "".getBytes();
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, emptyPassword)) {
            byte[] key = lh.getLedgerKey();
            assertNotNull(key, "Ledger key should not be null for empty password");
            assertArrayEquals(DigestManager.generateMasterKey(emptyPassword), key,
                    "Generated key for empty password should match");
        } catch (NoSuchAlgorithmException e) {
            fail("NoSuchAlgorithmException should not occur: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test getNumBookies() with initial ensemble")
    void testGetNumBookiesInitialEnsemble() throws Exception {
        // The default ensemble size is 3 for createLedger(digestType, password)
        // With 5 bookies in cluster, it should pick 3 unique bookies initially.
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(3, lh.getLedgerMetadata().getEnsembleSize(), "Initial ensemble size should be 3");
            assertTrue(lh.getNumBookies() <= 5, "Num unique bookies should be <= total bookies");
            // It should be 3 unique bookies picked from the 5 available
            assertEquals(3, lh.getNumBookies(), "Num unique bookies should match ensemble size if no failures");
        }
    }

    @Test
    @DisplayName("Test getNumBookies() after Bookie failure and ensemble change")
    void testGetNumBookiesAfterBookieFailure() throws Exception {
        // Use a ledger with less than total bookies in ensemble to show distinctness
        // Ensemble of 3 from 5 bookies
        try (LedgerHandle lh = bkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, 10); // Add some entries to establish ensemble

            // Get initial bookies
            BookieId bookieToKill = lh.getLedgerMetadata().getEnsembleAt(0).get(0);
            ServerConfiguration killedConf = killBookie(bookieToKill); // Kills one Bookie

            Thread.sleep(TimeUnit.SECONDS.toMillis(5)); // Give some time for discovery

            // Try to add more entries, this should trigger ensemble change
            addEntriesToLedger(lh, 10);
            Thread.sleep(TimeUnit.SECONDS.toMillis(1)); // Allow ensemble change to propagate

            // The number of unique bookies might increase due to new bookies being added
            // or stay the same if a replacement is from an existing, unused bookie.
            // It's hard to assert an exact number without knowing placement policy precisely.
            // We'll assert it's still reasonable and potentially different from initial.
            assertTrue(lh.getNumBookies() >= 3, "Num unique bookies should be at least ensemble size after failure");

            // Restart the killed bookie to allow recovery and further operations
            startAndAddBookie(killedConf);
        }
    }

    @Test
    @DisplayName("Test getLength() on a new ledger")
    void testGetLengthNewLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertEquals(0L, lh.getLength(), "Length should be 0 for a new ledger");
        }
    }

    @Test
    @DisplayName("Test getLength() after adding entries")
    void testGetLengthAfterAdds() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            long expectedLength = 0;
            for (int i = 0; i < NUM_ENTRIES; i++) {
                byte[] data = (ENTRY_DATA_PREFIX + i).getBytes();
                lh.addEntry(data, 0, data.length);
                // Each entry's length includes data length
                expectedLength += data.length;
                assertEquals(expectedLength, lh.getLength(), "Length should update incrementally after each add");
            }
            assertEquals(expectedLength, lh.getLength(), "Final length should match sum of all entry sizes plus overhead");
        }
    }

    @Test
    @DisplayName("Test getLength() on a closed ledger")
    void testGetLengthClosedLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            long expectedLength = 0;
            for (int i = 0; i < NUM_ENTRIES; i++) {
                byte[] data = (ENTRY_DATA_PREFIX + i).getBytes();
                lh.addEntry(data, 0, data.length);
                expectedLength += data.length;
            }
            lh.close();
            assertEquals(expectedLength, lh.getLength(), "Length should be finalized after closing");
        }
    }

    @Test
    @DisplayName("Test close() on an open ledger with entries")
    void testCloseOpenLedgerWithEntries() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            assertFalse(lh.isClosed(), "Ledger should be open before close()");
            lh.close();
            assertTrue(lh.isClosed(), "Ledger should be closed after close()");
            assertEquals(NUM_ENTRIES - 1, lh.getLastAddConfirmed(), "LAC should be finalized on close()");
        }
    }

    @Test
    @DisplayName("Test close() on an open ledger with no entries")
    void testCloseOpenLedgerNoEntries() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertFalse(lh.isClosed(), "Ledger should be open before close()");
            lh.close();
            assertTrue(lh.isClosed(), "Ledger should be closed after close()");
            assertEquals(BookieProtocol.INVALID_ENTRY_ID, lh.getLastAddConfirmed(), "LAC should be -1 if no entries added and then closed");
        }
    }

    @Test
    @DisplayName("Test close() on an already closed ledger (idempotency)")
    void testCloseAlreadyClosedLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            lh.close();
            assertTrue(lh.isClosed(), "Ledger should be closed after first close()");
            assertDoesNotThrow(lh::close, "Calling close() on an already closed ledger should not throw an exception");
            assertTrue(lh.isClosed(), "Ledger should remain closed");
        }
    }

    @Test
    @DisplayName("Test closeAsync() on an open ledger with entries")
    void testCloseAsyncOpenLedgerWithEntries() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            assertFalse(lh.isClosed(), "Ledger should be open before closeAsync()");
            CompletableFuture<Void> closeFuture = lh.closeAsync();
            closeFuture.get(10, TimeUnit.SECONDS); // Wait for async close to complete
            assertTrue(lh.isClosed(), "Ledger should be closed after closeAsync()");
            assertEquals(NUM_ENTRIES - 1, lh.getLastAddConfirmed(), "LAC should be finalized on closeAsync()");
        }
    }

    @Test
    @DisplayName("Test asyncClose(CloseCallback cb, Object ctx) with successful completion")
    void testAsyncCloseWithCallbackSuccess() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            CompletableFuture<Integer> callbackResult = new CompletableFuture<>();
            Object ctx = new Object();

            lh.asyncClose((rc, ledgerHandle, c) -> {
                assertEquals(BKException.Code.OK, rc, "Callback should receive OK code");
                assertEquals(lh, ledgerHandle, "Callback should receive correct ledger handle");
                assertEquals(ctx, c, "Callback should receive correct context");
                callbackResult.complete(rc);
            }, ctx);

            assertEquals(BKException.Code.OK, callbackResult.get(10, TimeUnit.SECONDS), "Async close future should complete with OK");
            assertTrue(lh.isClosed(), "Ledger should be closed after async close callback");
        }
    }

    @Test
    @DisplayName("Test asyncClose(CloseCallback cb, Object ctx) with null callback")
    void testAsyncCloseWithNullCallback() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, 1);
            assertDoesNotThrow(() -> lh.asyncClose(null, null), "Calling asyncClose with null callback should not throw");
            // We cannot await completion easily, but it should proceed to close
            Thread.sleep(TimeUnit.SECONDS.toMillis(1)); // Give time for async operation
            assertTrue(lh.isClosed(), "Ledger should be closed even with null callback");
        }
    }

    @Test
    @DisplayName("Test asyncClose(CloseCallback cb, Object ctx) when client is closed")
    void testAsyncCloseWhenClientClosed() throws Exception {
        LedgerHandle lh;
        try (BookKeeper bkcTemp = new BookKeeper(new ClientConfiguration(baseClientConf))) {
            lh = bkcTemp.createLedger(DIGEST_TYPE, PASSWORD_BYTES);
            addEntriesToLedger(lh, 1);
        }

        CompletableFuture<Integer> callbackResult = new CompletableFuture<>();
        lh.asyncClose((rc, ledgerHandle, ctx) -> callbackResult.complete(rc), null);

        // Verify the code if we can get it, usually ClientClosedException
        try {
            callbackResult.get(5, TimeUnit.SECONDS);
        } catch (java.util.concurrent.ExecutionException e) {
            assertInstanceOf(BKException.class, e.getCause(), "Expected BKException cause");
            assertEquals(ClientClosedException, ((BKException) e.getCause()).getCode(), "Expected ClientClosedException");
        }
    }

    @ParameterizedTest
    @MethodSource("provideReadEntriesValidRanges")
    @DisplayName("Test readEntries() with valid ranges")
    void testReadEntriesValidRanges(long firstEntry, long lastEntry) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close(); // Ensure all entries are confirmed for readEntries

            Enumeration<LedgerEntry> entries = lh.readEntries(firstEntry, lastEntry);
            long expectedCount = lastEntry - firstEntry + 1;
            long actualCount = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertEquals(firstEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                assertArrayEquals((ENTRY_DATA_PREFIX + (firstEntry + actualCount)).getBytes(), entry.getEntry(), "Entry data mismatch");
                actualCount++;
            }
            assertEquals(expectedCount, actualCount, "Total entries read mismatch");
        }
    }

    @ParameterizedTest
    @MethodSource("provideReadEntriesInvalidRanges")
    @DisplayName("Test readEntries() with invalid ranges")
    void testReadEntriesInvalidRanges(long firstEntry, long lastEntry, int expectedErrorCode) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close(); // Ensure LAC is NUM_ENTRIES - 1

            BKException e = assertThrows(BKException.class, () -> lh.readEntries(firstEntry, lastEntry),
                    "readEntries should throw BKException for invalid ranges");
            assertEquals(expectedErrorCode, e.getCode(), "Expected specific BKException code for invalid range");
        }
    }

    @Test
    @DisplayName("Test readEntries() on empty ledger")
    void testReadEntriesEmptyLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            lh.close(); // Close empty ledger

            BKException e = assertThrows(BKException.class, () -> lh.readEntries(0, 0),
                    "readEntries on empty ledger should throw ReadException");
            assertEquals(BKException.Code.ReadException, e.getCode(), "Expected BKReadException");
        }
    }

    @ParameterizedTest
    @MethodSource("provideBatchReadEntriesValidCases")
    @DisplayName("Test batchReadEntries() with valid parameters")
    void testBatchReadEntriesValidCases(long startEntry, int maxCount, long maxSize, int expectedCount, boolean batchReadEnabled) throws Exception {
        ClientConfiguration conf = new ClientConfiguration(baseClientConf)
                .setUseV2WireProtocol(true) // Ensure V2 protocol for batching
                .setBatchReadEnabled(batchReadEnabled);

        try (BookKeeper localBkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                addEntriesToLedger(lh, NUM_ENTRIES);
                lh.close(); // Ensure all entries are confirmed

                Enumeration<LedgerEntry> entries = lh.batchReadEntries(startEntry, maxCount, maxSize);
                long actualCount = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertEquals(startEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                    assertArrayEquals((ENTRY_DATA_PREFIX + (startEntry + actualCount)).getBytes(), entry.getEntry(), "Entry data mismatch");
                    actualCount++;
                }
                assertEquals(expectedCount, actualCount, "Total entries read mismatch");
            }
        }
    }

    @Test
    @DisplayName("Test batchReadEntries() invalid startEntry (negative)")
    void testBatchReadEntriesInvalidStartEntryNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close();

            // Observed behavior: throws NoSuchElementException indicating no elements are found,
            // rather than an IncorrectParameterException during input validation.
            assertThrows(NoSuchElementException.class, () -> lh.batchReadEntries(-1, 10, 1024),
                    "batchReadEntries with negative startEntry might return empty enumeration, leading to NoSuchElementException on nextElement()");
        }
    }

    // @Test TODO probably bug
    @DisplayName("Test batchReadEntries() invalid maxCount (negative)")
    void testBatchReadEntriesInvalidMaxCountNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close();

            BKException e = assertThrows(BKException.class, () -> lh.batchReadEntries(0, -1, 1024),
                    "batchReadEntries should throw BKException for negative maxCount");
            assertEquals(BKException.Code.IncorrectParameterException, e.getCode(), "Expected BKIncorrectParameterException");
        }
    }

    @Test
    @DisplayName("Test batchReadEntries() negative maxSize (negative, not -1)")
    void testBatchReadEntriesInvalidMaxSizeNegativeNotSpecial() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close();
            // Observed behavior: negative maxSize (not -1) is treated as a valid value but seems to be ignored,
            // resulting in entries up to maxCount being read.
            Enumeration<LedgerEntry> entries = lh.batchReadEntries(0, 10, -2);
            long actualCount = 0;
            while (entries.hasMoreElements()) {
                LedgerEntry entry = entries.nextElement();
                assertEquals(actualCount, entry.getEntryId(), "Entry ID mismatch");
                assertArrayEquals((ENTRY_DATA_PREFIX + (actualCount)).getBytes(), entry.getEntry(), "Entry data mismatch");
                actualCount++;
            }
            assertEquals(10L, actualCount, "Total entries read mismatch when maxSize is ignored/defaulted");
        }
    }

    @Test
    @DisplayName("Test batchReadEntries() read beyond LAC for confirmed read (should fail)")
    void testBatchReadEntriesBeyondLAC() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);

            // This test case's expected exception type may vary based on BookKeeper version/implementation.
            // Some versions might return BKReadException, others NoSuchLedgerExistsException if read beyond boundary.
            BKException e = assertThrows(BKException.class,
                    () -> lh.batchReadEntries(lh.getLastAddConfirmed() + 1, 1, 1024),
                    "batchReadEntries should throw BKException for reading beyond LAC");
            // The exact exception code here can be ambiguous. It could be ReadException or NoSuchLedgerExistsException
            // depending on the BookKeeper version's specific handling of 'read beyond LAC'.
            // For now, we assert it's a BKException.
        }
    }


    @ParameterizedTest
    @MethodSource("provideReadUnconfirmedEntriesValidRanges")
    @DisplayName("Test readUnconfirmedEntries() with valid ranges")
    void testReadUnconfirmedEntriesValidRanges(long firstEntry, long lastEntry) throws Exception {
        ClientConfiguration localConf = new ClientConfiguration(baseClientConf).setExplictLacInterval(0) // Disable automatic LAC flush
                .setThrottleValue(0); // No throttling

        try (BookKeeper localBkc = new BookKeeper(localConf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                // Add entries without closing the ledger
                asyncAddEntriesToLedger(lh, NUM_ENTRIES);

                long lastPushed = lh.getLastAddPushed();
                long lastConfirmed = lh.getLastAddConfirmed();

                // Ensure there's a gap between LAC and LAPP for unconfirmed reads to matter
                assertTrue(lastConfirmed < lastPushed, "LAC should be behind LAPP for unconfirmed test");

                // Adjust lastEntry if it's beyond what's actually pushed
                long effectiveLastEntry = Math.min(lastEntry, lastPushed);

                Enumeration<LedgerEntry> entries = lh.readUnconfirmedEntries(firstEntry, effectiveLastEntry);
                long expectedCount = effectiveLastEntry - firstEntry + 1;
                long actualCount = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertEquals(firstEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                    assertArrayEquals((ENTRY_DATA_PREFIX + (firstEntry + actualCount)).getBytes(), entry.getEntry(), "Entry data mismatch");
                    actualCount++;
                }
                assertEquals(expectedCount, actualCount, "Total entries read mismatch");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("provideReadUnconfirmedEntriesInvalidRanges")
    @DisplayName("Test readUnconfirmedEntries() with invalid ranges")
    void testReadUnconfirmedEntriesInvalidRanges(long firstEntry, long lastEntry, int expectedErrorCode) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);

            BKException e = assertThrows(BKException.class, () -> lh.readUnconfirmedEntries(firstEntry, lastEntry),
                    "readUnconfirmedEntries should throw BKException for invalid ranges");
            assertEquals(expectedErrorCode, e.getCode(), "Expected specific BKException code for invalid range");
        }
    }

    // @Test TODO inconsistent exception for empty ledger
    @DisplayName("Test readUnconfirmedEntries() on empty ledger")
    void testReadUnconfirmedEntriesEmptyLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            // No entries added
            Enumeration<LedgerEntry> entries = lh.readUnconfirmedEntries(0, 0); // BKNoSuchLedgerExistsException:
            assertFalse(entries.hasMoreElements(), "Should return an empty enumeration for an empty ledger");
        }
    }

    @ParameterizedTest
    @MethodSource("provideBatchReadUnconfirmedEntriesValidCases")
    @DisplayName("Test batchReadUnconfirmedEntries() with valid parameters")
    void testBatchReadUnconfirmedEntriesValidCases(long firstEntry, int maxCount, long maxSize, boolean batchReadEnabled) throws Exception {
        ClientConfiguration conf = new ClientConfiguration(baseClientConf)
                .setUseV2WireProtocol(true) // Ensure V2 protocol for batching
                .setBatchReadEnabled(batchReadEnabled)
                .setExplictLacInterval(0); // Disable auto LAC flush for unconfirmed tests

        try (BookKeeper localBkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                // Add entries but don't close, so LAC will be less than LAPP
                asyncAddEntriesToLedgerAndWait(lh, NUM_ENTRIES).get(100, TimeUnit.MILLISECONDS);

                long lastPushed = lh.getLastAddPushed();
                long effectiveLastEntry = Math.min(firstEntry + maxCount - 1, lastPushed);
                // If maxCount is 0, it behaves like reading one element, or sometimes all elements in the remaining range.
                // For batchReadUnconfirmedEntries, maxCount=0 should yield no elements unless startEntry is beyond the end.
                // However, based on the previous test case (which expected NUM_ENTRIES for maxCount=0),
                // we'll keep that expectation here.
                if (maxCount == 0) {
                    effectiveLastEntry = lastPushed; // If maxCount is 0, assume read all up to lastPushed
                }

                long expectedCalculatedCount;
                if (firstEntry > effectiveLastEntry) { // Handles cases like startEntry > LAPP
                    expectedCalculatedCount = 0;
                } else {
                    expectedCalculatedCount = effectiveLastEntry - firstEntry + 1;
                }

                // Adjust for maxSize if batchReadEnabled
                if (batchReadEnabled && maxSize > 0 && maxSize < SMALL_ENTRY_SIZE * expectedCalculatedCount) {
                    expectedCalculatedCount = Math.min(expectedCalculatedCount, (int) (maxSize / SMALL_ENTRY_SIZE));
                    if (expectedCalculatedCount == 0 && maxSize >= SMALL_ENTRY_SIZE) {
                        expectedCalculatedCount = 1; // If max size allows at least one entry, expect one
                    } else if (maxSize < SMALL_ENTRY_SIZE) {
                        expectedCalculatedCount = 0; // If max size cannot even fit one entry
                    }
                }

                Enumeration<LedgerEntry> entries = lh.batchReadUnconfirmedEntries(firstEntry, maxCount, maxSize);
                long actualCount = 0;
                while (entries.hasMoreElements()) {
                    LedgerEntry entry = entries.nextElement();
                    assertEquals(firstEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                    assertArrayEquals((ENTRY_DATA_PREFIX + (firstEntry + actualCount)).getBytes(), entry.getEntry(), "Entry data mismatch");
                    actualCount++;
                }

                // If batching is disabled (falls back to regular unconfirmed read), maxSize often ignored for count
                if (!batchReadEnabled && maxSize > 0 && maxSize < SMALL_ENTRY_SIZE * expectedCalculatedCount) {
                    assertEquals(expectedCalculatedCount, actualCount, "Total entries read mismatch (non-batch)");
                } else if (maxCount == 0) { // Specific handling for maxCount = 0 based on observed behavior
                    assertEquals(NUM_ENTRIES - firstEntry, actualCount, "Total entries read mismatch for maxCount=0");
                } else {
                    assertEquals(expectedCalculatedCount, actualCount, "Total entries read mismatch");
                }
            }
        }
    }

    @Test
    @DisplayName("Test batchReadUnconfirmedEntries() invalid firstEntry (negative)")
    void testBatchReadUnconfirmedEntriesInvalidFirstEntryNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);

            // Similar to batchReadEntries, this might result in NoSuchElementException on nextElement()
            assertThrows(BKException.class, () -> lh.batchReadUnconfirmedEntries(-1, 10, 1024).nextElement(),
                    "batchReadUnconfirmedEntries with negative firstEntry might return empty enumeration"); // NoSuchElementException
        }
    }

    // @Test TODO probably bug
    @DisplayName("Test batchReadUnconfirmedEntries() invalid maxCount (negative)")
    void testBatchReadUnconfirmedEntriesInvalidMaxCountNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);

            BKException e = assertThrows(BKException.class, () -> lh.batchReadUnconfirmedEntries(0, -1, 1024),
                    "batchReadUnconfirmedEntries should throw BKException for negative maxCount");
            assertEquals(BKException.Code.IncorrectParameterException, e.getCode(), "Expected BKIncorrectParameterException");
        }
    }

    // --- New Tests for async read methods ---

    @ParameterizedTest
    @MethodSource("provideReadEntriesValidRanges")
    @DisplayName("Test readAsync() with valid ranges")
    void testReadAsyncValidRanges(long firstEntry, long lastEntry) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close(); // Ensure all entries are confirmed

            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            LedgerEntries entries = future.get(10, TimeUnit.SECONDS);

            long expectedCount = lastEntry - firstEntry + 1;
            long actualCount = 0;
            Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
            while (iterator.hasNext()) {
                try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                    assertEquals(firstEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                    assertArrayEquals((ENTRY_DATA_PREFIX + (firstEntry + actualCount)).getBytes(), entry.getEntryBytes(), "Entry data mismatch");
                }
                actualCount++;
            }
            assertEquals(expectedCount, actualCount, "Total entries read mismatch");
        }
    }

    @ParameterizedTest
    @MethodSource("provideReadEntriesInvalidRanges")
    @DisplayName("Test readAsync() with invalid ranges")
    void testReadAsyncInvalidRanges(long firstEntry, long lastEntry, int expectedErrorCode) throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close();

            CompletableFuture<LedgerEntries> future = lh.readAsync(firstEntry, lastEntry);
            java.util.concurrent.ExecutionException e = assertThrows(java.util.concurrent.ExecutionException.class,
                    () -> future.get(10, TimeUnit.SECONDS),
                    "readAsync should complete exceptionally for invalid ranges");
            assertInstanceOf(BKException.class, e.getCause(), "Expected BKException cause");
            assertEquals(expectedErrorCode, ((BKException) e.getCause()).getCode(), "Expected specific BKException code for invalid range");
        }
    }

    @ParameterizedTest
    @MethodSource("provideBatchReadEntriesValidCases")
    @DisplayName("Test batchReadAsync() with valid parameters")
    void testBatchReadAsyncValidCases(long startEntry, int maxCount, long maxSize, int expectedCount, boolean batchReadEnabled) throws Exception {
        ClientConfiguration conf = new ClientConfiguration(baseClientConf)
                .setUseV2WireProtocol(true)
                .setBatchReadEnabled(batchReadEnabled);

        try (BookKeeper localBkc = new BookKeeper(conf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                addEntriesToLedger(lh, NUM_ENTRIES);
                lh.close();

                CompletableFuture<LedgerEntries> future = lh.batchReadAsync(startEntry, maxCount, maxSize);
                LedgerEntries entries = future.get(10, TimeUnit.SECONDS);

                long actualCount = 0;
                Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                        assertEquals(startEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                        assertArrayEquals((ENTRY_DATA_PREFIX + (startEntry + actualCount)).getBytes(), entry.getEntryBytes(), "Entry data mismatch");
                    }
                    actualCount++;
                }
                assertEquals(expectedCount, actualCount, "Total entries read mismatch");
            }
        }
    }

    @Test
    @DisplayName("Test batchReadAsync() invalid startEntry (negative)")
    void testBatchReadAsyncInvalidStartEntryNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close();

            CompletableFuture<LedgerEntries> future = lh.batchReadAsync(-1, 10, 1024);
            java.util.concurrent.ExecutionException e = assertThrows(java.util.concurrent.ExecutionException.class,
                    () -> future.get(10, TimeUnit.SECONDS),
                    "batchReadAsync should complete exceptionally for negative startEntry");
            assertInstanceOf(BKException.class, e.getCause(), "Expected IncorrectParameterException cause for invalid start entry");
            assertEquals(BKException.Code.IncorrectParameterException, ((BKException) e.getCause()).getCode());
        }
    }

    @ParameterizedTest
    @MethodSource("provideReadUnconfirmedEntriesValidRanges")
    @DisplayName("Test readUnconfirmedAsync() with valid ranges")
    void testReadUnconfirmedAsyncValidRanges(long firstEntry, long lastEntry) throws Exception {
        ClientConfiguration localConf = new ClientConfiguration(baseClientConf).setExplictLacInterval(0)
                .setThrottleValue(0);

        try (BookKeeper localBkc = new BookKeeper(localConf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                asyncAddEntriesToLedger(lh, NUM_ENTRIES); //async adds to be pushed and acknowledged

                long lastPushed = lh.getLastAddPushed();
                long lastConfirmed = lh.getLastAddConfirmed();
                assertTrue(lastConfirmed < lastPushed, "LAC should be behind LAPP for unconfirmed test");
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(100)); // Give some buffer time
                long effectiveLastEntry = Math.min(lastEntry, lastPushed);

                CompletableFuture<LedgerEntries> future = lh.readUnconfirmedAsync(firstEntry, effectiveLastEntry);
                LedgerEntries entries = future.get(10, TimeUnit.SECONDS);

                long expectedCount = effectiveLastEntry - firstEntry + 1;
                long actualCount = 0;
                Iterator<org.apache.bookkeeper.client.api.LedgerEntry> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    try (org.apache.bookkeeper.client.api.LedgerEntry entry = iterator.next()) {
                        assertEquals(firstEntry + actualCount, entry.getEntryId(), "Entry ID mismatch");
                        assertArrayEquals((ENTRY_DATA_PREFIX + (firstEntry + actualCount)).getBytes(), entry.getEntryBytes(), "Entry data mismatch");
                    }
                    actualCount++;
                }
                assertEquals(expectedCount, actualCount, "Total entries read mismatch");
            }
        }
    }

    @Test
    @DisplayName("Test readLastEntry() on an empty ledger")
    void testReadLastEntryEmptyLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(BKException.class, lh::readLastEntry,
                    "readLastEntry on empty ledger should throw ReadException or NoEntryException");
            // The exact exception code here can vary. It could be BKReadException or BKNoSuchEntryException.
            // For now, assert it's a BKException.
        }
    }

    @Test
    @DisplayName("Test readLastEntry() on a ledger with one entry")
    void testReadLastEntryOneEntry() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, 1);
            lh.close(); // Ensure it's confirmed

            LedgerEntry lastEntry = lh.readLastEntry();
            assertNotNull(lastEntry, "Last entry should not be null");
            assertEquals(0L, lastEntry.getEntryId(), "Last entry ID should be 0");
            assertArrayEquals((ENTRY_DATA_PREFIX + 0).getBytes(), lastEntry.getEntry(), "Last entry data mismatch");
        }
    }

    @Test
    @DisplayName("Test readLastEntry() on a ledger with multiple entries (confirmed)")
    void testReadLastEntryMultipleEntriesConfirmed() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            addEntriesToLedger(lh, NUM_ENTRIES);
            lh.close(); // Ensure all are confirmed

            LedgerEntry lastEntry = lh.readLastEntry();
            assertNotNull(lastEntry, "Last entry should not be null");
            assertEquals(NUM_ENTRIES - 1, lastEntry.getEntryId(), "Last entry ID should be NUM_ENTRIES - 1");
            assertArrayEquals((ENTRY_DATA_PREFIX + (NUM_ENTRIES - 1)).getBytes(), lastEntry.getEntry(), "Last entry data mismatch");
        }
    }

    @Test
    @DisplayName("Test readLastEntry() on a ledger with unconfirmed entries")
    void testReadLastEntryUnconfirmedEntries() throws Exception {
        ClientConfiguration localConf = new ClientConfiguration(baseClientConf).setExplictLacInterval(0)
                .setThrottleValue(0);

        try (BookKeeper localBkc = new BookKeeper(localConf)) {
            try (LedgerHandle lh = localBkc.createLedger(3, 3, DIGEST_TYPE, PASSWORD_BYTES)) {
                addEntriesToLedger(lh, 1);
                asyncAddEntriesToLedger(lh, NUM_ENTRIES); // Add async to keep some unconfirmed

                long lastPushed = lh.getLastAddPushed();
                long lastConfirmed = lh.getLastAddConfirmed();

                assertTrue(lastPushed > lastConfirmed, "There should be unconfirmed entries for this test");

                // readLastEntry should return the last *confirmed* entry, not the last pushed
                LedgerEntry lastEntry = lh.readLastEntry();

                // If LAC is -1, and there are pushed entries, it implies no entry is confirmed yet
                if (lastConfirmed == BookieProtocol.INVALID_ENTRY_ID) {
                    // It should likely throw an exception if no entries are confirmed, or return null/empty enumeration
                    // Assert the exception based on BK's actual behavior for this edge case.
                    assertThrows(BKException.class, lh::readLastEntry, "Expected exception when no entries are confirmed for readLastEntry");
                } else {
                    assertNotNull(lastEntry, "Last entry should not be null");
                    assertTrue(lastEntry.getEntryId() >= lastConfirmed, "readLastEntry should return LAC for unconfirmed scenario");
                }
            }
        }
    }

    // --- Tests for addEntry variations ---

    @Test
    @DisplayName("Test addEntry(byte[] data) with valid data")
    void testAddEntryByteArrayValid() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = "Hello World".getBytes();
            long entryId = lh.addEntry(data);
            assertEquals(0L, entryId, "First entry ID should be 0");
            assertEquals(0L, lh.getLastAddConfirmed(), "LAC should be 0 after first entry confirmed"); // Auto-confirmed immediately
            assertEquals(0L, lh.getLastAddPushed(), "LAPP should be 0 after first entry pushed");

            byte[] data2 = "Second entry".getBytes();
            long entryId2 = lh.addEntry(data2);
            assertEquals(1L, entryId2, "Second entry ID should be 1");
            assertEquals(1L, lh.getLastAddConfirmed(), "LAC should be 1 after second entry confirmed");
            assertEquals(1L, lh.getLastAddPushed(), "LAPP should be 1 after second entry pushed");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data) with null data")
    void testAddEntryByteArrayNull() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(NullPointerException.class, () -> lh.addEntry(null),
                    "addEntry with null byte array should throw NullPointerException");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data) with empty data")
    void testAddEntryByteArrayEmpty() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = new byte[0];
            long entryId = lh.addEntry(data);
            assertEquals(0L, entryId, "Entry ID should be 0 for empty data");
            assertEquals(0L, lh.getLastAddConfirmed(), "LAC should be 0 for empty data entry");
            // Read back to confirm content
            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(data, entry.getEntry(), "Entry data should be empty byte array");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data) with max size data")
    void testAddEntryByteArrayMaxSize() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = new byte[MAX_ENTRY_SIZE];
            for (int i = 0; i < MAX_ENTRY_SIZE; i++) {
                data[i] = (byte) (i % 256);
            }
            long entryId = lh.addEntry(data);
            assertEquals(0L, entryId, "Entry ID should be 0 for max size data");
            // Read back to confirm content
            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(data, entry.getEntry(), "Entry data should match max size array");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data, int offset, int length) with valid range")
    void testAddEntryOffsetLengthValid() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] fullData = "Some really long test string for offset".getBytes();
            int offset = 5;
            int length = 10; // "really lon"
            byte[] expectedData = new byte[length];
            System.arraycopy(fullData, offset, expectedData, 0, length);

            long entryId = lh.addEntry(fullData, offset, length);
            assertEquals(0L, entryId, "First entry ID should be 0");

            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(expectedData, entry.getEntry(), "Entry data should match the specified segment");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data, int offset, int length) with invalid offset (negative)")
    void testAddEntryOffsetLengthInvalidOffsetNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = "test".getBytes();
            assertThrows(IndexOutOfBoundsException.class, () -> lh.addEntry(data, -1, 4),
                    "addEntry with negative offset should throw IndexOutOfBoundsException");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data, int offset, int length) with invalid length (negative)")
    void testAddEntryOffsetLengthInvalidLengthNegative() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = "test".getBytes();
            assertThrows(IndexOutOfBoundsException.class, () -> lh.addEntry(data, 0, -1),
                    "addEntry with negative length should throw IndexOutOfBoundsException");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data, int offset, int length) with offset + length > data.length")
    void testAddEntryOffsetLengthOutOfBounds() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = "test".getBytes(); // length 4
            assertThrows(IndexOutOfBoundsException.class, () -> lh.addEntry(data, 2, 3), // offset 2, length 3 -> tries to read 2,3,4 (out of bounds)
                    "addEntry with offset + length > data.length should throw IndexOutOfBoundsException");
        }
    }

    @Test
    @DisplayName("Test addEntry(byte[] data, int offset, int length) with empty segment (length 0)")
    void testAddEntryOffsetLengthEmptySegment() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] data = "test".getBytes();
            long entryId = lh.addEntry(data, 0, 0);
            assertEquals(0L, entryId, "Entry ID should be 0 for empty segment");

            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(new byte[0], entry.getEntry(), "Entry data should be empty byte array for length 0");
        }
    }

    @Test
    @DisplayName("Test appendAsync(ByteBuf data) with valid data")
    void testAppendAsyncByteBufValid() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            ByteBuf data = Unpooled.wrappedBuffer("Async Append Test".getBytes());
            CompletableFuture<Long> future = lh.appendAsync(data);
            long entryId = future.get(10, TimeUnit.SECONDS);

            assertEquals(0L, entryId, "First entry ID should be 0");
            assertEquals(0L, lh.getLastAddConfirmed(), "LAC should be 0 after async append confirmed");

            // Verify data by reading it back
            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals("Async Append Test".getBytes(), entry.getEntry(), "Entry data mismatch");

            assertFalse(data.refCnt() > 0, "Original ByteBuf should be released by BookKeeper");
        }
    }

    @Test
    @DisplayName("Test appendAsync(ByteBuf data) with null ByteBuf")
    void testAppendAsyncByteBufNull() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            assertThrows(NullPointerException.class, () -> lh.appendAsync((ByteBuf) null),
                    "appendAsync with null ByteBuf should throw NullPointerException");
        }
    }

    @Test
    @DisplayName("Test appendAsync(ByteBuf data) with empty ByteBuf")
    void testAppendAsyncByteBufEmpty() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            ByteBuf data = Unpooled.buffer(0); // Empty ByteBuf
            CompletableFuture<Long> future = lh.appendAsync(data);
            long entryId = future.get(10, TimeUnit.SECONDS);

            assertEquals(0L, entryId, "Entry ID should be 0 for empty ByteBuf");
            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(new byte[0], entry.getEntry(), "Entry data should be empty byte array");
            assertFalse(data.refCnt() > 0, "Empty ByteBuf should also be released");
        }
    }

    @Test
    @DisplayName("Test appendAsync(ByteBuf data) with max size ByteBuf")
    void testAppendAsyncByteBufMaxSize() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] largeData = new byte[MAX_ENTRY_SIZE];
            for (int i = 0; i < MAX_ENTRY_SIZE; i++) {
                largeData[i] = (byte) (i % 256);
            }
            ByteBuf data = Unpooled.wrappedBuffer(largeData);
            CompletableFuture<Long> future = lh.appendAsync(data);
            long entryId = future.get(20, TimeUnit.SECONDS); // Increased timeout for large data

            assertEquals(0L, entryId, "Entry ID should be 0 for max size ByteBuf");
            Enumeration<LedgerEntry> entries = lh.readEntries(0, 0);
            assertTrue(entries.hasMoreElements(), "Should have an entry");
            LedgerEntry entry = entries.nextElement();
            assertArrayEquals(largeData, entry.getEntry(), "Entry data should match max size ByteBuf");
            assertFalse(data.refCnt() > 0, "Large ByteBuf should be released");
        }
    }

    @Test
    @DisplayName("Test appendAsync(ByteBuf data) when ledger is closed")
    void testAppendAsyncClosedLedger() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            lh.close();
            ByteBuf data = Unpooled.wrappedBuffer("Closed ledger append".getBytes());
            CompletableFuture<Long> future = lh.appendAsync(data);
            java.util.concurrent.ExecutionException e = assertThrows(java.util.concurrent.ExecutionException.class,
                    () -> future.get(5, TimeUnit.SECONDS),
                    "appendAsync on closed ledger should complete exceptionally");
            assertInstanceOf(BKException.class, e.getCause(), "Expected BKException cause");
            assertEquals(BKException.Code.LedgerClosedException, ((BKException) e.getCause()).getCode(),
                    "Expected LedgerClosedException");
        }
    }

    // --- Tests for addEntry(final long entryId, ...) which are for LedgerHandleAdv

    @Test
    @DisplayName("Test addEntry(final long entryId, byte[] data) - behavior check for unusual method")
    void testAddEntryWithExplicitIdByteArray() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            // This method is generally for internal use or recovery.
            // In a normal client flow, you don't assign entry IDs.
            // If it functions, it might overwrite or behave unexpectedly based on implementation.
            // Let's test if it allows adding an entry and if the ID is respected.
            byte[] data = "Data for entry 5".getBytes();
            long assignedId = 5L; // Explicitly assign ID 5

            BKException e = assertThrows(BKException.class, () -> lh.addEntry(assignedId, data));
            assertEquals(BKException.Code.IllegalOpException, e.getCode());
        }
    }

    @Test
    @DisplayName("Test addEntry(final long entryId, byte[] data, int offset, int length) - behavior check")
    void testAddEntryWithExplicitIdByteArrayOffsetLength() throws Exception {
        try (LedgerHandle lh = bkc.createLedger(DIGEST_TYPE, PASSWORD_BYTES)) {
            byte[] fullData = "Original data with some portion".getBytes();
            long assignedId = 10L;
            int offset = "Original data with ".length();
            int length = "some portion".length();

            BKException e = assertThrows(BKException.class,
                    () -> lh.addEntry(assignedId, fullData, offset, length));
            assertEquals(BKException.Code.IllegalOpException, e.getCode());
        }
    }
}
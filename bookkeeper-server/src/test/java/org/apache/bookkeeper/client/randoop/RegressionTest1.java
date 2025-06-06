package org.apache.bookkeeper.client.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test501");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test502");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test503");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test504");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test505");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test506");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test507");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test508");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test509");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test510");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test511");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test512");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test513");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test514");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test515");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test516");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test517");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test518");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test519");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test520");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test521");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test522");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test523");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test524");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test525");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test526");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test527");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test528");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test529");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test530");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test531");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test532");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test533");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test534");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test535");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test536");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test537");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test538");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test539");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test540");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test541");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.complete(Object)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test542");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test543");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test544");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test545");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test546");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.CompletableFuture.completeExceptionally(java.lang.Throwable)\" because \"future\" is null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }
}


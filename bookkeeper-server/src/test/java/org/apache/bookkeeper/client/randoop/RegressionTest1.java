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
    public void test0501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0501");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0502");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0503");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0504");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0505");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0506");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0507");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0508");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0509");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0510");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0511");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0512");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0513");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0514");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0515");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0516");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0517");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0518");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0519");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0520");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0521");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0522");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0523");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0524");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0525");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0526");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0527");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0528");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0529");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0530");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0531");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0532");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0533");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0534");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0535");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0536");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0537");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0538");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0539");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0540");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0541");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0542");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0543");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0544");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0545");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0546");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0547");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0548");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0549");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0550");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0551");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0552");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0553");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0554");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0555");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0556");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0557");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0558");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0559");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0560");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0561");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0562");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0563");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0564");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0565");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0566");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0567");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0568");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0569");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0570");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0571");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0572");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0573");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0574");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0575");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0576");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0577");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0578");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0579");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0580");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0581");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0582");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0583");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0584");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0585");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0586");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0587");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0588");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0589");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0590");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0591");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0592");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0593");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0594");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0595");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0596");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0597");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0598");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0599");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0600");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0601");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0602");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0603");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0604");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0605");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0606");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0607");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0608");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0609");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0610");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0611");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0612");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0613");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0614");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0615");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0616");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0617");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0618");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0619");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0620");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0621");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0622");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0623");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0624");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0625");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0626");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0627() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0627");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0628() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0628");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0629() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0629");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0630() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0630");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0631() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0631");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0632() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0632");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0633() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0633");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0634() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0634");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0635() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0635");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0636() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0636");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0637() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0637");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0638() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0638");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0639() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0639");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0640() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0640");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0641() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0641");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0642() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0642");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0643() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0643");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0644() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0644");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0645() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0645");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0646() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0646");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0647() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0647");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0648() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0648");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0649() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0649");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0650() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0650");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0651() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0651");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0652() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0652");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0653() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0653");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0654() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0654");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0655() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0655");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0656() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0656");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0657() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0657");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0658() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0658");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0659() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0659");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0660() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0660");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0661() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0661");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0662() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0662");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0663() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0663");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0664() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0664");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0665() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0665");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0666() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0666");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0667() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0667");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0668() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0668");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0669() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0669");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0670() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0670");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0671() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0671");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0672() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0672");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0673() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0673");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0674() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0674");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0675() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0675");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0676() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0676");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0677() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0677");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0678() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0678");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0679() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0679");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0680() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0680");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0681() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0681");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0682() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0682");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0683() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0683");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0684() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0684");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0685() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0685");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0686() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0686");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0687() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0687");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0688() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0688");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0689() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0689");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0690() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0690");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0691() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0691");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0692() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0692");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0693() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0693");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0694() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0694");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0695() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0695");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0696() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0696");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0697() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0697");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0698() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0698");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0699() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0699");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0700() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0700");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0701() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0701");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0702() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0702");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0703() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0703");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0704() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0704");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0705() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0705");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0706() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0706");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0707() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0707");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0708() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0708");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0709() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0709");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0710() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0710");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0711() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0711");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0712() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0712");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0713() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0713");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0714() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0714");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0715() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0715");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0716() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0716");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0717() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0717");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0718() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0718");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0719() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0719");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0720() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0720");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0721() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0721");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0722() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0722");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0723() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0723");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0724() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0724");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0725() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0725");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0726() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0726");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0727() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0727");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0728() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0728");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0729() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0729");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0730() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0730");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0731() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0731");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0732() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0732");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0733() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0733");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0734() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0734");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0735() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0735");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0736() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0736");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0737() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0737");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0738() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0738");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0739() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0739");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0740() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0740");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0741() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0741");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0742() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0742");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0743() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0743");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0744() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0744");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0745() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0745");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0746() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0746");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0747() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0747");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0748() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0748");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0749() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0749");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0750() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0750");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0751() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0751");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0752() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0752");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0753() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0753");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0754() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0754");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0755() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0755");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0756() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0756");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0757() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0757");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0758() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0758");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0759() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0759");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0760() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0760");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0761() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0761");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0762() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0762");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0763() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0763");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0764() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0764");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0765() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0765");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0766() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0766");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0767() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0767");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0768() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0768");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0769() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0769");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0770() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0770");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0771() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0771");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0772() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0772");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0773() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0773");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0774() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0774");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0775() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0775");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0776() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0776");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0777() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0777");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0778() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0778");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0779() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0779");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0780() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0780");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0781() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0781");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0782() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0782");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0783() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0783");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0784() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0784");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0785() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0785");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0786() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0786");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0787() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0787");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0788() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0788");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0789() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0789");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0790() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0790");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0791() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0791");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0792() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0792");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0793() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0793");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0794() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0794");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0795() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0795");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0796() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0796");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0797() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0797");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0798() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0798");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0799() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0799");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0800() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0800");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0801() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0801");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0802() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0802");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0803() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0803");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0804() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0804");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0805() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0805");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0806() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0806");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0807() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0807");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0808() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0808");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0809() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0809");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0810() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0810");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0811() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0811");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0812() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0812");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0813() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0813");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0814() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0814");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0815() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0815");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0816() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0816");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0817() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0817");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0818() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0818");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0819() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0819");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0820() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0820");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0821() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0821");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0822() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0822");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0823() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0823");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0824() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0824");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0825() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0825");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0826() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0826");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0827() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0827");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0828() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0828");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0829() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0829");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0830() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0830");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0831() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0831");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0832() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0832");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0833() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0833");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0834() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0834");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0835() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0835");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0836() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0836");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0837() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0837");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0838() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0838");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0839() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0839");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0840() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0840");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0841() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0841");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0842() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0842");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0843() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0843");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0844() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0844");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0845() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0845");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0846() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0846");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0847() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0847");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0848() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0848");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0849() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0849");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0850() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0850");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0851() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0851");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0852() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0852");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0853() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0853");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0854() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0854");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0855() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0855");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0856() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0856");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0857() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0857");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0858() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0858");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0859() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0859");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0860() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0860");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0861() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0861");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0862() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0862");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0863() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0863");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0864() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0864");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0865() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0865");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0866() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0866");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0867() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0867");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0868() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0868");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0869() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0869");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0870() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0870");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0871() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0871");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0872() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0872");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0873() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0873");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0874() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0874");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0875() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0875");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0876() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0876");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0877() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0877");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0878() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0878");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0879() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0879");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0880() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0880");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0881() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0881");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0882() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0882");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0883() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0883");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0884() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0884");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0885() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0885");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0886() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0886");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0887() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0887");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0888() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0888");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) voidCompletableFuture4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0889() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0889");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0890() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0890");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0891() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0891");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0892() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0892");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0893() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0893");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0894() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0894");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0895() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0895");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0896() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0896");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0897() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0897");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0898() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0898");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0899() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0899");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0900() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0900");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0901() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0901");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0902() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0902");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0903() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0903");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0904() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0904");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0905() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0905");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0906() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0906");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0907() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0907");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0908() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0908");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0909() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0909");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0910() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0910");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0911() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0911");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0912() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0912");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0913() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0913");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0914() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0914");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0915() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0915");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0916() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0916");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0917() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0917");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0918() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0918");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "hi!", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0919() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0919");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0920() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0920");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0921() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0921");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "hi!", (Object) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0922() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0922");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0923() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0923");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0924() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0924");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0925() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0925");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0926() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0926");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0927() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0927");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0928() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0928");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0929() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0929");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0930() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0930");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "", (Object) 100.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0931() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0931");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0932() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0932");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0933() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0933");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0934() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0934");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 1, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0935() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0935");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0936() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0936");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0937() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0937");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0938() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0938");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0939() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0939");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0940() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0940");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0941() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0941");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0942() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0942");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0943() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0943");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0944() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0944");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0945() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0945");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "hi!", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0946() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0946");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0947() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0947");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0948() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0948");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0949() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0949");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 1, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0950() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0950");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0951() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0951");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "hi!", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0952() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0952");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0953() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0953");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0954() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0954");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0955() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0955");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(100, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0956() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0956");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0957() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0957");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "hi!", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0958() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0958");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0959() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0959");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0960() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0960");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0961() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0961");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "", (Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0962() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0962");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0963() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0963");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0964() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0964");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0965() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0965");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = new Object();
        Class<?> wildcardClass5 = obj4.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) wildcardClass5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test0966() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0966");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0967() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0967");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 10, "", (Object) resultCallBack5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0968() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0968");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0969() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0969");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0970() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0970");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0971() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0971");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "hi!", (Object) 10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0972() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0972");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", (Object) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0973() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0973");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 0, "", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0974() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0974");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(0, "", (Object) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0975() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0975");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 100, "", (Object) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0976() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0976");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test0977() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0977");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) ' ', "", obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0978() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0978");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0979() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0979");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((-1), "hi!", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0980() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0980");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0981() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0981");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) 10.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0982() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0982");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0983() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0983");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0984() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0984");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "hi!", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0985() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0985");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '#', "hi!", (Object) "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0986() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0986");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0987() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0987");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) (-2882382797L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0988() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0988");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0989() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0989");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(1, "hi!", (Object) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0990() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0990");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "hi!", (Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0991() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0991");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0992() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0992");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) -1, "", (Object) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0993() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0993");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) -1, "hi!", (Object) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0994() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0994");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "hi!", (Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0995() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0995");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 10, "", (Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0996() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0996");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult(10, "", (Object) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0997() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0997");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (short) 100, "", (Object) 1.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0998() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0998");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) (byte) 0, "hi!", (Object) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0999() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0999");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) '4', "", (Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1000() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test1000");
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture0 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack1 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture0);
        java.util.concurrent.CompletableFuture<Void> voidCompletableFuture4 = null;
        org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack resultCallBack5 = new org.apache.bookkeeper.client.BookKeeperAdmin.ResultCallBack(voidCompletableFuture4);
        Class<?> wildcardClass6 = resultCallBack5.getClass();
        // The following exception was thrown during execution in test generation
        try {
            resultCallBack1.processResult((int) 'a', "", (Object) wildcardClass6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass6);
    }
}


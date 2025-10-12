package core.assertions;

import core.helper.LogHelper;
import org.testng.Assert;

public final class Asserts {

    private Asserts() {
    }

    public static void assertTrue(boolean condition, String description) {
        LogHelper.info("Verifying that {} is TRUE", description);
        Assert.assertTrue(condition, "Expected TRUE but was FALSE for: " + description);
    }

    public static void assertFalse(boolean condition, String description) {
        LogHelper.info("Verifying that {} is FALSE", description);
        Assert.assertFalse(condition, "Expected FALSE but was TRUE for: " + description);
    }

    public static void assertEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} equals {}", description, expected);
        Assert.assertEquals(actual, expected, "Expected: " + expected + ", but got: " + actual);
    }

    public static void assertNotEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} does NOT equal {}", description, expected);
        Assert.assertNotEquals(actual, expected, "Expected not equal but both were: " + actual);
    }

    public static void assertNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NULL", description);
        Assert.assertNull(value, "Expected NULL but found: " + value);
    }

    public static void assertNotNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NOT NULL", description);
        Assert.assertNotNull(value, "Expected NOT NULL but found NULL for: " + description);
    }

    public static void assertContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains '{}'", description, expected);
        boolean result = actual != null && actual.contains(expected);
        Assert.assertTrue(result, "Expected '" + actual + "' to contain '" + expected + "'");
    }

    public static void assertNotContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} does NOT contain '{}'", description, expected);
        boolean result = actual != null && !actual.contains(expected);
        Assert.assertTrue(result, "Expected '" + actual + "' NOT to contain '" + expected + "'");
    }

    public static void assertContainsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains (ignore case) '{}'", description, expected);
        boolean result = actual != null && actual.toLowerCase().contains(expected.toLowerCase());
        Assert.assertTrue(result, "Expected (ignore case) '" + actual + "' to contain '" + expected + "'");
    }

    public static void assertEqualsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} equals (ignore case) '{}'", description, expected);
        boolean result = actual != null && actual.equalsIgnoreCase(expected);
        Assert.assertTrue(result, "Expected (ignore case) '" + expected + "', but got '" + actual + "'");
    }
}
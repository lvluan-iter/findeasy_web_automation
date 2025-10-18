package core.assertions;

import core.helper.LogHelper;
import org.testng.asserts.SoftAssert;

public final class SoftAsserts {
    private static final ThreadLocal<SoftAssert> softAssert = ThreadLocal.withInitial(SoftAssert::new);

    private SoftAsserts() {
    }

    public static void assertTrue(boolean condition, String description) {
        LogHelper.info("Verifying that {} is TRUE (soft)", description);
        softAssert.get().assertTrue(condition, "Expected TRUE but was FALSE for: " + description);
    }

    public static void assertFalse(boolean condition, String description) {
        LogHelper.info("Verifying that {} is FALSE (soft)", description);
        softAssert.get().assertFalse(condition, "Expected FALSE but was TRUE for: " + description);
    }

    public static void assertEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} equals {} (soft)", description, expected);
        softAssert.get().assertEquals(actual, expected, "Expected: " + expected + ", but got: " + actual);
    }

    public static void assertNotEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} does NOT equal {} (soft)", description, expected);
        softAssert.get().assertNotEquals(actual, expected, "Expected not equal but both were: " + actual);
    }

    public static void assertNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NULL (soft)", description);
        softAssert.get().assertNull(value, "Expected NULL but found: " + value);
    }

    public static void assertNotNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NOT NULL (soft)", description);
        softAssert.get().assertNotNull(value, "Expected NOT NULL but found NULL for: " + description);
    }

    public static void assertContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains '{}' (soft)", description, expected);
        boolean result = actual != null && actual.contains(expected);
        softAssert.get().assertTrue(result, "Expected '" + actual + "' to contain '" + expected + "'");
    }

    public static void assertNotContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} does NOT contain '{}' (soft)", description, expected);
        boolean result = actual != null && !actual.contains(expected);
        softAssert.get().assertTrue(result, "Expected '" + actual + "' NOT to contain '" + expected + "'");
    }

    public static void assertContainsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains (ignore case) '{}' (soft)", description, expected);
        boolean result = actual != null && actual.toLowerCase().contains(expected.toLowerCase());
        softAssert.get().assertTrue(result, "Expected (ignore case) '" + actual + "' to contain '" + expected + "'");
    }

    public static void assertEqualsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} equals (ignore case) '{}' (soft)", description, expected);
        boolean result = actual != null && actual.equalsIgnoreCase(expected);
        softAssert.get().assertTrue(result, "Expected (ignore case) '" + expected + "', but got '" + actual + "'");
    }

    public static void assertAll() {
        LogHelper.info("Verifying all soft assertions...");
        softAssert.get().assertAll();
        softAssert.remove();
    }
}

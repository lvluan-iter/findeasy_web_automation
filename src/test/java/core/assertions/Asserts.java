package core.assertions;

import core.helper.LogHelper;

import java.util.Objects;

public final class Asserts {

    private Asserts() {
    }

    public static void assertTrue(boolean condition, String description) {
        LogHelper.info("Verifying that {} is TRUE", description);
        if (!condition) {
            throw new AssertionError("Expected TRUE but was FALSE for: " + description);
        }
    }

    public static void assertFalse(boolean condition, String description) {
        LogHelper.info("Verifying that {} is FALSE", description);
        if (condition) {
            throw new AssertionError("Expected FALSE but was TRUE for: " + description);
        }
    }

    public static void assertEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} equals {}", description, expected);
        if (!Objects.equals(actual, expected)) {
            throw new AssertionError(
                    "Expected '" + expected + "' but got '" + actual + "' for: " + description
            );
        }
    }

    public static void assertNotEquals(Object actual, Object expected, String description) {
        LogHelper.info("Verifying that {} does NOT equal {}", description, expected);
        if (Objects.equals(actual, expected)) {
            throw new AssertionError(
                    "Expected not equal but both were: " + actual + " for: " + description
            );
        }
    }

    public static void assertNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NULL", description);
        if (value != null) {
            throw new AssertionError("Expected NULL but found: " + value + " for: " + description);
        }
    }

    public static void assertNotNull(Object value, String description) {
        LogHelper.info("Verifying that {} is NOT NULL", description);
        if (value == null) {
            throw new AssertionError("Expected NOT NULL but found NULL for: " + description);
        }
    }

    public static void assertContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains '{}'", description, expected);
        if (actual == null || !actual.contains(expected)) {
            throw new AssertionError(
                    "Expected '" + actual + "' to contain '" + expected + "' for: " + description
            );
        }
    }

    public static void assertNotContains(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} does NOT contain '{}'", description, expected);
        if (actual != null && actual.contains(expected)) {
            throw new AssertionError(
                    "Expected '" + actual + "' NOT to contain '" + expected + "' for: " + description
            );
        }
    }

    public static void assertContainsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} contains (ignore case) '{}'", description, expected);
        if (actual == null || !actual.toLowerCase().contains(expected.toLowerCase())) {
            throw new AssertionError(
                    "Expected (ignore case) '" + actual + "' to contain '" + expected + "' for: " + description
            );
        }
    }

    public static void assertEqualsIgnoreCase(String actual, String expected, String description) {
        LogHelper.info("Verifying that {} equals (ignore case) '{}'", description, expected);
        if (actual == null ? expected != null : !actual.equalsIgnoreCase(expected)) {
            throw new AssertionError(
                    "Expected (ignore case) '" + expected + "', but got '" + actual + "' for: " + description
            );
        }
    }
}
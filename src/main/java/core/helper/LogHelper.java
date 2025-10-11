package core.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LogHelper {

    private static final Logger logger = LogManager.getLogger();

    private LogHelper() {
    }

    public static void info(String message, Object... params) {
        logger.info(message);
    }

    public static void warn(String message, Object... params) {
        logger.warn(message);
    }

    public static void error(String message, Throwable t, Object... params) {
        logger.error(message, t);
    }

    public static void step(String message, Object... params) {
        logger.info(message);
    }

    public static void pass(String message, Object... params) {
        logger.info("✅ PASS: {}", message);
    }

    public static void fail(String message, Object... params) {
        logger.error("❌ FAIL: {}", message);
    }
}

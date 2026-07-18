package exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {
    private static final Logger logger = LoggerFactory.getLogger(AppLogger.class);

    public void logWithParameters(String username, int attemptCount) {
        logger.info("User {} attempted login {} times", username, attemptCount);
        logger.warn("Failed login attempt #{} for user {}", attemptCount, username);
    }

    public void logMultipleParams(String action, String userId, String resource) {
        logger.info("User {} performed {} on resource {}", userId, action, resource);
    }

    public void logWithException(String operation, Exception ex) {
        logger.error("Failed to execute operation: {}", operation, ex);
    }

    public void logConditional(String level, String message) {
        switch (level) {
            case "error" -> logger.error("CONDITIONAL: {}", message);
            case "warn" -> logger.warn("CONDITIONAL: {}", message);
            case "info" -> logger.info("CONDITIONAL: {}", message);
            case "debug" -> logger.debug("CONDITIONAL: {}", message);
            case "trace" -> logger.trace("CONDITIONAL: {}", message);
            default -> logger.info("DEFAULT: {}", message);
        }
    }
}

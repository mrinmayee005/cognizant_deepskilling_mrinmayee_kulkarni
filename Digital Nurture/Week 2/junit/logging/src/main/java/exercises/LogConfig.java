package exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogConfig {
    private static final Logger logger = LoggerFactory.getLogger(LogConfig.class);

    public void logErrorExample() {
        logger.error("This is an ERROR message - something went wrong");
        logger.error("Error with exception", new RuntimeException("Sample exception"));
    }

    public void logWarningExample() {
        logger.warn("This is a WARNING message - something might be wrong");
        logger.warn("Warning: disk space low on drive {}", "C:");
    }

    public void logInfoExample() {
        logger.info("This is an INFO message - general information");
        logger.info("Application started on port {}", 8080);
    }

    public void logDebugExample() {
        logger.debug("This is a DEBUG message - detailed debugging info");
        logger.debug("Processing item {} of {}", 5, 100);
    }

    public void logTraceExample() {
        logger.trace("This is a TRACE message - most verbose level");
    }
}

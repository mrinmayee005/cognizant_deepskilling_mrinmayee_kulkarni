package exercises;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class LogConfigTest {
    private static final Logger logger = LoggerFactory.getLogger(LogConfigTest.class);

    @Test
    public void testLogErrorAndWarning() {
        LogConfig logConfig = new LogConfig();

        // Should log ERROR level message
        logConfig.logErrorExample();

        // Should log WARN level message
        logConfig.logWarningExample();

        // Verify methods execute without throwing
        assertTrue(true);
    }

    @Test
    public void testAllLogLevels() {
        LogConfig logConfig = new LogConfig();

        logConfig.logTraceExample();
        logConfig.logDebugExample();
        logConfig.logInfoExample();
        logConfig.logWarningExample();
        logConfig.logErrorExample();

        assertTrue(true);
    }
}

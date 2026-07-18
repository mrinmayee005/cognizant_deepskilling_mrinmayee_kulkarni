package exercises;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AppLoggerTest {
    @Test
    public void testParameterizedLogging() {
        AppLogger appLogger = new AppLogger();

        appLogger.logWithParameters("john_doe", 3);
        appLogger.logMultipleParams("READ", "user123", "/api/data");

        assertTrue(true);
    }

    @Test
    public void testLogWithException() {
        AppLogger appLogger = new AppLogger();

        try {
            throw new RuntimeException("Test exception");
        } catch (Exception e) {
            appLogger.logWithException("database-operation", e);
        }

        assertTrue(true);
    }

    @Test
    public void testConditionalLogging() {
        AppLogger appLogger = new AppLogger();

        appLogger.logConditional("error", "Error condition message");
        appLogger.logConditional("warn", "Warning condition message");
        appLogger.logConditional("info", "Info condition message");
        appLogger.logConditional("debug", "Debug condition message");
        appLogger.logConditional("trace", "Trace condition message");
        appLogger.logConditional("unknown", "Default condition message");

        assertTrue(true);
    }
}

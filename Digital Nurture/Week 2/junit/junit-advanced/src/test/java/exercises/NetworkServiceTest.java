package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class NetworkServiceTest {
    @Test
    void testComputeHeavyTask() {
        NetworkService ns = new NetworkService();
        int result = ns.computeHeavyTask(1000);
        assertEquals(499500, result);
    }

    @Test
    @Timeout(5)
    void testComputeHeavyTaskWithTimeout() {
        NetworkService ns = new NetworkService();
        int result = ns.computeHeavyTask(10000);
        assertEquals(49995000, result);
    }

    @Test
    void testComputeHeavyTaskWithAssertTimeout() {
        NetworkService ns = new NetworkService();
        assertTimeout(java.time.Duration.ofSeconds(2), () -> {
            int result = ns.computeHeavyTask(5000);
            assertEquals(12497500, result);
        });
    }

    @Test
    @Timeout(value = 3, unit = java.util.concurrent.TimeUnit.SECONDS)
    void testComputeHeavyTaskTimeoutSeconds() {
        NetworkService ns = new NetworkService();
        int result = ns.computeHeavyTask(2000);
        assertEquals(1999000, result);
    }
}

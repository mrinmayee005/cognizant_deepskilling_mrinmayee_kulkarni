package exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExceptionThrowerTest {
    private static int executionOrder = 0;

    @Test
    @Order(1)
    void testFirst() {
        executionOrder++;
        assertEquals(1, executionOrder, "This should execute first");
    }

    @Test
    @Order(2)
    void testSecond() {
        executionOrder++;
        assertEquals(2, executionOrder, "This should execute second");
    }

    @Test
    @Order(3)
    void testThird() {
        executionOrder++;
        assertEquals(3, executionOrder, "This should execute third");
    }
}

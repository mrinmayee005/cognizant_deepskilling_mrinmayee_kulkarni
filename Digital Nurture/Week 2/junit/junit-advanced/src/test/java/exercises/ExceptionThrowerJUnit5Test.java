package exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionThrowerJUnit5Test {
    @Test
    void testThrowRuntimeException() {
        ExceptionThrower et = new ExceptionThrower();
        RuntimeException ex = assertThrows(RuntimeException.class, et::throwRuntimeException);
        assertEquals("Runtime exception occurred", ex.getMessage());
    }

    @Test
    void testThrowIllegalArgumentException() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> et.throwIllegalArgumentException(null));
        assertThrows(IllegalArgumentException.class, () -> et.throwIllegalArgumentException(""));
    }

    @Test
    void testThrowArithmeticException() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(ArithmeticException.class, () -> et.throwArithmeticException(10, 0));
    }

    @Test
    void testRiskyOperationWithNull() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(NullPointerException.class, () -> et.riskyOperation(null));
    }

    @Test
    void testRiskyOperationWithEmpty() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> et.riskyOperation(""));
    }

    @Test
    void testRiskyOperationSuccess() {
        ExceptionThrower et = new ExceptionThrower();
        String result = et.riskyOperation("hello");
        assertEquals("HELLO", result);
    }
}

package exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {
    @Test
    void testAdd() {
        MathUtils mu = new MathUtils();
        assertEquals(5, mu.add(2, 3));
    }

    @Test
    void testMultiply() {
        MathUtils mu = new MathUtils();
        assertEquals(12, mu.multiply(3, 4));
    }

    @Test
    void testFactorial() {
        MathUtils mu = new MathUtils();
        assertEquals(120, mu.factorial(5));
    }
}

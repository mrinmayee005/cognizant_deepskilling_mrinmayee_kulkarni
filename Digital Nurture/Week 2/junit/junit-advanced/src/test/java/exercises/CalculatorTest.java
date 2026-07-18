package exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testAdd() {
        MathUtils mu = new MathUtils();
        assertEquals(10, mu.add(4, 6));
    }

    @Test
    void testDivide() {
        MathUtils mu = new MathUtils();
        assertEquals(5, mu.divide(10, 2));
    }
}

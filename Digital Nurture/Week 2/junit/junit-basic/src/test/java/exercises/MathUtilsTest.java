package exercises;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MathUtilsTest {
    @Test
    public void testLargestNumber() {
        MathUtils mu = new MathUtils();
        assertEquals(3, mu.largestNumber(1, 2, 3));
        assertEquals(3, mu.largestNumber(3, 2, 1));
        assertEquals(3, mu.largestNumber(1, 3, 2));
        assertEquals(5, mu.largestNumber(5, 5, 5));
    }

    @Test
    public void testIsEven() {
        MathUtils mu = new MathUtils();
        assertTrue(mu.isEven(2));
        assertTrue(mu.isEven(0));
        assertTrue(mu.isEven(-4));
    }

    @Test
    public void testFactorial() {
        MathUtils mu = new MathUtils();
        assertEquals(1, mu.factorial(0));
        assertEquals(1, mu.factorial(1));
        assertEquals(120, mu.factorial(5));
    }
}

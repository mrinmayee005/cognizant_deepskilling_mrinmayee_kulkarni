package exercises;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorATest {
    private Calculator calculator;
    private long startTime;

    @Before
    public void setUp() {
        calculator = new Calculator();
        startTime = System.currentTimeMillis();
        System.out.println("Test started at: " + startTime);
    }

    @After
    public void tearDown() {
        long endTime = System.currentTimeMillis();
        System.out.println("Test ended at: " + endTime);
        System.out.println("Duration: " + (endTime - startTime) + "ms");
        calculator = null;
    }

    @Test
    public void testAdditionUsingSetup() {
        // Arrange - done in setUp
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiplicationUsingSetup() {
        // Arrange - done in setUp
        int a = 5;
        int b = 4;
        // Act
        int result = calculator.multiply(a, b);
        // Assert
        assertEquals(20, result);
    }
}

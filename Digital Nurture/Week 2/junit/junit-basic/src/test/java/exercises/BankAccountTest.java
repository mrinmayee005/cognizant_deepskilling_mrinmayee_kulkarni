package exercises;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {
    private double balance;
    private String owner;

    @Before
    public void setUp() {
        balance = 1000.0;
        owner = "John Doe";
        System.out.println("Initializing bank account for: " + owner);
    }

    @After
    public void tearDown() {
        balance = 0;
        owner = null;
        System.out.println("Account cleared");
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 500.0;
        // Act
        balance += depositAmount;
        // Assert
        assertEquals(1500.0, balance, 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 300.0;
        // Act
        balance -= withdrawAmount;
        // Assert
        assertEquals(700.0, balance, 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        // Arrange
        double withdrawAmount = 2000.0;
        // Act
        boolean success = balance >= withdrawAmount;
        if (success) {
            balance -= withdrawAmount;
        }
        // Assert
        assertTrue(!success);
        assertEquals(1000.0, balance, 0.001);
    }
}

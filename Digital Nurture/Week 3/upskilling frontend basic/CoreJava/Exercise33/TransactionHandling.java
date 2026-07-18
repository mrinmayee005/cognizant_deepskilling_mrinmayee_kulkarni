/**
 * Exercise 33: Transaction Handling
 * Objective: Demonstrate database transactions with commit and rollback.
 * Simulates a money transfer between two accounts.
 *
 * SETUP REQUIRED:
 * 1. Download MySQL Connector/J from https://dev.mysql.com/downloads/connector/j/
 * 2. Add the JAR to your classpath:
 *    javac -cp ".;mysql-connector-j-8.x.x.jar" TransactionHandling.java
 *    java -cp ".;mysql-connector-j-8.x.x.jar" TransactionHandling
 * 3. Ensure MySQL server is running
 *
 * SQL to create the test table:
 * CREATE DATABASE IF NOT EXISTS bank;
 * USE bank;
 * CREATE TABLE IF NOT EXISTS accounts (
 *     id INT PRIMARY KEY AUTO_INCREMENT,
 *     name VARCHAR(100) NOT NULL,
 *     balance DOUBLE DEFAULT 0.0
 * );
 * INSERT INTO accounts (name, balance) VALUES
 * ('Alice', 1000.00),
 * ('Bob', 500.00);
 *
 * Compile: javac -cp ".;mysql-connector-j-8.x.x.jar" TransactionHandling.java
 * Run: java -cp ".;mysql-connector-j-8.x.x.jar" TransactionHandling
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHandling {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password_here";

    public static void main(String[] args) {
        System.out.println("=== Transaction Handling Demo ===\n");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Display initial balances
            System.out.println("--- Initial Balances ---");
            displayBalances(conn);

            // Successful transfer: Alice sends $200 to Bob
            System.out.println("\n--- Transfer $200 from Alice to Bob (SUCCESS) ---");
            transferMoney(conn, "Alice", "Bob", 200.00);

            System.out.println("\n--- Balances After Successful Transfer ---");
            displayBalances(conn);

            // Failed transfer: Alice tries to send $10000 (insufficient funds)
            System.out.println("\n--- Transfer $10000 from Alice to Bob (SHOULD FAIL) ---");
            transferMoney(conn, "Alice", "Bob", 10000.00);

            System.out.println("\n--- Balances After Failed Transfer ---");
            displayBalances(conn);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void transferMoney(Connection conn, String from, String to, double amount) throws SQLException {
        String checkBalance = "SELECT balance FROM accounts WHERE name = ?";
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE name = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE name = ?";

        boolean originalAutoCommit = conn.getAutoCommit();

        try {
            // Disable auto-commit to start a transaction
            conn.setAutoCommit(false);

            // Check sender's balance
            double senderBalance = 0;
            try (PreparedStatement pstmt = conn.prepareStatement(checkBalance)) {
                pstmt.setString(1, from);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        senderBalance = rs.getDouble("balance");
                    }
                }
            }

            if (senderBalance < amount) {
                System.out.println("FAILED: " + from + " has $" + senderBalance
                        + ", cannot transfer $" + amount);
                conn.rollback();
                System.out.println("Transaction rolled back.");
                return;
            }

            // Debit sender
            try (PreparedStatement pstmt = conn.prepareStatement(debitSQL)) {
                pstmt.setDouble(1, amount);
                pstmt.setString(2, from);
                pstmt.executeUpdate();
            }

            // Credit receiver
            try (PreparedStatement pstmt = conn.prepareStatement(creditSQL)) {
                pstmt.setDouble(1, amount);
                pstmt.setString(2, to);
                pstmt.executeUpdate();
            }

            // Commit the transaction
            conn.commit();
            System.out.println("SUCCESS: Transferred $" + amount + " from " + from + " to " + to);

        } catch (SQLException e) {
            // Rollback on any error
            conn.rollback();
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Transaction rolled back.");
        } finally {
            // Restore auto-commit
            conn.setAutoCommit(originalAutoCommit);
        }
    }

    public static void displayBalances(Connection conn) throws SQLException {
        String sql = "SELECT name, balance FROM accounts";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("  %s: $%,.2f%n", rs.getString("name"), rs.getDouble("balance"));
            }
        }
    }
}

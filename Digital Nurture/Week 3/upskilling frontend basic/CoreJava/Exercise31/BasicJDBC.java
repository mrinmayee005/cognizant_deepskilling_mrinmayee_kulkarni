/**
 * Exercise 31: Basic JDBC
 * Objective: Connect to a MySQL database and execute a SELECT query using JDBC.
 *
 * SETUP REQUIRED:
 * 1. Download MySQL Connector/J from https://dev.mysql.com/downloads/connector/j/
 * 2. Add the JAR to your classpath:
 *    javac -cp ".;mysql-connector-j-8.x.x.jar" BasicJDBC.java
 *    java -cp ".;mysql-connector-j-8.x.x.jar" BasicJDBC
 * 3. Ensure MySQL server is running
 * 4. Update the connection URL, username, and password below
 *
 * SQL to create the test table:
 * CREATE DATABASE IF NOT EXISTS school;
 * USE school;
 * CREATE TABLE students (
 *     id INT PRIMARY KEY AUTO_INCREMENT,
 *     name VARCHAR(100) NOT NULL,
 *     age INT,
 *     grade VARCHAR(10),
 *     gpa DOUBLE
 * );
 * INSERT INTO students (name, age, grade, gpa) VALUES
 * ('Alice Johnson', 20, 'A', 3.8),
 * ('Bob Smith', 22, 'B', 3.2),
 * ('Charlie Brown', 21, 'A', 3.9),
 * ('Diana Prince', 23, 'C', 2.7),
 * ('Edward Norton', 20, 'B', 3.5);
 *
 * Compile: javac -cp ".;mysql-connector-j-8.x.x.jar" BasicJDBC.java
 * Run: java -cp ".;mysql-connector-j-8.x.x.jar" BasicJDBC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBC {

    // Update these values for your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password_here";

    public static void main(String[] args) {
        System.out.println("=== Basic JDBC Demo ===\n");

        // Step 1: Register JDBC driver (not needed for JDBC 4.0+ / Java 6+)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: MySQL JDBC Driver not found!");
            System.out.println("Please add mysql-connector-j JAR to classpath.");
            System.out.println("Download from: https://dev.mysql.com/downloads/connector/j/");
            return;
        }

        // Step 2: Establish connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected successfully!\n");

            // Step 3: Create and execute a query
            statement = connection.createStatement();
            String sql = "SELECT id, name, age, grade, gpa FROM students ORDER BY name";
            resultSet = statement.executeQuery(sql);

            // Step 4: Process the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("--- Query Results ---");
            System.out.printf("%-5s %-20s %-5s %-8s %-6s%n",
                    metaData.getColumnName(1),
                    metaData.getColumnName(2),
                    metaData.getColumnName(3),
                    metaData.getColumnName(4),
                    metaData.getColumnName(5));
            System.out.println("-".repeat(50));

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                double gpa = resultSet.getDouble("gpa");

                System.out.printf("%-5d %-20s %-5d %-8s %-6.1f%n", id, name, age, grade, gpa);
            }

            System.out.println("\nTotal rows retrieved: " + getRowCount(resultSet));

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
        } finally {
            // Step 5: Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("\nDatabase resources closed.");
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    private static int getRowCount(ResultSet rs) throws SQLException {
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;
    }
}

/**
 * Exercise 32: JDBC Insert and Update
 * Objective: Create a StudentDAO class with insert and update using PreparedStatement.
 *
 * SETUP REQUIRED:
 * 1. Download MySQL Connector/J from https://dev.mysql.com/downloads/connector/j/
 * 2. Add the JAR to your classpath:
 *    javac -cp ".;mysql-connector-j-8.x.x.jar" JDBCInsertUpdate.java
 *    java -cp ".;mysql-connector-j-8.x.x.jar" JDBCInsertUpdate
 * 3. Ensure MySQL server is running with the 'school' database from Exercise31
 *
 * SQL to create the table:
 * CREATE TABLE IF NOT EXISTS students (
 *     id INT PRIMARY KEY AUTO_INCREMENT,
 *     name VARCHAR(100) NOT NULL,
 *     age INT,
 *     grade VARCHAR(10),
 *     gpa DOUBLE
 * );
 *
 * Compile: javac -cp ".;mysql-connector-j-8.x.x.jar" JDBCInsertUpdate.java
 * Run: java -cp ".;mysql-connector-j-8.x.x.jar" JDBCInsertUpdate
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password_here";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // INSERT a new student
    public int insertStudent(String name, int age, String grade, double gpa) {
        String sql = "INSERT INTO students (name, age, grade, gpa) VALUES (?, ?, ?, ?)";
        int affectedRows = 0;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.setDouble(4, gpa);

            affectedRows = pstmt.executeUpdate();
            System.out.println("Inserted " + affectedRows + " row(s) for: " + name);

        } catch (SQLException e) {
            System.out.println("Insert error: " + e.getMessage());
        }
        return affectedRows;
    }

    // UPDATE student's GPA by name
    public int updateStudentGPA(String name, double newGPA) {
        String sql = "UPDATE students SET gpa = ? WHERE name = ?";
        int affectedRows = 0;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newGPA);
            pstmt.setString(2, name);

            affectedRows = pstmt.executeUpdate();
            System.out.println("Updated " + affectedRows + " row(s) for: " + name);

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
        return affectedRows;
    }

    // UPDATE student's grade by name
    public int updateStudentGrade(String name, String newGrade) {
        String sql = "UPDATE students SET grade = ? WHERE name = ?";
        int affectedRows = 0;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newGrade);
            pstmt.setString(2, name);

            affectedRows = pstmt.executeUpdate();
            System.out.println("Updated " + affectedRows + " row(s) for: " + name);

        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
        }
        return affectedRows;
    }

    // SELECT and display all students
    public void displayAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- All Students ---");
            System.out.printf("%-5s %-20s %-5s %-8s %-6s%n", "ID", "Name", "Age", "Grade", "GPA");
            System.out.println("-".repeat(50));

            while (rs.next()) {
                System.out.printf("%-5d %-20s %-5d %-8s %-6.1f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade"),
                        rs.getDouble("gpa"));
            }

        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
        }
    }
}

public class JDBCInsertUpdate {
    public static void main(String[] args) {
        System.out.println("=== JDBC Insert & Update Demo ===\n");

        StudentDAO dao = new StudentDAO();

        // Insert new students
        System.out.println("--- Inserting Students ---");
        dao.insertStudent("Frank Castle", 30, "B", 3.0);
        dao.insertStudent("Natasha Romanoff", 28, "A", 3.7);
        dao.insertStudent("Peter Parker", 19, "A", 3.9);

        // Display all students
        dao.displayAllStudents();

        // Update a student
        System.out.println("\n--- Updating Students ---");
        dao.updateStudentGPA("Frank Castle", 3.6);
        dao.updateStudentGrade("Peter Parker", "A+");

        // Display updated students
        dao.displayAllStudents();
    }
}

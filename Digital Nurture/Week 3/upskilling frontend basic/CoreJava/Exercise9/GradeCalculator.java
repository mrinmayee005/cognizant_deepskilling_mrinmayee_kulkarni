/**
 * Exercise 9: Grade Calculator
 * Objective: Determine a letter grade based on a numeric score using if-else.
 *   90-100: A
 *   80-89:  B
 *   70-79:  C
 *   60-69:  D
 *   Below 60: F
 * Compile: javac GradeCalculator.java
 * Run: java GradeCalculator
 */
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your score (0-100): ");
        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Invalid score! Please enter a value between 0 and 100.");
        } else {
            char grade;

            if (score >= 90) {
                grade = 'A';
            } else if (score >= 80) {
                grade = 'B';
            } else if (score >= 70) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Score: " + score);
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }
}

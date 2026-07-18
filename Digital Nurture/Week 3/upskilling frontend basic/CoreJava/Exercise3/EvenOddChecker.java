/**
 * Exercise 3: Even/Odd Checker
 * Objective: Determine if a number is even or odd using the modulus operator.
 * Compile: javac EvenOddChecker.java
 * Run: java EvenOddChecker
 */
import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        scanner.close();
    }
}

/**
 * Exercise 20: Try-Catch Example
 * Objective: Handle exceptions using try-catch blocks.
 * Compile: javac TryCatchExample.java
 * Run: java TryCatchExample
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Try-Catch Example ===\n");

        // Example 1: ArithmeticException (division by zero)
        System.out.println("--- Example 1: Division by Zero ---");
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example 2: ArrayIndexOutOfBoundsException
        System.out.println("\n--- Example 2: Array Index Out of Bounds ---");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Example 3: InputMismatchException
        System.out.println("\n--- Example 3: Input Mismatch ---");
        try {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Error: That is not a valid integer!");
        }

        // Example 4: Multiple catch blocks
        System.out.println("\n--- Example 4: Multiple Catch Blocks ---");
        try {
            String str = null;
            System.out.println("String length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointer Error: " + e.getMessage());
        }

        // Example 5: finally block
        System.out.println("\n--- Example 5: Finally Block ---");
        try {
            int result = 100 / 5;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed (always runs).");
        }

        scanner.close();
    }
}

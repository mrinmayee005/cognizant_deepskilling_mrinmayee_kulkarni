/**
 * Exercise 13: Recursive Fibonacci
 * Objective: Generate Fibonacci numbers using recursion.
 * The sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * Compile: javac RecursiveFibonacci.java
 * Run: java RecursiveFibonacci
 */
import java.util.Scanner;

public class RecursiveFibonacci {

    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci terms to display: ");
        int count = scanner.nextInt();

        System.out.println("Fibonacci Sequence (" + count + " terms):");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.println("\nDetailed breakdown:");
        for (int i = 0; i < Math.min(count, 15); i++) {
            System.out.println("fibonacci(" + i + ") = " + fibonacci(i));
        }

        scanner.close();
    }
}

/**
 * Exercise 5: Multiplication Table
 * Objective: Generate a multiplication table for a given number from 1 to 10.
 * Compile: javac MultiplicationTable.java
 * Run: java MultiplicationTable
 */
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Multiplication Table for " + number + ":");
        System.out.println("----------------------------------");

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}

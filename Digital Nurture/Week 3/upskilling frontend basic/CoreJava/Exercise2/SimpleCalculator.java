/**
 * Exercise 2: Simple Calculator
 * Objective: Build a calculator that reads two numbers and an operation from the user.
 * Compile: javac SimpleCalculator.java
 * Run: java SimpleCalculator
 */
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Choose operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                    scanner.close();
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        System.out.println("Result: " + num1 + " " + operation + " " + num2 + " = " + result);
        scanner.close();
    }
}

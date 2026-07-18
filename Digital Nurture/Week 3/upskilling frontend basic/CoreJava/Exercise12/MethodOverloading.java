/**
 * Exercise 12: Method Overloading
 * Objective: Demonstrate method overloading with multiple add() methods.
 * Compile: javac MethodOverloading.java
 * Run: java MethodOverloading
 */
public class MethodOverloading {

    // Add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Add an integer and a double
    public static double add(int a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("=== Method Overloading Demo ===");

        int sum1 = add(5, 10);
        System.out.println("add(5, 10) = " + sum1 + "  [int + int]");

        double sum2 = add(3.5, 2.7);
        System.out.println("add(3.5, 2.7) = " + sum2 + "  [double + double]");

        int sum3 = add(1, 2, 3);
        System.out.println("add(1, 2, 3) = " + sum3 + "  [int + int + int]");

        double sum4 = add(10, 5.5);
        System.out.println("add(10, 5.5) = " + sum4 + "  [int + double]");
    }
}

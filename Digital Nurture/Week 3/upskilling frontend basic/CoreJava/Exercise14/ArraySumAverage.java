/**
 * Exercise 14: Array Sum and Average
 * Objective: Calculate the sum and average of elements in an array.
 * Compile: javac ArraySumAverage.java
 * Run: java ArraySumAverage
 */
public class ArraySumAverage {
    public static void main(String[] args) {
        int[] numbers = {10, 25, 30, 45, 50, 65, 70, 85, 90, 100};

        System.out.println("=== Array Sum and Average ===");
        System.out.print("Array elements: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Calculate sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Calculate average
        double average = (double) sum / numbers.length;

        System.out.println("Number of elements: " + numbers.length);
        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
    }
}

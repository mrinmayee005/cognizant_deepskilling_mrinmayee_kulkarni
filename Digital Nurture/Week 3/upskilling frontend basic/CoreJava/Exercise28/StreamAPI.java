/**
 * Exercise 28: Stream API
 * Objective: Use Java Stream API to filter, map, and process collections.
 * Compile: javac StreamAPI.java
 * Run: java StreamAPI
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30);

        System.out.println("=== Stream API Demo ===");
        System.out.println("List: " + numbers + "\n");

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Filter odd numbers
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Odd numbers:  " + oddNumbers);

        // Filter numbers greater than 10
        List<Integer> greaterThan10 = numbers.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
        System.out.println("Greater than 10: " + greaterThan10);

        // Map: square each number
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Map: multiply by 2
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled);

        // Reduce: sum of all elements
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("\nSum of all numbers: " + sum);

        // Reduce: find max
        int max = numbers.stream()
                .reduce(Integer::max)
                .orElse(0);
        System.out.println("Maximum value: " + max);

        // Reduce: find min
        int min = numbers.stream()
                .reduce(Integer::min)
                .orElse(0);
        System.out.println("Minimum value: " + min);

        // Count even numbers
        long evenCount = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Count of even numbers: " + evenCount);

        // Chained operations: even numbers, squared, sorted
        List<Integer> evenSquaresSorted = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Even squares (sorted): " + evenSquaresSorted);

        // String operations
        System.out.println("\n--- String Stream Operations ---");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");

        String longWords = words.stream()
                .filter(w -> w.length() > 5)
                .collect(Collectors.joining(", "));
        System.out.println("Words longer than 5 chars: " + longWords);

        String uppercased = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" | "));
        System.out.println("All uppercase: " + uppercased);
    }
}

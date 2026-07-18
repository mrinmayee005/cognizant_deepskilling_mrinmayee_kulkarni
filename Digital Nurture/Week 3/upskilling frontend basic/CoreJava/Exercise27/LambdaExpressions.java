/**
 * Exercise 27: Lambda Expressions
 * Objective: Sort a list of strings using lambda expressions.
 * Compile: javac LambdaExpressions.java
 * Run: java LambdaExpressions
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Eve");
        names.add("Bob");
        names.add("Diana");

        System.out.println("=== Lambda Expressions Demo ===\n");

        // Original list
        System.out.println("Original list: " + names);

        // Sort alphabetically using lambda
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted alphabetically:  " + names);

        // Sort by length using lambda
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Sorted by length:       " + names);

        // Sort in reverse alphabetical order using lambda and Comparator
        names.sort(Comparator.comparing(String::reverse));
        System.out.println("Reverse alpha (broken): " + names);

        names.sort(Comparator.comparing((String s) -> s).reversed());
        System.out.println("Reverse alphabetical:   " + names);

        // Using lambda with forEach
        System.out.println("\n--- Lambda with forEach ---");
        names.forEach(name -> System.out.println("  - " + name));

        // Lambda with custom logic
        System.out.println("\n--- Names longer than 4 characters ---");
        names.stream()
             .filter(name -> name.length() > 4)
             .forEach(name -> System.out.println("  " + name + " (" + name.length() + " chars)"));

        // Functional interface demonstration
        System.out.println("\n--- Custom Functional Interface ---");
        StringProcessor toUpper = s -> s.toUpperCase();
        StringProcessor toLower = s -> s.toLowerCase();
        StringProcessor reverse = s -> new StringBuilder(s).reverse().toString();

        String test = "Hello Lambda";
        System.out.println("Original:  " + test);
        System.out.println("Upper:     " + toUpper.process(test));
        System.out.println("Lower:     " + toLower.process(test));
        System.out.println("Reversed:  " + reverse.process(test));
    }
}

@FunctionalInterface
interface StringProcessor {
    String process(String input);
}

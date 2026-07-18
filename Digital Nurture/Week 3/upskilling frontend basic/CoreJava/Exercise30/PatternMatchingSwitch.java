/**
 * Exercise 30: Pattern Matching for Switch
 * Objective: Demonstrate Java 21 pattern matching for switch expressions.
 * Requires Java 21+
 * Compile: javac PatternMatchingSwitch.java
 * Run: java PatternMatchingSwitch
 */
public class PatternMatchingSwitch {

    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer: " + i + (i > 0 ? " (positive)" : i < 0 ? " (negative)" : " (zero)");
            case String s -> "String of length " + s.length() + ": \"" + s + "\"";
            case Double d -> "Double: " + d + (d > 100 ? " (large)" : " (small)");
            case Boolean b -> "Boolean: " + b;
            case int[] arr -> "int array of length " + arr.length;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    static String classifyNumber(int number) {
        return switch (number) {
            case 0 -> "Zero";
            case int n when n > 0 && n <= 10 -> "Small positive (" + n + ")";
            case int n when n > 10 && n <= 100 -> "Medium positive (" + n + ")";
            case int n when n > 100 -> "Large positive (" + n + ")";
            case int n when n < 0 && n >= -10 -> "Small negative (" + n + ")";
            case int n -> "Large negative (" + n + ")";
        };
    }

    static String processShape(Object shape) {
        return switch (shape) {
            case String s when s.equalsIgnoreCase("circle") -> "Processing a circle (round shape)";
            case String s when s.equalsIgnoreCase("square") -> "Processing a square (4 equal sides)";
            case String s when s.equalsIgnoreCase("triangle") -> "Processing a triangle (3 sides)";
            case String s -> "Unknown shape: " + s;
            case null -> "No shape provided";
            default -> "Not a valid shape input";
        };
    }

    public static void main(String[] args) {
        System.out.println("=== Pattern Matching for Switch (Java 21+) ===\n");

        // Basic pattern matching
        System.out.println("--- Basic Type Pattern Matching ---");
        Object[] values = {42, "Hello", 3.14, true, new int[]{1, 2, 3}, null, 4.0f};
        for (Object val : values) {
            System.out.println("  " + describe(val));
        }

        // Guarded patterns
        System.out.println("\n--- Guarded Number Classification ---");
        int[] testNumbers = {-50, -5, 0, 3, 15, 200};
        for (int num : testNumbers) {
            System.out.println("  " + num + " -> " + classifyNumber(num));
        }

        // Shape processing
        System.out.println("\n--- Shape Pattern Matching ---");
        Object[] shapes = {"circle", "Square", "triangle", "pentagon", null};
        for (Object shape : shapes) {
            System.out.println("  " + processShape(shape));
        }

        // Pattern matching with sealed classes
        System.out.println("\n--- Pattern Matching with instanceof ---");
        Object[] mixed = {1, "test", 2.5, 'A', List.of(1, 2, 3)};
        for (Object obj : mixed) {
            if (obj instanceof Integer i) {
                System.out.println("  Integer found: " + i);
            } else if (obj instanceof String s) {
                System.out.println("  String found: \"" + s + "\" (length=" + s.length() + ")");
            } else if (obj instanceof Double d) {
                System.out.println("  Double found: " + d);
            } else {
                System.out.println("  Other type: " + obj.getClass().getSimpleName());
            }
        }
    }
}

/**
 * Exercise 38: Decompilation Demo
 * Objective: Understand decompilation by creating a simple class and examining
 * how decompilers reconstruct source code from bytecode.
 *
 * STEPS:
 * 1. Compile this file:
 *    javac DecompileDemo.java
 *
 * 2. Use one of the following decompilers:
 *
 *    a) JD-GUI (Java Decompiler GUI):
 *       - Download from: https://github.com/java-decompiler/jd-gui/releases
 *       - Open the .class file or .jar file
 *       - View reconstructed source code
 *
 *    b) CFR (Class File Reader):
 *       - Download from: https://github.com/leibnitz27/cfr/releases
 *       - Command: java -jar cfr.jar DecompileDemo.class
 *
 *    c) FernFlower (built into IntelliJ IDEA):
 *       - IntelliJ IDEA -> Build -> Decompile with FernFlower
 *       - Or use command: java -jar fernflower.jar DecompileDemo.class output/
 *
 *    d) Procyon:
 *       - Download from: https://github.com/mstrobel/procyon/releases
 *       - Command: java -jar procyon-decompiler.jar DecompileDemo.class
 *
 * 3. Compare the decompiled output with the original source code.
 *    Notice how the decompiler reconstructs:
 *    - Control structures (if/else, for, while)
 *    - Method signatures
 *    - Field declarations
 *    - Annotations
 *    - String constants
 *
 * WHAT TO LOOK FOR:
 * - Enum values are reconstructed
 * - Annotations are preserved in bytecode attributes
 * - Generics are erased but type info is in signatures
 * - Lambda expressions are converted to synthetic methods
 * - Switch statements may become tableswitch/lookupswitch
 */
import java.util.ArrayList;
import java.util.List;

public class DecompileDemo {

    // Enum - interesting to decompile
    public enum Season {
        SPRING, SUMMER, AUTUMN, WINTER;

        public String getEmoji() {
            return switch (this) {
                case SPRING -> "\uD83C\uDF31";
                case SUMMER -> "\u2600\uFE0F";
                case AUTUMN -> "\uD83C\uDF42";
                case WINTER -> "\u2744\uFE0F";
            };
        }
    }

    // Inner class
    public static class Calculator {
        private double memory;

        public Calculator() {
            this.memory = 0;
        }

        public double add(double a, double b) {
            memory = a + b;
            return memory;
        }

        public double subtract(double a, double b) {
            memory = a - b;
            return memory;
        }

        public double getMemory() {
            return memory;
        }
    }

    // Generics - type info is in bytecode signature
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Varargs method
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // Method with try-with-resources
    public static String repeatString(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Decompile Demo ===\n");

        // Calculator demo
        Calculator calc = new Calculator();
        System.out.println("Calculator.add(5, 3) = " + calc.add(5, 3));
        System.out.println("Calculator.subtract(10, 4) = " + calc.subtract(10, 4));

        // Season enum
        System.out.println("\nSeasons:");
        for (Season s : Season.values()) {
            System.out.println("  " + s + " " + s.getEmoji());
        }

        // Generics
        List<String> names = List.of("Alice", "Charlie", "Bob", "Diana");
        System.out.println("\nMax name: " + findMax(names));

        List<Integer> numbers = List.of(5, 2, 8, 1, 9, 3);
        System.out.println("Max number: " + findMax(numbers));

        // Varargs
        System.out.println("\nsum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));

        // String repeat
        System.out.println("repeatString(\"Java\", 3) = " + repeatString("Java", 3));

        System.out.println("\n--- Decompilation Instructions ---");
        System.out.println("1. Compile: javac DecompileDemo.java");
        System.out.println("2. CFR: java -jar cfr.jar DecompileDemo.class");
        System.out.println("3. JD-GUI: Open DecompileDemo.class in the GUI");
        System.out.println("4. Compare the decompiled output with this source code.");
    }
}

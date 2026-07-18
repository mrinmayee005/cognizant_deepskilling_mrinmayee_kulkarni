/**
 * Exercise 34: Java Module System (JPMS) Demo
 * Objective: Demonstrate Java 9+ module system with two modules.
 *
 * COMPILE AND RUN (standalone mode):
 *   cd Exercise34
 *   javac ModuleDemo.java
 *   java ModuleDemo
 *
 * COMPILE AND RUN WITH MODULES:
 *   cd Exercise34
 *   mkdir -p mods/com.utils mods/com.greetings
 *   javac -d mods/com.utils com.utils/module-info.java com.utils/com/utils/StringUtils.java
 *   javac --module-path mods -d mods/com.greetings com.greetings/module-info.java com.greetings/com/greetings/Main.java
 *   java --module-path mods -m com.greetings/com.greetings.Main
 *
 * MODULE STRUCTURE:
 *   com.greetings/module-info.java  - Declares module requires com.utils
 *   com.greetings/Main.java         - Main entry point using StringUtils
 *   com.utils/module-info.java      - Declares module exports com.utils
 *   com.utils/StringUtils.java      - String utility methods
 */
public class ModuleDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Module System Demo ===\n");

        System.out.println("Module Structure:");
        System.out.println("=================");
        System.out.println("com.greetings module:");
        System.out.println("  module-info.java  - requires com.utils");
        System.out.println("  Main.java         - imports and uses StringUtils");
        System.out.println();
        System.out.println("com.utils module:");
        System.out.println("  module-info.java  - exports com.utils package");
        System.out.println("  StringUtils.java  - reverse, isPalindrome, toCamelCase");
        System.out.println();

        System.out.println("To run with modules:");
        System.out.println("  1. Compile com.utils: javac -d mods/com.utils com.utils\\module-info.java com.utils\\com\\utils\\StringUtils.java");
        System.out.println("  2. Compile com.greetings: javac --module-path mods -d mods\\com.greetings com.greetings\\module-info.java com.greetings\\com\\greetings\\Main.java");
        System.out.println("  3. Run: java --module-path mods -m com.greetings\\com.greetings.Main");
        System.out.println();

        System.out.println("--- String Utilities Demo (simulated) ---");
        String test1 = "Hello World";
        String test2 = "racecar";
        String test3 = "hello world";

        System.out.println("Original:     \"" + test1 + "\"");
        System.out.println("Reversed:     \"" + new StringBuilder(test1).reverse().toString() + "\"");
        String cleaned = test2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("\"" + test2 + "\" is palindrome: " + cleaned.equals(new StringBuilder(cleaned).reverse().toString()));
        System.out.println("toCamelCase:  \"" + toCamelCase(test3) + "\"");
    }

    public static String toCamelCase(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder(words[0].toLowerCase());
        for (int i = 1; i < words.length; i++) {
            result.append(words[i].substring(0, 1).toUpperCase())
                  .append(words[i].substring(1).toLowerCase());
        }
        return result.toString();
    }
}

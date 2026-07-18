/**
 * Exercise 37: Bytecode Inspector
 * Objective: Understand Java bytecode by examining compiled class files.
 *
 * This program contains a class with various methods.
 * After compilation, use javap to inspect the bytecode.
 *
 * STEPS:
 * 1. Compile this file:
 *    javac BytecodeInspector.java
 *
 * 2. Disassemble the class file:
 *    javap -c BytecodeInspector.class
 *
 * 3. Disassemble with verbose output (includes constant pool):
 *    javap -v BytecodeInspector.class
 *
 * 4. Disassemble with line number tables:
 *    javap -c -l BytecodeInspector.class
 *
 * SAMPLE OUTPUT of "javap -c BytecodeInspector.class":
 * =====================================================
 * Compiled from "BytecodeInspector.java"
 * public class BytecodeInspector {
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2    // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #3    // String === Bytecode Inspector Demo ===
 *        5: invokevirtual #4    // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        ...
 *
 *   public static int add(int, int);
 *     Code:
 *        0: iload_0
 *        1: iload_1
 *        2: iadd
 *        3: ireturn
 *
 * KEY BYTECODE INSTRUCTIONS:
 *   iload_0    - Load int from local variable 0
 *   iadd       - Add two integers
 *   ireturn    - Return integer value
 *   invokevirtual - Invoke instance method
 *   getstatic  - Get static field
 *   ldc        - Load constant from constant pool
 *   bipush     - Push byte-sized integer onto stack
 */
public class BytecodeInspector {

    // Simple method - produces minimal bytecode
    public static int add(int a, int b) {
        return a + b;
    }

    // Method with local variables
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Method with conditional branching
    public static String classify(int number) {
        if (number > 0) {
            return "positive";
        } else if (number < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    // Method with exception handling
    public static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
    }

    // Method with object creation
    public static String concatenate(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        return sb.toString();
    }

    // Method with loop
    public static int sumOfSquares(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Bytecode Inspector Demo ===\n");

        System.out.println("add(3, 4) = " + add(3, 4));
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("classify(10) = " + classify(10));
        System.out.println("classify(-5) = " + classify(-5));
        System.out.println("classify(0) = " + classify(0));
        System.out.println("safeDivide(10, 3) = " + safeDivide(10, 3));
        System.out.println("concatenate(\"Hello\", \" World\") = " + concatenate("Hello", " World"));
        System.out.println("sumOfSquares(5) = " + sumOfSquares(5));

        System.out.println("\n--- Instructions to inspect bytecode ---");
        System.out.println("1. Compile: javac BytecodeInspector.java");
        System.out.println("2. Basic disassembly: javap -c BytecodeInspector.class");
        System.out.println("3. Verbose output: javap -v BytecodeInspector.class");
        System.out.println("4. With line numbers: javap -c -l BytecodeInspector.class");
        System.out.println("5. All public members: javap -p BytecodeInspector.class");
    }
}

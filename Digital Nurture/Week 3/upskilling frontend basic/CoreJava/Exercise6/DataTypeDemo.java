/**
 * Exercise 6: Data Types Demo
 * Objective: Demonstrate declarations of primitive data types in Java.
 * Compile: javac DataTypeDemo.java
 * Run: java DataTypeDemo
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        // Integer types
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9876543210L;

        // Floating-point types
        float floatVar = 3.14f;
        double doubleVar = 3.141592653589793;

        // Character type
        char charVar = 'A';

        // Boolean type
        boolean booleanVar = true;

        System.out.println("=== Java Primitive Data Types ===");
        System.out.println("byte:    " + byteVar + "  (size: 1 byte, range: -128 to 127)");
        System.out.println("short:   " + shortVar + "  (size: 2 bytes)");
        System.out.println("int:     " + intVar + " (size: 4 bytes)");
        System.out.println("long:    " + longVar + " (size: 8 bytes)");
        System.out.println("float:   " + floatVar + " (size: 4 bytes)");
        System.out.println("double:  " + doubleVar + " (size: 8 bytes)");
        System.out.println("char:    " + charVar + "  (size: 2 bytes)");
        System.out.println("boolean: " + booleanVar + " (size: 1 bit)");

        System.out.println("\nSize of each type:");
        System.out.println("byte:    " + Byte.BYTES + " byte(s)");
        System.out.println("short:   " + Short.BYTES + " byte(s)");
        System.out.println("int:     " + Integer.BYTES + " byte(s)");
        System.out.println("long:    " + Long.BYTES + " byte(s)");
        System.out.println("float:   " + Float.BYTES + " byte(s)");
        System.out.println("double:  " + Double.BYTES + " byte(s)");
        System.out.println("char:    " + Character.BYTES + " byte(s)");
    }
}

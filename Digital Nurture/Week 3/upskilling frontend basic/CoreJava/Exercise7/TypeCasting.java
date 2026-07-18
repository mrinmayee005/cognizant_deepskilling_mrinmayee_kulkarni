/**
 * Exercise 7: Type Casting
 * Objective: Demonstrate implicit (widening) and explicit (narrowing) type casting.
 * Compile: javac TypeCasting.java
 * Run: java TypeCasting
 */
public class TypeCastingDemo {
    public static void main(String[] args) {
        System.out.println("=== Implicit Casting (Widening) ===");
        int intVal = 100;
        double doubleFromInt = intVal;
        System.out.println("int " + intVal + " -> double " + doubleFromInt);

        float floatVal = 3.14f;
        double doubleFromFloat = floatVal;
        System.out.println("float " + floatVal + " -> double " + doubleFromFloat);

        char charVal = 'A';
        int intFromChar = charVal;
        System.out.println("char '" + charVal + "' -> int " + intFromChar);

        System.out.println("\n=== Explicit Casting (Narrowing) ===");
        double bigDouble = 9.78;
        int intFromDouble = (int) bigDouble;
        System.out.println("double " + bigDouble + " -> int " + intFromDouble + " (precision lost)");

        int bigInt = 200;
        byte byteFromInt = (byte) bigInt;
        System.out.println("int " + bigInt + " -> byte " + byteFromInt + " (data truncated if > 127)");

        double pi = 3.14159;
        float floatFromDouble = (float) pi;
        System.out.println("double " + pi + " -> float " + floatFromDouble);

        long longVal = 123456789L;
        short shortFromLong = (short) longVal;
        System.out.println("long " + longVal + " -> short " + shortFromLong + " (data truncated)");

        System.out.println("\n=== Overflow Example ===");
        byte overflow = (byte) 200;
        System.out.println("byte (byte) 200 = " + overflow + " (overflow occurred)");
    }
}

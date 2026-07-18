/**
 * Exercise 8: Operator Precedence
 * Objective: Evaluate complex expressions and understand operator precedence.
 * Compile: javac OperatorPrecedence.java
 * Run: java OperatorPrecedence
 */
public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 10, b = 5, c = 3, d = 2;

        System.out.println("=== Operator Precedence Demo ===");
        System.out.println("Values: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
        System.out.println();

        // Parentheses have highest precedence
        int result1 = (a + b) * c;
        System.out.println("(a + b) * c = " + result1 + "  [parentheses first]");

        // Multiplication before addition
        int result2 = a + b * c;
        System.out.println("a + b * c   = " + result2 + "  [multiplication before addition]");

        // Left-to-right evaluation for same precedence
        int result3 = a - b + c;
        System.out.println("a - b + c   = " + result3 + "  [left to right]");

        // Modulus precedence
        int result4 = a % b + c * d;
        System.out.println("a % b + c * d = " + result4 + "  [modulus and multiplication before addition]");

        // Logical operators
        boolean x = true, y = false, z = true;
        boolean result5 = x && y || z;
        System.out.println("x && y || z = " + result5 + "  [AND before OR]");

        boolean result6 = x || y && z;
        System.out.println("x || y && z = " + result6 + "  [AND before OR, same result]");

        boolean result7 = (x || y) && z;
        System.out.println("(x || y) && z = " + result7 + "  [parentheses change the result]");

        // Bitwise operators
        int m = 12, n = 10;
        int result8 = m & n << 1;
        System.out.println("\nm & n << 1 = " + result8 + "  [shift before AND]");
        int result9 = (m & n) << 1;
        System.out.println("(m & n) << 1 = " + result9 + "  [parentheses change precedence]");

        System.out.println("\n=== Precedence Order (highest to lowest) ===");
        System.out.println("1. Postfix:     x++ x--");
        System.out.println("2. Unary:       ++x --x +x -x ~ !");
        System.out.println("3. Multiplicative: * / %");
        System.out.println("4. Additive:    + -");
        System.out.println("5. Shift:       << >> >>>");
        System.out.println("6. Relational:  < > <= >= instanceof");
        System.out.println("7. Equality:    == !=");
        System.out.println("8. Bitwise AND: &");
        System.out.println("9. Bitwise XOR: ^");
        System.out.println("10. Bitwise OR: |");
        System.out.println("11. Logical AND: &&");
        System.out.println("12. Logical OR: ||");
        System.out.println("13. Ternary:    ? :");
        System.out.println("14. Assignment: = += -= *= /= %= &=");
    }
}

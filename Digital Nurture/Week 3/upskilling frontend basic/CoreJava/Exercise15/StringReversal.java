/**
 * Exercise 15: String Reversal
 * Objective: Reverse a string using different approaches.
 * Compile: javac StringReversal.java
 * Run: java StringReversal
 */
import java.util.Scanner;

public class StringReversal {

    // Method 1: Using a for loop
    public static String reverseWithLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // Method 2: Using StringBuilder
    public static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method 3: Using a char array
    public static String reverseWithCharArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        System.out.println("\n=== String Reversal Methods ===");
        System.out.println("Original:    \"" + input + "\"");
        System.out.println("Loop:        \"" + reverseWithLoop(input) + "\"");
        System.out.println("Builder:     \"" + reverseWithStringBuilder(input) + "\"");
        System.out.println("CharArray:   \"" + reverseWithCharArray(input) + "\"");

        scanner.close();
    }
}

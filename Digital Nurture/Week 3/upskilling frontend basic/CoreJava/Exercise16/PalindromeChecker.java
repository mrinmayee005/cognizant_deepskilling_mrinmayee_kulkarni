/**
 * Exercise 16: Palindrome Checker
 * Objective: Check if a string is a palindrome, ignoring non-alphanumeric characters.
 * Compile: javac PalindromeChecker.java
 * Run: java PalindromeChecker
 */
import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker ===");
        System.out.println("(Enter 'quit' to exit)\n");

        while (true) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            if (isPalindrome(input)) {
                System.out.println("\"" + input + "\" IS a palindrome.");
            } else {
                System.out.println("\"" + input + "\" is NOT a palindrome.");
            }
            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}

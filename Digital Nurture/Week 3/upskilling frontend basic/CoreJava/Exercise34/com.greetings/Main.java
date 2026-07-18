package com.greetings;

import com.utils.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Module System Demo ===\n");

        String test1 = "Hello World";
        String test2 = "racecar";
        String test3 = "hello world";

        System.out.println("--- String Utilities from com.utils module ---");
        System.out.println("Original:     \"" + test1 + "\"");
        System.out.println("Reversed:     \"" + StringUtils.reverse(test1) + "\"");
        System.out.println("\"" + test2 + "\" is palindrome: " + StringUtils.isPalindrome(test2));
        System.out.println("toCamelCase:  \"" + StringUtils.toCamelCase(test3) + "\"");

        System.out.println("\nModule System Summary:");
        System.out.println("- com.greetings requires com.utils");
        System.out.println("- com.utils exports com.utils.StringUtils");
    }
}

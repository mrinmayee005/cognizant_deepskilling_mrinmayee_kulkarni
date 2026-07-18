/**
 * Exercise 34a: Module System - com.utils.StringUtils
 * Part of the Java Module System exercise.
 * This file simulates the com.utils module's StringUtils class.
 */
package com.utils;

public class StringUtils {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
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

/**
 * Exercise 4: Leap Year Checker
 * Objective: Determine if a year is a leap year using nested conditionals.
 * A year is a leap year if:
 *   - Divisible by 4
 *   - But not by 100, unless also divisible by 400
 * Compile: javac LeapYearChecker.java
 * Run: java LeapYearChecker
 */
import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        scanner.close();
    }
}

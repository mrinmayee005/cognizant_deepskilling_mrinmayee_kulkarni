/**
 * Exercise 10: Number Guessing Game
 * Objective: Generate a random number and let the user guess it with feedback.
 * Compile: javac NumberGuessingGame.java
 * Run: java NumberGuessingGame
 */
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (!hasGuessedCorrectly) {
            System.out.print("\nEnter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempt(s)!");
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
    }
}

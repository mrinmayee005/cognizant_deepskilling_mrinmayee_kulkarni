/**
 * Exercise 22: File Writing
 * Objective: Write user input to a text file using FileWriter and BufferedWriter.
 * Compile: javac FileWriting.java
 * Run: java FileWriting
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "output.txt";

        System.out.println("=== File Writing Demo ===");
        System.out.println("Enter lines of text to write to '" + filename + "'.");
        System.out.println("Type 'END' on a new line to finish.\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String line;
            int lineCount = 0;

            while (true) {
                System.out.print("Enter text: ");
                line = scanner.nextLine();

                if (line.equalsIgnoreCase("END")) {
                    break;
                }

                writer.write(line);
                writer.newLine();
                lineCount++;
            }

            System.out.println("\nSuccessfully wrote " + lineCount + " lines to '" + filename + "'.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\nReading back the file contents:");
        System.out.println("-------------------------------");
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}

/**
 * Exercise 23: File Reading
 * Objective: Read and display the contents of a text file using various methods.
 * Compile: javac FileReading.java
 * Run: java FileReading
 *
 * NOTE: Run Exercise22 (FileWriting) first to create the output.txt file.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReading {
    public static void main(String[] args) {
        String filename = "output.txt";

        System.out.println("=== File Reading Demo ===\n");

        // Method 1: BufferedReader
        System.out.println("--- Method 1: BufferedReader ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Method 2: Files.readAllLines (Java 7+)
        System.out.println("\n--- Method 2: Files.readAllLines ---");
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Method 3: Files.readString (Java 11+)
        System.out.println("\n--- Method 3: Files.readString ---");
        try {
            String content = Files.readString(Paths.get(filename));
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

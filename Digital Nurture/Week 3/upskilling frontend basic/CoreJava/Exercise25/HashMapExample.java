/**
 * Exercise 25: HashMap Example
 * Objective: Use HashMap to store student IDs mapped to student names.
 * Compile: javac HashMapExample.java
 * Run: java HashMapExample
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Pre-populate with some data
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(104, "Diana");
        studentMap.put(105, "Edward");

        System.out.println("=== HashMap Example ===");
        System.out.println("Commands: add, get, remove, display, contains, size, quit\n");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    studentMap.put(id, name);
                    System.out.println("Student " + name + " (ID: " + id + ") added.");
                    break;

                case "get":
                    System.out.print("Enter student ID to look up: ");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    String studentName = studentMap.get(searchId);
                    if (studentName != null) {
                        System.out.println("ID " + searchId + " -> " + studentName);
                    } else {
                        System.out.println("No student found with ID " + searchId);
                    }
                    break;

                case "remove":
                    System.out.print("Enter student ID to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    String removed = studentMap.remove(removeId);
                    if (removed != null) {
                        System.out.println("Removed student: " + removed + " (ID: " + removeId + ")");
                    } else {
                        System.out.println("No student found with ID " + removeId);
                    }
                    break;

                case "display":
                    System.out.println("\nStudent Database:");
                    System.out.println("-----------------");
                    if (studentMap.isEmpty()) {
                        System.out.println("  (empty)");
                    } else {
                        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
                            System.out.println("  ID: " + entry.getKey() + " -> Name: " + entry.getValue());
                        }
                    }
                    System.out.println();
                    break;

                case "contains":
                    System.out.print("Enter ID to check: ");
                    int checkId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Contains ID " + checkId + ": " + studentMap.containsKey(checkId));
                    break;

                case "size":
                    System.out.println("Map size: " + studentMap.size());
                    break;

                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Try: add, get, remove, display, contains, size, quit");
            }
        }
    }
}

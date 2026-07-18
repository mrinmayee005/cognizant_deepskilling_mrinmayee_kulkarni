/**
 * Exercise 24: ArrayList Example
 * Objective: Use ArrayList to store and manipulate a list of student names.
 * Compile: javac ArrayListExample.java
 * Run: java ArrayListExample
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ArrayList Example ===");
        System.out.println("Commands: add, remove, display, sort, size, search, quit\n");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    students.add(name);
                    System.out.println(name + " added to the list.");
                    break;

                case "remove":
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    if (students.remove(removeName)) {
                        System.out.println(removeName + " removed from the list.");
                    } else {
                        System.out.println(removeName + " not found in the list.");
                    }
                    break;

                case "display":
                    System.out.println("\nStudent List:");
                    if (students.isEmpty()) {
                        System.out.println("  (empty)");
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println("  " + (i + 1) + ". " + students.get(i));
                        }
                    }
                    System.out.println();
                    break;

                case "sort":
                    Collections.sort(students);
                    System.out.println("List sorted alphabetically.");
                    break;

                case "size":
                    System.out.println("List size: " + students.size());
                    break;

                case "search":
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    int index = students.indexOf(searchName);
                    if (index >= 0) {
                        System.out.println(searchName + " found at index " + index);
                    } else {
                        System.out.println(searchName + " not found.");
                    }
                    break;

                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Try: add, remove, display, sort, size, search, quit");
            }
        }
    }
}

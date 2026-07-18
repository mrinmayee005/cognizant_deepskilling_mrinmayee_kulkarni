/**
 * Exercise 21: Custom Exception
 * Objective: Create and throw a custom exception for invalid age.
 * Compile: javac CustomException.java
 * Run: java CustomException
 */
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is invalid. Person must be at least 18 years old.");
        }
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Custom Exception Demo ===\n");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        try {
            Person person = new Person(name, age);
            System.out.println("\nPerson created successfully:");
            person.display();
        } catch (InvalidAgeException e) {
            System.out.println("\nInvalidAgeException caught!");
            System.out.println("Message: " + e.getMessage());
        }

        System.out.println("\n--- Testing with invalid age ---");
        try {
            Person child = new Person("Young Person", 15);
            child.display();
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n--- Testing with valid age ---");
        try {
            Person adult = new Person("Adult Person", 25);
            adult.display();
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        scanner.close();
    }
}

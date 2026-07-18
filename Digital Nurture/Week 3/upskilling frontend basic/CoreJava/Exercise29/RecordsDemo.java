/**
 * Exercise 29: Records Demo
 * Objective: Use Java records as immutable data carriers with Stream API.
 * Requires Java 16+
 * Compile: javac RecordsDemo.java
 * Run: java RecordsDemo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age, String city) {
    // Compact constructor with validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

    // Custom method
    public boolean isAdult() {
        return age >= 18;
    }
}

record Employee(String name, String department, double salary) {
    public String summary() {
        return name + " (" + department + ") - $" + String.format("%,.2f", salary);
    }
}

public class RecordsDemo {
    public static void main(String[] args) {
        System.out.println("=== Records Demo (Java 16+) ===\n");

        // Create persons using record constructor
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "London"));
        people.add(new Person("Charlie", 17, "Paris"));
        people.add(new Person("Diana", 35, "New York"));
        people.add(new Person("Eve", 22, "London"));
        people.add(new Person("Frank", 45, "Tokyo"));

        // Access record components
        System.out.println("--- Record Components ---");
        Person p = people.get(0);
        System.out.println("Name: " + p.name());
        System.out.println("Age: " + p.age());
        System.out.println("City: " + p.city());
        System.out.println("toString(): " + p);
        System.out.println("Is adult: " + p.isAdult());

        // Use with Streams
        System.out.println("\n--- Adults (using Streams) ---");
        people.stream()
                .filter(Person::isAdult)
                .forEach(person -> System.out.println("  " + person.name() + " (age " + person.age() + ")"));

        System.out.println("\n--- People from London ---");
        people.stream()
                .filter(person -> person.city().equals("London"))
                .forEach(person -> System.out.println("  " + person.name()));

        System.out.println("\n--- Average Age ---");
        double avgAge = people.stream()
                .mapToInt(Person::age)
                .average()
                .orElse(0);
        System.out.printf("Average age: %.1f%n", avgAge);

        System.out.println("\n--- Group by City ---");
        people.stream()
                .collect(Collectors.groupingBy(Person::city))
                .forEach((city, persons) -> {
                    System.out.println("  " + city + ":");
                    persons.forEach(person -> System.out.println("    - " + person.name()));
                });

        // Employee records
        System.out.println("\n--- Employee Records ---");
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 95000),
                new Employee("Bob", "Marketing", 72000),
                new Employee("Charlie", "Engineering", 105000),
                new Employee("Diana", "HR", 68000)
        );

        employees.stream()
                .filter(e -> e.department().equals("Engineering"))
                .sorted((e1, e2) -> Double.compare(e2.salary(), e1.salary()))
                .forEach(e -> System.out.println("  " + e.summary()));
    }
}

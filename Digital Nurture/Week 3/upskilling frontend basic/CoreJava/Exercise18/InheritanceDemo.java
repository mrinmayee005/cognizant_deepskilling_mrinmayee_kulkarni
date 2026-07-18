/**
 * Exercise 18: Inheritance Demo
 * Objective: Demonstrate inheritance with Animal base class and Dog subclass.
 * Compile: javac InheritanceDemo.java
 * Run: java InheritanceDemo
 */
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(name + " fetches the ball!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}

class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    public void purr() {
        System.out.println(name + " purrs contentedly...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor: " + isIndoor);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demo ===\n");

        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, true);

        System.out.println("--- Dog ---");
        dog.displayInfo();
        dog.makeSound();
        dog.fetch();

        System.out.println("\n--- Cat ---");
        cat.displayInfo();
        cat.makeSound();
        cat.purr();

        System.out.println("\n--- Polymorphism ---");
        Animal animal1 = dog;
        Animal animal2 = cat;

        animal1.makeSound();
        animal2.makeSound();
    }
}

/**
 * Exercise 17: Car Class
 * Objective: Create a Car class with properties and a display method.
 * Compile: javac CarClass.java
 * Run: java CarClass
 */
public class CarClass {

    private String make;
    private String model;
    private int year;

    public CarClass(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("  Make:  " + make);
        System.out.println("  Model: " + model);
        System.out.println("  Year:  " + year);
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }

    public static void main(String[] args) {
        System.out.println("=== Car Class Demo ===\n");

        CarClass car1 = new CarClass("Toyota", "Camry", 2023);
        CarClass car2 = new CarClass("Honda", "Civic", 2022);
        CarClass car3 = new CarClass("Ford", "Mustang", 2024);

        car1.displayDetails();
        System.out.println();
        car2.displayDetails();
        System.out.println();
        car3.displayDetails();

        System.out.println("\nUsing toString(): " + car1);

        System.out.println("\nUsing setters:");
        car1.setYear(2025);
        car1.setModel("Corolla");
        car1.displayDetails();
    }
}

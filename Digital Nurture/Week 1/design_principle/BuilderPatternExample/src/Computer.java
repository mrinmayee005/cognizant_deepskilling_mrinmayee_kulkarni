public class Computer {

    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String storage;
    private String OS;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.OS = builder.OS;
    }

    // Display method
    public void display() {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("OS: " + OS);
        System.out.println("---------------------");
    }

    // Static Builder Class
    public static class Builder {

        // Required
        private String CPU;
        private String RAM;

        // Optional
        private String storage;
        private String OS;

        // Constructor with required fields
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Setter methods for optional fields
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        // Build method
        public Computer build() {
            return new Computer(this);
        }
    }
}
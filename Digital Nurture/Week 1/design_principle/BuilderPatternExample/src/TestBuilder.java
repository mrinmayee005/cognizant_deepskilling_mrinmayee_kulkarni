public class TestBuilder {
    public static void main(String[] args) {

        // Computer 1
        Computer c1 = new Computer.Builder("i5", "8GB")
                .setStorage("512GB")
                .setOS("Windows")
                .build();

        // Computer 2 (different config)
        Computer c2 = new Computer.Builder("Ryzen 7", "16GB")
                .setStorage("1TB")
                .build();

        // Display
        c1.display();
        c2.display();
    }
}
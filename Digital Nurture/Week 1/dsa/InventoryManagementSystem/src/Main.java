public class Main {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        inv.addProduct(new Product(1, "Laptop", 10, 50000));
        inv.addProduct(new Product(2, "Mouse", 50, 500));

        inv.displayAll();

        System.out.println("---- Update ----");
        inv.updateProduct(1, 8, 48000);

        System.out.println("---- Delete ----");
        inv.deleteProduct(2);

        inv.displayAll();
    }
}
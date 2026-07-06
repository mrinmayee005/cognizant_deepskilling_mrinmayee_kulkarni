import java.util.HashMap;

public class Inventory {

    HashMap<Integer, Product> map = new HashMap<>();

    public void addProduct(Product p) {
        map.put(p.productId, p);
        System.out.println("Product Added");
    }

    public void updateProduct(int id, int quantity, double price) {
        if (map.containsKey(id)) {
            Product p = map.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void deleteProduct(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("Product Deleted");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void displayAll() {
        for (Product p : map.values()) {
            p.display();
        }
    }
}
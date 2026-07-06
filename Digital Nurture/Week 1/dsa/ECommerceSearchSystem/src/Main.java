public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Phone", "Electronics"),
                new Product(3, "Shoes", "Fashion"),
                new Product(4, "Watch", "Accessories"),
                new Product(5, "Bag", "Fashion")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product p1 = SearchFunctions.linearSearch(products, 3);
        if (p1 != null) p1.display();

        // Binary Search (array must be sorted)
        System.out.println("Binary Search:");
        Product p2 = SearchFunctions.binarySearch(products, 4);
        if (p2 != null) p2.display();
    }
}
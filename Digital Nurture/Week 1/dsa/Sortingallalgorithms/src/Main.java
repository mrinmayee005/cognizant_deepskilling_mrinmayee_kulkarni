public class Main {
    public static void main(String[] args) {

        Order[] orders = {
                new Order(1, "A", 5000),
                new Order(2, "B", 2000),
                new Order(3, "C", 8000),
                new Order(4, "D", 1000)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        Sorting.bubbleSort(orders);
        for (Order o : orders) {
            o.display();
        }

        System.out.println("-----------");

        // Quick Sort
        Order[] orders2 = {
                new Order(1, "A", 5000),
                new Order(2, "B", 2000),
                new Order(3, "C", 8000),
                new Order(4, "D", 1000)
        };

        System.out.println("Quick Sort:");
        Sorting.quickSort(orders2, 0, orders2.length - 1);
        for (Order o : orders2) {
            o.display();
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "C Programming", "Dennis"),
                new Book(2, "Data Structures", "Mark"),
                new Book(3, "Java Programming", "James"),
                new Book(4, "Python Basics", "Guido")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book b1 = SearchLibrary.linearSearch(books, "Java Programming");
        if (b1 != null) b1.display();

        // Binary Search (sorted by title)
        System.out.println("Binary Search:");
        Book b2 = SearchLibrary.binarySearch(books, "Python Basics");
        if (b2 != null) b2.display();
    }
}
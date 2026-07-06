public class TestSingleton {

    public static void main(String[] args) {

        // Get instance 1
        Logger obj1 = Logger.getInstance();
        obj1.log("First message");

        // Get instance 2
        Logger obj2 = Logger.getInstance();
        obj2.log("Second message");

        // Check if both objects are same
        if (obj1 == obj2) {
            System.out.println("Same instance");
        } else {
            System.out.println("Different instances");
        }
    }
}

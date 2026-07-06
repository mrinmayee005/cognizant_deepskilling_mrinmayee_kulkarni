public class TestProxy {
    public static void main(String[] args) {

        Image image = new ProxyImage("photo.jpg");

        // First time → loads from server
        image.display();

        System.out.println("---------------------");

        // Second time → no loading (cached)
        image.display();
    }
}
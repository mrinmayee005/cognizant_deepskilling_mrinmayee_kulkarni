public class ProxyImage implements Image {

    private RealImage realImage;
    private String fName;

    public ProxyImage(String fName) {
        this.fName = fName;
    }

    public void display() {

        // Lazy initialization
        if (realImage == null) {
            realImage = new RealImage(fName);
        }

        // Cached object reused
        realImage.display();
    }
}
public class RealImage implements Image {

    private String fName;

    public RealImage(String fileName) {
        this.fName = fileName;
        loadServer(); // heavy operation
    }

    private void loadServer() {
        System.out.println("Loading image coming from server: " + fName);
    }

    public void display() {
        System.out.println("Display image: " + fName);
    }
}
public class WebsiteClient implements Observer {

    private String name;

    public WebsiteClient(String name) {
        this.name = name;
    }

    public void update(double price) {
        System.out.println(name + " (Website) received price: " + price);
    }
}
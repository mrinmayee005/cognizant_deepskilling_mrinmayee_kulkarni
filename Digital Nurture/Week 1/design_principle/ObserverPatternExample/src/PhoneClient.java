public class PhoneClient implements Observer {

    private String name;

    public PhoneClient(String name) {
        this.name = name;
    }

    public void update(double price) {
        System.out.println(name + " (Phone) received price: " + price);
    }
}
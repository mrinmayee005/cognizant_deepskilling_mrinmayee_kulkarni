public class TestObserver {
    public static void main(String[] args) {

        StockMarket stock = new StockMarket();

        Observer user1 = new PhoneClient("User1");
        Observer user2 = new WebsiteClient("User2");

        stock.registObserver(user1);
        stock.registObserver(user2);

        // Change price
        stock.changePrice(1000);

        System.out.println("-----------");

        stock.changePrice(1200);
    }
}
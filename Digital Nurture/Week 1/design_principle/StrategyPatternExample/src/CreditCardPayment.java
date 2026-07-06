public class CreditCardPayment implements PaymentStrategy {

    private String cardNo;

    public CreditCardPayment(String cardNo) {
        this.cardNo = cardNo;
    }

    public void pay(double amount) {
        System.out.println("Amount Paid " + amount + " using Credit Card: " + cardNo);
    }
}
public class TestStrategy {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();


        context.setStrategy(new CreditCardPayment("8392-94382"));
        context.payAmount(1000);


        context.setStrategy(new PayPalPayment("mpk@gmail.com"));
        context.payAmount(2000);
    }
}
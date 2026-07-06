public class PaymentContext {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void payAmount(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected! Please select a payment strategy.");
            return;
        }
        strategy.pay(amount);
    }
}
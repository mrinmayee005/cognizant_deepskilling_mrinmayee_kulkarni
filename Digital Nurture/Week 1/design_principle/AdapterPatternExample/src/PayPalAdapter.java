public class PayPalAdapter implements PaymentProcessor {

    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public void Paymentprocess(double amount) {
        paypal.sendPaymentNow(amount); // adapting method
    }
}
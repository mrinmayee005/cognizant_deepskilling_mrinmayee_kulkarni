public class StripeAdapter implements PaymentProcessor {

    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void Paymentprocess(double amount) {
        stripe.makeChargeNow(amount);
    }
}
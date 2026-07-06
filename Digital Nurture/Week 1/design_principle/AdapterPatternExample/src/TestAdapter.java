public class TestAdapter {
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter(new PayPal());
        paypal.Paymentprocess(1000);

        PaymentProcessor stripe = new StripeAdapter(new Stripe());
        stripe.Paymentprocess(2000);

        PaymentProcessor razorpay = new RazorpayAdapter(new Razorpay());
        razorpay.Paymentprocess(3000);
    }
}
public class RazorpayAdapter implements PaymentProcessor {

    private Razorpay razorpay;

    public RazorpayAdapter(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    public void Paymentprocess(double amount) {
        razorpay.payRightNow(amount);
    }
}
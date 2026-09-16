package hotel.payment;

public class UpiPayment implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Processing UPI payment of " + amount);
    }
}

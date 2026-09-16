package hotel.payment;

public class CardPayment implements PaymentProcessor {
    @Override
    public void process(double amount) {
        System.out.println("Processing Card payment of " + amount);
    }
}

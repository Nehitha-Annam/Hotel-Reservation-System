package hotel.exceptions;

public class InvalidPaymentException extends HotelException {
    public InvalidPaymentException(String paymentMode) {
        super("Invalid Payment Mode: " + paymentMode);
    }
}

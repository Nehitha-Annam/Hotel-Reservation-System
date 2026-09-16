package hotel;

public class Booking {
    private Customer customer;
    private String hotelName;
    private String paymentMode;

    // Constructor
    public Booking(Customer customer, String hotelName, String paymentMode) {
        this.customer = customer;
        this.hotelName = hotelName;
        this.paymentMode = paymentMode;
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Hotel: " + hotelName);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Room: " + customer.getRoomNumber());
        System.out.println("Payment Mode: " + paymentMode);
    }
}

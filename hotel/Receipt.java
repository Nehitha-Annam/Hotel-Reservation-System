package hotel;

public class Receipt {
    public static void print(Customer customer, String hotelName, Room room, String paymentMode) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Hotel: " + hotelName);
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getType() + ")");
        System.out.println("Price: " + room.getPrice());
        System.out.println("Payment Mode: " + paymentMode);
        System.out.println("----------------");
    }
}

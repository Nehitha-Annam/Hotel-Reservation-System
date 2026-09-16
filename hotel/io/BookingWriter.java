package hotel.io;

import hotel.Booking;
import hotel.Feedback;

import java.io.FileWriter;
import java.io.IOException;

public class BookingWriter {

    public static void writeBooking(Booking booking) {
        try (FileWriter fw = new FileWriter("bookings.txt", true)) {
            fw.write(booking.getCustomer().getName() + " booked at " + booking.getHotelName() +
                    " Room: " + booking.getCustomer().getRoomNumber() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing booking: " + e.getMessage());
        }
    }

    public static void writeFeedback(Feedback fb) {
        try (FileWriter fw = new FileWriter("feedbacks.txt", true)) {
            fw.write(fb.getCustomerName() + ": " + fb.getComments() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing feedback: " + e.getMessage());
        }
    }
}

package hotel.admin;

import hotel.Booking;
import hotel.Feedback;
import hotel.Hotel;

import java.util.List;

public class AdminDashboard {

    // Show basic stats: number of bookings and hotels
    public static void showStats(int bookingCount, int hotelCount) {
        System.out.println("\n--- Admin Dashboard ---");
        System.out.println("Total Hotels: " + hotelCount);
        System.out.println("Total Bookings: " + bookingCount);
    }

    // Optional detailed views
    public static void showBookingDetails(List<Booking> bookings) {
        System.out.println("\n--- All Bookings ---");
        for (Booking b : bookings) {
            b.displayBookingDetails();
            System.out.println("---------------------");
        }
    }

    public static void showHotelRooms(List<Hotel> hotels) {
        System.out.println("\n--- Hotels & Rooms ---");
        for (Hotel h : hotels) {
            h.displayRooms();
        }
    }

    public static void showFeedbacks(List<Feedback> feedbacks) {
        System.out.println("\n--- Customer Feedbacks ---");
        for (Feedback f : feedbacks) {
            f.display();
        }
    }
}

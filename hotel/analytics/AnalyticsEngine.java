package hotel.analytics;

import hotel.Booking;
import hotel.Hotel;
import hotel.HotelManager;
import hotel.Room;

import java.util.List;

public class AnalyticsEngine {

    public static void generateReport(HotelManager manager) {
        System.out.println("\n--- Analytics Report ---");
        List<Hotel> hotels = manager.getHotels();
        List<Booking> bookings = manager.getBookings();

        System.out.println("Total Hotels: " + hotels.size());
        System.out.println("Total Bookings: " + bookings.size());

        for (Hotel h : hotels) {
            long bookedRooms = h.getRooms().stream().filter(r -> !r.isAvailable()).count();
            System.out.println(h.getName() + " - Booked Rooms: " + bookedRooms);
        }
    }

    public static void generateReportStatic(HotelManager manager) {
        generateReport(manager);
    }
}

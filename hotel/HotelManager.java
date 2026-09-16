package hotel;

import hotel.admin.AdminDashboard;
import hotel.complaint.ComplaintManager;
import hotel.exceptions.HotelException;
import hotel.io.BookingWriter;
import hotel.payment.*;
import hotel.util.Validator;
import hotel.analytics.AnalyticsEngine;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Core manager class for hotels, rooms, bookings, feedback, and complaints
 */
public class HotelManager {

    private final List<Hotel> hotels = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final List<Feedback> feedbacks = new ArrayList<>();
    private final ComplaintManager complaintManager = new ComplaintManager();

    public HotelManager() {
        initializeHotels();
    }

    // Initialize hotels with rooms and different costs
    private void initializeHotels() {
        hotels.add(new Hotel("OceanView", Arrays.asList(
                new Room(101, "Single", 1200),
                new Room(102, "Double", 1800),
                new Room(103, "Suite", 2500)
        )));
        hotels.add(new Hotel("MountainRetreat", Arrays.asList(
                new Room(201, "Single", 1300),
                new Room(202, "Double", 1900),
                new Room(203, "Suite", 2700)
        )));
        hotels.add(new Hotel("CityPalace", Arrays.asList(
                new Room(301, "Single", 1100),
                new Room(302, "Double", 1700),
                new Room(303, "Suite", 2400)
        )));
        hotels.add(new Hotel("GreenValley", Arrays.asList(
                new Room(401, "Single", 1250),
                new Room(402, "Double", 1850),
                new Room(403, "Suite", 2600)
        )));
        hotels.add(new Hotel("DesertInn", Arrays.asList(
                new Room(501, "Single", 1150),
                new Room(502, "Double", 1750),
                new Room(503, "Suite", 2450)
        )));
    }

    // Show all hotels
    public void showHotels() {
        System.out.println("\nAvailable Hotels:");
        hotels.forEach(h -> System.out.println("- " + h.getName()));
    }

    // Show rooms in a specific hotel
    public void showRooms(String hotelName) {
        Hotel hotel = getHotelByName(hotelName);
        if (hotel != null) {
            hotel.displayRooms();
        } else {
            System.out.println("Hotel not found.");
        }
    }

    // Book a room interactively
    public void bookRoomInteractive(Scanner sc) {
        try {
            System.out.print("Enter Hotel Name: ");
            String hotelName = sc.nextLine();
            Hotel hotel = getHotelByName(hotelName);
            if (hotel == null) {
                System.out.println("Hotel not found.");
                return;
            }

            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            System.out.print("Enter Room Type (Single/Double/Suite): ");
            String type = sc.nextLine();
            System.out.print("Enter Number of Persons: ");
            int persons = Validator.readInt(sc); // Fixed import
            System.out.print("Enter Payment Mode (UPI/Card): ");
            String paymentMode = sc.nextLine();

            Room room = hotel.getAvailableRoom(type);
            if (room == null) {
                System.out.println("No available rooms of type: " + type);
                return;
            }

            if ((type.equalsIgnoreCase("Single") && persons > 1) ||
                    (type.equalsIgnoreCase("Double") && persons > 2) ||
                    (type.equalsIgnoreCase("Suite") && persons > 4)) {
                System.out.println("Room type cannot accommodate " + persons + " persons.");
                return;
            }

            Customer customer = new Customer(name, phone, room.getRoomNumber(), persons);
            Booking booking = new Booking(customer, hotelName, paymentMode);
            bookings.add(booking);
            room.setAvailable(false);

            PaymentProcessor processor;
            if (paymentMode.equalsIgnoreCase("UPI")) {
                processor = new UpiPayment();
            } else if (paymentMode.equalsIgnoreCase("Card")) {
                processor = new CardPayment();
            } else {
                throw new HotelException("Invalid payment mode: " + paymentMode);
            }
            processor.process(room.getPrice());

            Receipt.print(customer, hotelName, room, paymentMode);
            BookingWriter.writeBooking(booking);

        } catch (HotelException e) { // Fixed multi-catch
            System.out.println("Booking Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    // Checkout a booking
    public void checkout(String phone) {
        Booking match = null;
        for (Booking b : bookings) {
            if (b.getCustomer().getPhone().equals(phone)) {
                match = b;
                break;
            }
        }

        if (match != null) {
            Hotel hotel = getHotelByName(match.getHotelName());
            Room room = hotel.getRoomByNumber(match.getCustomer().getRoomNumber());
            if (room != null) room.setAvailable(true);
            bookings.remove(match);

            Receipt.print(match.getCustomer(), match.getHotelName(), room, match.getPaymentMode());
            System.out.println("Checkout successful.");
        } else {
            System.out.println("No booking found for this phone number.");
        }
    }

    // View all bookings
    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            System.out.println("\nAll Bookings:");
            bookings.forEach(b -> {
                b.displayBookingDetails();
                System.out.println("--------------------------");
            });
        }
    }

    // Submit feedback
    public void submitFeedback(Scanner sc) {
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Feedback: ");
        String comments = sc.nextLine();

        Feedback fb = new Feedback(name, comments);
        feedbacks.add(fb);
        BookingWriter.writeFeedback(fb);
        System.out.println("Feedback submitted successfully!");
    }

    // View all feedback
    public void viewFeedbacks() {
        if (feedbacks.isEmpty()) {
            System.out.println("No feedback yet.");
        } else {
            System.out.println("\nCustomer Feedbacks:");
            feedbacks.forEach(Feedback::display);
        }
    }

    // Submit a complaint
    public void submitComplaint(String name, String complaint) {
        complaintManager.addComplaint(name, complaint);
    }

    // Optional: admin view of complaints
    public void viewComplaints() {
        complaintManager.viewComplaints();
    }

    // Show admin dashboard
    public void showAdminDashboard() {
        AdminDashboard.showStats(bookings.size(), hotels.size());
    }

    // Generate analytics report
    public void generateAnalyticsReport() {
        AnalyticsEngine.generateReportStatic(this);
    }

    // Getters
    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public ComplaintManager getComplaintManager() {
        return complaintManager;
    }

    // Helper method to get hotel by name
    private Hotel getHotelByName(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equalsIgnoreCase(name)) {
                return h;
            }
        }
        return null;
    }
}

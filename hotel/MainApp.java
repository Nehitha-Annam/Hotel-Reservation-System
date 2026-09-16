package hotel;

import hotel.analytics.AnalyticsEngine;
import hotel.threading.RoomCleanerThread;
import hotel.threading.WelcomeThread;
import hotel.util.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        // Welcome thread
        Thread welcome = new WelcomeThread();
        welcome.setPriority(Thread.NORM_PRIORITY);
        welcome.start();

        try {
            welcome.join();
        } catch (InterruptedException e) {
            System.out.println("Welcome thread interrupted.");
        }

        // Room cleaning thread
        Thread cleaner = new RoomCleanerThread();
        cleaner.setPriority(Thread.MIN_PRIORITY);
   

        Scanner sc = new Scanner(System.in);
        HotelManager manager = new HotelManager();

        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. View Hotels");
                System.out.println("2. View Rooms");
                System.out.println("3. Book Room");
                System.out.println("4. Checkout");
                System.out.println("5. View Bookings");
                System.out.println("6. Submit Feedback");
                System.out.println("7. View Feedback");
                System.out.println("8. Admin Dashboard");
                System.out.println("9. Analytics Report");
                System.out.println("10. Submit Complaint");
		System.out.println("11. Start Room Cleaning");
                System.out.println("12. Exit");
                System.out.print("Enter your choice: ");

                int choice = Validator.readInt(sc);
                switch (choice) {
                    case 1:
                        manager.showHotels();
                        break;
                    case 2:
                        System.out.print("Enter Hotel Name: ");
                        String hotelName = sc.nextLine();
                        manager.showRooms(hotelName);
                        break;
                    case 3:
                        manager.bookRoomInteractive(sc);
                        break;
                    case 4:
                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();
                        manager.checkout(phone);
                        break;
                    case 5:
                        manager.viewBookings();
                        break;
                    case 6:
                        manager.submitFeedback(sc);
                        break;
                    case 7:
                        manager.viewFeedbacks();
                        break;
                    case 8:
                        manager.showAdminDashboard();
                        break;
                    case 9:
                        AnalyticsEngine.generateReportStatic(manager);

                        break;
                    case 10:
                        System.out.print("Enter your name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter your complaint: ");
                        String complaint = sc.nextLine();
                        manager.submitComplaint(name, complaint);
                        break;
		    case 11:
    			cleaner.start();
    			break;

                    case 12:
                        System.out.println("Thank you for using the system!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter a number.");
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        sc.close();
    }
}

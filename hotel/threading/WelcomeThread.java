package hotel.threading;

public class WelcomeThread extends Thread {

    @Override
    public void run() {
        System.out.println("---- Welcome to the Hotel Reservation System ----");
    }
}

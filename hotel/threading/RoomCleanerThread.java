package hotel.threading;


public class RoomCleanerThread extends Thread {
    @Override
    public void run() {
        System.out.println("🧹 Room Cleaning Service Started...");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Cleaning room batch " + i + "...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Cleaning interrupted.");
            }
        }
        System.out.println("✅ All rooms cleaned!");
    }
}

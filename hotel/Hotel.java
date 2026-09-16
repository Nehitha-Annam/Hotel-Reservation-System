package hotel;

import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void displayRooms() {
        System.out.println("\nRooms in " + name + ":");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    public Room getAvailableRoom(String type) {
        for (Room r : rooms) {
            if (r.getType().equalsIgnoreCase(type) && r.isAvailable()) return r;
        }
        return null;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

package hotel;

public class Customer {
    private String name;
    private String phone;
    private int roomNumber;
    private int persons;

    public Customer(String name, String phone, int roomNumber, int persons) {
        this.name = name;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.persons = persons;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getRoomNumber() { return roomNumber; }
    public int getPersons() { return persons; }
}

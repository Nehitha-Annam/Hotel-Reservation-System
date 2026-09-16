package hotel;

public class Feedback {
    private String customerName;
    private String comments;

    public Feedback(String customerName, String comments) {
        this.customerName = customerName;
        this.comments = comments;
    }

    public void display() {
        System.out.println(customerName + " says: " + comments);
    }

    public String getCustomerName() { return customerName; }
    public String getComments() { return comments; }
}

package hotel.complaint;

import java.util.ArrayList;
import java.util.List;

public class ComplaintManager {
    private final List<String> complaints = new ArrayList<>();

    public void addComplaint(String name, String complaint) {
        complaints.add(name + ": " + complaint);
        System.out.println("Complaint submitted successfully!");
    }

    public void viewComplaints() {
        System.out.println("\n--- All Complaints ---");
        if (complaints.isEmpty()) {
            System.out.println("No complaints submitted yet.");
        } else {
            for (String c : complaints) {
                System.out.println(c);
            }
        }
    }
}

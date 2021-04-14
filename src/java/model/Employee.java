package model;

import java.util.ArrayList;

public class Employee extends User {
    private ArrayList<Availability> availability;

    public Employee(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        availability = new ArrayList<>();
    }

    public void addAvailability(Availability availability) {
        this.availability.add(availability);
    }

    public ArrayList<Availability> getAvailability() {
        return this.availability;
    }
}

package main.java.user;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Login login;
    private ArrayList<Availability> availability;

    User(String firstName, String lastName, String email, String phoneNumber, String password) throws SQLException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.login = Login.getInstance(email, password);
        availability = new ArrayList<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public Login getLogin() {
        return this.login;
    }

    public void setAvailability(Availability availability) {
        this.availability.add(availability);
    }

    public ArrayList<Availability> getAvailability() {
        return this.availability;
    }

}

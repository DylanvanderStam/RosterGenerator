package main.java.user;

import java.sql.SQLException;

public class Employee extends User {
    public Employee(String firstName, String lastName, String email, String phoneNumber, String password) throws SQLException {
        super(firstName, lastName, email, phoneNumber, password);
    }
}

package model;

import connection.ConnectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Employee extends User {
    private ArrayList<Availability> availability;

    public Employee(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password);
        availability = new ArrayList<>();
        try {
            getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addAvailability(Availability availability) {
        this.availability.add(availability);
    }

    public void getData() throws SQLException {
        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        String sql = "SELECT * FROM `availability` WHERE email = '" + this.getEmail() + "'";
        ResultSet rst;

        Statement statement = connection.createStatement();
        rst = statement.executeQuery(sql);

        while(rst.next()) {
            availability.add(new Availability(rst.getString(2), rst.getDouble(3), rst.getDouble(4)));
        }
    }

    public ArrayList<Availability> getAvailability() {
        return this.availability;
    }
}

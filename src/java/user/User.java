package user;

import connection.ConnectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private ArrayList<Availability> availability;

    User(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        availability = new ArrayList<>();

        try {
            getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
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
            addAvailability(new Availability(rst.getString(2), rst.getDouble(3), rst.getDouble(4)));
        }
    }

    public ArrayList<Availability> getAvailability() {
        return this.availability;
    }
}

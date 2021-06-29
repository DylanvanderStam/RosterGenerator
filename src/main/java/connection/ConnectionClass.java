package main.java.connection;

import javafx.scene.control.Label;
import main.java.user.Availability;
import main.java.user.Employee;
import main.java.user.User;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionClass {
    private static Connection connection;

    private ConnectionClass(Label label) {
        String dbName = "rostergenerator";
        String userName = "admin";
        String password = "test";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
        } catch (Exception e) {
            label.setText("No database connection");
        }

    }

    public static void createConnection(Label label) {
        new ConnectionClass(label);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void getAvailabilityFromDatabase(User user) throws SQLException {
        String sql = "SELECT * FROM `availability` WHERE email = '" + user.getEmail() + "'";
        Statement statement = connection.createStatement();
        ResultSet rst = statement.executeQuery(sql);

        while(rst.next()) {
            user.setAvailability(new Availability(rst.getString(2), rst.getDouble(3), rst.getDouble(4)));
        }
    }

    public static ArrayList<User> getUsersFromDatabase() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM `employee`";
        Statement statement = connection.createStatement();
        ResultSet rst = statement.executeQuery(sql);

        while(rst.next()) {
            users.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }

        return users;
    }
}

package company;

import connection.ConnectionClass;
import user.Employee;
import user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<User> users;

    public Company(String companyName) {
        this.companyName = companyName;
        this.users = new ArrayList<>();

        try {
            this.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void newUser() {
        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO `employee`(`firstName`, `lastName`, `email`, `phoneNumber`, `password`) VALUES ('Dylan', 'van der Stam', 'test', '0612345678', 'test123')";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getData() throws SQLException {
        ConnectionClass connectionclass = new ConnectionClass();
        Connection connection = connectionclass.getConnection();

        String sql = "SELECT * FROM `employee`";
        ResultSet rst;

        Statement statement = connection.createStatement();
        rst = statement.executeQuery(sql);

        while(rst.next()) {
            users.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
    }

    public ArrayList<User> getEmployees() {
        return users;
    }
}

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
    private ConnectionClass connection;

    public Company(String companyName) {
        this.companyName = companyName;
        this.users = new ArrayList<>();
        this.connection = new ConnectionClass();

        try {
            this.getData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getData() throws SQLException {
        Connection conn = connection.getConnection();

        String sql = "SELECT * FROM `employee`";
        ResultSet rst;

        Statement statement = conn.createStatement();
        rst = statement.executeQuery(sql);

        while(rst.next()) {
            users.add(new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

package main.java.company;

import main.java.connection.ConnectionClass;
import main.java.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<User> users;

    public Company(String companyName) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ConnectionClass.createConnection();
        this.companyName = companyName;
        this.users = ConnectionClass.getUsersFromDatabase();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

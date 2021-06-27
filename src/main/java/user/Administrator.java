package user;

import java.sql.SQLException;

public class Administrator extends User {
    public Administrator(String firstName, String lastName, String email, String phoneNumber, String password) throws SQLException {
        super(firstName, lastName, email, phoneNumber, password);
    }
}

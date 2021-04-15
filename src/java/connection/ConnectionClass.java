package connection;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection() {
            String dbName = "rostergenerator";
            String userName = "admin";
            String password = "test";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
    }
}

package user;

import connection.ConnectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    private static Login single_instance = null;

    private Login() {
    }

    public static Login getInstance(String username, String password) throws SQLException {
        if(single_instance == null) {
            ConnectionClass connectionclass = new ConnectionClass();
            Connection connection = connectionclass.getConnection();

            String sql = "SELECT * FROM `employee`";
            ResultSet rst;

            Statement statement = connection.createStatement();
            rst = statement.executeQuery(sql);

            while(rst.next()) {
                if(username.equals(rst.getString(3)) && password.equals(rst.getString(5))){
                    return new Login();
                }
            }
        }
        return null;
    }
}

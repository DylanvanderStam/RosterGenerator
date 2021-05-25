package controller;

import connection.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountController {
    private Employee activeUser;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button back;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private Text activeUserText;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField passwordField2;

    @FXML
    private Button passwordButton;

    @FXML
    private Button saveButton;

    @FXML
    private Text breadCrumb;

    public void initData(Employee user) {
        activeUser = user;
        activeUserText.setText("Change account details for " + activeUser.getName());
    }

    @FXML
    void save(ActionEvent event) throws IOException {

    }

    @FXML
    void change(ActionEvent event) throws SQLException {
        if(checkPassword(passwordField.getText(), passwordField2.getText())) {
            ConnectionClass connectionclass = new ConnectionClass();
            Connection connection = connectionclass.getConnection();

            String sql = "UPDATE `employee` SET `password`= '" + passwordField.getText() + "' WHERE `email` = '" + activeUser.getEmail() + "'";

            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
    }

    public static boolean checkPassword(String password1, String password2) {
        return password1.matches(".*\\d.*") && !password1.contains(" ") && password1.equals(password2);
    }


    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane root = loader.load();

        DashboardController dashboardController = loader.getController();
        dashboardController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

}

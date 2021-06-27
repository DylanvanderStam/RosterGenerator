package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.connection.ConnectionClass;
import main.java.notification.Notification;
import main.java.notification.PasswordError;
import main.java.notification.PasswordSucces;
import main.java.user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountController {
    private User activeUser;

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

    @FXML
    private Label notification;

    public void initData(User user) {
        activeUser = user;
        activeUserText.setText("Change account details for " + activeUser.getName());
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        //To be implemented
    }

    @FXML
    void change(ActionEvent event) throws SQLException {
        Notification not;
        if(checkPassword(passwordField.getText(), passwordField2.getText())) {
            String sql = "UPDATE `employee` SET `password`= '" + passwordField.getText() + "' WHERE `email` = '" + activeUser.getEmail() + "'";

            Statement statement = ConnectionClass.getConnection().createStatement();
            statement.execute(sql);

            notification.setTextFill(Color.GREEN);
            not = new PasswordSucces();
            not.playNotification(notification);
        } else {
            notification.setTextFill(Color.RED);
            not = new PasswordError();
            not.playNotification(notification);
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

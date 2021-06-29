package main.java.controller;

import main.java.company.Company;
import main.java.connection.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.notification.LoginError;
import main.java.notification.LoginSucces;
import main.java.notification.Notification;
import main.java.user.Login;
import main.java.user.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    ArrayList<User> users;
    private User activeUser;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;

    @FXML
    private Label notification;

    @FXML
    private Label databasemessage;

    @FXML
    void login(ActionEvent event) throws IOException, SQLException {
        if (Login.getInstance(email.getText(), password.getText()) != null) {
            Notification not = new LoginSucces();
            not.playNotification(notification);

            for(User temp : users) {
                if(temp.getEmail().equals(email.getText()) && temp.getPassword().equals(password.getText())) {
                    activeUser = temp;
                    ConnectionClass.getAvailabilityFromDatabase(activeUser);
                }
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
            AnchorPane root = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.initData(activeUser);

            rootPane.getChildren().setAll(root);
        } else {
            Notification not = new LoginError();
            not.playNotification(notification);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ConnectionClass.createConnection(databasemessage);
            Company antes = new Company("Antes");
            users = antes.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

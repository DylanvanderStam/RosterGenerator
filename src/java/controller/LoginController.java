package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import company.Company;
import user.Login;
import user.User;
import notification.LoginError;
import notification.LoginSucces;
import notification.Notification;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    ArrayList<User> employees;
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
    void login(ActionEvent event) throws IOException {
        Login login = Login.getInstance(email.getText(), password.getText(), employees);
        if(login != null) {
            Notification not = new LoginSucces();
            not.notification(notification);

            activeUser = login.getActiveUser();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
            AnchorPane root = loader.load();

            DashboardController dashboardController = loader.getController();
            dashboardController.initData(activeUser);

            rootPane.getChildren().setAll(root);
        } else {
            Notification not = new LoginError();
            not.notification(notification);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Company antes = new Company("Antes");
        employees = antes.getEmployees();
    }
}

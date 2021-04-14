package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Company;
import model.Employee;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    ArrayList<Employee> employees;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) throws IOException {
        for(Employee temp : employees) {
            if (temp.getEmail().equals(email.getText()) && temp.getPassword().equals(password.getText())) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
                AnchorPane root = loader.load();

                DashboardController dashboardController = loader.getController();
                dashboardController.initData(temp);

                rootPane.getChildren().setAll(root);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Company antes  = new Company("Antes");
        employees = antes.getEmployees();
    }
}

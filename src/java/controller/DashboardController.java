package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    private Employee activeUser;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Text activeUserLabel;

    @FXML
    private Text breadCrumb;

    @FXML
    private Text updateTextLabel;

    @FXML
    private Button availability;

    @FXML
    private Button generateRoster;

    @FXML
    private Button account;

    @FXML
    private Button signOut;

    @FXML
    private AnchorPane pane;

    public void initData(Employee user) {
        activeUser = user;
        activeUserLabel.setText("Welcome " + activeUser.getFirstName());
    }

    public void setUpdateText(String updateText) {
        updateTextLabel.setText(updateText);
    }

    @FXML
    void account(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Account.fxml"));
        AnchorPane root = loader.load();

        AccountController accountController = loader.getController();
        accountController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    @FXML
    void availability(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Availability.fxml"));
        AnchorPane root = loader.load();

        AvailabilityController availabilityController = loader.getController();
        availabilityController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    @FXML
    void generateRoster(ActionEvent event) {

    }

    @FXML
    void signOut(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        rootPane.getChildren().setAll(root);
    }

    @FXML
    void setActiveUser() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        breadCrumb.setText("Dashboard");
    }
}

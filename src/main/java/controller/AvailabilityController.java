package main.java.controller;

import main.java.connection.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import main.java.user.Employee;
import main.java.user.User;
import util.Util;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AvailabilityController implements Initializable {
    private User activeUser;
    private String selectedDate1;
    private String selectedDate2;
    private String selectedDate3;
    private String selectedDate4;
    private String selectedDate5;
    private String selectedDate6;
    private String selectedDate7;
    private static String date1Check;
    private static String date2Check;
    private static String date3Check;
    private static String dateFormat = "dd/MM/yyyy";

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Text breadCrumb;

    @FXML
    private Button back;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Text date1;

    @FXML
    private Text date2;

    @FXML
    private Text date3;

    @FXML
    private Text date4;

    @FXML
    private Text date5;

    @FXML
    private Text date6;

    @FXML
    private Text date7;

    @FXML
    private TextField bt1;

    @FXML
    private TextField et1;

    @FXML
    private TextField bt2;

    @FXML
    private TextField et2;

    @FXML
    private TextField bt3;

    @FXML
    private TextField et3;

    @FXML
    private TextField bt4;

    @FXML
    private TextField et4;

    @FXML
    private TextField bt5;

    @FXML
    private TextField et5;

    @FXML
    private TextField bt6;

    @FXML
    private TextField et6;

    @FXML
    private TextField bt7;

    @FXML
    private TextField et7;

    @FXML
    private Button getAvailability;

    @FXML
    private Button save;

    @FXML
    private Button select;

    public void initData(User user) {
        activeUser = user;
    }

    @FXML
    void getAvailability(ActionEvent event) {
        //To be implemented
    }

    @FXML
    void select(ActionEvent event) throws SQLException {
        LocalDate date = datePicker.getValue();

        String sql = "SELECT `date` FROM `availability` WHERE `email` = '" + activeUser.getEmail() + "' AND  `date` = '" + date.format(DateTimeFormatter.ofPattern(dateFormat)) + "'";
        ResultSet rst;

        Statement statement = ConnectionClass.getConnection().createStatement();
        rst = statement.executeQuery(sql);

        if(!rst.next()) {
            showFields();

            int i = 1;
            while (i < 8) {
                String finaldate = date.format(DateTimeFormatter.ofPattern(dateFormat));
                if (i == 1) {
                    date1.setText(finaldate);
                    selectedDate1 = finaldate;
                } else if (i == 2) {
                    date2.setText(finaldate);
                    selectedDate2 = finaldate;
                } else if (i == 3) {
                    date3.setText(finaldate);
                    selectedDate3 = finaldate;
                } else if (i == 4) {
                    date4.setText(finaldate);
                    selectedDate4 = finaldate;
                } else if (i == 5) {
                    date5.setText(finaldate);
                    selectedDate5 = finaldate;
                } else if (i == 6) {
                    date6.setText(finaldate);
                    selectedDate6 = finaldate;
                } else {
                    date7.setText(finaldate);
                    selectedDate7 = finaldate;
                }
                date = date.plusDays(1);
                i++;
            }
        } else {
            updateScreen();
        }
    }

    @FXML
    void save(ActionEvent event) throws IOException, SQLException {
        ArrayList<String> beginButton = new ArrayList<>();
        ArrayList<String> endButton = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();

        dates.add(selectedDate1);
        dates.add(selectedDate2);
        dates.add(selectedDate3);
        dates.add(selectedDate4);
        dates.add(selectedDate5);
        dates.add(selectedDate6);
        dates.add(selectedDate7);

        beginButton.add(bt1.getText());
        beginButton.add(bt2.getText());
        beginButton.add(bt3.getText());
        beginButton.add(bt4.getText());
        beginButton.add(bt5.getText());
        beginButton.add(bt6.getText());
        beginButton.add(bt7.getText());

        endButton.add(et1.getText());
        endButton.add(et2.getText());
        endButton.add(et3.getText());
        endButton.add(et4.getText());
        endButton.add(et5.getText());
        endButton.add(et6.getText());
        endButton.add(et7.getText());

        Statement statement = ConnectionClass.getConnection().createStatement();
        String sqlInsert = "INSERT INTO `availability`(`email`, `date`, `beginTime`, `endTime`) VALUES ('";

        int i = 0;

        for(String date : dates) {
            String sql = sqlInsert + activeUser.getEmail() + "','" + date + "','" + Util.parseDouble(beginButton).get(i) + "','" + Util.parseDouble(endButton).get(i) + "')";
            i++;
            statement.execute(sql);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane root = loader.load();

        DashboardController dashboardController = loader.getController();
        dashboardController.setUpdateText("Availability has been added.");
        dashboardController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    public static boolean checkAvailability(LocalDate date, Double beginTime, Double endTime, Boolean filledIN, Employee email) throws SQLException {
        String sql = "SELECT `date` FROM `availability` WHERE `email` = '" + email.getEmail() + "' AND  `date` = '" + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "'";
        ResultSet rst;

        Statement statement = ConnectionClass.getConnection().createStatement();
        rst = statement.executeQuery(sql);

        String finaldate = null;

        if(!rst.next()) {
            int i = 1;
            while (i < 4) {
                finaldate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if (i == 1) {
                    date1Check = finaldate;
                } else if (i == 2) {
                    date2Check = finaldate;
                } else if (i == 3) {
                    date3Check = finaldate;
                }
                date = date.plusDays(1);
                i++;
            }
        }
        return (date1Check.equals(finaldate) || date2Check.equals(finaldate) || date3Check.equals(finaldate))  && !filledIN && endTime - beginTime == 9.0;
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane root = loader.load();

        DashboardController dashboardController = loader.getController();
        dashboardController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    public void updateScreen() {
        date1.setText("This date has already been filled in!");
        hideFields();
    }

    public void hideFields() {
        date2.setVisible(false);
        date3.setVisible(false);
        date4.setVisible(false);
        date5.setVisible(false);
        date6.setVisible(false);
        date7.setVisible(false);
        bt1.setVisible(false);
        bt2.setVisible(false);
        bt3.setVisible(false);
        bt4.setVisible(false);
        bt5.setVisible(false);
        bt6.setVisible(false);
        bt7.setVisible(false);
        et1.setVisible(false);
        et2.setVisible(false);
        et3.setVisible(false);
        et4.setVisible(false);
        et5.setVisible(false);
        et6.setVisible(false);
        et7.setVisible(false);
    }

    public void showFields() {
        date1.setVisible(true);
        date2.setVisible(true);
        date3.setVisible(true);
        date4.setVisible(true);
        date5.setVisible(true);
        date6.setVisible(true);
        date7.setVisible(true);
        bt1.setVisible(true);
        bt2.setVisible(true);
        bt3.setVisible(true);
        bt4.setVisible(true);
        bt5.setVisible(true);
        bt6.setVisible(true);
        bt7.setVisible(true);
        et1.setVisible(true);
        et2.setVisible(true);
        et3.setVisible(true);
        et4.setVisible(true);
        et5.setVisible(true);
        et6.setVisible(true);
        et7.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        breadCrumb.setText("Availability");
        hideFields();
    }
}

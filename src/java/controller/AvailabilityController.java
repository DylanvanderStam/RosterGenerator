package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Availability;
import model.Employee;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AvailabilityController implements Initializable {
    private Employee activeUser;
    private String selectedDate1;
    private String selectedDate2;
    private String selectedDate3;
    private String selectedDate4;
    private String selectedDate5;
    private String selectedDate6;
    private String selectedDate7;
    private Double beginTime1;
    private Double beginTime2;
    private Double beginTime3;
    private Double beginTime4;
    private Double beginTime5;
    private Double beginTime6;
    private Double beginTime7;
    private Double endTime1;
    private Double endTime2;
    private Double endTime3;
    private Double endTime4;
    private Double endTime5;
    private Double endTime6;
    private Double endTime7;

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

    public void initData(Employee user) {
        activeUser = user;
    }

    @FXML
    void getAvailability(ActionEvent event) {
        for(Availability temp : activeUser.getAvailability()) {
            System.out.println(temp.getDate() + " " + temp.getBeginTime() + " " + temp.getEndTime());
        }
    }

    @FXML
    void select(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        int i = 1;
        while(i < 8) {
            String finaldate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if(i == 1) {
                date1.setText(finaldate);
                selectedDate1 = finaldate;
            } else if(i == 2) {
                date2.setText(finaldate);
                selectedDate2 = finaldate;
            } else if(i == 3) {
                date3.setText(finaldate);
                selectedDate3 = finaldate;
            } else if(i == 4) {
                date4.setText(finaldate);
                selectedDate4 = finaldate;
            } else if(i == 5) {
                date5.setText(finaldate);
                selectedDate5 = finaldate;
            } else if(i == 6) {
                date6.setText(finaldate);
                selectedDate6 = finaldate;
            } else {
                date7.setText(finaldate);
                selectedDate7 = finaldate;
            }
            date = date.plusDays(1);
            i++;
        }
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        if(bt1.getText().contains(":30")) {
            beginTime1 = Double.parseDouble(bt1.getText().substring(0, 2) + ".5");
        } else {
            beginTime1 = Double.parseDouble(bt1.getText().substring(0, 2));
        }

        if(bt2.getText().contains(":30")) {
            beginTime2 = Double.parseDouble(bt2.getText().substring(0, 2) + ".5");
        } else {
            beginTime2 = Double.parseDouble(bt2.getText().substring(0, 2));
        }

        if(bt3.getText().contains(":30")) {
            beginTime3 = Double.parseDouble(bt3.getText().substring(0, 2) + ".5");
        } else {
            beginTime3 = Double.parseDouble(bt3.getText().substring(0, 2));
        }

        if(bt4.getText().contains(":30")) {
            beginTime4 = Double.parseDouble(bt4.getText().substring(0, 2) + ".5");
        } else {
            beginTime4 = Double.parseDouble(bt4.getText().substring(0, 2));
        }

        if(bt5.getText().contains(":30")) {
            beginTime5 = Double.parseDouble(bt5.getText().substring(0, 2) + ".5");
        } else {
            beginTime5 = Double.parseDouble(bt5.getText().substring(0, 2));
        }

        if(bt6.getText().contains(":30")) {
            beginTime6 = Double.parseDouble(bt6.getText().substring(0, 2) + ".5");
        } else {
            beginTime6 = Double.parseDouble(bt6.getText().substring(0, 2));
        }

        if(bt7.getText().contains(":30")) {
            beginTime7 = Double.parseDouble(bt7.getText().substring(0, 2) + ".5");
        } else {
            beginTime7 = Double.parseDouble(bt7.getText().substring(0, 2));
        }

        //End time
        if(et1.getText().contains(":30")) {
            endTime1 = Double.parseDouble(et1.getText().substring(0, 2) + ".5");
        } else {
            endTime1 = Double.parseDouble(et1.getText().substring(0, 2));
        }

        if(et2.getText().contains(":30")) {
            endTime2 = Double.parseDouble(et2.getText().substring(0, 2) + ".5");
        } else {
            endTime2 = Double.parseDouble(et2.getText().substring(0, 2));
        }

        if(et3.getText().contains(":30")) {
            endTime3 = Double.parseDouble(et3.getText().substring(0, 2) + ".5");
        } else {
            endTime3 = Double.parseDouble(et3.getText().substring(0, 2));
        }

        if(et4.getText().contains(":30")) {
            endTime4 = Double.parseDouble(et4.getText().substring(0, 2) + ".5");
        } else {
            endTime4 = Double.parseDouble(et4.getText().substring(0, 2));
        }

        if(et5.getText().contains(":30")) {
            endTime5 = Double.parseDouble(et5.getText().substring(0, 2) + ".5");
        } else {
            endTime5 = Double.parseDouble(et5.getText().substring(0, 2));
        }

        if(et6.getText().contains(":30")) {
            endTime6 = Double.parseDouble(et6.getText().substring(0, 2) + ".5");
        } else {
            endTime6 = Double.parseDouble(et6.getText().substring(0, 2));
        }

        if(et7.getText().contains(":30")) {
            endTime7 = Double.parseDouble(et7.getText().substring(0, 2) + ".5");
        } else {
            endTime7 = Double.parseDouble(et7.getText().substring(0, 2));
        }

        activeUser.addAvailability(new Availability(selectedDate1, beginTime1, endTime1));
        activeUser.addAvailability(new Availability(selectedDate2, beginTime2, endTime2));
        activeUser.addAvailability(new Availability(selectedDate3, beginTime3, endTime3));
        activeUser.addAvailability(new Availability(selectedDate4, beginTime4, endTime4));
        activeUser.addAvailability(new Availability(selectedDate5, beginTime5, endTime5));
        activeUser.addAvailability(new Availability(selectedDate6, beginTime6, endTime6));
        activeUser.addAvailability(new Availability(selectedDate7, beginTime7, endTime7));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane root = loader.load();

        DashboardController dashboardController = loader.getController();
        dashboardController.setUpdateText("Availability has been added.");
        dashboardController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
        AnchorPane root = loader.load();

        DashboardController dashboardController = loader.getController();
        dashboardController.initData(activeUser);

        rootPane.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        breadCrumb.setText("Availability");
    }
}

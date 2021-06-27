package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Util;

public class GUIStarter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        String style = "-fx-background-color: #" + Util.darkMode() + ";";
        root.setStyle(style);

        stage.setScene(new Scene(root));
        stage.setTitle("Roster Generator");
        stage.show();
    }

}

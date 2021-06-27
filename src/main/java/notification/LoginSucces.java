package main.java.notification;

import javafx.scene.control.Label;

public class LoginSucces extends Notification {
    @Override
    protected String getNotification() {
        return null;
    }

    protected void playSound() {
        super.playSound("/sound/loginsucces.wav");
    }

    @Override
    protected void playAnimation(Label label) {
    }
}

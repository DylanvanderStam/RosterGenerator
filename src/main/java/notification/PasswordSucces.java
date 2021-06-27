package main.java.notification;

import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PasswordSucces extends Notification{
    @Override
    protected String getNotification() {
        return "Password has been changed!";
    }

    @Override
    protected void playAnimation(Label label) {
        Duration duration = Duration.millis(2500);
        RotateTransition rotateTransition = new RotateTransition(duration, label);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }
}

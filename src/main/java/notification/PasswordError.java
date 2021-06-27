package main.java.notification;

import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PasswordError extends Notification{
    @Override
    protected String getNotification() {
        return "Passwords contain illegal characters or don't match, please try again.";
    }

    @Override
    protected void playAnimation(Label label) {
        Duration duration = Duration.millis(2500);
        RotateTransition rotateTransition = new RotateTransition(duration, label);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }
}

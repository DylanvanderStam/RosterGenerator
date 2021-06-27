package notification;

import javafx.scene.control.Label;

public class LoginError extends Notification{
    @Override
    protected String getNotification() {
        return "The provided credentials are not correct.";
    }

    protected void playSound() {
        super.playSound("src/main/resources/loginerror.wav");
    }

    @Override
    protected void playAnimation(Label label) {
    }
}

package notification;

import javafx.scene.control.Label;

public abstract class Notification {
    public final void notification(Label label) {
        label.setText(this.getNotification());
        this.playSound();
        this.playAnimation(label);
    }

    public String getNotification() {
        return null;
    }

    public void playSound() {
    }

    public void playAnimation(Label label) {
    }
}

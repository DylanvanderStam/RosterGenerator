package notification;

import javafx.scene.control.Label;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public abstract class Notification {
    public final void playNotification(Label label) {
        label.setText(this.getNotification());
        this.playSound();
        this.playAnimation(label);
    }

    protected abstract String getNotification();

    protected void playSound() {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File("src/resources/notification.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected abstract void playAnimation(Label label);
}

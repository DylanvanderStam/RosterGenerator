package notification;

import javafx.scene.control.Label;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class LoginSucces extends Notification{
    @Override
    protected String getNotification() {
        return null;
    }

    @Override
    protected void playSound() {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File("src/resources/loginsucces.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void playAnimation(Label label) {
    }
}

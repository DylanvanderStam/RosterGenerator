package notification;

import javafx.scene.control.Label;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class LoginSucces extends Notification{
    @Override
    public String getNotification() {
        return null;
    }

    @Override
    public void playSound() {
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
    public void playAnimation(Label label) {
    }
}

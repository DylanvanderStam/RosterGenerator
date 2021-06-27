package main.java.notification;

import javafx.scene.control.Label;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public abstract class Notification {
    public final void playNotification(Label label) {
        label.setText(this.getNotification());
        this.playSound();
        this.playAnimation(label);
    }

    protected abstract String getNotification();

    protected void playSound() {
        playSound("/sound/notification.wav");
    }

    protected void playSound(String sound) {
        URL defaultSound = getClass().getResource(sound);
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(defaultSound);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected abstract void playAnimation(Label label);
}

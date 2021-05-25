package util;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static Paint checkTime() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime time = LocalTime.parse(date);
        int seconds = time.toSecondOfDay();

        if(darkMode(seconds)){
            return Color.GRAY;
        }
        return Color.WHITE;
    }

    public static boolean darkMode(Integer time) {
        return time < 43200 || time > 86400;
    }
}

package util;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {
    private Util() {

    }

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

    public static ArrayList<Double> parseDouble(ArrayList<String> value) {
        ArrayList<Double> times = new ArrayList<>();
        Double time;
        for(String temp : value) {
            if(temp.contains(":30")) {
                time = Double.parseDouble(temp.substring(0, 2) + ".5");
            } else {
                time = Double.parseDouble(temp.substring(0, 2));
            }
            times.add(time);
        }
        return times;
    }
}

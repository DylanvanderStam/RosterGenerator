package main.java.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {
    private Util() {

    }

    public static String darkMode() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime time = LocalTime.parse(date);
        int seconds = time.toSecondOfDay();

        if(checkTime(seconds)){
            return "a1a1a1";
        }
        return "ffffff";
    }

    public static boolean checkTime(Integer time) {
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

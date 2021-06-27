package main.java.user;

public class Availability {
    private String date;
    private Double beginTime;
    private Double endTime;

    public Availability(String date, Double beginTime, Double endTime) {
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getDate() {
        return this.date;
    }

    public Double getBeginTime() {
        return this.beginTime;
    }

    public Double getEndTime() {
        return this.endTime;
    }
}

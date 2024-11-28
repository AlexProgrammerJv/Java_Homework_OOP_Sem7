package Model.Event;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

    private final String date;
    private final String time;
    private final String activity;
    private final Date localDate;

    public Event(String date, String time, String activity) {
        this.date = date;
        this.time = time;
        this.activity = activity;
        this.localDate = new Date(this.date+" "+this.time);
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return "Event -> [" +
                "Date: '" + date + '\'' +
                ", Time: '" + time + '\'' +
                ", Activity: '" + activity + '\'' +
                ']';
    }
}

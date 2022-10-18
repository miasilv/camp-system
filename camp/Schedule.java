package camp;

import java.util.HashMap;

public class Schedule {
    private HashMap<String, Activity> schedule;

    public Schedule(){
        schedule = new HashMap<String, Activity>();
    }
    public Schedule getSchedule(){
        return this.schedule;
    }
    public void editSchedule(int index, Activity activity){

    }
    public String toString(){
        return "";
    }
}

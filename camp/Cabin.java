package camp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Cabin {
    private UUID cabinID;
    private ArrayList<Camper> campers;
    private Counselor counselor;
    private HashMap<Day, Schedule> schedule;

    public Cabin(){

        cabinID = new UUID(0, 0);
        campers = new ArrayList<Camper>();
        counselor = new Counselor();
        schedule = new HashMap<Day, Schedule>();
    }
    public void addCounselor(Counselor counselor){

    }
    public void addCamper(Camper camper){

    }
    public void removeCamper(Camper camper){

    }
    public void editCamper(int index, Camper camper){

    }
    public Schedule getSchedule(Day day){
        return schedule;
    }
    public Counselor getCounselor(){
        return counselor;
    }
    public ArrayList<Camper> getCampers(){
        return campers;
    }
    private boolean hasCounselor(){
        return true;
    }
    private boolean isFull(){
        return true;
    }
}

package camp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
/**
 * an object representing a cabin
 * @author sara
 */
public class Cabin {
    private UUID cabinID;
    private ArrayList<Camper> campers;
    private Counselor counselor;
    private HashMap<Day, Schedule> schedule;
    /**
     * constructor of cabin
     */
    public Cabin(){

        cabinID = new UUID(0, 0);
        campers = new ArrayList<Camper>();
        schedule = new HashMap<Day, Schedule>();
    }
    /**
     * method to add a counselor to the cabin
     * @param counselor the counselor being added
     */
    public void addCounselor(Counselor counselor){
        this.counselor = counselor;
    }
    /**
     * method to add a camper to cabin
     * @param camper the camper being added
     */
    public void addCamper(Camper camper){
        campers.add(camper);
    }
    /**
     * method to remove a camper from cabin
     * @param camper the camper being removed
     */
    public void removeCamper(Camper camper){
        campers.remove(camper);
    }
    /**
     * method to get a camper
     * @param index the index of the camper to be retrieved
     * @return the camper
     */
    public Camper getCamper(int index){
        return campers.get(index);
    }
    /**
     * a method to get the schedule of the cabin on a specific day
     * @param day the day of the schedule being grabbed
     * @return the schedule for that day
     */
    public Schedule getSchedule(Day day){
        return schedule.get(day);
    }
    /**
     * getter of the counselor
     * @return the counselor
     */
    public Counselor getCounselor(){
        return counselor;
    }
    /**
     * getter of the campers
     * @return the list of campers
     */
    public ArrayList<Camper> getCampers(){
        return campers;
    }
    /**
     * method to determine whether the cabin has a counselor
     * @return whether the cabin has a counselor
     */
    private boolean hasCounselor(){
        if(counselor != null){
            return true;
        }
        return false;
    }
    /**
     * method checking whether the cabin is full
     * @return if the cabin is full or not
     */
    private boolean isFull(){
        if(counselor != null && campers.size() == 8)
            return true;
        return false;
    }
}

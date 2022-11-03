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
    private ArrayList<Counselor> counselors;
    private HashMap<Day, Schedule> schedule;
    private double maxAge;
    private double minAge;
    private ArrayList<String> daysStr;
    private ArrayList<Day> days;
    
    /**
     * constructor of cabin
     */
    public Cabin(int minAge, int maxAge){
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.cabinID = UUID.randomUUID();
        campers = new ArrayList<Camper>();
        counselors = new ArrayList<Counselor>();
        this.daysStr = constructDaysStr();
        this.days = constructDays();
        
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        for(int i = 0; i < days.size(); i++) {
            schedules.add(new Schedule());
        }
        this.schedule = createHash(schedules, days);
    }

    //overloaded constructor for dataloader
    public Cabin(ArrayList<Camper> campers, ArrayList<Counselor> counselors, double maxAge, double minAge, ArrayList<Schedule> schedules, UUID id){
        this.campers = campers;
        this.counselors = counselors;

        this.maxAge= maxAge;
        this.minAge = minAge; 
        this.cabinID = id;
        this.daysStr = constructDaysStr();
        this.days = constructDays();
        this.schedule = createHash(schedules, days);
       
    }

    
    private ArrayList<Day> constructDays() {
        ArrayList<Day> days = new ArrayList<Day>();
        days.add(Day.MONDAY);
        days.add(Day.TUESDAY);
        days.add(Day.WEDNESDAY);
        days.add(Day.THURSDAY);
        days.add(Day.FRIDAY);
        days.add(Day.SATURDAY);
        days.add(Day.SUNDAY);

        return days;
    }
    private ArrayList<String> constructDaysStr() {
        ArrayList<String> daysStr = new ArrayList<String>();
        daysStr.add("Monday");
        daysStr.add("Tuesday");
        daysStr.add("Wednesday");
        daysStr.add("Thursday");
        daysStr.add("Friday");
        daysStr.add("Saturday");
        daysStr.add("Sunday");

        return daysStr;
    }

    public ArrayList<String> getDaysStr(){
        return this.daysStr;
    }
    public String getDayStr(int index){
        return this.daysStr.get(index);
    }
    public ArrayList<Day> getDays(){
        return this.days;
    }
    public Day getDays(int index){
        return this.days.get(index);
    }
    /**
     * constructs a weekly schedule with a different schedule for each day
     * @param schedules the daily schedules the week schedule needs to include
     * @param days the days the schedule needs to include
     * @return the weekly schedule
     */
    public static HashMap<Day, Schedule> createHash(ArrayList<Schedule> schedules, ArrayList<Day> days) {
        HashMap<Day, Schedule> schedule = new HashMap<Day, Schedule>();
       for(int i = 0; i< days.size(); i++){
            schedule.put(days.get(i), schedules.get(i));
       }
        return schedule;
    }
    /**
     * creates a string showcasing the weekly schedule
     * @return the String representation of the weekly schedule
     */
    public String cabinHashToString(){
        String workingString = "";
        for (Day keyValue  : schedule.keySet()) {
            System.out.println(keyValue);
            workingString += keyValue.toString() + "\n"; 
            workingString += schedule.get(keyValue).toString() + "\n";
        }
        return workingString;
    }
    /**
     * a method to get the schedule of the cabin on a specific day
     * @param day the day of the schedule being grabbed
     * @return the schedule for that day
     */
    public ArrayList<String> getSchedule(Day day){
        return schedule.get(day).getActivites();
    }

    public HashMap<Day, Schedule> getSchedule(){
        return this.schedule;
    }
    public void setSchedule(HashMap<Day, Schedule> schedule){
        this.schedule = schedule;
    }

    public double getMinAge(){
        return minAge;
    }
    public boolean setMinAge(int minAge) {
        this.minAge = minAge;
        return true;
    }

    public double getMaxAge(){
        return maxAge;
    }
    public boolean setMaxAge(int maxAge) {
        this.maxAge = maxAge;
        return true;
    }

   

    public UUID getID() {
        return cabinID;
    }

    /**
     * written by natalie
     * @return a string representation of the cabin uuid
     */
    public String getCabinID() {
        return getID().toString();
        
    }
    public void setCabinID(UUID cabinID) {
        this.cabinID = cabinID;
    }

    public ArrayList<Counselor> getCounselors(){
        return counselors;
    }
    public Counselor getCounselor(int index){
        return counselors.get(index);
    }
    public boolean setCounselor(Counselor counselor){
        counselors.clear();
        counselors.add(counselor);
        return true;
     }
    public void removeCounselor(Counselor counselor) {
        counselors.remove(counselor);
    }

    public ArrayList<Camper> getCampers(){
        return campers;
    }
    public void setCampers(ArrayList<Camper> campers){
        this.campers = campers;
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
     * checks if a camper is in a cabin
     * @param camper the camper being searched for
     * @return whether or not the camper is in the cabin
     */
    public boolean hasCamper(Camper camper){
        for(int i=0; i<campers.size(); i++){
            if(campers.get(i).equals(camper))
                return true;
        }
        return false;
    }
    /**
     * method to determine whether a specific counselor is assigned to a cabin
     * @param counselor the counselor being searched for
     * @return whether or not that counselor is in the cabin
     */
    public boolean hasCounselor(Counselor counselor){
        for(int i=0; i<counselors.size(); i++){
           if(counselors.get(i).equals(counselor))
                return true; 
        }
        return false;
    }

    /**
     * method checking whether the cabin is full
     * @return if the cabin is full or not
     */
    public boolean isFull(){
        if(counselors.size() == 1 && campers.size() == 8)
            return true;
        return false;
    }

    public String toString(){
        String workingString = "";
        workingString +=  String.valueOf(Math.round(minAge)) +  "-" + String.valueOf(Math.round(maxAge)) + " year olds\n";
        return workingString;
    }
    /**
     * method that passes the cabin object to the camper to allow them to update their cabin hash
     * @param camper the camper being updated
     * @param session the session the cabin is in
     */
    public void updateCampersCabinHashes(Camper camper, Session session){
        camper.addSession(session, this);
    }
    /**
     * method that passes the cabin object to the counselor to allow them to update their cabin hash
     * @param counselor the counselor being updated
     * @param session the session the cabin is in
     */
    public void updateCounselorsCabinHashes(Counselor counselor, Session session) {
        counselor.updateCounselorCabinHash(session, this);
    }

    public String getVitals() {
        String str = "";
        if(counselors.size() == 1) {
            str  = counselors.get(0).getName() + ":\n" + "\tAllergies: " + counselors.get(0).getAllergiesStr() + "\n\tEmergencyContacts:\n\t" + counselors.get(0).getEmergencyContactsStr();
        }
        for(int i = 0; i < campers.size(); i++) {
            Camper c = campers.get(i);
            str += "\n\n" + c.getName() + ":\n" + "\tAllergies: " + c.getAllergiesStr() + "\n\tEmergency Contacts: " + c.getEmergencyContactsStr() + "\n\tMedications:\n\t" + c.getMedicationsStr();
        }
        return str;
    }
}

package camp;

public class Medication {
    private String dose;
    private String type;
    private String time;
    
    /**
     * Constructor for the medication class
     * @param dose Dose of the medication
     * @param type Type of medication
     * @param time Time of medication consumption
     */
    public Medication(String dose, String type, String time) {
        this.dose = dose;
        this.type = type;
        this.time = time;
    }

    //-----------------------------ACCESSORS----------------------------
    
    public String getDose() {
        return dose;
    }
    public String getType() {
        return type;
    }
    public String getTime() {
        return time;
    }

    //-----------------------------MUTATORS----------------------------

    public boolean setDose(String dose) {
        this.dose = dose;
        return true;
    }

    public boolean setType(String type) {
        this.type = type;
        return true;
    }

    public boolean setTime(String time) {
        this.time = time;
        return true;
    }

    // -----------------------------MISC------------------------------------

    public String toString() {
        return "type: " + type + "\ndose: " + dose + "\ntime: " + time;
    }
}

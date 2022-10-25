package camp;

public class Medication {
    private String dose;
    private String type;
    private String time;
    
    /**
     * Constrcutor for the medication class
     * @param dose Dose of the medication
     * @param type Type of medication
     * @param time Time of medication consumption
     */
    public Medication(String dose, String type, String time) {
        this.dose = dose;
        this.type = type;
        this.time = time;
    }

    public String getDose() {
        return dose;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString() {
        return dose + " " + type + " " + time;
    }
}

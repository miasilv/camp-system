package camp;

public class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    /**
     * Constructor for the contact class
     * @param firstName First name of the contact
     * @param lastName Last name of the contact
     * @param phoneNumber Phone number of the contact
     * @param address Address of the contact
     * @param relationship Relationship of the contact to the camper
     */
    public Contact(String name, String phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email; // just added this
    
    }

    //---------------------------ACCESSORS-----------------------------------
    
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }

    // ---------------------------MUTATORS-----------------------------------

    public boolean setName(String change) {
        this.name = change;
        return true;
    }

    public boolean setEmail(String change) {
        this.email = change;
        return true;
    }

    public boolean setPhoneNumber(String change) {
        this.phoneNumber = change;
        return true;
    }

    public boolean setAddress(String change) {
        this.address = change;
        return true;
    }

    // ---------------------------MISC-----------------------------------

    public String toString() {
        return "\n\t" + name + "\n" + "\t" +
                "Email: " + email + "\n" + "\t" +
                "Phone Number: " + phoneNumber + "\n" + "\t" +
                "Address: " + address;
    }

}

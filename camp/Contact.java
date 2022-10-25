package camp;

public class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String relationship;

    /**
     * Constructor for the contact class
     * @param firstName First name of the contact
     * @param lastName Last name of the contact
     * @param phoneNumber Phone number of the contact
     * @param address Address of the contact
     * @param relationship Relationship of the contact to the camper
     */
    public Contact(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    
    }

    //i could java doc these but they're more or less self-explanatory
    
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getRelationship() {
        return relationship;
    }
}

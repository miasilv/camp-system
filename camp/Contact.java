public class Contact {
    private String firstName;
    private String lastName;
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
    public Contact(String firstName, String lastName, String phoneNumber, String address, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.relationship = relationship;
    }

    //i could java doc these but they're more or less self-explanatory
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

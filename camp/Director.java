public class Director extends User {
    
    /**
     * Constructor for the director class
     * @param name Name of the director
     * @param email Email of the director
     * @param password Password of the director
     */
    public Director(String name, String email, String password, String phoneNumber) {
        super(name, email, password, phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package camp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class UserList {
    private ArrayList<Director> directors;
    private ArrayList<Counselor> counselors;
    private ArrayList<Guardian> guardians;
    private ArrayList<Camper> campers;
    private ArrayList<User> users;
    private static UserList userList;

    /**
     * Constructor for the user list to load in all the users
     */
    private UserList() {
        directors = DataLoader.loadDirector();
        guardians = DataLoader.loadGuardians();
    }

    /**
     * Grabs a static instance of the userlist (so we only read once)
     * @return The user list
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
            return userList;
        }
        return userList;
    }

    //------------------------ACCESSORS--------------------------

    public ArrayList<Director> getDirectors() {
        return directors;
    }
    
    public ArrayList<Camper> getCampers() {
        return campers;
    }

    public ArrayList<Counselor> getCounselors() {
        return counselors;
    }

    public ArrayList<Guardian> getGuardians() {
        return guardians;
    }

    /**
     * Gets the director based on email
     * @param email The email to search for
     * @return The director with that email
     */
    public Director getDirector(String email) {
        for (int i=0; i<directors.size(); i++) {
            if (directors.get(i).getEmail().equals(email)) {
                return directors.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Counselor getCounselor(String email) {
        for (int i=0; i < counselors.size(); i++) {
            if (counselors.get(i).getEmail().equals(email)) {
                return counselors.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Guardian getGuardian(String email) {
        for (int i=0; i < guardians.size(); i++) {
            if (guardians.get(i).getEmail().equals(email)) {
                return guardians.get(i);
            }
        }
        return null; // if unable to find it, return first
    }

    /**
     * Gets the director based on uuid
     * 
     * @param id The UUID to search for
     * @return The director with that UUID
     */
    public Director getDirector(UUID id) {
        for (int i=0; i < directors.size(); i++) {
            if (directors.get(i).getID().equals(id)) { 
                return directors.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Counselor getCounselor(UUID id) {
        for (int i = 0; i < counselors.size(); i++) {
            if (counselors.get(i).getID().equals(id)) {
                return counselors.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Guardian getGuardian(UUID id) {
        for (int i = 0; i < guardians.size(); i++) {
            if (guardians.get(i).getID().equals(id)) {
                return guardians.get(i);
            }
        }
        return null; // if unable to find it
    }

    /**
     * Accesses the camper based on UUID
     * @param id The UUID of the camper
     * @return The camper with that UUID
     */
    public Camper getCamper(UUID id) {
        for (int i = 0; i < campers.size(); i++) {
            if (campers.get(i).getID().equals(id)) {
                return campers.get(i);
            }
        }
        return null; // if unable to find it
    }

    /**
     * Loops through all the directors, counselors, and guardians for users
     * @param email Email to search for
     * @return User with that email
     */
    public User getUser(String email) {
        if (getDirector(email) != null) {
            return getDirector(email);
        }
        else if (getGuardian(email) != null) {
            return getGuardian(email);
        }
        return null; // if no email is found
    }

    /**
     * Accesses a user based on UUID
     * @param id The UUID of the user to grab
     * @return The user with that UUID
     */
    public User getUser(UUID id) {
        if (getDirector(id) != null) {
            return getDirector(id);
        } 
        else if (getGuardian(id) != null) {
            return getGuardian(id);
        }
        return null; // if no email is found
    }

    //---------------------------ADDING THROUGH UI---------------------------

    /**
     * Adds a director to the directors list
     * @param name The name of the director
     * @param email The email of the director
     * @param password The password of the director
     * @param phoneNumber The phone number of the dir
     */
    public void addDirector(String name, String email, String password, String phoneNumber) {
        Director aDirector = new Director(name, email, password, phoneNumber);
        directors.add(aDirector);
    }

    /**
     * Adds a counselor to the counselors list
     * @param name The name of the counselor
     * @param email The email of the counselor
     * @param password The password of the counselor
     * @param phoneNumber The phone number of the counselor
     */
    public void addCounselor(String name, String email, String password, String phoneNumber) {
        Counselor aCounselor = new Counselor(name, email, password, phoneNumber);
        counselors.add(aCounselor);
    }

    /**
     * Adds a guardian to the guardians list
     * @param name The name of the guardian
     * @param email The email of the guardian
     * @param password The password of the guardian
     * @param phoneNumber The phone num of the guardian
     */
    public void addGuardian(String name, String email, String password, String phoneNumber) {
        Guardian aGuardian = new Guardian(name, email, password, phoneNumber);
        guardians.add(aGuardian);
    }

    //---------------------------ADDING THROUGH JSON----------------------

    public void addDirector(UUID id, String name, String email, String password, String phoneNumber) {
        Director aDirector = new Director(id, name, email, password, phoneNumber);
        directors.add(aDirector);
    }

    public void addCounselor(UUID id, String name, String email, String password, String phoneNumber, String bio, ArrayList<String> relationships, ArrayList<Contact> contacts, Date birthday, ArrayList<String> allergies, ArrayList<String> themes) {
        Counselor aCounselor = new Counselor(id, name, email, password, phoneNumber, bio, relationships, contacts, birthday, allergies, themes);
        counselors.add(aCounselor);
    }

    public void addGuardian(UUID id, String name, String email, String password, String phoneNumber, ArrayList<Camper> campers) {
        Guardian aGuardian = new Guardian(id, name, email, password, phoneNumber, campers);
        guardians.add(aGuardian);
    }

    /**
     * Removes a director based on email
     * @param email The email to search for
     */
    public void removeDirector(String email) {
        for (int i = 0; i < directors.size(); i++) {
            if (directors.get(i).getEmail().equals(email)) {
                directors.remove(i);
            }
        }
    }

    public void removeCounselor(String email) {
        for (int i = 0; i < counselors.size(); i++) {
            if (counselors.get(i).getEmail().equals(email)) {
                counselors.remove(i);
            }
        }
    }

    public void removeGuardian(String email) {
        for (int i = 0; i < guardians.size(); i++) {
            if (guardians.get(i).getEmail().equals(email)) {
                guardians.remove(i);
            }
        }
    }

    /**
     * Removes the director based on uuid
     * @param id The UUID to search for
     * @return The director with that UUID
     */
    public void removeDirector(UUID id) {
        for (int i = 0; i < directors.size(); i++) {
            if (directors.get(i).getID().equals(id)) {
                directors.remove(i);
            }
        }
    }

    public void removeGuardian(UUID id) {
        for (int i = 0; i < guardians.size(); i++) {
            if (guardians.get(i).getID().equals(id)) {
                guardians.remove(i);
            }
        }
    }
    
}

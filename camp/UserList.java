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
    private static UserList userList;

    private UserList() {
        directors = DataLoader.loadDirector();
        campers = DataLoader.loadCampers();
        guardians = DataLoader.loadGuardians();
        campers = DataLoader.loadCampers();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    // ACCESSORS AND MUTATORS!

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


    // "every arraylist must have getters, adders, and removers - mia"

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

    public Camper getCamper(UUID id) {
        for (int i = 0; i < campers.size(); i++) {
            if (campers.get(i).getID().equals(id)) {
                return campers.get(i);
            }
        }
        return null; // if unable to find it
    }

    /**
     * Loops through all the directors, counselors, and guadians for users
     * @param email Email to search for
     * @return User with that email
     */
    public User getUser(String email) {
        if (getDirector(email) != null) {
            return getDirector(email);
        }
        else if (getCounselor(email) != null) {
            return getCounselor(email);
        }
        else if (getGuardian(email) != null) {
            return getGuardian(email);
        }
        return null; // if no email is found
    }

    public User getUser(UUID id) {
        if (getDirector(id) != null) {
            return getDirector(id);
        } else if (getCounselor(id) != null) {
            return getCounselor(id);
        } else if (getGuardian(id) != null) {
            return getGuardian(id);
        }
        return null; // if no email is found
    }

    /* ADDING THROUGH UI */
    public void addDirector(String name, String email, String password, String phoneNumber) {
        Director aDirector = new Director(name, email, password, phoneNumber);
        directors.add(aDirector);
    }

    public void addCounselor(String name, String email, String password, String phoneNumber) {
        Counselor aCounselor = new Counselor(name, email, password, phoneNumber);
        counselors.add(aCounselor);
    }

    public void addGuardian(String name, String email, String password, String phoneNumber) {
        Guardian aGuardian = new Guardian(name, email, password, phoneNumber);
        guardians.add(aGuardian);
    }

    /* ADDING IN THROUGH THE JSONS! */
    public void addDirector(UUID id, String name, String email, String password, String phoneNumber) {
        Director aDirector = new Director(id, name, email, password, phoneNumber);
        directors.add(aDirector);
    }

    public void addCounselor(UUID id, String name, String email, String password, String phoneNumber, String bio, ArrayList<String> relationships, ArrayList<Contact> contacts, Date birthday, ArrayList<String> allergies) {
        Counselor aCounselor = new Counselor(id, name, email, password, phoneNumber, bio, relationships, contacts, birthday, allergies);
        counselors.add(aCounselor);
    }

    public void addGuardian(UUID id, String name, String email, String password, String phoneNumber, ArrayList<Camper> campers) {
        Guardian aGuardian = new Guardian(id, name, email, password, phoneNumber, campers);
        guardians.add(aGuardian);
    }

    /**
     * Removes a director based on email
     * 
     * @param email The email to search for
     * @return The director with that email
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
     * 
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

    public void removeCounselor(UUID id) {
        for (int i = 0; i < counselors.size(); i++) {
            if (counselors.get(i).getID().equals(id)) {
                counselors.remove(i);
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
    
    public void saveUsers() {
        
    }
}

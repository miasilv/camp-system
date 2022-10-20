import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author Natalie Crawford
 * The DataLoader class
 */

public class DataLoader extends DataConstants {
    private ArrayList<User> users;
    private Camp camp;
    /**
     * get guardians, counselors, and directors
     * @return
     */
    public ArrayList<User> getAllUsers(){
    
        return users;

    }
    /**
     * 
     * @return
     */
    public Camp getCamp(){
        return camp;

    }

    public static ArrayList<Camper> loadCampers() {
        ArrayList<Camper> campers = new ArrayList<Camper>();

        return campers;
    }
    public static ArrayList<Director> loadDirector() {
		ArrayList<Director> directors = new ArrayList<Director>();
		
		try {
			FileReader reader = new FileReader(DIRECTOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray directorsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < directorsJSON.size(); i++) {
				JSONObject directorJSON = (JSONObject)directorsJSON.get(i);
				String name = (String)directorJSON.get(DIRECTOR_NAME);
				String email = (String)directorJSON.get(DIRECTOR_EMAIL);
                String password = (String)directorJSON.get(DIRECTOR_PASSWORD);
				String phoneNumber = (String)directorJSON.get(DIRECTOR_PHONE_NUMBER);

				
				directors.add(new Director(name, email, password, phoneNumber));
			}
			
			return directors;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

    public static ArrayList<Guardian> loadGuardians() {
		ArrayList<Guardian> guardians = new ArrayList<Guardian>();
		
		try {
			FileReader reader = new FileReader(GUARDIAN_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray guardiansJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < guardiansJSON.size(); i++) {
				JSONObject guardianJSON = (JSONObject)guardiansJSON.get(i);
				String name = (String)guardianJSON.get(GUARDIAN_NAME);
				String email = (String)guardianJSON.get(GUARDIAN_EMAIL);
                String password = (String)guardianJSON.get(GUARDIAN_PASSWORD);
				String phoneNumber = (String)guardianJSON.get(GUARDIAN_PHONE_NUMBER);
                UUID id = UUID.fromString((String)guardianJSON.get(GUARDIAN_UUID));
                JSONArray campersJSON = (JSONArray)guardianJSON.get(GUARDIAN_CAMPERS);

                //make arraylist of campers
                ArrayList<Camper> campers = new ArrayList<Camper>();
                for(int j = 0; j < campersJSON.size(); j++){
                    UUID camperID = UUID.fromString((String)campersJSON.get(j));
                    Camper camper = UserList.getInstance().getCamperByUUID(camperID);
                    campers.add(camper);
                }
				
				guardians.add(new Guardian(name, email, password, phoneNumber, id, campers));
			}
			
			return guardians;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


    public static ArrayList<Counselor> loadCounselors() {
		ArrayList<Counselor> counselors = new ArrayList<Counselor>();
		
		try {
			FileReader reader = new FileReader(COUNSELOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray counselorsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < counselorsJSON.size(); i++) {
				JSONObject counselorJSON = (JSONObject)counselorsJSON.get(i);
				String name = (String)counselorJSON.get(COUNSELOR_NAME);
				String email = (String)counselorJSON.get(COUNSELOR_EMAIL);
                String password = (String)counselorJSON.get(COUNSELOR_PASSWORD);
				String phoneNumber = (String)counselorJSON.get(COUNSELOR_PHONE_NUMBER);
                String bio = (String)counselorJSON.get(COUNSELOR_BIO);
                Date birthday = (Date)counselorJSON.get(COUNSELOR_BIRTHDAY);
                UUID id = UUID.fromString((String)counselorJSON.get(COUNSELOR_UUID));

                JSONArray allergiesJSON = (JSONArray)counselorJSON.get(COUNSELOR_ALLERGIES);
                JSONArray emergencycontactsJSON = (JSONArray)counselorJSON.get(COUNSELOR_EMERGENCY_CONTACTS);
                
                //make arraylist of allergies
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j = 0; j < allergiesJSON.size(); j++){
                    allergies.add((String)allergiesJSON.get(j));
                }

                //make arraylist of emergency contact data
                ArrayList<EmergencyContact> emergencies = new ArrayList<EmergencyContact>();
                for(int j = 0; j < emergencycontactsJSON.size(); j++){
                    JSONObject contact = (JSONObject)emergencycontactsJSON.get(j);
                    String ename = (String)contact.get(EMERGENCY_NAME);
                    String ephone = (String)contact.get(EMERGENCY_PHONE);
                    String eaddress = (String)contact.get(EMERGENCY_ADDRESS);
                    String erelationship = (String)contact.get(EMERGENCY_RELATIONSHIP);
                    EmergencyContact emergency = new EmergencyContact(ename, ephone, eaddress, erelationship);
                    emergencies.add(emergency);
                }
				
				counselors.add(new Counselor(name, email, password, phoneNumber, bio, birthday, id, allergies, emergencies));
			}
			
			return counselors;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

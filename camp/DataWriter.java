package camp;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * @author Natalie Crawford
 * The DataWriter class
 */
public class DataWriter extends DataConstants {

    public static void main(String[] args) {
        saveCounselors();
    }


    //save directors
    public static void saveDirectors() {
		UserList users = UserList.getInstance();
		ArrayList<Director> directors = users.getDirectors();
		JSONArray jsonDirectors = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< directors.size(); i++) {
			jsonDirectors.add(getDirectorJSON(directors.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + DIRECTOR_FILE_NAME)) {
 
            file.write(jsonDirectors.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getDirectorJSON(Director director) {
		JSONObject directorDetails = new JSONObject();
		directorDetails.put(DIRECTOR_NAME, director.getName());
		directorDetails.put(DIRECTOR_EMAIL, director.getEmail());
        directorDetails.put(DIRECTOR_PASSWORD, director.getPassword());
        directorDetails.put(DIRECTOR_PHONE_NUMBER, director.getPhoneNumber());
        directorDetails.put(DIRECTOR_UUID, director.getDirectorID());
		
		
        return directorDetails;
	}


    //save guardians
    public static void saveGuardians() {
		UserList users = UserList.getInstance();
		ArrayList<Guardian> guardians = users.getGuardians();
		JSONArray jsonGuardians = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< guardians.size(); i++) {
			jsonGuardians.add(getGuardianJSON(guardians.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + GUARDIAN_FILE_NAME)) {
 
            file.write(jsonGuardians.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getGuardianJSON(Guardian guardian) {
		JSONObject guardianDetails = new JSONObject();
		guardianDetails.put(GUARDIAN_NAME, guardian.getName());
		guardianDetails.put(GUARDIAN_EMAIL, guardian.getEmail());
        guardianDetails.put(GUARDIAN_PASSWORD, guardian.getPassword());
        guardianDetails.put(GUARDIAN_PHONE_NUMBER, guardian.getPhoneNumber());
        guardianDetails.put(DIRECTOR_UUID, guardian.getGuardianID());
        guardianDetails.put(GUARDIAN_CAMPERS, guardian.getCampers());
		
		
        return guardianDetails;
	}



    //save counselors
    public static void saveCounselors() {
		CounselorList users = CounselorList.getInstance();
		ArrayList<Counselor> counselors = users.getCounselors();
		JSONArray jsonCounselors = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< counselors.size(); i++) {
			jsonCounselors.add(getCounselorJSON(counselors.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/tester.json")) {
 
            file.write(jsonCounselors.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCounselorJSON(Counselor counselor) {
		JSONObject counselorDetails = new JSONObject();
		counselorDetails.put(COUNSELOR_NAME, counselor.getName());
		counselorDetails.put(COUNSELOR_EMAIL, counselor.getEmail());
        counselorDetails.put(COUNSELOR_PASSWORD, counselor.getPassword());
        counselorDetails.put(COUNSELOR_PHONE_NUMBER, counselor.getPhoneNumber());
        counselorDetails.put(COUNSELOR_UUID, counselor.getCounselorID());
        counselorDetails.put(COUNSELOR_BIO, counselor.getBio());
        counselorDetails.put(COUNSELOR_BIRTHDAY, counselor.getBirthday());
        counselorDetails.put(COUNSELOR_ALLERGIES, counselor.getAllergies());
		counselorDetails.put(COUNSELOR_EMERGENCY_CONTACTS, counselor.getEmergencyContacts());
    
		
        return counselorDetails;
	}

     //save campers
     public static void saveCampers() {
		CamperList campersL = CamperList.getInstance();
		ArrayList<Camper> campers = campersL.getCampers();
		JSONArray jsonCampers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< campers.size(); i++) {
			jsonCampers.add(getCamperJSON(campers.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + CAMPER_FILE_NAME)) {
 
            file.write(jsonCampers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCamperJSON(Camper camper) {
		JSONObject camperDetails = new JSONObject();
		camperDetails.put(CAMPER_NAME, camper.getName());
		camperDetails.put(CAMPER_MEDICATIONS, camper.getMedications());
        camperDetails.put(CAMPER_NOTES, camper.getNotes());
        camperDetails.put(CAMPER_SESSIONS, camper.getSessions());
        camperDetails.put(CAMPER_UUID, camper.getCamperID());
        camperDetails.put(CAMPER_BIRTHDAY, camper.getBirthday());
        camperDetails.put(CAMPER_ALLERGIES, camper.getAllergies());
		camperDetails.put(CAMPER_EMERGENCY_CONTACTS, camper.getEmergencyContacts());
		
        return camperDetails;
	}



    //save camp
    public static void saveCamp() {
		CampList camp = CampList.getInstance();
		ArrayList<Camp> camps = camp.getCamps();
		JSONArray jsonCamps = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< camps.size(); i++) {
			jsonCamps.add(getCampJSON(camps.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + CAMP_FILE_NAME)) {
            file.write(jsonCamps.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCampJSON(Camp camp) {
		JSONObject campDetails = new JSONObject();
		campDetails.put(CAMP_NAME, camp.getName());
		campDetails.put(CAMP_ACTIVITIES, camp.getActivities());
        campDetails.put(CAMP_FAQS, camp.getFAQs());
        campDetails.put(CAMP_PRICE, camp.getPrice());
        campDetails.put(CAMP_UUID, camp.getCampID());
        campDetails.put(CAMP_RATIO, camp.getRatio());
        campDetails.put(CAMP_SESSIONS, camp.getSessions());
		
        return campDetails;
	}

    //save cabin
    public static void saveCabin() {
		CampList camp = CampList.getInstance();
		ArrayList<Cabin> cabins = camp.getCabins();
		JSONArray jsonCabins = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< cabins.size(); i++) {
			jsonCabins.add(getCabinJSON(cabins.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter("./camp/json files/" + CABIN_FILE_NAME)) {
 
            file.write(jsonCabins.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCabinJSON(Cabin cabin) {
		JSONObject cabinDetails = new JSONObject();
		cabinDetails.put(CABIN_BEDS, cabin.getBeds());
		cabinDetails.put(CABIN_CAMPERS, cabin.getCampers());
        cabinDetails.put(CABIN_COUNSELOR, cabin.getCounselor());
        cabinDetails.put(CABIN_MAX_AGE, cabin.getMaxAge());
        cabinDetails.put(CABIN_UUID, cabin.getCabinID());
        cabinDetails.put(CABIN_MIN_AGE, cabin.getMinAge());
        cabinDetails.put(CABIN_SCHEDULE, cabin.getSchedule());
		
        return cabinDetails;
	}

    //add save session
}

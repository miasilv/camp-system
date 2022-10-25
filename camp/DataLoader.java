package camp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author Natalie Crawford
 * The DataLoader class
 */

public class DataLoader extends DataConstants {

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
				
				guardians.add(new Guardian(id, name, email, password, phoneNumber,campers));
			}
			
			return guardians;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

    //load counselors
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
                ArrayList<Contact> emergencies = new ArrayList<Contact>();
                ArrayList<String> relationships = new ArrayList<String>();
                for(int j = 0; j < emergencycontactsJSON.size(); j++){
                    JSONObject contact = (JSONObject)emergencycontactsJSON.get(j);
                    String ename = (String)contact.get(EMERGENCY_NAME);
                    String ephone = (String)contact.get(EMERGENCY_PHONE);
                    String eaddress = (String)contact.get(EMERGENCY_ADDRESS);
                    String erelationship = (String)contact.get(EMERGENCY_RELATIONSHIP);
                    Contact emergency = new Contact(ename, ephone, eaddress);
                    emergencies.add(emergency);
                    relationships.add(erelationship);

                    
                }
				
				counselors.add(new Counselor(id, name, email, password, phoneNumber, bio, relationships, emergencies, birthday, allergies));
			}
			
			return counselors;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


    //load campers
    public static ArrayList<Camper> loadCampers() {
		ArrayList<Camper> campers = new ArrayList<Camper>();
		
		try {
			FileReader reader = new FileReader(COUNSELOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray campersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < campersJSON.size(); i++) {
				JSONObject camperJSON = (JSONObject)campersJSON.get(i);
				String name = (String)camperJSON.get(CAMPER_NAME);
                Date birthday = (Date)camperJSON.get(CAMPER_BIRTHDAY);
                UUID id = UUID.fromString((String)camperJSON.get(CAMPER_UUID));

                JSONArray allergiesJSON = (JSONArray)camperJSON.get(CAMPER_ALLERGIES);
                JSONArray emergencycontactsJSON = (JSONArray)camperJSON.get(CAMPER_EMERGENCY_CONTACTS);
                JSONArray medicationsJSON = (JSONArray)camperJSON.get(CAMPER_MEDICATIONS);
                JSONArray sessionsJSON = (JSONArray)camperJSON.get(CAMPER_SESSIONS);
                JSONArray notesJSON = (JSONArray)camperJSON.get(CAMPER_NOTES);
                
                //make arraylist of allergies
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j = 0; j < allergiesJSON.size(); j++){
                    allergies.add((String)allergiesJSON.get(j));
                }

                //make arraylist of notes
                ArrayList<String> notes = new ArrayList<String>();
                for(int j = 0; j < notesJSON.size(); j++){
                    notes.add((String)notesJSON.get(j));
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

                //make arraylist of emergency contact data
                ArrayList<Medication>  medications = new ArrayList<Medication>();
                for(int j = 0; j < emergencycontactsJSON.size(); j++){
                    JSONObject contact = (JSONObject)medicationsJSON.get(j);
                    String type = (String)contact.get(MEDICATION_TYPE);
                    String dose = (String)contact.get(MEDICATION_DOSE);
                    String time = (String)contact.get(MEDICATION_TIME);
    
                    Medication medication = new Medication(dose, type, time);
                    medications.add(medication);
                }

                //make arraylist of sessions
                ArrayList<Session> sessions = new ArrayList<Session>();
                for(int j = 0; j < sessionsJSON.size(); j++){
                    UUID sessionID = UUID.fromString((String)sessionsJSON.get(j));
                    Session session = Camp.getInstance().getSessionByUUID(sessionID);
                    sessions.add(session);
                }
				
				campers.add(new Camper(id, name, birthday, medications, allergies, sessions, notes, emergencies));
			}
			
			return campers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}



    //load cabin
    public static ArrayList<Cabin> loadCabins() {
		ArrayList<Cabin> cabins = new ArrayList<Cabin>();
		
		try {
			FileReader reader = new FileReader(CABIN_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray cabinsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < cabinsJSON.size(); i++) {
				JSONObject cabinJSON = (JSONObject)cabinsJSON.get(i);
				int beds = (int)cabinJSON.get(CABIN_BEDS);
                int maxAge = (int)cabinJSON.get(CABIN_MAX_AGE);
                int minAge = (int)cabinJSON.get(CABIN_MIN_AGE);
                UUID id = UUID.fromString((String)cabinJSON.get(CABIN_UUID));

                JSONArray campersJSON = (JSONArray)cabinJSON.get(CABIN_CAMPERS);
                JSONArray counselorsJSON = (JSONArray)cabinJSON.get(CABIN_COUNSELOR);
                JSONArray schedulesJSON = (JSONArray)cabinJSON.get(CABIN_SCHEDULE);
                
                //make arraylist of schedule data
                ArrayList<Schedule> schedules = new ArrayList<Schedule>();
                for(int j = 0; j < schedulesJSON.size(); j++){
                    JSONObject dschedule = (JSONObject)schedulesJSON.get(j);
                    String day = (String)dschedule.get(SCHEDULE_DAY);

                    JSONArray dayschedulesJSON = (JSONArray)schedulesJSON.get(j);
                    ArrayList<String> activities = new ArrayList<String>() ;
                    for(int k = 0; k<dayschedulesJSON.size(); k++){
                        activities.add((String)dayschedulesJSON.get(k));
                    }
                    
                    Schedule schedule = new Schedule(activities);
                    schedules.add(schedule);
                }

                //make arraylist of campers
                ArrayList<Camper> campers = new ArrayList<Camper>();
                for(int j = 0; j < campersJSON.size(); j++){
                    UUID camperID = UUID.fromString((String)campersJSON.get(j));
                    Camper camper = UserList.getInstance().getCamperByUUID(camperID);
                    campers.add(camper);
                }

                 //make arraylist of counselors
                 ArrayList<Counselor> counselors = new ArrayList<Counselor>();
                 for(int j = 0; j < counselorsJSON.size(); j++){
                     UUID camperID = UUID.fromString((String)campersJSON.get(j));
                     Camper camper = UserList.getInstance().getCamperByUUID(camperID);
                     campers.add(camper);
                 }
				
				cabins.add(new Cabin(campers, counselors, beds, maxAge, minAge, schedules, id));
			}
			
			return cabins;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

    //load camp
    public static ArrayList<Camp> loadCamp() {
	    ArrayList<Camp> camps = new ArrayList<Camp>();
		
		try {
			FileReader reader = new FileReader(CAMP_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray campsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < campsJSON.size(); i++) {
				JSONObject campJSON = (JSONObject)campsJSON.get(i);
				String name = (String)campJSON.get(CAMP_NAME);
                int price = (int)campJSON.get(CAMP_PRICE);
                int campersPerCounselor = (int)campJSON.get(CAMP_RATIO);
                UUID id = UUID.fromString((String)campJSON.get(CAMP_UUID));

                JSONArray sessionsJSON = (JSONArray)campJSON.get(CAMP_SESSIONS);
                JSONArray faqsJSON = (JSONArray)campJSON.get(CAMP_FAQS);
                JSONArray activitiesJSON = (JSONArray)campJSON.get(CAMP_ACTIVITIES);
                
                //make arraylist of sessions
                ArrayList<Session> sessions = new ArrayList<Session>();
                for(int j = 0; j < sessionsJSON.size(); j++){
                    JSONObject sessionJSON = (JSONObject)sessionsJSON.get(j);
                    UUID seshid = UUID.fromString((String)sessionJSON.get(SESSION_ID));
                    String theme = (String)sessionJSON.get(SESSION_THEME);
                    int seshNum = (int)sessionJSON.get(SESSION_NUM);
                    Date start= (Date)sessionJSON.get(SESSION_START);
                    Date end = (Date)sessionJSON.get(SESSION_END);
                    JSONArray cabinsJSON = (JSONArray)sessionJSON.get(SESSION_CABINS);


                    //make arraylist of cabins
                    ArrayList<Cabin> cabins = new ArrayList<Cabin>();
                    for(int k = 0; k < cabinsJSON.size(); k++){
                        UUID cabinID = UUID.fromString((String)cabinsJSON.get(j));
                        Cabin cabin = Camp.getInstance().getCabinByUUID(cabinID);
                        cabins.add(cabin);
                    }
                    
                    Session session = new Session (seshid, theme, cabins, seshNum, start, end);
                    sessions.add(session);
                }

                //make arraylist of faqs
                ArrayList<FAQ> faqs = new ArrayList<FAQ>();
                for(int j = 0; j < faqsJSON.size(); j++){
                    JSONObject faqJSON = (JSONObject)faqsJSON.get(j);
                    String question = (String)faqJSON.get(FAQ_QUESTION);
                    String answer = (String)faqJSON.get(FAQ_ANSWER);
                    FAQ faq = new FAQ(question, answer);
                    faqs.add(faq);
                }

                 //make arraylist of activities
                 ArrayList<String> activities = new ArrayList<String>();
                 for(int j = 0; j < activitiesJSON.size(); j++){
                     activities.add((String)activitiesJSON.get(j));
                 }

                Camp camp = Camp.getInstance(id, name, sessions, price, faqs, campersPerCounselor, activities);
				camps.add(camp);
			}
			
			return camps;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

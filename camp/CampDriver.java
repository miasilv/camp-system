package camp;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mia Silver
 * The Camp Driver (the front end of the system)
 */
public class CampDriver {
    private Scanner in;
	private ArrayList<String> options;
	private CampFacade facade;
	private User user;

	//Classes (and in some cases instance variables)
	private static final String CAMP = "camp";
	private static final String FAQ = "faq"; //also in camp
    private static final String SESSION = "session"; //also in camper and camp
    private static final String CABIN = "cabin"; //also in session, counselor, and camper
	private static final String SCHEDULE = "schedule"; //also in cabin
    private static final String USER = "user";
    private static final String COUNSELOR = "counselor"; //also in cabin
	private static final String GUARDIAN = "guardian"; 
    private static final String CAMPER = "camper"; //also in cabin and guardian
    private static final String MEDICATION = "medication"; //also in camper
    private static final String CONTACT = "contact"; //also in counselor and camper

	//camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "campers per counselor";
	private static final String ACTIVITIES = "activitiy";

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String THEME = "session theme";
	private static final String SESS_DESCR = "session description"; 
	private static final String START_DATE = "start date";
	private static final String END_DATE = "enddate";

	//cabin instance variables
    private static final String MAX_AGE = "max age";
    private static final String MIN_AGE = "min age";

	//schedule times
	private String[] times = {"8:00:", "9:00 - 9:45:", "10:00 - 11:45:", "12:00 - 12:45:", "1:00 - 2:45:", "3:00 - 3:45:", "4:00 - 5:45:", "6:00 - 6:45:", "7:00 - 8:45:", "10:00:"};
	
	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phone number"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//guardian instance variables
	private static final String SESS_NUM = "total number of sessions";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergy"; //can also be used for Camper

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";
	private static final String ADDRESS = "address";

	//medication instance variables
    private static final String DOSE = "dose";
    private static final String TYPE = "type";
    private static final String TIME = "time";

    /**
	 * Constructs a new driver, construct this in the main method and it will create a new facade
	 */
	public CampDriver() {
        in = new Scanner(System.in); 
		options = new ArrayList<String>();
		facade = new CampFacade();
    }


	//--------------------------------------------------------- Loops and display methods ----------------------------------------------------------
    /**
	 * Call this method to start the loop in the main method, this is the welcome screen 
	 * which holds camp information, sign in, user portal, and log out. 
	 * Sign in switches with user portal and log out if a user is detected.
	 */
	public void runDriver() {
        clear();
        System.out.println("***** Welcome to the Camp Website! *****");
		facade.updateCamp();

        while(true) {
			//updating options----------------------------------------
			clearOptions();
			options.add("View Camp Information");
			if(user == null) {
				options.add("Sign in");
			}
			else {
				options.add("User Portal");
				options.add("Log out");
			}
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Home Screen *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}

			switch(choice) {
				case 0: //camp information
					displayCampInformation();
					break;
				
				case 1: //either sign in or user portal
					if(user == null) { //sign in
						clear();
						System.out.print("Enter your email: ");
						String email = in.nextLine();
						System.out.print("Enter your password: ");
						String password = in.nextLine();
				
						if(facade.signIn(email, password)) {
							user = facade.getUser();
							System.out.println("Successfully signed in");
							in.nextLine();
							break;
						}
						System.out.println("Could not sign you in");
						in.nextLine();
						break;
					}
					else { //user portal
						if(user instanceof Director) {
							facade.updateDirector();
							displayDirectorPortal();
						}
						if(user instanceof Guardian) {
							facade.updateGuardian();
							displayGuardianPortal();
						}
						if(user instanceof Counselor) {
							facade.updateCounselor();
							displayCounselorPortal();
						}						
					}
					break;
				
				case 2: //Log Out
					user = null;
					break;
			}
        }
    }


	/**
	 * This method is called when displaying camp instance variables. It includes the name of the camp
	 * price per session, an array list of sessions, how many campers are per counselor roughly, an array list of faqs
	 * and an array list of activities offered. You can go into activities, faq, and sessions
	 */
	private void displayCampInformation() {
		while(true) {
			//updating options and Camp object----------------------------------------
			facade.updateCamp();
			clearOptions();
			options.add("Name: " + facade.getCampString(NAME));
			options.add("Pricing: $" + facade.getCampDouble(PRICE) + " per session");
			options.add("Sessions Available");
			options.add("Campers per Counselor: " + facade.getCampInt(RATIO));
			options.add("FAQs"); 
			options.add("Activities Offered");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Camp Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				
				System.exit(0);
			}
			
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //the user chose name
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getCampString(NAME));
					String change = setStringInformation(NAME);
					if(!(change == null)) {
						if(!facade.setCampString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //the user chose price
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + PRICE + ": " + facade.getCampDouble(PRICE));
					double doub = setDoubleInformation(PRICE);
					if(!(doub == -1)) {
						if(!facade.setCampDouble(PRICE, doub)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Session List
					displaySessionList();
					break;

				case 3: //Campers per Counselor
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + RATIO + ": " + facade.getCampInt(RATIO));
					int num = setIntInformation(RATIO);
					if(!(num == -1)) {
						if(!facade.setCampInt(RATIO, num)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 4: //FAQ List
					displayFAQList();
					break;

				case 5: //activity list
					displayActivitiesList();
					break;
			}
		}
	}

	/**
	 * Displays a list of activities, only the director has access to edit the list of activites
	 */
	private void displayActivitiesList() {
		ArrayList<String> activities = facade.getCampActivities();

		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < activities.size(); i++) {
				options.add(activities.get(i));
			}
			options.add("Add a new Activity");
			options.add("Remove an existing Activity");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Camp Activities *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove an Activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which activity do you want to delete?");
				int num = getNum();
				if(0 >= num && num <= 6) {
					System.out.println("These activities cannot be deleted.");
					in.nextLine();
				}
				else if(num >= activities.size()) {
					System.out.println("This is not a valid number");
					in.nextLine();
				}
				else if(!facade.removeCampActivity(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				continue;
			}
			
			if(choice == options.size() -4) { //the user wants to add an Activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("What activity do you want to add?");
				if(!facade.addCampActivity(in.nextLine())) {
					System.out.println("Something went wrong, unable to add");
					in.nextLine();
				}
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing activity
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println(facade.getCampActivities().get(choice));
				String change = setStringInformation(ACTIVITIES);
				if(!(change == null)) {
					if(!facade.setCampActivity(choice, change)) {
						System.out.println("Sorry, something went wrong, unable to add.");
						in.nextLine();
					}
				}
				continue;
        	}
		}
	}

	/**
	 * Displays an FAQ list (the display includes question and answer but to edit you must
	 * go into the faq object)
	 */
	private void displayFAQList() {
		ArrayList<FAQ> faqs = facade.getCampFAQ();
		
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < faqs.size(); i++) {
				options.add(faqs.get(i).toString()); 
			}
			options.add("Add a new FAQ");
			options.add("Remove an existing FAQ");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** FAQs *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove an FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which faq do you want to delete?");
				int num = getNum();
				if(0 >= num || num < faqs.size()) {
					System.out.println("Not a valid number");
					in.nextLine();
				}
				else if(!facade.removeCampFAQ(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
				}
				continue;
			}

			if(choice == options.size() -4) { //the user wants to add an FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}
				createFAQ();
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing FAQ
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}
				
				facade.updateFAQ(choice);
				displayFAQ();
				continue;
        	}
		}
	}

	/**
	 * Displays an FAQ object including the question and answer strings
	 */
	private void displayFAQ() {
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			options.add("Question: " + facade.getFAQString(QUESTION));
			options.add("Answer: " + facade.getFAQString(ANSWER));
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}

			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Question
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + QUESTION + ": " + facade.getFAQString(QUESTION));
					String change = setStringInformation(QUESTION);
					if(!(change == null)) {
						if(!facade.setFAQString(QUESTION, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Answer
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + ANSWER + ": " + facade.getFAQString(ANSWER));
					String change2 = setStringInformation(ANSWER);
					if(!(change2 == null)) {
						if(!facade.setFAQString(ANSWER, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
			}
		}
	}

	/**
	 * Displays the array list of sessions inside the camp object.
	 * The session shows the theme, dates, and description
	 */
	private void displaySessionList() {
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < facade.getCampSessions().size(); i++) {
				options.add("Session " + (i + 1) + "- " + facade.getCampSessions().get(i).toString());
			}
			options.add("Add a new Session");
			options.add("Remove an existing Session");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Sessions *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Session
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which session do you want to delete?");
				int num = getNum();
				if(0 > num || num >= facade.getCampSessions().size()) {
					System.out.println("Not a valid number");
					in.nextLine();
					continue;
				}
				else if(!facade.removeCampSession(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				System.out.println("Removed session");
				continue;
			}

			if(choice == options.size() -4) { //the user wants to add a Session
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to view/edit this.");
					in.nextLine();
					continue;
				}
				createSession();
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing Session
				if(user == null) {
					System.out.println("You do not have permission to view/edit this.");
					in.nextLine();
					continue;
				}
				
				facade.updateSession(choice);
				displaySessionInformation();
				continue;
        	}
		}
	}

	/**
	 * Displays a session object's instance variables, including theme, description, start date, end date,
	 * and cabins. You can go into cabins
	 */
	private void displaySessionInformation() {
		while(true) {			
			//updating options----------------------------------------
			clearOptions();
			options.add("Theme: " + facade.getSessionString(THEME));
			options.add("Session Descripton: " + facade.getSessionString(SESS_DESCR));
			options.add("Start Date: " + displayDate(facade.getSessionDate(START_DATE)));
			options.add("End Date: " + displayDate(facade.getSessionDate(END_DATE)));
			options.add("Cabins"); 
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Session Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}

			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Theme
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + THEME + ": " + facade.getSessionString(THEME));
					String change = setStringInformation(THEME);
					if(!(change == null)) {
						if(!facade.setSessionString(THEME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Session Description
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + SESS_DESCR + ": " + facade.getSessionString(SESS_DESCR));
					String change2 = setStringInformation(SESS_DESCR);
					if(!(change2 == null)) {
						if(!facade.setSessionString(SESS_DESCR, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					System.out.println("Sorry, somethig went wrong, unable to edit");
					break;

				case 2: //Start Date
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + START_DATE + ": " + displayDate(facade.getSessionDate(START_DATE)));
					Date date = setDateInformation(START_DATE);
					if(!(date == null)) {
						if(!facade.setSessionDate(START_DATE, date)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;

				case 3: //End Date
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					
					clear();
					System.out.println("Old " + END_DATE + ": " + displayDate(facade.getSessionDate(END_DATE)));
					Date date2 = setDateInformation(END_DATE);
					if(!(date2 == null)) {
						if(!facade.setSessionDate(END_DATE, date2)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;

				case 4: //Cabin List
					if(!(user instanceof Director)) {
						System.out.println("Sorry, you don't have permission to view this.");
						in.nextLine();
						break;
					}
				
					displayCabinList();
					break;
			}
		}
	}

	/**
	 * Displays the array list of cabins inside the session object.
	 * The cabin shows the cabin number and also the age range of campers in that cabin.
	 */
	private void displayCabinList() {
		ArrayList<Cabin> cabins = facade.getSessionCabinList();
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < cabins.size(); i++) {
				options.add("Cabin " + (i + 1) + ": " + cabins.get(i).toString()); 
			}
			options.add("Add a new Cabin");
			options.add("Remove an existing Cabin");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Cabins *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Cabin
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which cabin do you want to delete?");
				int num = getNum();
				if(0 > num || num >= cabins.size()) {
					System.out.println("Not a valid number");
					in.nextLine();
					continue;
				}
				else if(!facade.removeSessionCabin(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				System.out.println("Removing Cabin");
				continue;
			}

			if(choice == options.size() -4) { //the user wants to add a Cabin
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}
				
				clear();
				System.out.println("Would you like to create a new cabin or add a pre-existing cabin? (enter 1 or 2 respectively)");
				if(getNum() + 1 == 1) { //user wants to create a new cabin
					createCabin();
					continue;
				}
				else {
					ArrayList<Cabin> allCabins = facade.getAllCabins();
					for(int i = 0; i < allCabins.size(); i++) {
						System.out.println("Cabin " + (i + 1) + ": " + allCabins.get(i) + "\n");
					}
					System.out.println("\nWhich cabin are you adding to this session?");
					int choice2 = getNum();
					if(0 > choice2 || choice2 >= allCabins.size()) {
						System.out.println("This is not a valid number");
						in.nextLine();
					}
					else if(!facade.addSessionCabin(allCabins.get(choice2))) {
						System.out.println("Something went wrong, unable to add");
						in.nextLine();
					}
					continue;
				}

			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing cabin
				if(!(user instanceof Director)) {
					System.out.println("You do not have permission to view this");
					in.nextLine();
					continue;
				}
				
				facade.updateCabin(choice);
				displayCabinInformation();
				continue;
        	}
		}
	}

	/**
	 * Displays a cabin object's instance variables, including min age, max age, number of beds, 
	 * the counselor for this cabin, the campers in the cabin, and the schedule. You can go
	 * into campers and schedule
	 */
	private void displayCabinInformation() {
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			options.add("Miumum age: " + facade.getCabinInt(MIN_AGE));
			options.add("Maximum age: " + facade.getCabinInt(MAX_AGE));
			options.add("Counselor: " + facade.getCabinCounselor());
			options.add("Campers");
			options.add("Schedule");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //min age
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + MIN_AGE + ": " + facade.getCabinInt(MIN_AGE));
					int num = setIntInformation(MIN_AGE);
					if(!(num == -1)) {
						if(!facade.setCabinInt(MIN_AGE, num)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //max age
					if(!(user instanceof Director)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + MAX_AGE + ": " + facade.getCabinInt(MAX_AGE));
					int num2 = setIntInformation(MAX_AGE);
					if(!(num2 == -1)) {
						if(!facade.setCabinInt(MAX_AGE, num2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //counselor				
					if(!(user instanceof Director)) {
						System.out.println("You don't have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					if(facade.getCabinCounselor() == null) {
						System.out.println("Would you like to add a cousnelor? (y/n)");
					}
					else {
						System.out.println(facade.getCabinCounselor().toString());
						System.out.println("would you like to change the counselor? (y/n)");
					}
					
					if(in.nextLine().equalsIgnoreCase("y")) {
						ArrayList<Counselor> counselors = facade.getAllCounselors();
						for(int i = 0; i < counselors.size(); i++) {
							System.out.print((i + 1) + ": " + counselors.get(i) + "\n");
						}
						System.out.println("\nWhich Cousnelor are you putting into this cabin?");
						int choice2 = getNum();
						if(0 > choice2 || choice2 >= counselors.size()) {
							System.out.println("This is not a valid number");
							in.nextLine();
						}
						else if(!facade.setCabinCounselor(counselors.get(choice2))) {
							System.out.println("Something went wrong, unable to add");
							in.nextLine();
						}
					}
					break;
				
				case 3: //campers
					displayCamperList(CABIN);
					break;

				case 4: //schedule
					displayScheduleDays();
					break;
			}
		}
	}

	/**
	 * Displays the days of the week for the user to choose from to see that specific cabin's schedule
	 */
	private void displayScheduleDays() {
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			options.add("Monday");
			options.add("Tuesday");
			options.add("Wednesday");
			options.add("Thursday");
			options.add("Friday");
			options.add("Saturday");
			options.add("Sunday");
			options.add("Return");
			options.add("Quit");
			
			//printing choices and getting choice----------------------------------------
			clear();			
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			
			switch(choice) {
				case 0:
					displaySchedule(Day.MONDAY);
					break;
				
				case 1:
					displaySchedule(Day.TUESDAY);
					break;
				
				case 2:
					displaySchedule(Day.WEDNESDAY);
					break;
				
				case 3:
					displaySchedule(Day.THURSDAY);
					break;
				
				case 4:
					displaySchedule(Day.FRIDAY);
					break;
				
				case 5:
					displaySchedule(Day.SATURDAY);
					break;
				
				case 6:
					displaySchedule(Day.SUNDAY);
					break;
			}

		}
	}

	/**
	 * Displays the schedule of a specific day for a specific cabin
	 * @param day the day of the schedule being displayed
	 */
	private void displaySchedule(Day day) {
		facade.updateSchedule(day);
		HashMap<String, String> schedule = facade.getSchedule();
		
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < schedule.size(); i++) {
				options.add(times[i] + " " + schedule.get(times[i]));
			}
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			ArrayList<String> activities = facade.getCampActivities();
			switch(choice) {
				case 0: //wake up
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;
				
				case 1: //breakfast
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;
				
				case 2: //activity 1
					if(!(user instanceof Director)) {
						System.out.println("Sorry, you do not have permission to edit this.");
						in.nextLine();
						break;
					}

					clear();
					System.out.println(options.get(choice));
					System.out.println("would you like to change the activity? (y/n)");
					if(in.nextLine().equalsIgnoreCase("y")) {
						for(int i = 0; i < activities.size(); i++) {
							System.out.print((i + 1) + ": " + activities.get(i) + "\n");
						}
						System.out.println("\nWhich Activity are you putting into this time slot?");
						int choice2 = getNum();
						if(0 > choice2 || choice2 >= activities.size()) {
							System.out.println("Not a valid number");
							in.nextLine();
						}
						else if(!facade.addScheduleActivity(times[choice], activities.get(choice2))) {
							System.out.println("Something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //lunch
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;

				case 4: //activity 2
					if(!(user instanceof Director)) {
						System.out.println("Sorry, you do not have permission to edit this.");
						in.nextLine();
						break;
					}

					clear();
					System.out.println(options.get(choice));
					System.out.println("would you like to change the activity? (y/n)");
					if(in.nextLine().equalsIgnoreCase("y")) {
						for(int i = 0; i < activities.size(); i++) {
							System.out.print((i + 1) + ": " + activities.get(i) + "\n");
						}
						System.out.println("\nWhich Activity are you putting into this time slot?");
						int choice2 = getNum();
						if(0 > choice2 || choice2 >= activities.size()) {
							System.out.println("Not a valid number");
							in.nextLine();
						}
						else if(!facade.addScheduleActivity(times[choice], activities.get(choice2))) {
							System.out.println("Something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 5: //afternoon snack
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;

				case 6: //activity 3
					if(!(user instanceof Director)) {
						System.out.println("Sorry, you do not have permission to edit this.");
						break;
					}

					clear();
					System.out.println(options.get(choice));
					System.out.println("would you like to change the activity? (y/n)");
					if(in.nextLine().equalsIgnoreCase("y")) {
						for(int i = 0; i < activities.size(); i++) {
							System.out.print((i + 1) + ": " + activities.get(i) + "\n");
						}
						System.out.println("\nWhich Activity are you putting into this time slot?");
						int choice2 = getNum();
						if(0 > choice2 || choice2 >= activities.size()) {
							System.out.println("Not a valid number");
							in.nextLine();
						}
						else if(!facade.addScheduleActivity(times[choice], activities.get(choice2))) {
							System.out.println("Something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 7: //dinner
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;

				case 8: //evening activity
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;

				case 9: //lights out
					System.out.println("Sorry, you do not have permission to edit this.");
					in.nextLine();
					break;
			}
		}		
	}

	/**
	 * Displays the user portal for a director, including name, email, phone, and password
	 */
	private void displayDirectorPortal() {
		while(true) {
			//updating options----------------------------------------
			facade.updateDirector();
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE));
			options.add("Password: " + facade.getUserString(PASSWORD));			
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** User Portal (Director) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!(change == null)) {
						if(!facade.setUserString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
			}	
		}
	}

	/**
	 * Displays the user portal for a counselor, including name, email, phone, password,
	 * bio, birthday, allergies, a session-cabin hash, and emergency contacts. 
	 * You can go into allergies, session-cabin hash, and emergency contacts.
	 */
	private void displayCounselorPortal() {
		while(true) {
			//updating options----------------------------------------
			facade.updateCounselor();
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE));
			options.add("Password: " + facade.getUserString(PASSWORD));
			options.add("Bio: " + facade.getCounselorString(BIO));
			options.add("Birthday: " + displayDate(facade.getCounselorDate(BIRTHDAY)));
			options.add("Allergies");
			options.add("Sessions");
			options.add("Emergency Contacts");			
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** User Portal (Counselor) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!(change == null)) {
						if(!facade.setUserString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 4: //bio
					clear();
					System.out.println("Old " + BIO + ": " + facade.getCounselorString(BIO));
					String change5 = setStringInformation(BIO);
					if(!(change5 == null)) {
						if(!facade.setCounselorString(BIO, change5)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 5: //birthday
					clear();
					System.out.println("Old " + BIRTHDAY + ": " + displayDate(facade.getCounselorDate(BIRTHDAY)));
					Date date = setDateInformation(BIRTHDAY);
					if(!(date == null)) {
						if(!facade.setCounselorDate(BIRTHDAY, date)) {
							System.out.println("Sorry, something when wrong, unable to edit");
						}
					}
					break;
				
				case 6: //Allergies
					displayAllergyList(COUNSELOR);
					break;

				case 7: //sessionns
					displaySessionHash(COUNSELOR);
					break;
				
				case 8: //emergency contacts
					displayEmergencyContactHash(COUNSELOR);
					break;
			}
		}
	}

	/**
	 * Displays the user portal for a guardian, including name, email, phone, password,
	 * session number, price to pay, and camperlist. You can go into camper list.
	 */
	private void displayGuardianPortal() {
		while(true) {
			//updating options----------------------------------------
			facade.updateGuardian();
			clearOptions();
			options.add("Name: " + facade.getUserString(NAME));
			options.add("Email: " + facade.getUserString(EMAIL));
			options.add("Phone: " + facade.getUserString(PHONE)); //doesn't get the phone number for some reason?
			options.add("Password: " + facade.getUserString(PASSWORD));
			options.add("Total Number of Sessions Signed Up for: " + facade.getGuardianInt(SESS_NUM));
			options.add("Price for your children(s)' sessions: $" + facade.getGuardianDouble(PRICE));
			options.add("Camper(s) Profile");	
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** User Portal (Guardian) *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Name					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getUserString(NAME));
					String change = setStringInformation(NAME);
					if(!(change == null)) {
						if(!facade.setUserString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //Email				
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getUserString(EMAIL));
					String change2 = setStringInformation(EMAIL);
					if(!(change2 == null)) {
						if(!facade.setUserString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //Phone
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getUserString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3 == null)) {
						if(!facade.setUserString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //password
					clear();
					System.out.println("Old " + PASSWORD + ": " + facade.getUserString(PASSWORD));
					String change4 = setStringInformation(PASSWORD);
					if(!(change4 == null)) {
						if(!facade.setUserString(PASSWORD, change4)) {
							System.out.println("Sorry, something when wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 4:
					System.out.println("There is no way to edit this");
					in.nextLine();
					break;

				case 5: //price
					System.out.println("There is no way to edit this");
					in.nextLine();
					break;

				case 6:
					displayCamperList(GUARDIAN);
					break;
			}
		}
	}

	/**
	 * Displays a list of campers. This can either come from a cabin or a guardian. 
	 * @param classFrom the class that the camper list is coming from, either GUARDIAN or CABIN
	 */
	private void displayCamperList(String classFrom) {
		ArrayList<Camper> campers = new ArrayList<Camper>();
		
		if(classFrom.equals(GUARDIAN)) {
			campers = facade.getGuardianCamperList();
		}
		else if(classFrom.equals(CABIN)) {
			campers = facade.getCabinCamperList();
		}
		else {
			System.out.println("Something went wrong");
			return;
		}
		
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < campers.size(); i++) {
				options.add(campers.get(i).toString()); 
			}
			options.add("Add a new Camper");
			options.add("Remove an existing Camper");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Campers *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a Camper
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which camper do you want to delete?");
				int num = getNum();
				if(0 > num || num >= campers.size()) {
					System.out.println("Not a valid number");
					in.nextLine();
					continue;
				}
				if(!facade.removeGuardianCamper(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				System.out.println("Removed Camper");
				continue;
			}

			if(choice == options.size() -4) { //the user wants to add a Camper
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}
				createCamper();
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing Camper
				facade.updateCamper(classFrom, choice);
				displayCamperProfile();
				continue;
        	}
		}
	}

	/**
	 * Displays a camper object's instance variables, including name, birthday, medications, allergies,
	 * a session-cabin hash, and emergency contacts. You can go into everything after birthday.
	 */
	private void displayCamperProfile() {
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			options.add("Name: " + facade.getCamperString(NAME));
			options.add("Birthday: " + displayDate(facade.getCamperDate(BIRTHDAY)));
			options.add("Medications");
			options.add("Allergies");
			options.add("Sessions");
			options.add("Emergency Contacts");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //Name
					if(!(user instanceof Guardian)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
				
					clear();
					System.out.println("Old " + NAME + ": " + facade.getCamperString(NAME));
					String change = setStringInformation(NAME);
					if(!(change == null)) {
						if(!facade.setCamperString(NAME, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;
				
				case 1: //Birthday
					if(!(user instanceof Guardian)) { 
						System.out.println("You do not have permission to edit this.");
						break;
					}
			
					clear();
					System.out.println("Old " + BIRTHDAY + ": " + displayDate(facade.getCamperDate(BIRTHDAY)));
					Date date = setDateInformation(BIRTHDAY);
					if(date == null) {
						if(!facade.setCamperDate(BIRTHDAY, date)) {
							System.out.println("Sorry, something went wrong, unable to edit");
						}
					}
					break;

				case 2: //Medications
					displayMedicationList();
					break;

				case 3: //allergies
					displayAllergyList(CAMPER);
					break;

				case 4: //Sessions
					displaySessionHash(CAMPER);
					break;

				case 5: //Emergency Contacts
					displayEmergencyContactHash(CAMPER);
					break;
					
			}
		}
	}

	/**
	 * Displays a list of medications in a camper object
	 */
	private void displayMedicationList() {
		ArrayList<Medication> medications = facade.getCamperMedicationList();
		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < medications.size(); i++) {
				options.add(medications.get(i).toString()); 
			}
			options.add("Add a new Medication");
			options.add("Remove an existing Medication");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Medications *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			if(choice == options.size() - 3) { //the user wants to remove a medication
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which medication do you want to delete?");
				int num = getNum();
				if(0 > num || num >= medications.size()) {
					System.out.println("Not a valid number");
					in.nextLine();
					continue;
				}
				else if(!facade.removeCamperMedication(choice)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				System.out.println("Removed medication");
				continue;
			}

			if(choice == options.size() -4) { //the user wants to add a Medication
				if(!(user instanceof Guardian)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}
				createMedication();
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit/view a pre-existing Medication
				facade.updateMedication(choice);
				displayMedication();
				continue;
        	}
		}
	}

	/**
	 * Displays a medication object's instance variables, including dose, time, and type.
	 */
	private void displayMedication() {
		while(true) {
			//updating options and Camp object----------------------------------------
			clearOptions();
			options.add("Type: " + facade.getMedicationString(TYPE));
			options.add("Time: " + facade.getMedicationString(TIME));
			options.add("Dose: " + facade.getMedicationString(DOSE));
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Medication Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //the user chose type
					if(!(user instanceof Guardian)) { 
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + TYPE + ": " + facade.getMedicationString(TYPE));
					String change = setStringInformation(TYPE);
					if(!change.isEmpty()) {
						if(!facade.setMedicationString(TYPE, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //the user chose time
					if(!(user instanceof Guardian)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + TIME + ": " + facade.getMedicationString(TIME));
					String change2 = setStringInformation(TIME);
					if(!(change2.isEmpty())) {
						if(!facade.setMedicationString(TIME, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //the user chose dose
					if(!(user instanceof Guardian)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
				
					clear();
					System.out.println("Old " + DOSE + ": " + facade.getMedicationString(DOSE));
					String change3 = setStringInformation(DOSE);
					if(!(change3.isEmpty())) {
						if(!facade.setMedicationString(DOSE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
			}
		}
	}

	/**
	 * Displays a session hash about either from campers or counselors
	 * @param classFrom the class the session-cabin hash is coming from, either CAMPER or COUNSELOR
	 */
	private void displaySessionHash(String classFrom) {
		HashMap<Session, Cabin> cabinHash;
		if(classFrom.equals(CAMPER)) {
			cabinHash = facade.getCamperCabinHash();
		}
		else if (classFrom.equals(COUNSELOR)) {
			cabinHash = facade.getCounselorCabinHash();
		}
		else {
			System.out.println("Something went wrong)");
			return;
		}

		while(true) {
			//updating options----------------------------------------
			clearOptions();
			
			for (Map.Entry<Session, Cabin> entry : cabinHash.entrySet()) {
				Session session = entry.getKey();
				Cabin cabin = entry.getValue();
				options.add("Session " + session.getTheme() + ": Cabin" + cabin.toString());
			}

			options.add("Add a new Session");
			options.add("Remove an existing Session");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Session, Cabin Hash *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove a Session
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which Session do you want to delete (enter the theme)?");
				String theme = in.nextLine();
				if(user instanceof Guardian && !facade.removeCamperSession(theme)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				if(user instanceof Counselor && !facade.removeCounselorSession(theme)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				continue;
			}
			
			if(choice == options.size() -4) { //the user wants to add a Session
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				facade.updateCamp();
				ArrayList<Session> sessions = facade.getCampSessions();
				for(int i = 0; i < sessions.size(); i++) {
					System.out.println(sessions.get(i).toString());
				}
				System.out.println("Enter the theme of the session you would like to add:");
				String theme = in.nextLine();
				if(user instanceof Guardian && !facade.addCamperSession(theme)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				if(user instanceof Counselor && !facade.addCounselorSession(theme)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to view the cabin
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which Session's cabin do you want to view? (enter the session theme)");
				String theme = in.nextLine();				
				facade.updateCabinHash(theme);
				displayCabinInformation();
        	}
		}
	}

	/**
	 * Displays an allergy list of either a counselor or camper
	 * @param classFrom the class the allergy list is coming from, either CAMPER or COUNSELOR
	 */
	private void displayAllergyList(String classFrom) {
		ArrayList<String> allergies = new ArrayList<String>();
		if(classFrom.equals(CAMPER)) {
			allergies = facade.getCamperAllergyList();
		}
		else if (classFrom.equals(COUNSELOR)) {
			allergies = facade.getCounselorAllergyList();
		}
		else {
			System.out.println("Something went wrong)");
			return;
		}

		while(true) {
			//updating options----------------------------------------
			clearOptions();
			for(int i = 0; i < allergies.size(); i++) {
				options.add(allergies.get(i));
			}
			options.add("Add a new Allergy");
			options.add("Remove an existing Allergy");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Camp Allergies *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove an Allergy
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which allergy do you want to delete?");
				int num = getNum();
				if(0 > num || num >= allergies.size()) {
					System.out.println("Not a valid number");
					in.nextLine();
					continue;
				}
				else if(user instanceof Guardian && !facade.removeCamperAllergy(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				else if(user instanceof Counselor && !facade.removeCounselorAllergy(num)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				continue;
			}
			
			if(choice == options.size() -4) { //the user wants to add an allergy
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("What allergy do you want to add?");
				String allergy = in.nextLine();
				if(user instanceof Guardian && !facade.addCamperAllergy(allergy)) {
					System.out.println("Something went wrong, unable to add");
					in.nextLine();
				}
				else if(user instanceof Counselor && !facade.addCounselorAllergy(allergy)) {
					System.out.println("Something went wrong, unable to add");
					in.nextLine();
				}
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing allergy
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				if(user instanceof Guardian) {
					System.out.println(facade.getCamperAllergyList().get(choice));
					String change = setStringInformation(ALLERGIES);
					if(!facade.setCamperAllergy(choice, change)) {
						System.out.println("Something went wrong, unable to edit");
						in.nextLine();
					}
					continue;
				}
				else if(user instanceof Counselor) {
					System.out.println(facade.getCounselorAllergyList().get(choice));
					String change = setStringInformation(ALLERGIES);
					if(!facade.setCounselorAllergy(choice, change)) {
						System.out.println("Something went wrong, unable to edit");
						in.nextLine();
					}
					continue;
				}
				else {
					System.out.println("Something went wrong");
					in.nextLine();
				}
				continue;
        	}
		}
	}

	/**
	 * Displays the emergency contact hash of either a counselor or camper
	 * @param classFrom the class the emergency contact hash is coming from, either CAMPER or COUNSELOR
	 */
	private void displayEmergencyContactHash(String classFrom) {
		HashMap<String, Contact> eContacts;
		if(classFrom.equals(CAMPER)) {
			eContacts = facade.getCamperContactHash();
		}
		else if (classFrom.equals(COUNSELOR)) {
			eContacts = facade.getCounselorContactHash();
		}
		else {
			System.out.println("Something went wrong)");
			return;
		}

		while(true) {
			//updating options----------------------------------------
			clearOptions();
			Object[] key = eContacts.keySet().toArray();
			for(int i = 0; i < eContacts.size(); i++) {
				options.add(key[i].toString() + ": " + eContacts.get(key[i].toString()));
			}
			options.add("Add a new Emergency Contact");
			options.add("Remove an existing Emergency Contact");
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Emergency Contacts *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}
			if(choice == options.size() - 3) { //the user wants to remove an Emergency Contact
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which Emergency Contact do you want to delete (enter the relationship)?");
				String relationship = in.nextLine();
				if(user instanceof Guardian && !facade.removeCamperContact(relationship)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				if(user instanceof Counselor && !facade.removeCounselorContact(relationship)) {
					System.out.println("Something went wrong, unable to remove");
					in.nextLine();
					continue;
				}
				continue;
			}
			
			if(choice == options.size() -4) { //the user wants to add an Emergency 
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				createContact();
				continue;
			}

			if(choice >= 0 && choice < options.size() - 4) { //the user wants to edit a pre-existing allergy
				if(!(classFrom.equals(CAMPER) && user instanceof Guardian) && !(classFrom.equals(COUNSELOR) && user instanceof Counselor)) {
					System.out.println("You do not have permission to edit this.");
					in.nextLine();
					continue;
				}

				System.out.println("Which Emergency Contact do you want to edit (enter the relationship)?");
				String relationship = in.nextLine();
				if(!facade.updateContacts(relationship)) {
					System.out.println("Not a valid relationship");
					continue;
				}
				displayContact();
        	}
		}
	}

	/**
	 * Displays a contact object's instance variable, including name, email, and phone
	 */
	private void displayContact() {
		while(true) {
			//updating options and Camp object----------------------------------------
			clearOptions();
			options.add("Name: " + facade.getContactString(NAME));
			options.add("Email: " + facade.getContactString(EMAIL));
			options.add("Phone: " + facade.getContactString(PHONE));
			options.add("Address: " + facade.getContactString(ADDRESS));
			options.add("Return");
			options.add("Quit");

			//printing choices and getting choice----------------------------------------
			clear();
			System.out.println("***** Contact Information *****");
			int choice = getChoice();
			if(choice == -1) {
				continue;
			}
			
			//doing what the user chose----------------------------------------
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				//facade.save();;
				System.exit(0);
			}
			
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			switch(choice) {
				case 0: //the user chose type
					if(!(user instanceof Guardian) && !(user instanceof Counselor)) { 
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + NAME + ": " + facade.getContactString(NAME));
					String change = setStringInformation(NAME);
					if(!change.isEmpty()) {
						if(!facade.setContactString(TYPE, change)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
				
				case 1: //the user chose time
					if(!(user instanceof Guardian) && !(user instanceof Counselor)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
					
					clear();
					System.out.println("Old " + EMAIL + ": " + facade.getContactString(EMAIL));
					String change2 = setStringInformation(TIME);
					if(!(change2.isEmpty())) {
						if(!facade.setContactString(EMAIL, change2)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 2: //the user chose dose
					if(!(user instanceof Guardian) && !(user instanceof Counselor)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
				
					clear();
					System.out.println("Old " + PHONE + ": " + facade.getContactString(PHONE));
					String change3 = setStringInformation(PHONE);
					if(!(change3.isEmpty())) {
						if(!facade.setContactString(PHONE, change3)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;

				case 3: //the user chose address
					if(!(user instanceof Guardian) && !(user instanceof Counselor)) {
						System.out.println("You do not have permission to edit this.");
						in.nextLine();
						break;
					}
				
					clear();
					System.out.println("Old " + ADDRESS + ": " + facade.getContactString(ADDRESS));
					String change4 = setStringInformation(ADDRESS);
					if(!(change4.isEmpty())) {
						if(!facade.setContactString(ADDRESS, change4)) {
							System.out.println("Sorry, something went wrong, unable to edit");
							in.nextLine();
						}
					}
					break;
			}
		}
	}


	//------------------------------------------- Creating new objects ----------------------------------------------------------------------------------

	/**
	 * Creates an faq object
	 */
	private void createFAQ() {
		System.out.println("What is the question of the new faq?");
		String question = in.nextLine();
		System.out.println("What is the answer of the new faq?");
		String answer = in.nextLine();
		if(!facade.addCampFAQ(question, answer)) {
			System.out.println("Something went wrong, unable to add");
			in.nextLine();
		}
	}

	/**
	 * Creates a Session object
	 */
	private void createSession() {
		System.out.println("What would you like the theme to be?");
		String theme = in.nextLine();
		System.out.println("What would you like the session description to be?");
		String description = in.nextLine();
		System.out.println("What would you like the start date to be?");
		Date startDate = getDate(in.nextLine());
		System.out.println("What would you like the end date to be?");
		Date endDate = getDate(in.nextLine());
		if(!facade.addCampSession(theme, description, startDate, endDate)) {
			System.out.println("Something went wrong, unable to add");
			in.nextLine();
		}
	}
	
	/**
	 * Creates a cabin object
	 */
	private void createCabin() {
		System.out.println("Enter the minimum age for the cabin: ");
		int minAge = getNum() + 1;
		System.out.println("Enter the maximum age for the cabin: ");
		int maxAge = getNum() + 1;
		if(!facade.addSessionCabin(minAge, maxAge)) {
			System.out.println("Something went wrong, unable to add");
			in.nextLine();
		}
	}

	/*
	 * Creates a camper object
	 */
	private void createCamper() {
		System.out.println("Enter the name of the camper: ");
		String name = in.nextLine();
		System.out.println("Enter the birthday of the camper: (MM/DD/YYYY) ");
		Date birthday = getDate(in.nextLine());
		if(!facade.addGuardianCamper(name, birthday)) {
			System.out.println("Something went wrong");
			in.nextLine();
		}
	}

	/*
	 * Creates a contact object
	 */
	private void createContact() {
		System.out.println("Enter the relationship: ");
		String relationship = in.nextLine();
		System.out.println("Enter the name for the contact: ");
		String name = in.nextLine();
		System.out.println("Enter the phone number for the contact: ");
		String phone = in.nextLine();
		System.out.println("Enter the email for the contact: ");
		String email = in.nextLine();
		System.out.println("Enter the address of the contact: ");
		String address = in.nextLine();
		if(!facade.addCamperContact(relationship, name, email, phone, address)) {
			System.out.println("Something went wrong");
			in.nextLine();
		}
	}

	/*
	 * Creates a medication object
	 */
	private void createMedication() {
		System.out.println("Enter the dose for the medication: ");
		String dose = in.nextLine();
		System.out.println("Enter the type for the medication: ");
		String type = in.nextLine();
		System.out.println("Enter the number of beds for the cabin: ");
		String time = in.nextLine();
		if(!facade.addCamperMedication(dose, type, time)) {
			System.out.println("Something went wrong");
			in.nextLine();
		}
	}

	//------------------------------------------- Methods that change an instance variable/array list ----------------------------------------------
	/**
	 * User inputs a new string to replace a string variable and verifies the change
	 * @param variableName the instance variable being edited
	 * @return the new string to input into the variableName, null if not verified
	 */
	private String setStringInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		String change = in.nextLine();	
		
		System.out.println("You would like to change it to " + change);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return change;
		}
		System.out.println("The " + variableName + " will not be changed");
		return null;	
	}

	/**
	 * User inputs a new int to replace an int variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new int to input into the variableName, -1 if not a valid int/not verified
	 */
	private int setIntInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		int num = getNum() + 1;
		
		System.out.println("You would like to change it to " + num);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return num;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return -1;		
	}

	/**
	 * User inputs a new double to replace a double variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new double to input into the variableName, -1 if not a valid double/ not verified
	 */
	private double setDoubleInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		double doub;
		try {
			doub = Double.parseDouble(in.nextLine());
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}
		
		System.out.println("You would like to change it to " + doub);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return doub;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return -1;		
	}

	/**
	 * User inputs a new date to replace a date variable and verifies the change
	 * @param type the instance variable being edited
	 * @return the new date to input into the variableName, null if not valid
	 */
	private Date setDateInformation(String variableName) {
		System.out.print("Enter what you would like to change this to: ");
		Date date = getDate(in.nextLine());
		if(date == null) {
			System.out.println("Something went wrong");
			return null;
		}
		System.out.println("You would like to change it to " + displayDate(date));
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return date;
		}
		System.out.println("The " + variableName + " will not be changed.");
		return null;
	}

	//------------------------------------- Methods that deal with the array list, options, and the console ----------------------------------------------
	/**
	 * Clears the array list
	 */
	private void clearOptions() {
		options.clear();
	}

	/**
	 * Displays the options, and gets the user's input
	 * @return the user's choice
	 */
	private int getChoice() {
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		System.out.print("Enter the number of the option you would like to see/edit: ");

		int num = getNum();

		if (num < 0 || num > options.size() - 1) {
			clear();
			System.out.println("Sorry, your option is not in the valid range.\n");
			in.nextLine();
			return -1;
		}
		clear();
		return num;
	}

	/**
	 * User entered int minus 1 for arraylists
	 */
	private int getNum() {
		int num;
		try {
			num = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			in.nextLine();
			clear();
			return -1;
		}
		return num;
	}

	/**
	 * Converts a date to a string
	 * @param date the date to be converted
	 * @return the string version of the date
	 */
	private String displayDate(Date date) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormatter.format(date);
	}

	/**
	 * User entered Date
	 */
	private Date getDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			System.out.println("Sorry " + date + " is not parsable");
			return null;
		}
	}

    /**
	 * Clears the console
	 */
	private void clear() {
		System.out.print("\033[H\033[2J");
	}

    public static void main(String[] args) {
        CampDriver camp = new CampDriver();
        camp.runDriver();
    }
}

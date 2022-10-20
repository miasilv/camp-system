import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mia Silver
 * The Camp Driver (the front end of the system)
 */
public class CampDriver {
    private Scanner in;
	private ArrayList<String> options;
	private CampFacade facade;
	private User user;

	//Classes
	private static final String CAMP_INFORMATION = "campI";
    private static final String SESSION_INFORMATION = "sessI";
    private static final String CABIN_INFORMATION = "cabI";
    private static final String USER_INFORMATION = "userI";
    private static final String COUNSELOR_INFORMATION = "counI";
    private static final String MEDICATION_INFORMATION = "medI";
    private static final String CONTACT_INFORMATION = "contI";
    private static final String GUARDIAN_INFORMATION = "guardI";
    private static final String CAMPER_INFORMATION = "camperI";

	//camp instance variables
	private static final String NAME = "name"; //can also use for User, Camper, and Contact
	private static final String SESSIONS = "sessions"; //can also use for Camper
    private static final String PRICE = "price"; //can also use for Guardian
    private static final String RATIO = "ratio";
	private static final String FAQ = "faqs";
	private static final String ACTIVITIES = "activities";

	//FAQ instance variables
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	
	//session instance variables
	private static final String CABINs = "cabins"; //can also use for Counselor and Camper
	private static final String SESS_NUM = "sessNum"; //can also be used in Guardian
	private static final String START_DATE = "startD";
	private static final String END_DATE = "endD";

	//cabin instance variables
	private static final String CAMPER = "campers"; //can also use for Guardian
	private static final String COUNSELOR = "counselor";
	private static final String SCHEDULE = "schedule"; //can also use for schedule class

	//user instance variables
	private static final String EMAIL = "email"; //can also be used for Contact
	private static final String PHONE = "phoneNum"; //can also be used for Contact
	private static final String PASSWORD = "password";

	//counselor instance variables
	private static final String BIO = "bio";
	private static final String EMERGENCY_CONTACTS = "emergenCon"; //can also be used for Camper
	private static final String BIRTHDAY = "birthday"; //can also be used for Camper
	private static final String ALLERGIES = "allergies"; //can also be used for Camper

	//camper instance variables
	private static final String MEDICATION = "medication";

	//contact instance variables
	private static final String RELATIONSHIP = "relationship";

    /**
	 * Constructs a new driver
	 */
	public CampDriver() {
        in = new Scanner(System.in); 
		options = new ArrayList<String>();
		facade = new CampFacade();
    }

    /**
	 * Runs the driver
	 */
	public void runDriver() {
        clear();
        System.out.println("***** Welcome to the Camp Website! *****");

        while(true) {
			displayHomeScreen();
        }
    }

	/**
	 * Displays the home screen and performs the loop for that screen
	 */
	private void displayHomeScreen() {
		while(true) {
			//updating options
			clearOptions();
			options.add("View Camp Information");
			options.add("Sign In");
			options.add("Quit");

			//displays choices and checks number
			System.out.println("***** Home Screen *****");
			int choice = getOptions();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) {
				System.out.println("Goodbye!");
				System.exit(0);
			}

			//switches between choices
			switch(choice) {
				case 0:
					displayCampInformation();
					break;
				case 1:
					signIn();
					break;
			}
		}
	}

	/**
	 * Displays the Camp Information and does the loop for that screen
	 */
	private void displayCampInformation() {
		while(true) {
			//updating options
			clearOptions();
			options.add("Name: " + facade.getInformation(CAMP_INFORMATION, NAME));
			options.add("Pricing: $" + facade.getInformation(CAMP_INFORMATION, PRICE) + " per session");
			options.add("Sessions Available:\n" + facade.getSessionList(CAMP_INFORMATION));
			options.add("Campers per Counselor: " + facade.getInformation(CAMP_INFORMATION, RATIO));
			options.add("FAQs:\n" + facade.getFAQList(CAMP_INFORMATION)); 
			options.add("Activities Offered:\n" + facade.getActivityList(CAMP_INFORMATION));
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			System.out.println("***** Camp Information *****");
			int choice = getOptions();
			if(choice == -1) {
				continue;
			}
			if(choice == options.size() - 1) { //the user chose quit
				System.out.println("Goodbye!");
				System.exit(0);
			}
			if(choice == options.size() - 2) { //the user chose return
				return;
			}

			//switches between choices
			switch(choice) {
				case 0:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editStringInformation(CAMP_INFORMATION, NAME);
					break;
				case 1:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editDoubleInformation(CAMP_INFORMATION, PRICE);
					break;
				case 2:
					//TODO sessions
				case 3:
					if(!(user instanceof Director)) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editIntInformation(CAMP_INFORMATION, RATIO);
					break;
				case 4:
					//TODO FAQs
					
			}
		}
	}

	/**
	 * Sign in display
	 */
	private void signIn() {
		clear();
		System.out.print("Enter your email: ");
		System.out.print("Enter your password: ");
	}

	/**
	 * Edits a class' String instance varaible.
	 * @param className the class in which the String instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editStringInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");
		String change = in.nextLine();		
		
		if(verify(change)) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Edits a class' int instance varaible.
	 * @param className the class in which the int instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editIntInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");	
		
		int change;
		try {
			change = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return;
		}
		clear();
		
		if(verify(Integer.toString(change))) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Edits a class' double instance varaible.
	 * @param className the class in which the double instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editDoubleInformation(String className, String variableName) {
		System.out.println("Old" + variableName + ": " + facade.getInformation(className, variableName));
		System.out.print("Enter what you would like to change this to: ");	
		
		double change;
		try {
			change = Double.parseDouble(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return;
		}
		clear();
		
		if(verify(Double.toString(change))) {
			facade.editInformation(className, variableName, change);
			System.out.println("New" + variableName + ": " + facade.getInformation(className, variableName));
			return;
		}
		System.out.println("The " + variableName + " will not be changed.");		
	}

	/**
	 * Verifies that the input is what the user wants to change it to
	 * @param change the new input
	 * @return true if it is correct, false if it is not correct
	 */
	private boolean verify(String change) {
		System.out.println("You would like to change it to " + change);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Clears the array list
	 */
	private void clearOptions() {
		options.clear();
	}

	/**
	 * Prints the array list and gets the user's choice
	 * @return the user's choice
	 */
	private int getOptions() {
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}

		System.out.print("Enter the number of the option you would like to see: ");
		int num;

		try {
			num = Integer.parseInt(in.nextLine()) - 1;
		} catch (Exception e) {
			System.out.println("You need to enter a valid number\n");
			clear();
			return -1;
		}
		clear();

		if (num < 0 || num > options.size() - 1) {
			clear();
			System.out.println("Sorry, your option is not in the valid range.\n");
			return -1;
		}
		return num;
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

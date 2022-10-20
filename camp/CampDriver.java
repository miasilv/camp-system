import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Mia Silver
 * The Camp Driver (the front end of the system)
 */
public class CampDriver {
    private Scanner in;
	private ArrayList<String> options;
	private CampFacade facade;
	private User user;

	private static final String CAMP_INFORMATION = "CampI";
    private static final String SESSION_INFORMATION = "SessI";
    private static final String CABIN_INFORMATION = "CabI";
    private static final String USER_INFORMATION = "UserI";
    private static final String COUNSELOR_INFORMATION = "CounI";
    private static final String MEDICATION_INFORMATION = "MedI";
    private static final String CONTACT_INFORMATION = "ContI";
    private static final String GUARDIAN_INFORMATION = "GuardI";
    private static final String CAMPER_INFORMATION = "CamperI";

	private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String RATIO = "ratio";

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
			homeScreen();
        }
    }

	/**
	 * Displays the home screen and does the loop for that screen
	 */
	private void homeScreen() {
		while(true) {
			//updating options
			clearOptions();
			options.add("View Camp Information");
			options.add("Sign In");
			options.add("Quit");

			//displays choices and checks number
			System.out.println("***** Home Screen *****");
			printOptions();
			int choice = getNum();
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
			options.add("Return");
			options.add("Quit");

			//displays choices and checks number
			System.out.println("***** Camp Information *****");
			printOptions();
			int choice = getNum();
			if(choice == -1) {
				continue;
			}
			//if it is quit
			if(choice == options.size() - 1) {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			//if it is return
			if(choice == options.size() - 2) {
				return;
			}

			//switches between choices
			switch(choice) {
				case 0:
					if(!user.isDirector()) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editInformation(CAMP_INFORMATION, NAME);
					break;
				case 1:
					if(!user.isDirector()) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editInformation(CAMP_INFORMATION, PRICE);
					break;
				case 2:
					//TODO sessions
				case 3:
					if(!user.isDirector()) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editInformation(CAMP_INFORMATION, RATIO);
					break;
				case 4:
					//TODO FAQs
					
			}
		}
	}

	/**
	 * Edits a class' instance varaible.
	 * @param className the class in which the instance variable is located
	 * @param type the instance variable being edited
	 */
	private void editInformation(String className, String variableName) {
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
	 * Sign in
	 */
	private void signIn() {
		//TODO
	}

	/**
	 * Clears the array list
	 */
	private void clearOptions() {
		options.clear();
	}

	/**
	 * Prints the array list and asks for a number
	 */
	private void printOptions() {
		for(int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}

		System.out.print("Enter the number of the option you would like to see: ");
	}

    /**
	 * Clears the console
	 */
	private void clear() {
		System.out.print("\033[H\033[2J");
	}

    /**
	 * Gets a number from the user, used to get their option.
     * @return A number between 0 and the size of options - 1 correspoinding to their option
	 */
	private int getNum() {
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

    public static void main(String[] args) {
        CampDriver camp = new CampDriver();
        camp.runDriver();
    }
}

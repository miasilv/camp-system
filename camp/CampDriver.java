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
			options.add("Name: " + facade.getCampInformation("name"));
			options.add("Pricing: $" + facade.getCampInformation("price") + " per session");
			options.add("Sessions Available:\n" + facade.getSessionList());
			options.add("Campers per Counselor: " + facade.getCampInformation("ratio"));
			options.add("FAQs:\n" + facade.getFAQList()); 
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
					editCampInformation("name");
					break;
				case 1:
					if(!user.isDirector()) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editCampInformation("price");
					break;
				case 2:
					//TODO sessions
				case 3:
					if(!user.isDirector()) {
						System.out.println("You do not have permission to edit this.");
						break;
					}
					editCampInformation("ratio");
					break;
				case 4:
					//TODO FAQs
					
			}
		}
	}

	/**
	 * Edits camp information based on type
	 * @param type the type of camp information you are editing
	 */
	private void editCampInformation(String type) {
		System.out.println("Old" + type + ": " + facade.getCampInformation(type));
		String change = changeInfo();
		if(!change.isEmpty()) {
			facade.editCampInformation(type, change);
			System.out.println("New" + type + ": " + facade.getCampInformation(type));
		}
	}

	/**
	 * Sign in
	 */
	private void signIn() {
		//TODO
	}

	/**
	 * Change Information
	 */
	private String changeInfo() {
		System.out.print("Enter what you would like to change this to: ");
		String change = in.nextLine();
		System.out.println("You would like to change it to " + change);
		System.out.print("Is this right? (y/n): ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return answer;
		}
		return "";
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

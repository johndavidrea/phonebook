// The Phonebook class contains the code for managing our console phonebook
// It contains the methods needed to receive and enact commands from the user
package phonebook;
import java.util.Scanner;

public class Phonebook {
    private final EntryList book;
    private final Scanner input;
    private boolean isRunning;

    public Phonebook() {
        book = new EntryList();
        input = new Scanner(System.in);
        start();
    }

    //Initializes the program and starts its main loop
    private void start() {
        isRunning = true;
        System.out.println("Welcome to the console phonebook!");
        System.out.println("You can call these commands by number or by name.");
        printHelp();
        while (isRunning) {
            getCommand();
        }
    }

    // Handles getting and interpreting main-menu commands from the user
    private void getCommand() {
        String buffer = input.nextLine();

        if (buffer.toLowerCase().contains("list") || buffer.toLowerCase().contains("1")) {
            listEntries();
        } else if (buffer.toLowerCase().contains("view") || buffer.toLowerCase().contains("2")) {
            viewEntry();
        } else if (buffer.toLowerCase().contains("add") || buffer.toLowerCase().contains("3")) {
            addEntry();
        } else if (buffer.toLowerCase().contains("remove") || buffer.toLowerCase().contains("4")) {
            removeEntry();
        } else if (buffer.toLowerCase().contains("modify") || buffer.toLowerCase().contains("5")) {
            modifyEntry();
        } else if (buffer.toLowerCase().contains("search") || buffer.toLowerCase().contains("6")) {
            search();
        } else if (buffer.toLowerCase().contains("help") || buffer.toLowerCase().contains("7")) {
            printHelp();
        } else if (buffer.toLowerCase().contains("exit") || buffer.toLowerCase().contains("8")) {
            System.out.println("Thanks for using the console phonebook. Goodbye!");
            isRunning = false;
            return;
        } else {
            System.out.println("Invalid selection, returning to main menu.");
        }
        System.out.println("What would you like to do next?");
    }

    // Lists the entries contained in the phonebook
    private void listEntries() {
        if (book.size() == 0) {
            System.out.println("The phonebook is currently empty.");
            return;
        }
        for (int i = 1; i <= book.size(); i++) {
            Entry buffer = book.get(i);
            System.out.println("Entry " + (i) + ": " + buffer.getFullName());
        }
    }

    // Handles viewing the full details about a specific entry
    private void viewEntry() {
        System.out.println("Which entry would you like to view?");
        listEntries();
        int index = getIndex();
        if (index == -1) {
            System.out.println("Invalid selection, returning to main menu.");
            return;
        }
        book.get(index).printEntry();
    }

    // Adds a new entry to the phonebook
    private void addEntry() {
        System.out.println("Adding a new entry to the phonebook.");
        System.out.println("Please enter the first name:");
        String firstName = input.nextLine();
        System.out.println("Please enter the last name:");
        String lastName = input.nextLine();
        System.out.println("Please enter the address:");
        String address = input.nextLine();
        System.out.println("Please enter the city:");
        String city = input.nextLine();
        System.out.println("Please enter the phone number:");
        String phoneNumber = input.nextLine();

        Entry buffer = new Entry(firstName, lastName, address, city, phoneNumber);
        System.out.println("New entry has been added:");
        buffer.printEntry();

        book.add(buffer);
    }

    // Removes an entry from the phonebook
    private void removeEntry() {
        // Have the user select which entry to remove, then verify that the selection is valid
        System.out.println("Which entry would you like to remove?");
        listEntries();
        int index = getIndex();
        if (index == -1) {
            System.out.println("Invalid selection.");
            return;
        }
        System.out.println(book.get(index).getFullName() + " has been selected.");
        System.out.println("Do you want to delete this entry? Yes/No");
        String confirmDeletion = input.nextLine();
        // Get confirmation from the user before deleting the entry
        if (confirmDeletion.toLowerCase().contains("yes")) {
            System.out.println(book.get(index).getFullName() + " has been removed from the phonebook.");
            book.remove(index);
        } else if (confirmDeletion.toLowerCase().contains("no")) {
            System.out.println("Good thing I added a double-check here then. :)");
        } else {
            System.out.println("Invalid selection, returning to main menu.");
        }
    }

    // Modifies an entry in the phonebook
    private void modifyEntry() {
        // Have the user select which entry to modify, then verify that the selection is valid
        System.out.println("Which entry would you like to modify?");
        listEntries();
        int index = getIndex();
        if (index == -1) {
            System.out.println("Invalid selection, returning to main menu.");
            return;
        }
        // Have the user decide which subfield to modify, then get the new value for that subfield
        System.out.println(book.get(index).getFullName() + " selected. Which subfield would you like to change?");
        listVarTypes();
        String buffer = input.nextLine();

        if (buffer.toLowerCase().contains("first") || buffer.toLowerCase().contains("1")) {
            System.out.println("Please choose a new first name:");
            book.get(index).setFirstName(input.nextLine());
            System.out.println("The first name has been changed to: " + book.get(index).getFirstName());
        } else if (buffer.toLowerCase().contains("last") || buffer.toLowerCase().contains("2")) {
            System.out.println("Please choose a new last name:");
            book.get(index).setLastName(input.nextLine());
            System.out.println("The last name has been changed to: " + book.get(index).getLastName());
        } else if (buffer.toLowerCase().contains("address") || buffer.toLowerCase().contains("3")) {
            System.out.println("Please choose a new address:");
            book.get(index).setAddress(input.nextLine());
            System.out.println("The address has been changed to: " + book.get(index).getAddress());
        } else if (buffer.toLowerCase().contains("city") || buffer.toLowerCase().contains("4")) {
            System.out.println("Please choose a new city:");
            book.get(index).setCity(input.nextLine());
            System.out.println("The city has been changed to: " + book.get(index).getCity());
        } else if (buffer.toLowerCase().contains("phone") || buffer.toLowerCase().contains("number") || buffer.toLowerCase().contains("5")) {
            System.out.println("Please choose a new phone number:");
            book.get(index).setPhoneNumber(input.nextLine());
            System.out.println("The phone number has been changed to: " + book.get(index).getPhoneNumber());
        } else {
            System.out.println("Invalid selection, returning to main menu.");
        }
    }

    // Searches the phonebook for information matching the search term
    private void search() {
        // Get a term from the user and search the phonebook for it, track how many matches were found
        int matchesFound = 0;
        System.out.println("You can search by first name, last name, address, city, or phone number.");
        String searchTerm = input.nextLine();
        for (int i = 1; i <= book.size(); i++) {
            if (book.get(i).getFirstName().toUpperCase().contains(searchTerm.toUpperCase())) {
                System.out.println("Matching first name found at entry number " + (i) + ": " + book.get(i).getFullName());
                matchesFound++;
            }
            if (book.get(i).getLastName().toUpperCase().contains(searchTerm.toUpperCase())) {
                System.out.println("Matching last name found at entry number " + (i) + ": " + book.get(i).getFullName());
                matchesFound++;
            }
            if (book.get(i).getAddress().toUpperCase().contains(searchTerm.toUpperCase())) {
                System.out.println("Matching address found at entry number " + (i) + ": " + book.get(i).getFullName());
                matchesFound++;
            }
            if (book.get(i).getCity().toUpperCase().contains(searchTerm.toUpperCase())) {
                System.out.println("Matching city found at entry number " + (i) + ": " + book.get(i).getFullName());
                matchesFound++;
            }
            if (book.get(i).getPhoneNumber().toUpperCase().contains(searchTerm.toUpperCase())) {
                System.out.println("Matching phone number found at entry number " + (i) + ": " + book.get(i).getFullName());
                matchesFound++;
            }
        }
        // Tell the user how many matches were found
        if (matchesFound == 0) {
            System.out.println("No matches were found.");
        } else if (matchesFound == 1) {
            System.out.println("1 match was found.");
        } else {
            System.out.println(matchesFound + " matches were found.");
        }
    }

    // Prints a list of the available commands
    private void printHelp() {
        System.out.println("Here are the commands available to you:");
        System.out.println("[1] List entries");
        System.out.println("[2] View entry");
        System.out.println("[3] Add entry");
        System.out.println("[4] Remove entry");
        System.out.println("[5] Modify entry");
        System.out.println("[6] Search");
        System.out.println("[7] Help");
        System.out.println("[8] Exit");
    }

    // Gets the correct index number of an entry based on an identifier from the user
    private int getIndex() {
        String identifier = input.nextLine();
        for(int i = 1; i <= book.size(); i++) {
            if(identifier.toLowerCase().contains(book.get(i).getFirstName().toLowerCase()) ||
                    identifier.toLowerCase().contains(book.get(i).getLastName().toLowerCase()) ||
                    identifier.equals(Integer.toString(i)))
            {
                return i;
            }
        }
        // If no matching entry is found, return -1 to indicate the failure to find a matching index
        return -1;
    }

    // Lists the different information contained in an Entry object
    private void listVarTypes() {
        System.out.println("[1] First name");
        System.out.println("[2] Last name");
        System.out.println("[3] Address");
        System.out.println("[4] City");
        System.out.println("[5] Phone number");
    }
}

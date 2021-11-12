import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsManager {
    //menu method
    public static void printMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        try {
            int userOption = scanner.nextInt();
            if (userOption == 1) {
                System.out.println("You entered 1");
                choiceOne();
            } else if (userOption == 2) {
                System.out.println("You entered 2");
                choiceTwo();
            } else if (userOption == 3) {
                System.out.println("You entered 3");
                choiceThree();
            } else if (userOption == 4) {
                System.out.println("You entered 4");
                choiceFour();
            } else if (userOption == 5) {
                System.out.println("Goodbye");
            } else {
                printMenu();
            }
        }catch(InputMismatchException e){
            System.err.println("Enter a valid number.");
            printMenu();
        }

    }


    public static void keepGoing() {

        Scanner scanner = new Scanner(System.in);

        boolean confirmed;
        System.out.print("Do you want to see the menu again? [Y/N] ");
        String userConfirm = scanner.nextLine();
        confirmed = userConfirm.equalsIgnoreCase("y");

        if(confirmed) {
            printMenu();
        } else{
            System.out.println("Goodbye");
        }

    }


    public static void choiceOne() {

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try {
            //create the directory if it doesn't already exist
            if(Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            //create the file if it doesn't already exist
            if (Files.notExists(dataFile)) {
                Files.createFile(dataFile);
            }

        } catch(Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        Path contactTxtPath = Paths.get(directory, filename);

        try {
            List <String> printList = Files.readAllLines(contactTxtPath);

            //Custom print method
            for(int i = 0; i < printList.size(); i+=1){
                System.out.println(printList.get(i));
            }

        }
        catch (Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        keepGoing();

    }



    public static void choiceTwo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String createName = scanner.nextLine();
        String createNumber;
        do{
            System.out.println("Enter a number: ");
            createNumber = scanner.nextLine();
        }while(createNumber.length() < 7 || createNumber.length() > 15);

        String formattedNumber = createNumber.substring(0, 3) + "-" + createNumber.substring(3,6) + "-" + createNumber.substring(6);


        String createNameNumber = createName + " | " + formattedNumber;

        System.out.printf("Name: %s\nNumber: %s", createName, formattedNumber);
        System.out.println();

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        try {
            //create the directory if it doesn't already exist
            if(Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }
            //create the file if it doesn't already exist
            if (Files.notExists(dataFile)) {
                Files.createFile(dataFile);
            }

        } catch(Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        Path contactTxtPath = Paths.get(directory, filename);

        try {
            //if we don't want to overwrite our list

            Files.write(contactTxtPath, List.of(createNameNumber), StandardOpenOption.APPEND);

            List <String> printList = Files.readAllLines(contactTxtPath);

            //Custom print method
            for(int i = 0; i < printList.size(); i+=1){
                if(printList.contains(createName) && printList.contains(createNumber)){
                    System.out.println("That contact already exists.");
                    break;
                }
                System.out.println((i + 1) + " | " + printList.get(i));
            }

        }
        catch (Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        keepGoing();

    }



    public static void choiceThree() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String userSearch = scanner.nextLine();

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";

        Path contactTxtPath = Paths.get(directory, filename);

        try {
            List <String> contactList = Files.readAllLines(contactTxtPath);
            String message = "";
            for (String line : contactList) {
                if (line.contains(userSearch)) {
                    message = "We found a match: \n" + line;
                    break;
                } else {
                    message = "No match found.";
                }
            }
            System.out.println(message);
        }
        catch (Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        keepGoing();

    }


    private static void choiceFour() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a name to delete the contact: ");
        String userDelete = scanner.nextLine();

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";

        Path contactTxtPath = Paths.get(directory, filename);

        try {

            List <String> printList = Files.readAllLines(contactTxtPath);
            List<String> newList = new ArrayList<>();

            for (String line : printList) {

                if (line.contains(userDelete)) {
//                    printList.remove(line);  //we don't need this line
                    System.out.println("You are deleting: " + line);
                    continue;
                } else {
                    newList.add(line);
                }
            }
            Files.write(contactTxtPath, newList);

        }
        catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        keepGoing();

    }



    public static void main(String[] args) {

        System.out.println("Hello, welcome to the contacts manager. Select an option:");
        printMenu();


    }

}

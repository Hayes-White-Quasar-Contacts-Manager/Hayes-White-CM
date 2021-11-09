import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
    //menu method
    public static int printMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to the contacts manager. Select an option:");
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        int userOption = scanner.nextInt();
        if(userOption == 1){
            System.out.println("you entered 1");
            choiceOne();
        } else if(userOption == 2){
            System.out.println("you entered 2");
            choiceTwo();
        } else if(userOption == 3){
            System.out.println("you entered 3");
        } else if(userOption == 4){
            System.out.println("you entered 4");
        } else if(userOption == 5){
            System.out.println("goodbye");
        } else {
            printMenu();
        }
        return userOption;
    }



    public static List<String> choiceOne() {

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);       //method
        Path dataFile = Paths.get(directory, filename); //overloaded method to get both


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

        List<String> contactList = Arrays.asList("Mary | 2101234567", "Rhiannon | 2107899956", "Sally | 2104651234");

        try {
            Files.write(contactTxtPath, contactList);
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

        return contactList;
    }



    public static List<String> choiceTwo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String createName = scanner.nextLine();
        System.out.println("Enter a number: ");
        Integer createNumber = scanner.nextInt();
        System.out.printf("Name: %s\nNumber: %d", createName, createNumber);

        String directory = "./src/ContactDatabase";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);       //method
        Path dataFile = Paths.get(directory, filename); //overloaded method to get both


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

        List<String> contactList = Arrays.asList("Mary | 2101234567", "Rhiannon | 2107899956", "Sally | 2104651234");

        try {
            Files.write(contactTxtPath, contactList);
            List <String> printList = Files.readAllLines(contactTxtPath);

            //if we don't want to overwrite our list
            Files.write(contactTxtPath, Arrays.asList(String createName, Integer createNumber), StandardOpenOption.APPEND);


            //Custom print method
            for(int i = 0; i < printList.size(); i+=1){
                System.out.println((i + 1) + ": " + printList.get(i));
            }

        }
        catch (Exception e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
            e.getMessage();
        }

        return choiceTwo();
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //call the menu method
        printMenu();


    }

}

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
        } else if(userOption == 2){
            System.out.println("you entered 2");
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //call the menu method
        printMenu();


        //String directory = "./src/lecturedata";
        //        String filename = "groceryList.txt";
        //        Path dataDirectory = Paths.get(directory);       //method
        //        Path dataFile = Paths.get(directory, filename); //overloaded method to get both
        //        System.out.println("dataFile = " + dataFile);
        //
        //        //create the directory if it doesn't already exist
        //        if(Files.notExists(dataDirectory)){
        //            Files.createDirectories(dataDirectory);
        //        }
        //
        //        //create the file if it doesn't already exist
        //        if(Files.notExists(dataFile)){
        //            Files.createFile(dataFile);
        //        }



    }

}

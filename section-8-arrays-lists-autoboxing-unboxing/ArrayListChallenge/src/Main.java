import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        mobilePhone.printMenu();

        while (!quit) {
            System.out.println("Enter your choice: ");

            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) {
                System.out.println("Invalid input");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    mobilePhone.printMenu();
                    break;
                case 1:
                    newContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    mobilePhone.printContacts();
                    break;
                case 6:
                    System.out.println("Powering off");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        
        scanner.close();
    }

    private static void newContact() {
        String name = getInput("Enter name: ");
        String phoneNumber = getInput("Enter phone number: ");
        mobilePhone.storeContact(name, phoneNumber);
    }

    private static void updateContact() {
        String oldName = getInput("Enter name: ");
        String newName = getInput("Enter updated name: ");
        String phoneNumber = getInput("Enter phone number: ");
        mobilePhone.modifyContact(oldName, newName, phoneNumber);
    }

    private static void removeContact() {
        String name = getInput("Enter name: ");
        mobilePhone.removeContact(name);
    }

    private static void findContact() {
        String name = getInput("Enter name: ");
        mobilePhone.findContact(name);
    }

    private static String getInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

}

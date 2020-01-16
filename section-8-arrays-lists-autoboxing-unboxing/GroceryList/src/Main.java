import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
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
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItems();
                    break;
                case 6:
                    quit = true;
                    System.out.println("Goodbye! Final list:");
                    groceryList.printGroceryList();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application");
    }

    private static void addItem() {
        System.out.println("Please enter the grocery item:");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void modifyItem() {
        System.out.println("Please enter the item to modify:");
        String oldItem = scanner.nextLine();
        System.out.println("Please enter the new item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    private static void removeItem() {
        System.out.println("Please enter the item to remove:");
        groceryList.removeGroceryItem((scanner.nextLine()));
    }

    private static void searchItems() {
        System.out.println("Please enter the item to search for:");
        int index = groceryList.findItem((scanner.nextLine()));
        String result = index >= 0 ? "Item Found at position " + (index + 1) : "Item Not found";
        System.out.println(result);
    }
}

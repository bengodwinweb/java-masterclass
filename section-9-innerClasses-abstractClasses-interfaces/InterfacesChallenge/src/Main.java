import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Player ben = new Player("Ben", 10, 15, 10, "Mjölnir");
        System.out.println(ben);
        saveObject(ben);

        ben.setAttack(8);
        System.out.println(ben);
        saveObject(ben);
        loadObject(ben);
        System.out.println(ben);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (String value : objectToSave.write()) {
            System.out.println("Saving " + value + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}

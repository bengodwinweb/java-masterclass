import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Venice");
        addInOrder(placesToVisit, "Rome");
        addInOrder(placesToVisit, "Milan");
        addInOrder(placesToVisit, "Turin");
        addInOrder(placesToVisit, "Sicily");
        addInOrder(placesToVisit, "Milan");
        printList(placesToVisit);

        visit(placesToVisit);
//        placesToVisit.add("Rome");
//        placesToVisit.add("Milan");
//        placesToVisit.add("Turin");
//        placesToVisit.add("Sicily");
//        placesToVisit.add("Florence");
//        placesToVisit.add("Naples");
//        placesToVisit.add("Verona");

//        printList(placesToVisit);
//
//        placesToVisit.add(2, "Bologna");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        System.out.println("=========================");
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=========================\n");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newItem) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newItem);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newItem + " is already in the list");
                return false;
            } else if (comparison > 0) {
                // newItem should appear before this one
                // Rome -> Venice
                stringListIterator.previous();
                stringListIterator.add(newItem);
                return true;
            } else if (comparison < 0) {
                // move on to next city
            }
        }
        stringListIterator.add(newItem);
        return true;
    }

    private static void visit(LinkedList<String> linkedList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = linkedList.listIterator();

        if(linkedList.isEmpty()) {
            System.out.println("No cities in itinerary");
            return;
        } else  {
            System.out.println("Now visiting " + listIterator.next());
        }

        while (!quit) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input - press 3 to print options");
                continue;
            }
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached end of list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Reached beginning of list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid input - press 3 to print options");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\nPress");
        System.out.println("\t0 - To quit");
        System.out.println("\t1 - Go to next destination");
        System.out.println("\t2 - Return to previous destination");
        System.out.println("\t3 - Print menu options");
    }
}

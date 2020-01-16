import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your Grocery List");
        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        };
    }

    public void modifyGroceryItem(String oldItem, String newItem) {
        int index = findItem(oldItem);
        if (index >= 0) {
            modifyGroceryItem(index, newItem);
        } else {
            System.out.println("Item not found");
        }
    }

    private void modifyGroceryItem(int index, String newItem) {
        groceryList.set(index, newItem);
        System.out.println("Modified Item " + (index + 1));
    }

    public void removeGroceryItem(String item) {
        int index = findItem(item);
        if (index >= 0) {
            removeGroceryItem(index);
        } else {
            System.out.println("Item not found");
        }
    }

    private void removeGroceryItem(int index) {
        groceryList.remove(index);
        System.out.println("Removed Item " + (index + 1));
    }

    public int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }
}

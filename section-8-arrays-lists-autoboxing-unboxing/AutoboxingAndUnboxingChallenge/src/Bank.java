import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void createBranch(String name) {
        int index = findBranch(name);
        if (index == -1) {
            branches.add(new Branch(name));
        } else {
            System.out.println("Unable to create branch - branch with name " + name + " already exists.®");
        }
    }

    public void createCustomer(String branchName, String customerName, int transaction) {
        int index = findBranch(branchName);
        if (index >= 0) {
            branches.get(index).createCustomer(customerName, transaction);
        } else {
            System.out.println("Unable to create customer - branch with name " + branchName + "not found");
        }
    }

    public void addTransaction(String branchName, String customerName, int transaction) {
        int index = findBranch(branchName);
        if (index >= 0) {
            branches.get(index).addCustomerTransaction(customerName, transaction);
        } else {
            System.out.println("Unable to add transaction - no branch with name " + branchName + " found.");
        }
    }

    public void printBranch(String name) {
        int index = findBranch(name);
        if (index >= 0) {
            printBranch(index);
        } else {
            System.out.println("Unable to print branch - no branch with name " + name + " found.");
        }
    }

    private void printBranch(int index) {
        System.out.println(branches.get(index).getName());
        branches.get(index).printCustomers();
    }

    public void printBank() {
        System.out.println("-------------------------------");
        System.out.println(name + "\n");
        System.out.println("Branches:\n");
        for (int i = 0; i < branches.size(); i++) {
            printBranch(i);
        }
        System.out.println("-------------------------------");
    }

    private int findBranch(String name) {
    for (int i = 0; i < branches.size(); i++) {
        if (branches.get(i).getName().equals(name)) {
            return i;
        }
    }
    return -1;
    }
}

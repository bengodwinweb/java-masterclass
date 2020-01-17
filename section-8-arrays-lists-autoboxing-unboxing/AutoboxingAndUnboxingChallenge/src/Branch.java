import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean createCustomer(String name, int initialTransaction) {
        int existingCustomerIndex = findCustomer(name);
        if (existingCustomerIndex == -1) {
            customers.add(new Customer(name, initialTransaction));
            return true;
        }
        System.out.println("Unable to create new customer with name " + name + " - name matches existing record");
        return false;
    }

    public boolean addCustomerTransaction(String name, int transaction) {
        int index = findCustomer(name);
        if (index >= 0) {
            customers.get(index).addTransaction(transaction);
            return true;
        }
        System.out.println("Unable to add transaction - customer record with that name not found");
        return false;
    }

    public void printCustomers() {
        System.out.println("Customers:");
        customers.forEach(Customer::printCustomer);
        System.out.println();
    }

    private int findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

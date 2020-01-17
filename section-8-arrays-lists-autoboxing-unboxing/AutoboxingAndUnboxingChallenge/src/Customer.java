import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Integer> transactions;

    public Customer(String name, int transaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(transaction);
    }

    public String getName() {
        return name;
    }

    public void addTransaction(int transaction) {
        transactions.add(transaction);
    }

    public void printCustomer() {
        System.out.print(name + " (");
        for (int i = 0; i < transactions.size(); i++) {
            if (i == transactions.size() - 1) {
                System.out.println(toCurrency(transactions.get(i)) + ")");
            } else {
                System.out.print(toCurrency(transactions.get(i)) + ", ");
            }
        }
    }

    private String toCurrency(int transaction) {
        return "$" + (transaction / 100d);
    }
}

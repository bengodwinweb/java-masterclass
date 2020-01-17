public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Bank of America");
        bank.createBranch("Media");
        bank.createCustomer("Media", "Benjamin Godwin", 24819);
        bank.printBranch("Media");
        bank.addTransaction("Media", "Benjamin Godwin", 1502);
        bank.printBank();
    }
}

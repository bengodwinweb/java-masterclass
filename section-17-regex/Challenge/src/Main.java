public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        System.out.println("Challenge 1: " + challenge1.matches("I want a bike\\.") + "\n");
        System.out.println("Challenge 2: " + (challenge1.matches("I want a b\\w{3}\\.") && challenge2.matches("I want a b\\w{3}\\.")));
        System.out.println("Challenge 2: " + (challenge1.matches("I want a (bike|ball)\\.") && challenge2.matches("I want a (bike|ball)\\.")) + "\n");
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String challenge4 = "Replace all blanks with underscores.";

        String regEx1 = "I want a bike\\.";
        System.out.println("Challenge 1: " + challenge1.matches(regEx1) + "\n");

        String regEx2 = "I want a b\\w{3}\\.";
        String regEx3 = "I want a b(all|ike)\\.";
        System.out.println("Challenge 2: " + (challenge1.matches(regEx2) && challenge2.matches(regEx2)));
        System.out.println("Challenge 2: " + (challenge1.matches(regEx3) && challenge2.matches(regEx3)) + "\n");

        Pattern pattern = Pattern.compile(regEx2);
        Matcher matcher1 = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);
        System.out.println("Challenge 3: " + (matcher1.matches() && matcher2.matches()) + "\n");

        String regEx4 = "\\s";
        System.out.println("Challenge 4: " + challenge4.replaceAll(regEx4, "_") + "\n");


    }
}

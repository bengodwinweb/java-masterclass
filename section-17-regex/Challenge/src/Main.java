import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String challenge4 = "Replace all blanks with underscores.";
        String challenge5 = "aaabccccccccdddefffg";
        String challenge7_1 = "abcd.135"; // true
        String challenge7_2 = "kjisl.22"; // true
        String challenge7_3 = "f5.12a"; // false
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge9 = "abcd.135\ttuvqz.7\tttzik.999\n";
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {11, 12}";
        String challenge12_1 = "11111";
        String challenge12_2 = "19033";
        String challenge12_3 = "3341";

        String regEx1 = "I want a bike\\.";
        System.out.println("Challenge 1: " + challenge1.matches(regEx1) + "\n");

        String regEx2 = "I want a b\\w{3}\\.";
        String regEx3 = "I want a b(all|ike)\\.";
        System.out.println("Challenge 2: ");
        System.out.println("\t" + (challenge1.matches(regEx2) && challenge2.matches(regEx2)));
        System.out.println("\t" + (challenge1.matches(regEx3) && challenge2.matches(regEx3)) + "\n");

        Pattern pattern = Pattern.compile(regEx2);
        Matcher matcher1 = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);
        System.out.println("Challenge 3: " + (matcher1.matches() && matcher2.matches()) + "\n");

        String regEx4 = "\\s";
        System.out.println("Challenge 4: " + challenge4.replaceAll(regEx4, "_") + "\n");

        String regEx5 = "[a-g]+";
        System.out.println("Challenge 5: " + challenge5.matches(regEx5) + "\n");

        String regEx6 = "^a{3}bc{8}d{3}ef{3}g$";
        System.out.println("Challenge 6: " + challenge5.matches(regEx6) + "\n");

        String regEx7 = "^[a-zA-Z]+[\\.][\\d]+$";
        System.out.println("Challenge 7: " + (challenge7_1.matches(regEx7) && challenge7_2.matches(regEx7) && !challenge7_3.matches(regEx7)) + "\n");

        String regEx8 = "[a-zA-Z]+\\.(\\d+)";
        Pattern groupPattern = Pattern.compile(regEx8);
        Matcher groupMatcher = groupPattern.matcher(challenge8);
        System.out.println("Challenge 8:");
        while(groupMatcher.find()) {
            System.out.println("\t" + groupMatcher.group(1));
        }

        groupMatcher = groupPattern.matcher(challenge9);
        System.out.println("\nChallenge 9:");
        while(groupMatcher.find()) {
            System.out.println("\t" + groupMatcher.group(1));
        }

        groupMatcher.reset();
        System.out.println("\nChallenge 10:");
        while(groupMatcher.find()) {
            System.out.println("\tStart: " + groupMatcher.start(1) + ", End: " + (groupMatcher.end(1) - 1));
        }

        String regEx11 = "[{](\\d+, \\d+)[}]";
        Pattern pattern11 = Pattern.compile(regEx11);
        Matcher matcher11 = pattern11.matcher(challenge11);
        System.out.println("\nChallenge 11:");
        while(matcher11.find()) {
            System.out.println("\t" + matcher11.group(1));
        }

        String regEx12 = "\\d{5}";
        System.out.println("\nChallenge 12:");
        System.out.println("\tmatches \"" + challenge12_1 + "\": " + challenge12_1.matches(regEx12));
        System.out.println("\tmatches \"" + challenge12_2 + "\": " + challenge12_2.matches(regEx12));
        System.out.println("\tmatches \"" + challenge12_3 + "\": " + challenge12_3.matches(regEx12));

    }
}

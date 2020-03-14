import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String RST = "\u001B[0m";
    public static final String AR = "\u001B[31m";
    public static final String AG = "\u001B[32m";
    public static final String AP = "\u001B[35m";

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        System.out.println();

        String alphanumeric = "abcDeeeF12Ghhiiijkl99z";
        System.out.println("Original:\n\t" + alphanumeric);
        // "." - match all
        System.out.println("replaceAll: " + AR + "\".\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll(".", AP + "Y" + RST));
        // "^" - match at beginning of String
        System.out.println("replaceAll: " + AR + "\"^abcDeee\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("^abcDeee", AP + "YYY" + RST));
        // {3} - use quantifier to match beginning of String
        System.out.println("replaceAll: " + AR + "\"^abcDee{3}\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("^abcDe{3}", AP + "YYY" + RST));
        // + - use quantifier to match any amount of a character, excluding 0
        System.out.println("replaceAll: " + AR + "\"abcDe+\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("^abcDe+", AP + "YYY" + RST));
        // * - use quantifier to match any amount of a character, including 0
        System.out.println("replaceAll: " + AR + "\"abcDe*\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("^abcDe*", AP + "YYY" + RST));
        // {2,5} - quantifier range
        System.out.println("replaceAll: " + AR + "\"abcDe{2,5}\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("^abcDe{2,5}", AP + "YYY" + RST));
        // +* - combine quantifiers
        System.out.println("replaceAll: " + AR + "\"h+i*j\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("h+i*j", AP + "Y" + RST));
        // "$" - match at end of String
        System.out.println("replaceAll: " + AR + "\"jkl99z$\"" + RST + ", " + AG + "\"YYY\":\n\t" + RST + alphanumeric.replaceAll("jkl99z$", AP + "YYY" + RST));
        // "[]" - match each
        System.out.println("replaceAll: " + AR + "\"[aeiou]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[aeiou]", AP + "Y" + RST));
        // "[]" - each followed by f
        System.out.println("replaceAll: " + AR + "\"[aeiou][Fj]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[aeiou][Fj]", AP + "Y" + RST));
        // "[^]" - each except
        System.out.println("replaceAll: " + AR + "\"[^ej]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[^ej]", AP + "Y" + RST));
        // "-" - range
        System.out.println("replaceAll: " + AR + "\"[a-f3-8]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[a-f3-8]", AP + "Y" + RST));
        // "-" - range, add UpperCase
        System.out.println("replaceAll: " + AR + "\"[a-fA-F3-8]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[a-fA-F3-8]", AP + "Y" + RST));
        // "-" - range, turn off case sensitivity
        System.out.println("replaceAll: " + AR + "\"(?i)[a-f3-8]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("(?i)[a-f3-8]", AP + "Y" + RST));
        // "[0-9]" - match all digits
        System.out.println("replaceAll: " + AR + "\"[0-9]\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("[0-9]", AP + "Y" + RST));
        // "\\d" - match all digits
        System.out.println("replaceAll: " + AR + "\"\\d\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("\\d", AP + "Y" + RST));
        // "\\D" - match everything except digits
        System.out.println("replaceAll: " + AR + "\"\\D\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("\\D", AP + "Y" + RST));
        // "\\w" - match characters, digits, and '_'
        System.out.println("replaceAll: " + AR + "\"\\w\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("\\w", AP + "Y" + RST));
        // "\\W" - match everything except characters, digits, and '_'
        System.out.println("replaceAll: " + AR + "\"\\W\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + alphanumeric.replaceAll("\\W", AP + "Y" + RST));


        System.out.println();
        String stringWtihWhitespace = "L$AB cl±=we\t\tso48g^n a\\oq_31";

        System.out.println("Original with whitespace:\n\t" + stringWtihWhitespace);
        // "\\s" - match whitespace
        System.out.println("replaceAll: " + AR + "\"\\s\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + stringWtihWhitespace.replaceAll("\\s", AP + "Y" + RST));
        // "\\S" - match everything except whitespace
        System.out.println("replaceAll: " + AR + "\"\\S\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + stringWtihWhitespace.replaceAll("\\S", AP + "Y" + RST));
        // "\\b" - match boundaries
        System.out.println("replaceAll: " + AR + "\"\\b\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + stringWtihWhitespace.replaceAll("\\b", AP + "Y" + RST));
        // "\\B" - match everything except boundaries
        System.out.println("replaceAll: " + AR + "\"\\B\"" + RST + ", " + AG + "\"Y\":\n\t" + RST + stringWtihWhitespace.replaceAll("\\B", AP + "Y" + RST));


        System.out.println();
        StringBuilder htmlText = new StringBuilder();
        htmlText.append("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = ".*<h2>.*";
        Pattern pattern = Pattern.compile(h2Pattern); // can pass in options as second parameter
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println("Checking html text for h2 tag: " + (matcher.matches() ? AG + matcher.matches() : AR + matcher.matches()));


    }
}

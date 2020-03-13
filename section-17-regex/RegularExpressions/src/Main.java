public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        System.out.println();

        String alphanumeric = "abcDeeeF12Ghhiiijkl99z";
        System.out.println("Original:\n\t" + alphanumeric);
        // "." - match all
        System.out.println("Matches \".\":\n\t" + alphanumeric.replaceAll(".", "Y"));
        // "^" - match at beginning of String
        System.out.println("replaceAll at start:\n\t" + alphanumeric.replaceAll("^abcDeee", "YYY"));
        // "$" - match at end of String
        System.out.println("replaceAll at end:\n\t" + alphanumeric.replaceAll("jkl99z$", "YYY"));
        // "[]" - match each
        System.out.println("replace vowels:\n\t" + alphanumeric.replaceAll("[aeiou]", "Y"));
        // "[]" - each followed by f
        System.out.println("replace vowels and next if followed by F or j:\n\t" + alphanumeric.replaceAll("[aeiou][Fj]", "Y"));
        // "[^]" - each except
        System.out.println("replace all except e and j:\n\t" + alphanumeric.replaceAll("[^ej]", "Y"));
        // "-" - range
        System.out.println("replace range of chars or digits:\n\t" + alphanumeric.replaceAll("[a-f3-8]", "Y"));
        // "-" - range, add UpperCase
        System.out.println("replace range of chars or digits:\n\t" + alphanumeric.replaceAll("[a-fA-F3-8]", "Y"));
        // "-" - range, turn off case sensitivity
        System.out.println("replace range of chars or digits:\n\t" + alphanumeric.replaceAll("(?i)[a-f3-8]", "Y"));
        // "[0-9]" - match all digits
        System.out.println("replace digits:\n\t" + alphanumeric.replaceAll("[0-9]", "Y"));
        // "\\d" - match all digits
        System.out.println("replace digits:\n\t" + alphanumeric.replaceAll("\\d", "Y"));
        // "\\w" - match characters, digits, and '_'
        System.out.println("replace digits, chars, and _\n\t" + alphanumeric.replaceAll("\\w", "Y"));
        // "\\W" - match everything except characters, digits, and '_'
        System.out.println("replace everything except digits, chars, and _\n\t" + alphanumeric.replaceAll("\\W", "Y"));

        System.out.println();
        String stringWtihWhitespace = "L$AB cl±=we\t\tso48g^n a\\oq_31";

        System.out.println("string with whitespace\n\t" + stringWtihWhitespace);
        // "\\s" - match whitespace
        System.out.println("replace whitespace:\n\t" + stringWtihWhitespace.replaceAll("\\s", "Y"));
        // "\\S" - match everything except whitespace
        System.out.println("replace everything except whitespace:\n\t" + stringWtihWhitespace.replaceAll("\\S", "Y"));
        // "\\b" - match boundaries
        System.out.println("replace boundaries\n\t" + stringWtihWhitespace.replaceAll("\\b", "Y"));

    }
}

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

    }
}

import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Function<String, String> returnVal = s -> {
            StringBuilder r = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (i % 2 == 0) {
                    r.append(s.charAt(i));
                }
            }
            return r.toString();
        };
        Function<String, String> spongebobCase = s -> {
            StringBuilder r = new StringBuilder();
            for (int i =0; i<s.length(); i++) {
                if (i % 2 == 1) {
                    s = s.toUpperCase();
                } else {
                    s = s.toLowerCase();
                }
                r.append(s.charAt(i));
            }
            return r.toString();
        };


        Stream.of("Ben Godwin", "Jake Kaplan").map(returnVal).forEach(System.out::println);
        System.out.println();
        Stream.of("Ben Godwin", "Jake Kaplan").map(spongebobCase).forEach(System.out::println);
    }
}

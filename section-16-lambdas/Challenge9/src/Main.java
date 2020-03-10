import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        // Print names in alphabetical order, with first letter capitalized
        topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        // Print out how many names begin with the letter 'A'
        System.out.println("A names = " +
                topNames2015
                .stream()
                .filter(s -> s.toUpperCase().startsWith("A"))
                .count()
        );


    }
}

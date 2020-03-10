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

        topNames2015
                .stream()
                .sorted()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .forEach(System.out::println);
    }
}

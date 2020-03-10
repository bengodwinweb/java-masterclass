import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            Arrays.stream(parts).forEach(System.out::println);
        };

        new Thread(runnable).start();
    }
}

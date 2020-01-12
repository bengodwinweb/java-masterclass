package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(sumFirstAndLastDigit(252)); // 4
        System.out.println(sumFirstAndLastDigit(257)); // 9
        System.out.println(sumFirstAndLastDigit(0)); // 0
        System.out.println(sumFirstAndLastDigit(5)); // 10
        System.out.println(sumFirstAndLastDigit(-240)); // -1
    }

    public static int sumFirstAndLastDigit(int n) {
        if (n < 0) {
            return -1;
        }

        int last = n % 10;
        int first = 0;
        while (n > 0) {
            first = n % 10;
            n /= 10;
        }

        // System.out.println("First = " + first + ", Last = " + last);
        return first + last;
    }
}
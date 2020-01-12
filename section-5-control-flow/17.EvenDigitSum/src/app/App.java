package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(getEvenDigitSum(123456789)); // 20
        System.out.println(getEvenDigitSum(252)); // 4
    }

    public static int getEvenDigitSum(int n) {
        if (n < 0) {
            return -1;
        }

        int sum = 0;
        while (n > 0) {
            if (n % 10 % 2 == 0) {
                sum += n % 10;
            }
            n /= 10;
        }

        return sum;
    }
}
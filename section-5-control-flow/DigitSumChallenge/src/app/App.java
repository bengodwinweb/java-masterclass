package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(sumDigits(125)); // 8
        System.out.println(sumDigits(-125)); // -1
        System.out.println(sumDigits(4)); // -1
        System.out.println(sumDigits(32123)); // 11
    }

    public static int sumDigits(int n) {
        if (n < 10) {
            return -1;
        }
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
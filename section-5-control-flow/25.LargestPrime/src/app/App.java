package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(getLargestPrime(21)); // 7
        System.out.println(getLargestPrime(217)); // 31
        System.out.println(getLargestPrime(0)); // -1
        System.out.println(getLargestPrime(45)); // 5
        System.out.println(getLargestPrime(-1)); // -1
        System.out.println(getLargestPrime(16)); // 2
    }

    public static int getLargestPrime(int n) {
        if (n <= 1) return -1;

        int largestPrime = -1;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) largestPrime = i;
            }
        }
        
        return largestPrime;
    }
}
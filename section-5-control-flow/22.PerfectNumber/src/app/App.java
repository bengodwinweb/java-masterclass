package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(isPerfectNumber(6));
    }

    public static boolean isPerfectNumber(int n) {
        if (n < 1) {
            return false;
        }
        
        int sum = 0;
        for(int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
                System.out.println(sum);
            }
        }
        return sum == n ? true : false;
    }
}
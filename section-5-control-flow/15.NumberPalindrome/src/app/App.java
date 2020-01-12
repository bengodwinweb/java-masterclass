package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707)); // true
        System.out.println(isPalindrome(11212)); // false
    }

    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int working = n;

        while (working != 0) {
            int lastDigit = working % 10;
            reverse  = reverse * 10 + lastDigit;
            working /= 10;
        }

        if (reverse == n) {
            return true;
        };

        return false;
    }
}
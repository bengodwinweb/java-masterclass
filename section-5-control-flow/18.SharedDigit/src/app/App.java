package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(hasSharedDigit(12, 23)); // true
        System.out.println(hasSharedDigit(9, 23)); // false
        System.out.println(hasSharedDigit(15, 55)); // true
        System.out.println(hasSharedDigit(12, 13)); // true
    }

    public static boolean hasSharedDigit(int n1, int n2) {
        if (n1 < 10 || n1 > 99 || n2 < 10 || n2 > 99) {
            return false;
        }

        int original = n2;
        while(n1 > 0) {
            int digit = n1 % 10;
            while(n2 > 0) {
                if (digit == n2 % 10) {
                    return true;
                }
                n2 /= 10;
            }
            n1 /= 10;
            n2 = original;
        }

        return false;
    }
}
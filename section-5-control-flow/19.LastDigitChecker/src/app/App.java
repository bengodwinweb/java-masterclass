package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(hasSameLastDigit(41, 22, 71)); // true
        System.out.println(hasSameLastDigit(23, 32, 42)); // true
        System.out.println(hasSameLastDigit(9, 99, 999)); // false
    }

    public static boolean hasSameLastDigit(int n1, int n2, int n3) {
        if (!isValid(n1) || !isValid(n2) || !isValid(n3)) {
            return false;
        }

        int last1 = n1 % 10;
        int last2 = n2 % 10;
        int last3 = n3 % 10;

        if (last1 == last2 || last1 == last3 || last2 == last3) {
            return true;
        }

        return false;
    }

    public static boolean isValid(int n) {
        if (n >= 10 && n <= 1000) {
            return true;
        }

        return false;
    }
}
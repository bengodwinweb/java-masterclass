package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(getGreatestCommonDivisor(25, 15)); // 5
        System.out.println(getGreatestCommonDivisor(12, 30)); // 6
        System.out.println(getGreatestCommonDivisor(9, 18)); // -1
        System.out.println(getGreatestCommonDivisor(81, 153)); // 9
    }

    public static int getGreatestCommonDivisor(int n1, int n2) {
        if (n1 < 10 || n2 < 10) {
            return -1;
        }

        int greatestDivisor = 1;
        for(int i = 2; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                greatestDivisor = i;
            }
        }
        return greatestDivisor;
    }
}
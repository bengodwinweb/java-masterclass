package app;

public class App {
    public static void main(String[] args) throws Exception {
        printSquareStar(7);
    }

    public static void printSquareStar(int n) {
        if (n < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == 1 || i == n) {
                    for (int j = 0; j < n; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } else {
                    for (int j = 1; j <= n; j++) {
                        if (j == 1 || j == n || j == i || j == n - i + 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
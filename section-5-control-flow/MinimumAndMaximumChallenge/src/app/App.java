package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(true) {
            System.out.println("Enter a number:");

            boolean isInt = scanner.hasNextInt();
            if (!isInt) {
                System.out.println("Min = " + min + ", Max = " + max);
                break;
            }

            int current = scanner.nextInt();
            max = current > max ? current : max;
            min = current < min ? current : min;
        }

        scanner.close();
    }
}
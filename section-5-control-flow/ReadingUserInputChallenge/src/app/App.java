package app;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int i = 1;
        while (i <= 10) {
            System.out.println("Enter number #" + i + ":");
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                sum += scanner.nextInt();
                i++;
            } else {
                System.out.println("Invalid number");
            }
            scanner.nextLine();
        }

        System.out.println("Sum = " + sum);

        scanner.close();
    }
}
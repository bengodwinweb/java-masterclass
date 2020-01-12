package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;

        while(true) {
            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) break;
            sum += scanner.nextInt();
            count++;
            scanner.nextLine();
        }

        scanner.close();

        long avg = count > 0 ? Math.round((double) sum / (double) count) : 0;
        System.out.println("SUM = " + sum + " AVG = " + avg);
    }
}
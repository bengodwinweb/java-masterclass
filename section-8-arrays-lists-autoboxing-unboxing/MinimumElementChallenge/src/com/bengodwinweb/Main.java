package com.bengodwinweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] integers = getIntegers();
        System.out.println(Arrays.toString(integers));
        System.out.println("Min = " + findMin(integers));
    }

    public static int[] getIntegers() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> ints = new ArrayList<>();

        System.out.println("Enter integers: (press any other key to exit and get minimum)");

        while(true) {
            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) break;
            ints.add(scanner.nextInt());
            scanner.nextLine();
        }

        scanner.close();
        int[] integers = new int[ints.size()];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = ints.get(i);
        }
        return integers;
    }

    public static int findMin(int[] intArr) {
        int min = intArr[0];
        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] < min) min = intArr[i];
        }
        return min;
    }
}

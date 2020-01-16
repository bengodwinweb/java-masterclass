package com.bengodwinweb;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] integers = getIntegers();
//	    int[] integers = {7, 11, 8, 2, 9};
        System.out.println("integers: ");
        printArray(integers);
        int[] sortedInts = sortIntegers(integers);
        System.out.println("sortedInts: ");
        printArray(sortedInts);
    }

    public static int[] getIntegers() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> ints = new ArrayList<Integer>();

        System.out.println("Enter integers:");

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

    public static int[] sortIntegers(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            int a = intArr[i];
            int b = intArr[i + 1];
            if (a < b) {
                intArr[i] = b;
                intArr[i + 1] = a;
                sortIntegers(intArr);
            }
        }
        return intArr;
    }

    public static void printArray(int[] intArr) {
        System.out.print("{");
        for (int i : intArr) {
            System.out.print(" " + i);
        }
        System.out.println(" }\n");
    }
}

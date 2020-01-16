package com.bengodwinweb;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] integers = { 1, 2, 3, 4, 5};
        System.out.println("Array = " + Arrays.toString(integers));
        reverse(integers);
        System.out.println("Reverse = " + Arrays.toString(integers));
        System.out.println();

        int[] integers2 = { 1, 2, 3, 4, 5, 6};
        System.out.println("Array = " + Arrays.toString(integers2));
        reverse(integers2);
        System.out.println("Reverse = " + Arrays.toString(integers2));
    }

    public static void reverse(int[] intArr) {
        int maxIndex = intArr.length - 1;
        for(int i = 0; i < intArr.length / 2; i++) {
            int temp = intArr[i];
            intArr[i] = intArr[maxIndex - i];
            intArr[maxIndex - i] = temp;
        }
    }
}

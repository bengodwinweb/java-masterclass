package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
        System.out.println(hasTeen(2, 23, 34));
    }

    public static boolean hasTeen(int num1, int num2, int num3) {
        return isTeen(num1) || isTeen(num2) || isTeen(num3) ? true : false;
    }

    public static boolean isTeen(int num) {
        return num >= 13 && num <= 19 ? true : false;
    }
}

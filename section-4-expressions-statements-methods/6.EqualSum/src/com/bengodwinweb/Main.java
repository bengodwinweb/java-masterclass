package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1 ,2));
    }

    public static boolean hasEqualSum(int num1, int num2, int sum) {
        return num1 + num2 == sum ? true : false;
    }
}

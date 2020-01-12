package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(isLeapYear(1700));
        System.out.println(isLeapYear(1800));
        System.out.println(isLeapYear(2500));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2020));
    }

    public static boolean isLeapYear(int year) {
        if (year > 0 && year < 9999) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return true;
            }
        }

        return false;
    }
}

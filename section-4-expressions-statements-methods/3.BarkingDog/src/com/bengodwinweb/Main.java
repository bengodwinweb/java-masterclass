package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 1)); // true
        System.out.println(shouldWakeUp(false, 2)); // false
        System.out.println(shouldWakeUp(true, 8)); // false
        System.out.println(shouldWakeUp(true, -1)); // false
        System.out.println(shouldWakeUp(true, 24)); // false
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (barking) {
            if ((hourOfDay >= 0 && hourOfDay < 8) || (hourOfDay > 22 && hourOfDay <= 23)) {
                return true;
            }
        }

        return false;
    }
}

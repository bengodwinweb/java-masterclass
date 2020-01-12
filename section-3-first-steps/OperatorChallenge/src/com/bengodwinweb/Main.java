package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        double doubleValue = 20.00;
        double secondDouble = 80.00;
        boolean isDivisable = (doubleValue + secondDouble) * 100 % 40.00 == 0;

        System.out.println("isDivisable = " + isDivisable);

        if (!isDivisable) {
            System.out.println("Got some remainder");
        }

    }
}

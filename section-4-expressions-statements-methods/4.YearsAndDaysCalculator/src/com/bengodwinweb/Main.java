package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    printYearsAndDays(525600L);
        printYearsAndDays(1051200L);
        printYearsAndDays(561600L);
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {

            long years = minutes / (60 * 24 * 365);
            long days = minutes % (365 * 24 * 60) / (60 * 24);

            String minutesString = minutes + " min = ";
            String yearsString = years + " y and ";
            String daysString = days + " d";

            System.out.println(minutesString + yearsString + daysString);
        }
    }
}

package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeter(6, 2));
        System.out.println(calcFeetAndInchesToCentimeter(74));
    }

    public static double calcFeetAndInchesToCentimeter(int feet, int inches) {
        return (feet < 0 || inches < 0 || inches >= 12) ? -1 : (feet * 12 + inches) * 2.54;
    }

    public static double calcFeetAndInchesToCentimeter(int height) {
        if (height < 0) {
            return -1;
        }

        int feet = (int) (height / 12);
        int inches = height % 12;
        return calcFeetAndInchesToCentimeter(feet, inches);
    }
}

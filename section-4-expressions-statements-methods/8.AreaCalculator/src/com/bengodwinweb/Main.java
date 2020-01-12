package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        System.out.println(area(2));
        System.out.println(area(2, 4));
    }

    public static double area(double radius) {
        return radius < 0 ? -1 : radius * radius * Math.PI;
    }

    public static double area(double length, double width) {
        return length < 0 || width < 0 ? -1 : length * width;
    }
}

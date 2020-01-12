package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    Point first = new Point(6, 5);
	    Point second = new Point(3, 1);
        System.out.println("distance= " + first.distance()); // 7.8102...
        System.out.println("distance(second)= " + first.distance(second)); // 5.0
        System.out.println("distance(2, 2)= " + first.distance(2, 2)); // 5.0
    }
}

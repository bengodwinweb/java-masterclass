package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    Circle circle = new Circle(3.75);
        System.out.println("circle.radius= " + circle.getRadius()); // 3.75
        System.out.println("circle.area= " + circle.getArea()); // 44.1786...
        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("cylinder.radius= " + cylinder.getRadius()); // 5.55
        System.out.println("cylinder.height= " + cylinder.getHeight()); // 7.25
        System.out.println("cylinder.area= " + cylinder.getArea()); // 96.7689...
        System.out.println("cylinder.volume= " + cylinder.getVolume()); // 701.5745...
    }
}

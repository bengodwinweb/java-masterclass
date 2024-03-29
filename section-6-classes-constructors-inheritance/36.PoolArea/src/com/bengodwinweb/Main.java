package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth()); // 5.0
        System.out.println("rectangle.length= " + rectangle.getLength()); // 10.0
        System.out.println("rectangle.area= " + rectangle.getArea()); // 50.0
        Cuboid cuboid = new Cuboid(5, 10, 5);
        System.out.println("cuboid.width= " + cuboid.getWidth()); // 5.0
        System.out.println("cuboid.length= " + cuboid.getLength()); // 10.0
        System.out.println("cuboid.area= " + cuboid.getArea()); // 50.0
        System.out.println("cuboid.height= " + cuboid.getHeight()); // 5.0
        System.out.println("cuboid.volume= " + cuboid.getVolume()); // 250.0
    }
}

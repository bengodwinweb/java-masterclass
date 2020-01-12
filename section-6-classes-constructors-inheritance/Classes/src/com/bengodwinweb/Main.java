package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car kia = new Car();

        porsche.setModel("Carrera GT");
        System.out.println(porsche.getModel());

        kia.setModel("Forte 5");
    }
}

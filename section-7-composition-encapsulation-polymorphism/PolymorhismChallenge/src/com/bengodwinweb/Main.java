package com.bengodwinweb;

class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public Car(int cylinders, String name) {
        this(true, cylinders, 4, name);
    }

    public Car(boolean engine, int cylinders, int wheels, String name) {
        this.engine = engine;
        this.cylinders = cylinders;
        this.wheels = wheels;
        this.name = name;
    }

    public void startEngine() {
        System.out.println("Starting car engine");
    }

    public void accelerate() {
        System.out.println("Speeding up car");
    }

    public void brake() {
        System.out.println("Slowing down car");
    }

    public boolean hasEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getName() {
        return name;
    }
}

class Porsche extends Car {
    public Porsche() {
        super(8, "Porsche");
    }

    @Override
    public void startEngine() {
        System.out.println("Starting Porsche");
    }
}

class Kia extends Car {
    public Kia() {
        super(4, "Kia");
    }

    @Override
    public void startEngine() {
        System.out.println("Starting Kia");
    }
}

class Generic extends Car {
    public Generic() {
        super(6, "Generic");
    }
}

public class Main {

    public static void main(String[] args) {
	    Porsche porsche = new Porsche();
	    porsche.startEngine();
	    porsche.accelerate();

	    Kia kia = new Kia();
	    kia.startEngine();
	    kia.accelerate();

	    Generic car = new Generic();
	    car.startEngine();
	    car.accelerate();


    }
}

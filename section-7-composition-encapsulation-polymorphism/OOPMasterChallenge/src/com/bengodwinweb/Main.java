package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
        Cheese cheese = new Cheese();
	    Lettuce lettuce = new Lettuce();

	    Additional[] addOns = {cheese, lettuce};
	    Burger burger = new Burger("pretzel roll", "beef", addOns);

	    Avocado avocado = new Avocado();
	    Jalapeños jalapeños = new Jalapeños();
	    HealthyAdditional[] healthyAddOns = {avocado, jalapeños};
	    Burger burger2 = new HealthyBurger("chicken", addOns, healthyAddOns );

        System.out.println(burger.getBurger());
        System.out.println(burger2.getBurger());

        Burger deluxeBurger = new DeluxeBurger("beef");
		System.out.println(deluxeBurger.getBurger());
    }
}

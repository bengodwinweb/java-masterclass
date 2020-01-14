package com.bengodwinweb;

public class Avocado extends HealthyAdditional {
    public Avocado() {
        this("Avocado", 99);
    }

    private Avocado(String name, int price) {
        super(name, price);
    }
}

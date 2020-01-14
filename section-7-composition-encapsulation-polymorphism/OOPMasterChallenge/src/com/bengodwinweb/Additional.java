package com.bengodwinweb;

public class Additional {
    private String name;
    private int price;

    protected Additional(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

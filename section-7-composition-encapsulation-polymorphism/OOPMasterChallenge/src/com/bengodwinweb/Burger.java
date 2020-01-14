package com.bengodwinweb;

public class Burger {
    private String breadRollType;
    private String meat;
    private Additional [] addOns;

    private int basePrice;
    private int price;

    // Constructor methods
    public Burger(String breadRollType, String meat) {
        this(breadRollType, meat, new Additional[] {});
    }

    public Burger(String breadRollType, String meat, Additional[] addOns) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        basePrice = 499;
        this.addOns = addOns.length < 5 ? addOns : new Additional[] {};

        // Calculate price
        int price = basePrice;
        for (Additional additional : addOns) {
            price += additional.getPrice();
        }
        this.price = price;
    }

    public String getBurger() {
        String resultString = "Basic burger on a " + breadRollType + " and " + meat + " patty\n";
        if (addOns.length == 0) {
            resultString += "No add ons \n";
        } else {
            resultString += "Toppings:\n";
            for (Additional additional : addOns) {
                resultString += additional.getName() + " - " + toCurrency(additional.getPrice()) + "\n";
            }
        }
        resultString += "Total - " + toCurrency(price) + "\n";
        return resultString;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    public Additional[] getAddOns() {
        return addOns;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public int getBasePrice() {
        return basePrice;
    }

    protected int calculatePrice() {
        int total = basePrice;
        for (Additional additional : addOns) {
            total += additional.getPrice();
        }
        return total;
    }

    protected String toCurrency(int n) {
        return "$" + (n / 100d);
    }

}

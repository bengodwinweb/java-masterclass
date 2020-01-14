package com.bengodwinweb;

public class DeluxeBurger extends Burger {
    private DeluxeAdditional[] deluxeAddOns;

    public DeluxeBurger(String meat) {
        super("potato roll", meat);
        deluxeAddOns = new DeluxeAdditional[] {new Chips(), new Drink()};
        int deluxeBasePrice = 799;
        super.setPrice(deluxeBasePrice);
    }

    @Override
    public String getBurger() {
        int price = super.getPrice();
        return "Deluxe burger, chips and drink included (no add ons)\nTotal - " + super.toCurrency(price);
    }
}

package com.bengodwinweb;

public class HealthyBurger extends Burger {
    private HealthyAdditional[] healthyAddOns;

    public HealthyBurger(String meat) {
        this(meat, new HealthyAdditional[] {});
    }

    public HealthyBurger(String meat, HealthyAdditional[] healthyAddOns) {
        super("brown rye roll", meat);
        this.healthyAddOns = healthyAddOns.length < 3 ? healthyAddOns : new HealthyAdditional[] {};
    }

    public HealthyBurger(String meat, Additional[] addOns, HealthyAdditional[] healthyAddOns) {
        super("Brown rye roll", meat, addOns);
        this.healthyAddOns = healthyAddOns;
        updatePrice();
    }

    @Override
    public String getBurger() {
        Additional[] addOns = super.getAddOns();
        String breadRollType = super.getBreadRollType();
        String meat = super.getMeat();
        int price = super.getPrice();

        String resultString = "Healthy burger on a " + breadRollType + " and " + meat + " patty\n";
        if (addOns.length == 0) {
            resultString += "No add ons \n";
        } else {
            resultString += "Toppings:\n";
            for (Additional additional : addOns) {
                resultString += additional.getName() + " - " + toCurrency(additional.getPrice()) + "\n";
            }
        }
        if (healthyAddOns.length == 0) {
            resultString += "No healthy add ons \n";
        } else {
            resultString += "Healthy toppings:\n";
            for (HealthyAdditional additional : healthyAddOns) {
                resultString += additional.getName() + " - " + toCurrency(additional.getPrice()) + "\n";
            }
        }
        resultString += "Total - " + toCurrency(price) + "\n";
        return resultString;
    }

    private void updatePrice() {
        int price = super.getPrice();
        for (HealthyAdditional additional : healthyAddOns) {
            price += additional.getPrice();
        }
        super.setPrice(price);
    }

}

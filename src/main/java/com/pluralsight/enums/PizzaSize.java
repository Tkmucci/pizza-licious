package com.pluralsight.enums;

public enum PizzaSize {

    //declaring my pizza size and base price, size in inches and description
    SMALL_8(8.50,"8\"","Small"),
    MEDIUM_12(12.00,"12\"","Medium"),
    LARGE_16(16.50,"16\"","Large");

    //my declared variables
    private final double basePrice;
    private final String display;
    private final String name;

    //my constructor
    PizzaSize(double basePrice, String display, String name) {

        this.display = display;
        this.basePrice = basePrice;
        this.name = name;
    }

    //my getters
    //my get base price that returns the base price of the pizza
    public double getBasePrice() {
        return basePrice;
    }

    //my get display that returns the display size of the pizza
    public String getDisplay() {
        return display;
    }

    //my get name that returns the size name
    public String getName() {
        return name;
    }

    //printing out a formatted name for the price of the pizza and the size of the pizza
    @Override
    public String toString() {

        return String.format("%s (%s) - $%.2f",name,display,basePrice);
    }
}

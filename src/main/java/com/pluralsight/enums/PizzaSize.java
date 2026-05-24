package com.pluralsight.enums;

public enum PizzaSize {

    SMALL_8(8.50,"8\"","Small"),
    MEDIUM_12(12.00,"12\"","Medium"),
    LARGE_16(16.50,"16\"","Large");

    private final double basePrice;
    private final String display;
    private final String name;

    PizzaSize(double basePrice, String display, String name) {

        this.display = display;
        this.basePrice = basePrice;
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getDisplay() {
        return display;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return display;
    }
}

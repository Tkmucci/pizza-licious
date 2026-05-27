package com.pluralsight.enums;

public enum DrinkSize {

    SMALL(2.00, "Small"),
    MEDIUM(3.50, "Medium"),
    LARGE(4.50, "Large");

    private final double price;
    private final String name;

    DrinkSize(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }

}

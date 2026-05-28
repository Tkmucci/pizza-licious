package com.pluralsight.enums;

public enum DrinkSize {

    //declaring my drink size names and prices
    SMALL(2.00, "Small"),
    MEDIUM(2.50, "Medium"),
    LARGE(3.00, "Large");

    //declaring a variable to store the value of the price and name of the drink.
    private final double price;
    private final String name;

    //my constructor
    DrinkSize(double price, String name) {
        this.price = price;
        this.name = name;
    }

    //my getPrice method that returns the price of the drink
    public double getPrice() {
        return price;
    }

    //my getName method that returns the name of the drink
    public String getName() {
        return name;
    }

    //return the formatted name and price of the Drink
    @Override
    public String toString() {
        return String.format("%s - $%.2f",name, price);
    }

}

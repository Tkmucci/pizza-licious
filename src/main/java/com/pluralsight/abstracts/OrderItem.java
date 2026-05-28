package com.pluralsight.abstracts;

import com.pluralsight.interfaces.Price;

//making the class implement the interface to get the price and description of the product
public abstract class OrderItem implements Price {

    //making new variables for the item to get the price and product name.
    protected String name;
    protected double basePrice;

    //my constructor
    public OrderItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    //my abstract method for the calculated price
    public abstract double calculatePrice();

    //my get price method to get the product's price and overriding getPrice from Price interface
    @Override
    public double getPrice() {
        return calculatePrice();
    }

    //my get description method to get the description of the product, overriding the getDescription
    // from Price interface
    @Override
    public String getDescription() {
        return name;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
package com.pluralsight.abstracts;

import com.pluralsight.interfaces.Price;

public abstract class OrderItem implements Price {

    protected String name;
    protected double basePrice;

    public OrderItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();

    @Override
    public double getPrice() {
        return calculatePrice();
    }

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
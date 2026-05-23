package com.pluralsight.abstracts;

import com.pluralsight.interfaces.Price;

public abstract class OrderItem  implements Price {

    protected String name;
    protected double basePrice;

    public OrderItem(String name, double basePrice) {

        this.name = name;
        this.basePrice = basePrice;
    }

    abstract public double calculatePrice();

    public void setName(String name) {
        this.name = name;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public String getName() {
        return name;
    }
    public double getBasePrice() {
        return basePrice;
    }

}

package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;

public class GarlicKnots extends OrderItem {

    private static final double PRICE = 1.50;
    private int count;

    public GarlicKnots() {
        super("Garlic Knots", PRICE);
        this.count = 1;
    }

    public void incrementCount() {
        this.count++;
        this.basePrice = PRICE * count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return String.format("Garlic Knots (%d) - $%.2f", count, getPrice());
    }
}

package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;

public class GarlicKnots extends OrderItem {

    private static final double PRICE = 1.50;

    public GarlicKnots() {

        super("Garlic Knots", PRICE);
    }

    @Override
    public double calculatePrice() {

        return PRICE;
    }
    @Override
    public String getDescription() {

        return String.format("Garlic Knots - $%.2f", getPrice());
    }
}

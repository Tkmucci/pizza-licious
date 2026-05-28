package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;

public class GarlicKnots extends OrderItem {

    //declaring my variables
    private static final double PRICE = 1.50;
    private int count;

    //my constructor
    public GarlicKnots() {
        super("Garlic Knots", PRICE);
        this.count = 1;
    }

    //getting the count of the number of garlic knots
    public int getCount() {
        return count;
    }

    //increasing the number of garlic knots added and calculating the price
    public void incrementCount() {

        this.count++;
    }

    //calculating the garlic knots price, by their number.
    @Override
    public double calculatePrice() {

        this.basePrice = PRICE * count;
        return basePrice;
    }

    //printing out a formatted description of the transaction
    @Override
    public String getDescription() {
        return String.format("Garlic Knots (%d) - $%.2f", count, getPrice());
    }
}

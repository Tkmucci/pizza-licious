package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.DrinkSize;

public class Drink extends OrderItem {

    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {

        super(flavor, size.getPrice());

        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice(){

        return size.getPrice();
    }

    //@Override
}

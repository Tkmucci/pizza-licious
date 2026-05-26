package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.DrinkSize;

public class Drink extends OrderItem {

    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {

        super(flavor + " Drink", size.getPrice());

        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice(){

        return size.getPrice();
    }

    @Override
    public String getDescription() {

        return String.format("%s %s Drink - $%.2f",
                size.getName(), flavor, getPrice());
    }

    //getters and setters
    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}

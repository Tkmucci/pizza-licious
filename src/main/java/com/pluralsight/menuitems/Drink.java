package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.DrinkSize;

public class Drink extends OrderItem {

    private DrinkSize size;
    private String flavor;
    private int count;

    public Drink(DrinkSize size, String flavor) {

        super(flavor + " Drink", size.getPrice());

        this.size = size;
        this.flavor = flavor;
        this.count = 1;
    }

    public void incrementCount() {

        count++;
    }

    public boolean drinkIsTheSame(DrinkSize size, String flavor) {

        return this.size == size && this.flavor.equalsIgnoreCase(flavor) ;
    }

    @Override
    public double calculatePrice(){

        return size.getPrice() * count;
    }

    @Override
    public String getDescription() {

        if (count > 1) {
            return String.format("%s %s Drink (%d) - $%.2f",
                    size.getName(), flavor, count, getPrice());
        }

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

package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.DrinkSize;

public class Drink extends OrderItem {

    //declaring my variables
    private DrinkSize size;
    private String flavor;
    private int count;

    //my constructor
    public Drink(DrinkSize size, String flavor) {

        super(flavor + " Drink", size.getPrice());

        this.size = size;
        this.flavor = flavor;
        this.count = 1;
    }

    //my increment count to increment the number of times a drink of the same name and size is ordered
    public void incrementCount() {

        count++;
    }

    //my method that validates if the drink is the same and increase the count
    public boolean drinkIsTheSame(DrinkSize size, String flavor) {

        return this.size == size && this.flavor.equalsIgnoreCase(flavor) ;
    }

    //my method that calculates the price based on how many drinks have been orderd
    @Override
    public double calculatePrice(){

        return size.getPrice() * count;
    }

    //my getDescription that prints out
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

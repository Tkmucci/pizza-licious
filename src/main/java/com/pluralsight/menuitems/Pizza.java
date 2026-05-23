package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.PizzaSize;

import java.util.List;

public class Pizza extends OrderItem {

    private PizzaSize size;
    private String crustType;
    private List<Topping> meats;
    private List<Topping> cheeses;
    private List<Topping> regularToppings;
    private String sauce;
    private boolean stuffedCrust;
    private boolean extraMeat;
    private boolean extraCheese;

    public Pizza(String name, double basePrice) {

        super(name,basePrice);

        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public double getPrice(){

        return 0;
    }

    @Override
    public String getDescription(){

        return "Pizza";
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}

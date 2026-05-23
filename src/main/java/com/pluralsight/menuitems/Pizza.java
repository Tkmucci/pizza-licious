package com.pluralsight.menuitems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.PizzaSize;
import java.util.ArrayList;
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

    public Pizza(PizzaSize size, String crustType, String sauce) {
        super("", 0.00);
        this.size = size;
        this.crustType = crustType;
        this.sauce = sauce;
        this.stuffedCrust = false;
        this.extraMeat = false;
        this.extraCheese = false;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
    }

    @Override
    public double calculatePrice() {
        double total = 0;


        return total;
    }

    @Override
    public double getPrice() {
        return calculatePrice();
    }

    @Override
    public String getDescription() {
        return "Pizza Description coming soon";
    }

    public void addMeat(Topping meat) { meats.add(meat); }
    public void addCheese(Topping cheese) { cheeses.add(cheese); }
    public void addRegularTopping(Topping topping) { regularToppings.add(topping); }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public List<Topping> getMeats() {
        return meats;
    }

    public void setMeats(List<Topping> meats) {
        this.meats = meats;
    }

    public List<Topping> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<Topping> cheeses) {
        this.cheeses = cheeses;
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<Topping> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }
}
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

        super("Custom Pizza", size.getBasePrice());
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
        double total = size.getBasePrice();

        //add meat toppings, with the optional extra
        for (Topping meat : meats) {

            total += meat.getPrice(size);

            if (extraMeat) {

                total += meat.getExtraPrice(size);
            }
        }

        //add cheeses toppings, with the optional extra
        for (Topping cheese : cheeses) {

            total += cheese.getPrice(size);

            if (extraCheese) {

                total += cheese.getExtraPrice(size);
            }
        }

        //since regular toppings are free, we won't add anything.

        //add stuffed crust if selected
        if (this.stuffedCrust) {

            total += getStuffedCrustPrice();
        }

        return total;
    }

    private double getStuffedCrustPrice() {

        switch (size) {

            case SMALL_8:

                return 1.00;

            case MEDIUM_12:

                return 1.50;

            case LARGE_16:

                return 2.00;

            default:

                return 0.00;
        }
    }

    @Override
    public String getDescription() {

        StringBuilder orderDescription = new StringBuilder();
        orderDescription.append(size.getDisplay()).append(" ").append(name).append("\n");
        orderDescription.append("  Crust: ").append(crustType).append("\n");
        orderDescription.append("  Sauce: ").append(sauce).append("\n");

        if (!meats.isEmpty()) {

            orderDescription.append("  Meats: ");

            for (int i = 0; i < meats.size(); i++) {

                orderDescription.append(meats.get(i).getName());

                if (i < meats.size() - 1) orderDescription.append(", ");

            }
            if (extraMeat) orderDescription.append(" (EXTRA)");

            orderDescription.append("\n");
        }

        if (!cheeses.isEmpty()) {

            orderDescription.append("  Cheeses: ");

            for (int i = 0; i < cheeses.size(); i++) {

                orderDescription.append(cheeses.get(i).getName());

                if (i < cheeses.size() - 1) orderDescription.append(", ");

            }
            if (extraCheese) orderDescription.append(" (EXTRA)");

            orderDescription.append("\n");
        }

        if (!regularToppings.isEmpty()) {

            orderDescription.append("  Toppings: ");

            for (int i = 0; i < regularToppings.size(); i++) {

                orderDescription.append(regularToppings.get(i).getName());

                if (i < regularToppings.size() - 1) orderDescription.append(", ");

            }

            orderDescription.append("\n");
        }

        if (stuffedCrust) {
            orderDescription.append("  Stuffed Crust\n");
        }

        orderDescription.append("  Price: $").append(String.format("%.2f", getPrice()));

        return orderDescription.toString();
    }

    //methods to add toppings
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
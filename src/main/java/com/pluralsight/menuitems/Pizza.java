package com.pluralsight.menuitems;

//importing my other classes so I can use their data
import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.SauceType;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends OrderItem {

    //my declared variables
    private PizzaSize size;
    private CrustType crustType;
    private List<Topping> meats;
    private List<Topping> cheeses;
    private List<Topping> regularToppings;
    private SauceType sauce;
    private boolean stuffedCrust;
    private boolean extraMeat;
    private boolean extraCheese;
    private int count;

    // my constructor
    public Pizza(PizzaSize size, CrustType crustType, SauceType sauce) {


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
        this.count = 1;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    //increasing the number of pizzas bought
    public void incrementCount() {
        count++;
    }

    //determining if the same pizza is order so we can increase the count number
    public boolean matchesPremade(String pizzaName, PizzaSize size) {
        return this.name.equals(pizzaName) && this.size == size;
    }


    //calculating the pizza total price multiplying it by the number of pizzas
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

        return total * count;
    }

    //if a user chooses to get stuffed crust this is the method that I use to add to the total
    private double getStuffedCrustPrice() {

        return switch (size) {
            case SMALL_8 -> 1.00;
            case MEDIUM_12 -> 1.50;
            case LARGE_16 -> 2.00;
            default -> 0.00;
        };
    }

    //this is how I print my pizzas in the receipt. i formatted it how I want it to appear
    @Override
    public String getDescription() {

        //string builder that I am using to structure my printout
        StringBuilder orderDescription = new StringBuilder();

        //checking if the count is more than 1 so a different printout that shows the number of pizzas ordered
        if (count > 1) {

            orderDescription.append(size.getDisplay()).append(" ").append(name)
                    .append(" x (").append(count).append(")\n");

        } else {

            orderDescription.append(size.getDisplay()).append(" ").append(name).append("\n");

        }

        //displaying what crust and sauce is chosen by the user.
        orderDescription.append("  Crust: ").append(crustType).append("\n");
        orderDescription.append("  Sauce: ").append(sauce).append("\n");

        //checking if the user selected meat
        if (!meats.isEmpty()) {

            orderDescription.append("  Meats: ");

            for (int i = 0; i < meats.size(); i++) {

                orderDescription.append(meats.get(i).name());

                if (i < meats.size() - 1) orderDescription.append(", ");

            }
            if (extraMeat) orderDescription.append(" (EXTRA)");

            orderDescription.append("\n");
        }

        if (!cheeses.isEmpty()) {

            orderDescription.append("  Cheeses: ");

            for (int i = 0; i < cheeses.size(); i++) {

                orderDescription.append(cheeses.get(i).name());

                if (i < cheeses.size() - 1) orderDescription.append(", ");

            }
            if (extraCheese) orderDescription.append(" (EXTRA)");

            orderDescription.append("\n");
        }

        if (!regularToppings.isEmpty()) {

            orderDescription.append("  Toppings: ");

            for (int i = 0; i < regularToppings.size(); i++) {

                orderDescription.append(regularToppings.get(i).name());

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

    public CrustType getCrustType() {
        return crustType;
    }

    public void setCrustType(CrustType crustType) {
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

    public SauceType getSauce() {
        return sauce;
    }

    public void setSauce(SauceType sauce) {
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

    //my premade pizzas
    //the Classic — Marinara, Regular crust, Pepperoni + Sausage, Mozzarella
    public static Pizza theClassic(PizzaSize size) {
        Pizza pizza = new Pizza(size, CrustType.REGULAR, SauceType.MARINARA);
        pizza.setName("The Classic");
        pizza.addMeat(Topping.PEPPERONI);
        pizza.addMeat(Topping.SAUSAGE);
        pizza.addCheese(Topping.MOZZARELLA);
        return pizza;
    }

    //BBQ Chicken — BBQ sauce, Thick crust, Chicken + Bacon, Mozzarella
    public static Pizza bbqChicken(PizzaSize size) {
        Pizza pizza = new Pizza(size, CrustType.THICK, SauceType.BBQ);
        pizza.setName("BBQ Chicken");
        pizza.addMeat(Topping.CHICKEN);
        pizza.addMeat(Topping.BACON);
        pizza.addCheese(Topping.MOZZARELLA);
        return pizza;
    }

    //the Veggie — Pesto sauce, Thin crust, Mozzarella + Parmesan, veggies
    public static Pizza theVeggie(PizzaSize size) {
        Pizza pizza = new Pizza(size, CrustType.THIN, SauceType.PESTO);
        pizza.setName("The Veggie");
        pizza.addCheese(Topping.MOZZARELLA);
        pizza.addCheese(Topping.PARMESAN);
        pizza.addRegularTopping(Topping.MUSHROOMS);
        pizza.addRegularTopping(Topping.BELL_PEPPERS);
        pizza.addRegularTopping(Topping.ONIONS);
        pizza.addRegularTopping(Topping.SPINACH);
        pizza.addRegularTopping(Topping.TOMATOES);
        return pizza;
    }

    //buffalo Blaze — Buffalo sauce, Regular crust, Chicken, Buffalo Cheese
    public static Pizza buffaloBlaze(PizzaSize size) {
        Pizza pizza = new Pizza(size, CrustType.REGULAR, SauceType.BUFFALO);
        pizza.setName("Buffalo Blaze");
        pizza.addMeat(Topping.CHICKEN);
        pizza.addCheese(Topping.BUFFALO_CHEESE);
        pizza.addCheese(Topping.MOZZARELLA);
        return pizza;
    }

    //the Meat Lover — Marinara, Thick crust, all 6 meats, Mozzarella + Parmesan
    public static Pizza meatLover(PizzaSize size) {
        Pizza pizza = new Pizza(size, CrustType.THICK, SauceType.MARINARA);
        pizza.setName("Meat Lover");
        pizza.addMeat(Topping.PEPPERONI);
        pizza.addMeat(Topping.SAUSAGE);
        pizza.addMeat(Topping.HAM);
        pizza.addMeat(Topping.BACON);
        pizza.addMeat(Topping.CHICKEN);
        pizza.addMeat(Topping.MEATBALL);
        pizza.addCheese(Topping.MOZZARELLA);
        pizza.addCheese(Topping.PARMESAN);
        return pizza;
    }

}
package com.pluralsight.menuitems;

import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.ToppingsType;

public record Topping(String name, ToppingsType type) {

    //this is to get the price of this topping based on size and type
    public double getPrice(PizzaSize size) {

        return switch (type) {

            case MEAT -> getMeatPrice(size);

            case CHEESE -> getCheesePrice(size);

            case REGULAR ->
                //hard-coded zero because regular toppings are free.
                    0.00;
        };

    }

    //this is to get the extra price of this topping based on size and type
    public double getExtraPrice(PizzaSize size) {

        return switch (type) {

            case MEAT -> getExtraMeatPrice(size);

            case CHEESE -> getExtraCheesePrice(size);

            case REGULAR ->

                //hard-coded zero because regular toppings are free even if they are extra toppings
                    0.00;


        };
    }

    private double getMeatPrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 1.00;

            case MEDIUM_12 -> 2.00;

            case LARGE_16 -> 3.00;
        };
    }

    private double getExtraMeatPrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 0.50;

            case MEDIUM_12 -> 1.00;

            case LARGE_16 -> 1.50;

        };
    }

    public double getCheesePrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 0.75;

            case MEDIUM_12 -> 1.50;

            case LARGE_16 -> 2.25;

        };
    }

    public double getExtraCheesePrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 0.30;

            case MEDIUM_12 -> 0.60;

            case LARGE_16 -> 0.90;

        };
    }

    @Override
    public String toString() {

        return name;
    }

    //predefined topping constants for easy use

    //meat toppings
    public static final Topping PEPPERONI = new Topping("Pepperoni", ToppingsType.MEAT);
    public static final Topping SAUSAGE = new Topping("Sausage", ToppingsType.MEAT);
    public static final Topping HAM = new Topping("Ham", ToppingsType.MEAT);
    public static final Topping BACON = new Topping("Bacon", ToppingsType.MEAT);
    public static final Topping CHICKEN = new Topping("Chicken", ToppingsType.MEAT);
    public static final Topping MEATBALL = new Topping("Meatball", ToppingsType.MEAT);

    //cheese toppings
    public static final Topping MOZZARELLA = new Topping("Mozzarella", ToppingsType.CHEESE);
    public static final Topping PARMESAN = new Topping("Parmesan", ToppingsType.CHEESE);
    public static final Topping RICOTTA = new Topping("Ricotta", ToppingsType.CHEESE);
    public static final Topping GOAT_CHEESE = new Topping("Goat Cheese", ToppingsType.CHEESE);
    public static final Topping BUFFALO_CHEESE = new Topping("Buffalo", ToppingsType.CHEESE);

    //regular toppings
    public static final Topping ONIONS = new Topping("Onions", ToppingsType.REGULAR);
    public static final Topping MUSHROOMS = new Topping("Mushrooms", ToppingsType.REGULAR);
    public static final Topping BELL_PEPPERS = new Topping("Bell Peppers", ToppingsType.REGULAR);
    public static final Topping OLIVES = new Topping("Olives", ToppingsType.REGULAR);
    public static final Topping TOMATOES = new Topping("Tomatoes", ToppingsType.REGULAR);
    public static final Topping SPINACH = new Topping("Spinach", ToppingsType.REGULAR);
    public static final Topping BASIL = new Topping("Basil", ToppingsType.REGULAR);
    public static final Topping PINEAPPLE = new Topping("Pineapple", ToppingsType.REGULAR);
    public static final Topping ANCHOVIES = new Topping("Anchovies", ToppingsType.REGULAR);

}

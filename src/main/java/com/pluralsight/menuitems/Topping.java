package com.pluralsight.menuitems;

import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.ToppingsType;

public class Topping {

    private String name;
    private ToppingsType type;

    public Topping (String name, ToppingsType type) {

        this.name = name;
        this.type = type;
    }

    //this is to get the price of this topping based on size and type
    public double getPrice (PizzaSize size) {

        switch (type){

            case MEAT, CHEESE:

                return getPrice(size);

            case REGULAR:

                //hard-coded zero because regular toppings are free.
                return 0.00;
            default:
                return 0.00;
        }

    }

    //this is to get the extra price of this topping based on size and type
    public double getExtraPrice(PizzaSize size){

        switch (type){

            case MEAT, CHEESE:

                return getExtraPrice(size);

            case REGULAR:

                //hard-coded zero because regular toppings are free even if they are extra toppings
                return 0.00;

            default:

                return 0.00;

        }
    }

    private double getMeatPrice(PizzaSize size) {

        switch (size) {

            case SMALL_8:

                return 1.00;

            case MEDIUM_12:

                return 2.00;

            case LARGE_16:

                return 3.00;

            default:

                return 0.00;
        }
    }

    private double getExtraMeatPrice(PizzaSize size) {

        switch (size) {

            case SMALL_8:

                return 0.50;

            case MEDIUM_12:

                return 1.00;

            case LARGE_16:

                return 1.50;

            default:

                return 0.00;
        }
    }

    public double getCheesePrice(PizzaSize size) {

        switch (size) {

            case SMALL_8:

                return 0.75;

            case MEDIUM_12:

                return 1.50;

            case LARGE_16:

                return 2.25;

            default:

                return 0.00;
        }
    }

}

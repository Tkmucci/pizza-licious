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

    //this is to get the price of this
    public double getPrice (PizzaSize size) {

        switch (type){

            case MEAT:
                return getPrice(size);
            case CHEESE:
                return getPrice(size);
            case REGULAR:

                //hard-coded zero because regular toppings are free.
                return 0.00;
            default:
                return 0.00;
        }

    }

}

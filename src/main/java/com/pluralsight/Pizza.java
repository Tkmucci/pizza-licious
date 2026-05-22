package com.pluralsight;

import com.pluralsight.abstracts.OrderItem;

public class Pizza extends OrderItem {

    public Pizza(){

        super();
    }

    @Override
    public double getPrice(){

        return 0;
    }

    @Override
    public String getDescription(){

        return "Pizza";
    }

}

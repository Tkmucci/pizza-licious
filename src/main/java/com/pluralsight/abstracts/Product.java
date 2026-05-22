package com.pluralsight.abstracts;

import com.pluralsight.interfaces.Price;

public abstract class Product implements Price {

    public Product(){

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

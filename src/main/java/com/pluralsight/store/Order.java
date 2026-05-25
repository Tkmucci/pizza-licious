package com.pluralsight.store;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.menuitems.Drink;
import com.pluralsight.menuitems.GarlicKnots;
import com.pluralsight.menuitems.Pizza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;
    private String customerName;
    private LocalDateTime orderTime;

    //for testing
//    public Order(){
//
//        this.items = new ArrayList<>();
//        this.orderTime = LocalDateTime.now();
//        this.customerName = "Guest";
//    }

    public Order(String customerName){
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.customerName = customerName;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void addPizza(Pizza pizza){
        items.add(pizza);
    }

    public void addDrink(Drink drink){
        items.add(drink);
    }

    public void addGarlicKnots(GarlicKnots garlicknots){
        items.add(garlicknots);
    }

    public double getTotal(){

        double total = 0.0;

        for (OrderItem item : this.items) {

            total = total + item.getPrice();

        }
        return total;
    }

    public boolean isEmpty() {

        return this.items.isEmpty();
    }

    public int getItemCount() {

        return this.items.size();
    }

    public String getCustomerName() {
        return customerName;
    }

}

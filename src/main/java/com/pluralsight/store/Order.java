package com.pluralsight.store;

import com.pluralsight.abstracts.OrderItem;

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

    public String getCustomerName() {
        return customerName;
    }

}

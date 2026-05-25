package com.pluralsight.store;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.menuitems.Drink;
import com.pluralsight.menuitems.GarlicKnots;
import com.pluralsight.menuitems.Pizza;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public String getReceiptSaveName(){

        DateTimeFormatter receiptTimeFormatter = DateTimeFormatter.ofPattern("yyyMMdd-HHmmss");

        return orderTime.format(receiptTimeFormatter);
    }

    public String getFormattedOrderTime() {

        DateTimeFormatter orderTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        return orderTime.format(orderTimeFormatter);
    }

    @Override
    public String toString(){

        StringBuilder receiptPrintout = new StringBuilder();

        //for testing

        receiptPrintout.append("=".repeat(34));
        receiptPrintout.append("\nMUCCI & CO. ARTISAN PIZZA\n");
        receiptPrintout.append("=".repeat(34));
        receiptPrintout.append("\nCustomer: ").append(customerName).append("\n");
        receiptPrintout.append("Order Time: ").append(getFormattedOrderTime()).append("\n");
        receiptPrintout.append("-".repeat(34));
        receiptPrintout.append("\nITEMS: ");

        for (int i = 0; i < items.size(); i++) {

            receiptPrintout.append(i + 1).append(". ").append(this.items.get(i).getDescription()).append("\n");
        }

        receiptPrintout.append("\n").append("-".repeat(34));
        receiptPrintout.append(String.format("\nTotal: $%.2f\n",getTotal()));
        receiptPrintout.append("~".repeat(34));
        receiptPrintout.append("\n  Thank you, please call again!\n");
        receiptPrintout.append("~".repeat(34));

        return receiptPrintout.toString();
    }

    public String getCustomerName() {
        return customerName;
    }

}

package com.pluralsight.store;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.menuitems.Drink;
import com.pluralsight.menuitems.GarlicKnots;
import com.pluralsight.menuitems.Pizza;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //declaring my variables
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

    //my constant
    public Order(String customerName){
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
//        this.customerName = customerName;

        //formatting the customer name the way I prefer.
        if (customerName == null || customerName.isEmpty()) {

            this.customerName = "Mucci's Guest";
        } else {

            //capitalizing first letter
            this.customerName = customerName.substring(0, 1).toUpperCase() +
                    customerName.substring(1).toLowerCase();
        }

    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    //checking if a user orders the same pizza twice and increment it
    public void addPizza(Pizza pizza){

        // for premade pizzas, check if the same one already exists
        for (OrderItem item : items) {

            if (item instanceof Pizza existing) {

                if (existing.matchesPremade(pizza.getName(), pizza.getSize())) {

                    System.out.println("You ordered this pizza before we went ahead and increased your order.");
                    existing.incrementCount();
                    return;
                }
            }
        }
        // custom pizzas or new premade — just add
        items.add(pizza);
    }

    //adding drink to the order
    public void addDrink(Drink drink){

        //check if same size and flavor are already in the order and increase the order
        for (OrderItem item : items) {

            if (item instanceof Drink existing) {

                if (existing.drinkIsTheSame(drink.getSize(), drink.getFlavor())) {

                    existing.incrementCount();
                    return;
                }
            }
        }
        items.add(drink);
    }

    private GarlicKnots garlicKnots = null;

    public void addGarlicKnots(GarlicKnots newKnots) {

        if (garlicKnots == null) {

            garlicKnots = newKnots;
            items.add(garlicKnots);
        } else {
            garlicKnots.incrementCount();
        }
    }

    public int getGarlicKnotsCount() {

        if (garlicKnots == null) {

            return 0;
        }
        return garlicKnots.getCount();
    }

    //checking if the order has pizza
    public boolean hasPizza() {
        for (OrderItem item : items) {
            if (item instanceof Pizza) {
                return true;
            }
        }
        return false;
    }

    //checking if the order has garlic knots
    public boolean hasGarlicKnots() {
        for (OrderItem item : items) {
            if (item instanceof GarlicKnots) {
                return true;
            }
        }
        return false;
    }

    //checking if the order has a Drink
    public boolean hasDrink() {
        for (OrderItem item : items) {
            if (item instanceof Drink) {
                return true;
            }
        }
        return false;
    }


    //calculating the order total
    public double getTotal(){

        double total = 0.0;

        for (OrderItem item : this.items) {

            total = total + item.getPrice();

        }
        return total;
    }

//    public boolean isEmpty() {
//
//        return this.items.isEmpty();
//    }

    //incrementing item number
    public int getItemCount() {

        return this.items.size();
    }

    //formatted receipt name
    public String getReceiptSaveName(){

        DateTimeFormatter receiptTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        return orderTime.format(receiptTimeFormatter) + ".txt";
    }

    //formatting the date and time of the order
    public String getFormattedOrderTime() {

        DateTimeFormatter orderTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        return orderTime.format(orderTimeFormatter);
    }

    //the layout that my receipt should have structured using a string builder
    @Override
    public String toString(){

        StringBuilder receiptPrintout = new StringBuilder();


        receiptPrintout.append("=".repeat(34));
        receiptPrintout.append("\nMUCCI & CO. ARTISAN PIZZA\n");
        receiptPrintout.append("=".repeat(34));
        receiptPrintout.append("\nCustomer: ").append(customerName).append("\n");
        receiptPrintout.append("Order Time: ").append(getFormattedOrderTime()).append("\n");
        receiptPrintout.append("-".repeat(34));
        receiptPrintout.append("\nITEMS: \n");

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

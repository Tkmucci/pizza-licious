package com.pluralsight;

import com.pluralsight.store.Order;

import java.util.Scanner;

public class UserInterface {

    private Scanner userInput;
    private Order currentOrder;

    public UserInterface() {

        this.userInput = new Scanner(System.in);
    }

    public void showWelcomeMessage() {

        System.out.println("=".repeat(5));
        System.out.println("Welcome to Mucci & Co. Artisan Pizza");
        System.out.println("=".repeat(5));

        startNewOrder();
        System.out.println("Starting order for " + currentOrder.getCustomerName());
    }

    private void startNewOrder() {

        currentOrder = new Order();

    }

}

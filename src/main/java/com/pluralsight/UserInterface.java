package com.pluralsight;

import com.pluralsight.store.Order;

import java.util.Scanner;

public class UserInterface {

    private Scanner userInput;
    private Order currentOrder;

    public UserInterface() {

        this.userInput = new Scanner(System.in);
    }

    public void run() {

        showWelcomeMessage();
        homeScreen();
    }

    private void showWelcomeMessage() {

        System.out.println("=".repeat(36));
        System.out.println("Welcome to Mucci & Co. Artisan Pizza");
        System.out.println("=".repeat(36));

        startNewOrder();
        System.out.println("Starting order for " + currentOrder.getCustomerName());
    }

    private void startNewOrder() {

        String customerName = userInput.nextLine().trim();
        currentOrder = new Order(customerName);

    }

    private void homeScreen() {


    }

}

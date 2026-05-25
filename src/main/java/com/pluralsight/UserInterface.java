package com.pluralsight;

import com.pluralsight.store.Order;
import com.pluralsight.store.ReceiptManager;

import java.util.Scanner;

public class UserInterface {

    private Scanner userInput;
    private Order currentOrder;
    private ReceiptManager receiptManager;

    public UserInterface() {

        this.userInput = new Scanner(System.in);
        this.receiptManager = new ReceiptManager();
    }

    public void run() {

        showWelcomeMessage();
        homeScreen();

        //testing
        System.out.println(currentOrder.toString());

    }

    private void showWelcomeMessage() {

        //testing the method
        System.out.println("=".repeat(36));
        System.out.println("Welcome to Mucci & Co. Artisan Pizza");
        System.out.println("=".repeat(36));

        startNewOrder();
        System.out.println("Starting order for " + currentOrder.getCustomerName());
    }

    private void startNewOrder() {

        System.out.print("Customer Name (For 'Guest' press Enter: ");
        String customerName = userInput.nextLine().trim();
        currentOrder = new Order(customerName);

    }

    private void homeScreen() {


    }

}

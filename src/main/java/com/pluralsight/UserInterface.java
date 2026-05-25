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

        System.out.println("Starting order for" + currentOrder);
        startNewOrder();
    }

    private void startNewOrder() {

        System.out.println(currentOrder);

    }

}

package com.pluralsight;

import com.pluralsight.store.Order;

public class UserInterface {

    private Order currentOrder;

    private void showWelcomeMessage() {

        System.out.println("=".repeat(5));
        System.out.println("Welcome to Mucci & Co. Artisan Pizza");
        System.out.println("=".repeat(5));
    }

}

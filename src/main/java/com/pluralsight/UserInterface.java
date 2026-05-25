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

    }

    private void startNewOrder() {

        System.out.print("Customer Name (For 'Guest' press Enter: ");
        String customerName = userInput.nextLine().trim();

        System.out.println("Starting order for " + currentOrder.getCustomerName());

        currentOrder = new Order(customerName);

    }

    private void homeScreen() {

        System.out.print("""
                --- HOME MENU ---
                1) New Order
                0) Exit
                """);


        int userOption;

        do {

            System.out.print("Option: ");

            if (!userInput.hasNextInt()) {

                System.out.println("⚠️: Enter numbers only!");
                userInput.nextLine();
                userOption = -1;

            } else {

                userOption = userInput.nextInt();

                userInput.nextLine();
            }
            if (userOption < 0 || userOption > 1) {

                System.out.println("⚠️: Wrong choice (choose 0 or 1) try again!");
            }

        } while (userOption < 0 || userOption > 1);


        switch (userOption) {

            case 1:
                startNewOrder();
                break;
            case 0:

                System.out.println("""
                        \nThank you for visiting Mucci & Co.!
                        Have a great day! 🍕""");
                System.exit(0);


        }

    }

}

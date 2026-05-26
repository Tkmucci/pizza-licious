package com.pluralsight;

import com.pluralsight.enums.PizzaSize;
import com.pluralsight.menuitems.Pizza;
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

        System.out.print("Customer Name (For 'Guest' press Enter): ");
        String customerName = userInput.nextLine().trim();

        currentOrder = new Order(customerName);

        System.out.println("Starting order for " + currentOrder.getCustomerName());

        orderScreen();

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

            userOption = getUserOption(1);

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

    private void orderScreen() {

        int userOption;

        do {

            System.out.printf("""
                            \n--- ORDER MENU ---
                            Current items: %s
                            Current total: $%.2f
                            
                            1) Add Pizza
                            2) Add Drink
                            3) Add Garlic Knots
                            4) Checkout
                            0) Cancel order)
                            Option:
                            """
                    , currentOrder.getItemCount()
                    , currentOrder.getTotal()
            );


            userOption = getUserOption(4);


        } while (userOption < 0 || userOption > 4);

        switch (userOption) {

            case 1:
                System.out.println("Add pizza screen coming soon!!!");
                checkoutScreen();
            case 2:
                System.out.println("Add Drink screen coming soon!!!");
                break;
            case 3:
                System.out.println("Add Garlic Knots screen coming soon!!!");
                break;
            case 4:
                checkoutScreen();
                break;
            case 0:

                System.out.println("Canceling order, confirm?: ");
                String userConfirmation = userInput.nextLine();

                if (userConfirmation.equalsIgnoreCase("yes") || userConfirmation.equalsIgnoreCase("y")) {

                    return;
                }
                System.exit(0);

            default:
                System.out.println("⚠️:Enter a number between 1 and 4 and try again");

        }

    }

    private void addPizzaMenuScreen() {

        System.out.println("\n--- BUILD YOUR PIZZA ---");

        //selecting the pizza size
        System.out.print("""
                \n--- BUILD YOUR PIZZA ---
                
                Select pizza size:
                1) Small 8 - $8.50
                2) Medium 12 - $12.00
                3) Large 16 - $16.50
                Choose size:\s
                """);

        int sizeChoice = getUserOption(3);

        PizzaSize size = null;
        switch (sizeChoice) {
            case 1:
                size = PizzaSize.SMALL_8;
                break;
            case 2:
                size = PizzaSize.MEDIUM_12;
                break;
            case 3:
                size = PizzaSize.LARGE_16;
                break;
            default:
                System.out.println("Invalid size. Pizza not added to cart. Please try again.");
        }

        //selecting the crust
        System.out.print("""
                \n--- Select crust ---
                1) Thin
                2) Regular
                3) Thick
                4) Cauliflower
                Choose crust:\s
                """);
        int crustChoice = getUserOption(4);

        String crust = "";
        switch (crustChoice) {
            case 1:
                crust = "Thin";
                break;
            case 2:
                crust = "Regular";
                break;
            case 3:
                crust = "Thick";
                break;
            case 4:
                crust = "Cauliflower";
                break;
            default:
                System.out.println("Invalid crust. Pizza not added.");
        }

        //select sauce
        System.out.print("""
                \n--- Select sauce ---
                1) Marinara
                2) Alfredo
                3) Pesto
                4) BBQ
                5) Buffalo
                6) Olive Oil
                Choose sauce:\s
                """);
        int sauceChoice = getUserOption(6);

        String sauce = "";
        switch (sauceChoice) {
            case 1:
                sauce = "Marinara";
                break;
            case 2:
                sauce = "Alfredo";
                break;
            case 3:
                sauce = "Pesto";
                break;
            case 4:
                sauce = "BBQ";
                break;
            case 5:
                sauce = "Buffalo";
                break;
            case 6:
                sauce = "Olive Oil";
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        //create pizza
        Pizza pizza = new Pizza(size, crust, sauce);

        //add meats

        //add cheeses

        //add regular toppings

        //stuffed crust
        System.out.print("\nWould you like stuffed crust? (+$" + getStuffedCrustPrice(size) + ") (y/n): ");

        if (userInput.nextLine().trim().equalsIgnoreCase("y") || userInput.nextLine().trim().equalsIgnoreCase("yes")) {

            pizza.setStuffedCrust(true);
        }

    }

    private String getStuffedCrustPrice(PizzaSize size) {

        return "12.00";
    }

    private int getUserOption(int optionMax) {

        int userOption;

        if (!userInput.hasNextInt()) {

            System.out.println("⚠️: Enter numbers only!");
            userInput.nextLine();
            userOption = -1;

        } else {

            userOption = userInput.nextInt();
            userInput.nextLine();
        }

        if (userOption < 0 || userOption > optionMax) {

            System.out.println("⚠️: Wrong choice (choose 0 or 1) try again!");
        }
        return userOption;
    }

    private void checkoutScreen() {

        if (currentOrder.isEmpty()) {

            System.out.println("\n⚠️: Cannot checkout with an empty order!");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("CHECKOUT - ORDER SUMMARY");
        System.out.println("=".repeat(50));
        System.out.println(currentOrder.toString());

        System.out.print("Confirm order? (y/n): ");
        String confirm = userInput.nextLine().trim();

        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {

            receiptManager.saveReceipt(currentOrder);
            System.out.println("\nOrder completed successfully!");
        } else {

            System.out.println("\nOrder cancelled.");
        }
    }

}

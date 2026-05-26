package com.pluralsight.store;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.menuitems.Drink;
import com.pluralsight.menuitems.GarlicKnots;
import com.pluralsight.menuitems.Pizza;
import com.pluralsight.menuitems.Topping;

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
        //System.out.println(currentOrder.toString());

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

        while (true) {

                System.out.printf("""
                                \n
                                --- ORDER MENU ---
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


            int userOption = getUserOption(4);




            switch (userOption) {

                case 1:
                    addPizzaMenuScreen();
                    break;
                case 2:
                    addDrinkScreen();
                    break;
                case 3:
                    addGarlicKnotsScreen();
                    break;
                case 4:
                    checkoutScreen();
                    return;
                case 0:

                    System.out.println("Canceling order, confirm?: ");
                    String userConfirmation = userInput.nextLine();

                    if (userConfirmation.equalsIgnoreCase("yes") || userConfirmation.equalsIgnoreCase("y")) {

                        return;
                    }
                    else {
                    System.exit(0);
                    }

                default:
                    System.out.println("⚠️:Enter a number between 1 and 4 and try again");

            }
        }

    }

    private void addPizzaMenuScreen() {

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

        PizzaSize size;

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
                return;
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
                return;
        }

        //create pizza
        Pizza pizza = new Pizza(size, crust, sauce);

        //add meats
        addMeatToppings(pizza);

        //add cheeses
        addCheeseToppings(pizza);

        //add regular toppings
        addRegularToppings(pizza);

        //stuffed crust
        System.out.printf("\nWould you like stuffed crust? (+$%.2f) (y/n): ", getStuffedCrustPrice(size));

        String stuffedAnswer = userInput.nextLine().trim();

        if (stuffedAnswer.equalsIgnoreCase("y") || stuffedAnswer.equalsIgnoreCase("yes")) {

            pizza.setStuffedCrust(true);
        }

        currentOrder.addPizza(pizza);
        System.out.printf("\nPizza added to order! Price: $%.2f",currentOrder.getTotal());

    }

    private void addMeatToppings(Pizza pizza) {

        System.out.println("""
                \n--- MEAT TOPPINGS ---
                
                Pricing: 8" = $1.00, 12" = $2.00, 16" = $3.00
                
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball
                0) Done selecting meats
                """);

        while (true) {

            System.out.print("Add meat (0 when done): ");

            int choice = getUserOption(6);

            if (choice == 0) break;

            Topping meat = null;

            switch (choice) {

                case 1:
                    meat = Topping.PEPPERONI;
                    break;
                case 2:
                    meat = Topping.SAUSAGE;
                    break;
                case 3:
                    meat = Topping.HAM;
                    break;
                case 4:
                    meat = Topping.BACON;
                    break;
                case 5:
                    meat = Topping.CHICKEN;
                    break;
                case 6:
                    meat = Topping.MEATBALL;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            pizza.addMeat(meat);
            System.out.println("Added " + meat.name());
        }

        if (!pizza.getMeats().isEmpty()) {

            System.out.print("Would you like EXTRA meat on all meats? (+50% more per meat) (y/n): ");

            if (userInput.nextLine().trim().equalsIgnoreCase("y")) {

                pizza.setExtraMeat(true);
            }
        }

    }

    private void addCheeseToppings(Pizza pizza) {

        System.out.println("""
                \n--- CHEESE TOPPINGS ---
                Pricing: 8" = $0.75, 12" = $1.50, 16" = $2.25
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo
                0) Done selecting cheese
                """);

        while (true) {

            System.out.print("Add cheese (0 when done): ");

            int choice = getUserOption(5);

            if (choice == 0) break;

            Topping cheese = null;
            switch (choice) {

                case 1:
                    cheese = Topping.MOZZARELLA;
                    break;
                case 2:
                    cheese = Topping.PARMESAN;
                    break;
                case 3:
                    cheese = Topping.RICOTTA;
                    break;
                case 4:
                    cheese = Topping.GOAT_CHEESE;
                    break;
                case 5:
                    cheese = Topping.BUFFALO_CHEESE;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            pizza.addCheese(cheese);
            System.out.println("Added " + cheese.name());
        }

        if (!pizza.getCheeses().isEmpty()) {

            System.out.print("Would you like EXTRA cheese on all cheeses? (y/n): ");

            if (userInput.nextLine().trim().equalsIgnoreCase("y")) {

                pizza.setExtraCheese(true);
            }
        }

    }

    private void addRegularToppings(Pizza pizza) {

        System.out.print("""
                \n--- REGULAR TOPPINGS (FREE) ---
                
                1) Onions
                2) Mushrooms
                3) Bell Peppers
                4) Olives
                5) Tomatoes
                6) Spinach
                7) Basil
                8) Pineapple
                9) Anchovies
                0) Done selecting cheese toppings
                """);

        while (true) {

            System.out.print("Add topping (0 when done): ");

            int choice = getUserOption(9);

            if (choice == 0) break;

            Topping topping = null;

            switch (choice) {

                case 1:
                    topping = Topping.ONIONS;
                    break;
                case 2:
                    topping = Topping.MUSHROOMS;
                    break;
                case 3:
                    topping = Topping.BELL_PEPPERS;
                    break;
                case 4:
                    topping = Topping.OLIVES;
                    break;
                case 5:
                    topping = Topping.TOMATOES;
                    break;
                case 6:
                    topping = Topping.SPINACH;
                    break;
                case 7:
                    topping = Topping.BASIL;
                    break;
                case 8:
                    topping = Topping.PINEAPPLE;
                    break;
                case 9:
                    topping = Topping.ANCHOVIES;
                    break;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            pizza.addRegularTopping(topping);
            System.out.println("Added " + topping.name());
        }

    }

    private void addDrinkScreen() {

        System.out.println("""
                \n--- ADD DRINK ---"
                
                Select drink size:
                1) Small - $2.00
                2) Medium - $3.50
                3) Large - $4.50
                Choose size:\s
                """);
        int sizeChoice = getUserOption(3);

        DrinkSize size = null;
        switch (sizeChoice) {
            case 1:
                size = DrinkSize.SMALL;
                break;
            case 2:
                size = DrinkSize.MEDIUM;
                break;
            case 3:
                size = DrinkSize.LARGE;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        //choosing a flavor
        System.out.println("Enter flavor(Coke, Sprite, Lemonade...");

        String flavor = userInput.nextLine().trim();

        if (flavor.isEmpty()) {

            flavor = "Lemonade";
        }

        Drink drink = new Drink(size, flavor);

        currentOrder.addDrink(drink);

        System.out.printf("Drink added to order! Price: $%.2f \n", drink.getPrice());

    }

    private void addGarlicKnotsScreen() {

        GarlicKnots garlicKnots = new GarlicKnots();

        currentOrder.addGarlicKnots(garlicKnots);

        System.out.printf("\nGarlic Knots added to order! Price: $%.2f", garlicKnots.getPrice());

    }

    private double getStuffedCrustPrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 1.00;
            case MEDIUM_12 -> 1.20;
            case LARGE_16 -> 1.25;
        };
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

            System.out.printf("⚠️: Wrong choice (choose 0 or %s) try again!",optionMax);
        }
        return userOption;
    }

    private void checkoutScreen() {

        if (currentOrder.isEmpty()) {

            System.out.println("\n⚠️: Cannot checkout with an empty order!");
            homeScreen();
        }

        System.out.println("--- CHECKOUT ---");

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

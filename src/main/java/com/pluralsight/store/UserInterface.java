package com.pluralsight.store;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.SauceType;
import com.pluralsight.menuitems.Drink;
import com.pluralsight.menuitems.GarlicKnots;
import com.pluralsight.menuitems.Pizza;
import com.pluralsight.menuitems.Topping;

import java.util.Scanner;

public class UserInterface {

    //declaring my variables
    private final Scanner userInput;
    private Order currentOrder;
    private final ReceiptManager receiptManager;

    // my constructor
    public UserInterface() {

        this.userInput = new Scanner(System.in);
        this.receiptManager = new ReceiptManager();
    }

    //my run method that I will use to access userInterface from the runApp
    public void run() {

        showWelcomeMessage();
        homeScreen();

        //testing
        //System.out.println(currentOrder.toString());

    }

    //my method to show my nice welcome message
    private void showWelcomeMessage() {

        //testing the method
        System.out.println("=".repeat(36));
        System.out.println("Welcome to Mucci & Co. Artisan Pizza");
        System.out.println("=".repeat(36));

    }

    //my method that I use to start a new order
    private void startNewOrder() {

        System.out.print("Customer Name (For 'Guest' press Enter): ");

        String customerName = userInput.nextLine().trim();

        currentOrder = new Order(customerName);

        System.out.println("Starting order for " + currentOrder.getCustomerName());

        orderScreen();

    }

    //my method that I use to display the home menu options
    private void homeScreen() {

        while (true) {
            System.out.println("""
                    --- HOME MENU ---
                    1) New Order
                    0) Exit""");


            //validating my user input
            int userOption;

            do {

                System.out.print("\nOption: ");

                userOption = getUserOption(1);

            } while (userOption < 0 || userOption > 1);

            //my switch statement that I use to process the user option
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

    //my order screen method that I use to process the oder screen options for the user
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
                            """
                    , currentOrder.getItemCount()
                    , currentOrder.getTotal()
            );


            System.out.print("Option: ");
            int userOption = getUserOption(4);


            switch (userOption) {

                case 1:

                    //my pizza case that I use to process the pizza option for the user
                    System.out.println("""
                            
                            Order Type:
                            1) Premade Pizza
                            2) Custom Pizza""");
                    System.out.print("\nChoice: ");

                    int pizzaChoice = getUserOption(2);

                    switch (pizzaChoice) {

                        case 1:

                            addPremadePizzaMenuScreen();
                            break;
                        case 2:

                            System.out.println("Custom Pizza");
                            addCustomPizzaMenuScreen();
                            break;
                    }

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
                    } else {
                        orderScreen();
                    }

                default:


            }
        }

    }

    //my method to process the user's premade choice selection
    private void addPremadePizzaMenuScreen() {

        System.out.println("""
                
                --- PREMADE PIZZAS ---
                1) The Classic      - Marinara, Regular crust, Pepperoni + Sausage, Mozzarella
                2) BBQ Chicken      - BBQ sauce, Thick crust, Chicken + Bacon, Mozzarella
                3) The Veggie       - Pesto sauce, Thin crust, Mozzarella + Parmesan, Mixed Veggies
                4) Buffalo Blaze    - Buffalo sauce, Regular crust, Chicken, Buffalo + Mozzarella
                5) The Meat Lover   - Marinara, Thick crust, All 6 Meats, Mozzarella + Parmesan
                """);

        System.out.print("Choose pizza: ");
        int pizzaChoice = getUserOption(5);

        System.out.println("""
                
                Select size:
                1) Small  (8")
                2) Medium (12")
                3) Large  (16")
                """);

        System.out.print("Choose size: ");
        int sizeChoice = getUserOption(3);

        //processing pizza size selection
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
                System.out.println("Invalid size. Pizza not added.");
                return;
        }

        //processing pizza choice selection
        Pizza pizza;
        switch (pizzaChoice) {
            case 1:
                pizza = Pizza.theClassic(size);
                break;
            case 2:
                pizza = Pizza.bbqChicken(size);
                break;
            case 3:
                pizza = Pizza.theVeggie(size);
                break;
            case 4:
                pizza = Pizza.buffaloBlaze(size);
                break;
            case 5:
                pizza = Pizza.meatLover(size);
                break;
            default:
                System.out.println("Invalid choice. Pizza not added.");
                return;
        }

        numOfPizza(pizza);
        System.out.printf("%n%s added to order! Price: $%.2f%n", pizza.getName(), pizza.getPrice());

    }

    //processing the number of pizzas a person wants to order
    private void numOfPizza(Pizza pizza) {

        System.out.println("""
                \n--- YOUR PIZZA ---
                """ + pizza.getDescription());
        System.out.print("How many do you want?: ");
        int numPizzas = getUserOption(1000000);

        for (int i = 0; i < numPizzas; i++) {

            currentOrder.addPizza(pizza);

        }
    }

    //processing a custom pizza if the user chooses this option
    private void addCustomPizzaMenuScreen() {

        //selecting the pizza size
        System.out.print("""
                \n--- BUILD YOUR PIZZA ---
                
                Select pizza size:
                1) Small 8
                2) Medium 12
                3) Large 16
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

        //selecting crust type
        CrustType crust;
        switch (crustChoice) {
            case 1:
                crust = CrustType.THIN;
                break;
            case 2:
                crust = CrustType.REGULAR;
                break;
            case 3:
                crust = CrustType.THICK;
                break;
            case 4:
                crust = CrustType.CAULIFLOWER;
                break;
            default:
                System.out.println("Invalid crust. Pizza not added.");
                return;
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

        //selecting sauce type
        SauceType sauce;
        switch (sauceChoice) {
            case 1:
                sauce = SauceType.MARINARA;
                break;
            case 2:
                sauce = SauceType.ALFREDO;
                break;
            case 3:
                sauce = SauceType.PESTO;
                break;
            case 4:
                sauce = SauceType.BBQ;
                break;
            case 5:
                sauce = SauceType.BUFFALO;
                break;
            case 6:
                sauce = SauceType.OLIVE_OIL;
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

        //confirming the user wants to add stuffed crust
        if (stuffedAnswer.equalsIgnoreCase("y") || stuffedAnswer.equalsIgnoreCase("yes")) {

            pizza.setStuffedCrust(true);
        }

        numOfPizza(pizza);

        System.out.printf("\nPizza added to order! Price: $%.2f", currentOrder.getTotal());

    }

    //adding a meat topping to the pizza
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

        //processing the meat topping options
        while (true) {

            System.out.print("Add meat (0 when done): ");

            int choice = getUserOption(6);

            if (choice == 0) break;

            Topping meat;

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

    //adding cheese on the pizza
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

            Topping cheese;
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

    //adding regular toppings and showing the user that they are free
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

            Topping topping;

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

    //adding a drink to the order
    private void addDrinkScreen() {

        System.out.print("""
                \n--- ADD DRINK ---
                
                Select drink size:
                1) Small - $2.00
                2) Medium - $2.50
                3) Large - $3.00
                """);

        System.out.print("Choose size: ");
        int sizeChoice = getUserOption(3);

        DrinkSize size;
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
                return;
        }

        //choosing a flavor
        System.out.println("Enter flavor(Coke, Sprite, Lemonade...");

        String flavor = userInput.nextLine().trim();

        if (flavor.isEmpty()) {

            flavor = "Lemonade";
        }

        Drink drink = new Drink(size, flavor);

        System.out.println("How many drinks?: ");

        int drinkCount = getUserOption(1000000);

        for (int i = 0; i < drinkCount; i++) {

            currentOrder.addDrink(drink);
        }

        System.out.printf("Drink added to order! Price: $%.2f \n", drink.getPrice());

    }

    //adding garlic knots to the order and processing how many they want to order
    private void addGarlicKnotsScreen() {

        GarlicKnots garlicKnots = new GarlicKnots();

        System.out.println("How many Garlic Knots?: ");
        int garlicKnotsCount = getUserOption(1000000);
        for (int i = 0; i < garlicKnotsCount; i++) {

            currentOrder.addGarlicKnots(garlicKnots);
        }

        System.out.printf("\nGarlic Knots added to order! Price: $%.2f", garlicKnots.getPrice());

    }

    //getting the price of the stuffed crust
    private double getStuffedCrustPrice(PizzaSize size) {

        return switch (size) {

            case SMALL_8 -> 1.00;
            case MEDIUM_12 -> 1.50;
            case LARGE_16 -> 2.00;
        };
    }

    //validating the user for numbers
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

            System.out.printf("⚠️: Wrong choice (choose 0 - %s) try again!\n", optionMax);
        }
        return userOption;
    }

    private void checkoutScreen() {

        if (currentOrder.hasPizza() || (currentOrder.hasGarlicKnots() || currentOrder.hasDrink())) {

            System.out.println("         --- CHECKOUT ---");

            System.out.println(currentOrder.toString());

            System.out.print("Confirm order? (y/n): ");
            String confirm = userInput.nextLine().trim();

            if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {

                receiptManager.saveReceipt(currentOrder);
                System.out.println("\nOrder completed successfully!");
            } else {

                System.out.println("\nOrder cancelled.\n");

            }
        } else {
            System.out.println("""
                    ⚠️:Your order is empty — You must add a Drink or Garlic knots to proceed!
                    """);

            System.out.print("Returning to Order Screen");
            getBufferingEffect();

            //String proceed = userInput.nextLine().trim();


        }
    }

    //a method to give my display the loading effect
    public void getBufferingEffect(){

        try {

            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print("\b\b\b   \b\b\b");
            }
            System.out.println("...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}

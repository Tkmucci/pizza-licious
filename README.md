# 🍕 Pizza-licious — Mucci & Co. Artisan Pizza

The Java back-end for the [mucci-licious-ui](https://github.com/Tkmucci/mucci-licious-ui.git) front-end application. This is a command-line ordering system for **Mucci & Co. Artisan Pizza** that handles order management, pricing logic, and receipt generation.

---

## Features

- Build a **custom pizza** from scratch — choose size, crust, sauce, meat toppings, cheese toppings, regular toppings, and optional stuffed crust
- Order from a selection of **5 premade pizzas**
- Add **drinks** with a custom flavor and size
- Add **garlic knots** as a side
- Smart cart that **stacks duplicates** (e.g., adding the same premade pizza increments quantity rather than creating a new line item)
- Auto-saves a formatted **receipt** as a timestamped `.txt` file in the `receipts/` folder on checkout

---

## Tech Stack

- **Java 17**
- **Maven** (build & dependency management)
- No external dependencies — pure Java standard library

---

## Project Structure

```
src/main/java/com/pluralsight/
├── RunApp.java                  # Entry point
├── abstracts/
│   └── OrderItem.java           # Abstract base class for all menu items
├── enums/
│   ├── CrustType.java           # THIN, REGULAR, THICK, CAULIFLOWER
│   ├── DrinkSize.java           # SMALL, MEDIUM, LARGE
│   ├── PizzaSize.java           # SMALL_8, MEDIUM_12, LARGE_16
│   ├── SauceType.java           # MARINARA, ALFREDO, PESTO, BBQ, BUFFALO, OLIVE_OIL
│   └── ToppingsType.java        # MEAT, CHEESE, REGULAR
├── interfaces/
│   └── Price.java               # Price contract
├── menuitems/
│   ├── Pizza.java               # Pizza model + premade factory methods
│   ├── Drink.java               # Drink model
│   ├── GarlicKnots.java         # Garlic knots model
│   └── Topping.java             # Topping record with size-based pricing
└── store/
    ├── Order.java               # Order cart logic & receipt formatting
    ├── ReceiptManager.java      # Writes receipts to disk
    └── UserInterface.java       # CLI menus and user interaction
```

---

## Menu

### Pizza Sizes

| Size     | Base Price |
|----------|-----------|
| Small 8" | $8.50     |
| Medium 12" | $12.00  |
| Large 16" | $16.50   |

### Premade Pizzas

| Name          | Sauce    | Crust   | Toppings                              |
|---------------|----------|---------|---------------------------------------|
| The Classic   | Marinara | Regular | Pepperoni, Sausage, Mozzarella        |
| BBQ Chicken   | BBQ      | Thick   | Chicken, Bacon, Mozzarella            |
| The Veggie    | Pesto    | Thin    | Mozzarella, Parmesan, Mixed Veggies   |
| Buffalo Blaze | Buffalo  | Regular | Chicken, Buffalo Cheese, Mozzarella   |
| Meat Lover    | Marinara | Thick   | All 6 meats, Mozzarella, Parmesan     |

### Topping Pricing (Custom Pizza)

| Category       | Small 8" | Medium 12" | Large 16" |
|----------------|---------|-----------|---------|
| Meat           | +$1.00  | +$2.00    | +$3.00  |
| Extra Meat     | +$0.50  | +$1.00    | +$1.50  |
| Cheese         | +$0.75  | +$1.50    | +$2.25  |
| Extra Cheese   | +$0.30  | +$0.60    | +$0.90  |
| Regular Toppings | Free  | Free      | Free    |

### Stuffed Crust

| Size       | Price  |
|------------|--------|
| Small 8"   | +$1.00 |
| Medium 12" | +$1.50 |
| Large 16"  | +$2.00 |

### Other Items

| Item        | Price  |
|-------------|--------|
| Small Drink | $2.00  |
| Medium Drink | $2.50 |
| Large Drink | $3.00  |
| Garlic Knots | $1.50 |

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.x

### Run the app

```bash
git clone https://github.com/Tkmucci/pizza-licious.git
cd pizza-licious
mvn compile
mvn exec:java -Dexec.mainClass="com.pluralsight.RunApp"
```

Or run `RunApp.java` directly from your IDE.

### Receipts

Completed orders are saved automatically to a `receipts/` folder in the project root, named by timestamp (e.g. `receipts/20260527-144909.txt`).

---

## Related

- **Front-end UI:** [mucci-licious-ui](https://github.com/Tkmucci/mucci-licious-ui.git)

package org.example;


import java.util.List;
import java.util.Scanner;

public class Application {
    public Scanner scanner = new Scanner(System.in);
    OrderFileManager OFM = new OrderFileManager();

    public void homeScreen() {
        int option;

        do {
            displayHomeScreen();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    orderScreen();
                    break;
                case 0:
                    System.out.println("Thank you for using DELI-cious Deli. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private void displayHomeScreen() {
        System.out.println("DELI-cious Point of Sales Application");
        System.out.println("=====================================");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter your option: ");
    }


    private void orderScreen() {
        Order order = new Order();
        int option;

        do {
            displayOrderScreen();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addSandwich(order);
                    break;
                case 2:
                    addDrink(order);
                    break;
                case 3:
                    addChip(order);
                    break;
                case 4:
                    checkoutOrder(order);
                    break;
                case 0:
                    System.out.println("Order cancelled.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }

    private void displayOrderScreen() {
        System.out.println("Order Screen");
        System.out.println("============");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chip");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Enter your option: ");
    }

    private void addSandwich(Order order) {
        //displays the bread choices and allows the user to select an option
        System.out.println("Creating Sandwich...");
        System.out.println("Select your bread: ");
        System.out.println("[1] White");
        System.out.println("[2] Wheat");
        System.out.println("[3] Rye");
        System.out.println("[4] Wrap");
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        Bread bread = null;
        switch (breadChoice) {
            case 1 -> bread = Bread.WHITE;
            case 2 -> bread = Bread.WHEAT;
            case 3 -> bread = Bread.RYE;
            case 4 -> bread = Bread.WRAP;
            default -> System.out.println("Invalid bread choice. Please try again");
        }

        //displays the sandwich size choices and allows the user to select an option
        System.out.println("Select your sandwich size: ");
        System.out.println("[1] 4 inch");
        System.out.println("[2] 8 inch");
        System.out.println("[3] 12 inch");
        System.out.print("Enter your choice: ");
        int sandwichChoice = scanner.nextInt();
        scanner.nextLine();

        Sandwich customizedSandwich = new Sandwich(bread);
        switch (sandwichChoice) {
            case 1 -> customizedSandwich.setSandwichSize(SandwichSize.FOUR_IN);
            case 2 -> customizedSandwich.setSandwichSize(SandwichSize.EIGHT_IN);
            case 3 -> customizedSandwich.setSandwichSize(SandwichSize.TWELVE_IN);
            default -> System.out.println("Invalid bread choice. Please try again");
        }

        //display the list of toppings
        System.out.println(toppingMenu);;
        //allow the user to enter their toppings of choice and parses them by comma
        System.out.println("Select toppings (separate with comma, e.g., Lettuce, Extra meat, Provolone): ");
        String toppingsInput = scanner.nextLine();
        String[] toppingsArray = toppingsInput.split(",");

        for (String topping : toppingsArray) {
            Topping t = isToppingValid(topping.trim());
            if (t != null) {
                customizedSandwich.addTopping(t);
            }
        }
        //prompts for the toasted options and add the sandwich to the order
        System.out.println("Would you like yur sandwich toasted? (yes/no)");
        System.out.print("Enter your choice: ");
        String toastedChoice = scanner.nextLine();

        if (toastedChoice.equalsIgnoreCase("Yes")) {
            customizedSandwich.setToasted(true);
        } else {
            customizedSandwich.setToasted(false);
        }

        order.addSandwich(customizedSandwich);
        System.out.println("The following sandwich has been added to your order\n" + customizedSandwich.toString());
    }


    private void addDrink(Order order) {
        DrinksMenu.runDrinkMenu();

        System.out.println("Drink added.");
    }

    private void checkoutOrder(Order order) {
        System.out.println("Checkout");
        System.out.println("========");

        int option;
        do {
            System.out.println("1) Confirm");
            System.out.println("2) Cancel");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    OFM.generateReceipt(order);
                    System.out.println("Order confirmed. Receipt created.");
                    return;
                case 2:
                    System.out.println("Order cancelled.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 2);

        scanner.close();
    }

    private void addChip(Order order) {
        System.out.println("Add Chips");
        System.out.println("=========");
        scanner.nextLine();

        System.out.println("Choose chips: Regular, Kettle, Tortilla");
        String name = scanner.nextLine();

        Chip chip = new Chip(name);

        order.addChip(chip);

        System.out.println("Chips added.");
    }

    String toppingMenu = """
                    
                       ----------------Meats-----------------
                        - Steak             - Chicken
                        - Ham               - Bacon
                        - Salami            - Extra Meat
                        - Roast Beef
                       ---------------Cheese------------------
                        - American          - Swiss
                        - Provolone         - Extra Cheese
                        - Cheddar
                        -----------Other Toppings-------------
                        - Lettuce           - Cucumbers
                        - Peppers           - Pickles
                        - Onion             - Guacamole
                        - Tomatoes          - Mushrooms
                        - Jalapenos
                        -------------Sauces-------------------
                        - Mayo              - Ranch
                        - Mustard           - Thousand Islands
                        - Ketchup           - Vinaigrette
                        
                    """;

    private Topping isToppingValid(String toppingName) {
        // checks if the toppings entered match the topping options if it does it returns the selected topping
        Topping topping = null;
        List<Topping> toppings = Topping.initializeToppings();
        for (Topping t : toppings) {
            if (t.getName().equalsIgnoreCase(toppingName)) {
                 topping = t;
            }
        }
        return topping;
    }
}






package org.example;


import java.util.List;
import java.util.Scanner;

public class Application {
    public Scanner scanner = new Scanner(System.in);
    OrderFileManager OFM = new OrderFileManager();

    public void homeScreen() {
        int option;

        do {
            //Display Home screen
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
        private void displayHomeScreen() { //Display Home screen options
            System.out.println(""" 
                          ==================Menu Options=======================
                                        1- New Order
                                        0- Exit
                                    Enter your option: 
                                          """);
        }


    private void orderScreen() {
        // Create new order object
        Order order = new Order();
        int option;

        do {
            //Display order screen options
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
        System.out.println("""
                 
        ==================Order Screen=========================
                      1- Add Sandwich
                      2- Add Drink
                      3- Add Chip
                      4- Checkout
                      0- Cancel Order
                      Enter your option:
        """);
    }

    private void addSandwich(Order order) {
        //displays the bread choices and allows the user to select an option
        System.out.println("""
        =============Creating Sandwich...=========
                       Select your bread:
        [1] White                          [3]Rye
        [2] Wheat                          [4]Wrap
        
                   Enter your choice: 
                     
        """);
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
        System.out.println("""
        ========== Select your sandwich size ==========
                     [1] 4 inch
                     [2] 8 inch
                     [3] 12 inch
                     
                 Enter your choice: 
                """);
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
        System.out.println("The sandwich below has been added to your order:\n" + customizedSandwich.toString());
    }


    private void addDrink(Order order) {
        DrinksMenu.runDrinkMenu(order);

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
            OFM.generateReceipt(order); //Generate receipt

            switch (option) {
                case 1:
                    OFM.createReceipt(); //Create receipt
                    System.out.println("Order confirmed.");
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

        Chip chip = new Chip(name); //New chip object

        order.addChip(chip); //Add chip to order

        System.out.println("Chips added.");
    }

    String toppingMenu = """
                    
                       ---------------Meats------------------
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
                        --------------Sauces------------------
                        - Mayo              - Ranch
                        - Mustard           - Thousand Islands
                        - Ketchup           - Vinaigrette
                        ---------------Sides------------------
                        - Au Jus            - Sauce
                        
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






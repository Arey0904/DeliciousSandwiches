package org.example;



import java.util.Scanner;

public class Application {
    private Menu menu;
    private Order[] orders;

    public Application() {
        menu = new Menu();

    }

    public void screen() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
                    addChips(order);
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

    private void addDrink(Order order) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add Drink");
        System.out.println("=========");

        System.out.println("Drink name: ");
        String name = scanner.nextLine();

        System.out.println("Drink size: ");
        int size = scanner.nextInt();

        double price = menu.getDrinkPrice(size);
        Drink drink = new Drink(name, size, price);
        order.addDrink(drink);

        System.out.println("Drink added.");
    }

    private void checkoutOrder(Order order) {
        System.out.println("Checkout");
        System.out.println("========");

        order.displayOrderDetails();
        System.out.println("Total cost: $" + order.TotalCost());

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1) Confirm");
            System.out.println("2) Cancel");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    order.saveReceipt();
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add Chips");
        System.out.println("=========");


        System.out.println("Chip name: ");
        String name = scanner.nextLine();

        Chip chip = new Chip(name);
        order.addChip(chip);

        System.out.println("Chips added.");
    }
}






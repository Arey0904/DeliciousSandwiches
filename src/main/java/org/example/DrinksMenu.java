package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DrinksMenu {
    static DrinksMenu drinks = new DrinksMenu();
    public static void DrinksMenu(){
    Scanner scanner = new Scanner(System.in);
      System.out.println("""
                Please select your Drink:
                [1] - Soda
                [2] - Juice
                [3] - Water
                [0] - EXIT""");
    String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "1":
                Soda();
                break;
            case "2":
                Juice();
                break;
            case "3":
                Water();
                break;
            case "0":
                System.exit(0);
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }
    private static void Water() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose size: SMALL, MEDIUM, LARGE");
        String size = scanner.nextLine();
    }

    private static void Juice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose size: SMALL, MEDIUM, LARGE");
        String size = scanner.nextLine();
    }

    public static void Soda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose size: SMALL, MEDIUM, LARGE");
        String size = scanner.nextLine();
    }
   // d.size -> DrinkSize


    private ArrayList<Beverage> beverageList = new ArrayList<>();

    public static void drinks() {
    }


    public void Drink(){
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.COKE));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.COKE));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.COKE));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.SPRITE));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.SPRITE));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.SPRITE));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.DR_PEPPER));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.DR_PEPPER));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.DR_PEPPER));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.ORANGE_FANTA));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.ORANGE_FANTA));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.ORANGE_FANTA));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.STRAWBERRY_FANTA));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.STRAWBERRY_FANTA));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.STRAWBERRY_FANTA));

}

    public double findPrice(DrinkSizeType size, DrinkType type) {
        double value = 0.0;
        for (Beverage b : beverageList) {
            if (b.getSize() == size && b.getType() == type) value = b.getPrice();
        }
        return value;
    }



    double order(DrinkType beverage, DrinkSizeType size) {
        double price = 0.0;

        price = findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }

}
package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DrinksMenu {
    public static Scanner scanner = new Scanner(System.in);

    public static void runDrinkMenu(Order order) {
        //This represents a method called runDrinkMenu, which takes an Order object as a parameter.
        // The purpose of this method is to prompt the user to select a type and size of drink, and then add the selected drink to the given Order object.
        System.out.println("Choose Drink: Water, Coke, Sprite, Dr Pepper, Orange Fanta, Strawberry Fanta");
        String type = scanner.nextLine();

        System.out.println("Choose size: Small, Medium, Large");
        String size = scanner.nextLine();

        for (Drink drink : drinkList) {
            if (size.equals(drink.getSize().getName()) && type.equals(drink.getType().getName())) {
                order.addDrink(drink);
            }
        }
    }
    private static ArrayList<Drink> drinkList = loadDrinks();

    public static ArrayList<Drink> loadDrinks() {
        //This Java code defines a static ArrayList<Drink> variable named drinkList and initializes it with the result of calling the loadDrinks() method.
        // The loadDrinks() method populates the beverageList with a series of Drink objects and returns it.
        ArrayList<Drink> beverageList = new ArrayList<>();

        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.WATER));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.WATER));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.WATER));
        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.COKE));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.COKE));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.COKE));
        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.SPRITE));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.SPRITE));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.SPRITE));
        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.DR_PEPPER));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.DR_PEPPER));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.DR_PEPPER));
        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.ORANGE_FANTA));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.ORANGE_FANTA));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.ORANGE_FANTA));
        beverageList.add(new Drink(DrinkSizeType.SMALL, 2.00, DrinkType.STRAWBERRY_FANTA));
        beverageList.add(new Drink(DrinkSizeType.MEDIUM, 2.50, DrinkType.STRAWBERRY_FANTA));
        beverageList.add(new Drink(DrinkSizeType.LARGE, 3.00, DrinkType.STRAWBERRY_FANTA));

        return beverageList;
    }
}
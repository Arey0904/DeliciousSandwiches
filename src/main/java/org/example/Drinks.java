package org.example;

import java.util.Scanner;

public class Drinks {
    void drinkScreen() {

    }


    public static void drinksScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Would you like a Drink:
                [1] - Yes
                [2] - NO""");
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "1":
                DrinksMenu();
                break;
            case "2":
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }

    }

    public static void DrinksMenu() {
        Drinks.DrinksMenu();
    }

}

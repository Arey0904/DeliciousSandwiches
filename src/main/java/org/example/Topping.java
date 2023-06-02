package org.example;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private String name;
    private double basePrice;

    public Topping(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    //multiplies the base topping prices by 2 or 3 depending on the sandwich size to get the right price
    public double getToppingPrice(Topping t, SandwichSize sandwichSize) {
        double price = 0;
        if (sandwichSize == SandwichSize.FOUR_IN){
            price = t.basePrice;
        }else if (sandwichSize == SandwichSize.EIGHT_IN) {
            price = t.basePrice * 2;
        }else {
            price = t.basePrice * 3;
        }
        return price;
    }

    public static List<Topping> initializeToppings() {

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Steak",  1.0));
        toppings.add(new Topping("Ham",  1.0));
        toppings.add(new Topping("Salami",  1.0));
        toppings.add(new Topping("Roast Beef",  1.0));
        toppings.add(new Topping("Chicken",  1.0));
        toppings.add(new Topping("Bacon", 1.0));
        toppings.add(new Topping("Extra Meat", 0.50));
        toppings.add(new Topping("American", 0.75));
        toppings.add(new Topping("Provolone", 0.75));
        toppings.add(new Topping("Cheddar", 0.75));
        toppings.add(new Topping("Swiss", 0.75));
        toppings.add(new Topping("Extra Cheese", 0.30));
        toppings.add(new Topping("Lettuce", 0.00));
        toppings.add(new Topping("Peppers", 0.00));
        toppings.add(new Topping("Onions", 0.00));
        toppings.add(new Topping("Tomatoes", 0.00));
        toppings.add(new Topping("Jalapenos", 0.00));
        toppings.add(new Topping("Cucumbers", 0.00));
        toppings.add(new Topping("Pickles", 0.00));
        toppings.add(new Topping("Guacamole", 0.00));
        toppings.add(new Topping("Mushrooms", 0.00));
        toppings.add(new Topping("Mayo", 0.00));
        toppings.add(new Topping("Mustard", 0.00));
        toppings.add(new Topping("Ketchup", 0.00));
        toppings.add(new Topping("Ranch", 0.00));
        toppings.add(new Topping("Thousand Islands", 0.00));
        toppings.add(new Topping("Vinaigrette", 0.00));
        toppings.add(new Topping("Au Jus", 0.00));
        toppings.add(new Topping("Sauce",0.00));

        return toppings;
    }
}
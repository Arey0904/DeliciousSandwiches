package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip> chips = new ArrayList<>();

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich){
        this.sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        this.drinks.add(drink);
    }

    public void addChip(Chip chip){
        this.chips.add(chip);
    }

    public double calculateTotalPrice(){
        double sandwichesTotal = 0;
        double drinksTotal = 0;
        double chipsTotal = 0;

        for (Sandwich s : sandwiches){
            sandwichesTotal += s.getTotalSandwichPrice();
        }
        for (Drink d : drinks){
            drinksTotal += d.getPrice();
        }
        for (Chip c : chips){
            chipsTotal += c.getPrice();
        }

        return sandwichesTotal + drinksTotal + chipsTotal;
    }
}

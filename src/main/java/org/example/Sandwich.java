package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private double basePrice;
    private Bread bread;
    private List<Topping> toppings;
    private SandwichSize sandwichSize;
    private boolean isToasted;
    private double totalToppingPrice;

    public Sandwich(Bread bread,SandwichSize sandwichSize ) {
        this.basePrice = basePrice;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.sandwichSize = sandwichSize;
        this.isToasted = false; //default option is not toasted
    }

    public double getBasePrice() {
        switch (sandwichSize){
            case FOUR_IN -> basePrice = 5.50;
            case EIGHT_IN -> basePrice = 7.00;
            case TWELVE_IN ->  basePrice = 8.50;
        } return basePrice;
    }

    public double calculateTotalToppings(){
        for (Topping t : toppings){
            totalToppingPrice += t.getToppingPrice(t, sandwichSize);
        } return totalToppingPrice;
    }

    public Bread getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public double getTotalSandwichPrice(){
        return this.basePrice + calculateTotalToppings();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Size: ").append(sandwichSize).append("\n");
        sb.append("Toppings:\n");
        for (Topping topping : toppings){
            sb.append("- ").append(topping.getName()).append("\n");
        }
        sb.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        sb.append("Price: $").append(getTotalSandwichPrice()).append("\n");
        return sb.toString();
    }
}

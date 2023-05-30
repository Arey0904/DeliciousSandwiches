package org.example;

import java.util.List;

public class Sandwich {

    private double basePrice;
    private Bread bread;
    private List<Topping> toppings;
    private Size size;
    private boolean isToasted;

    public Sandwich(double basePrice, Bread bread, List<Topping> toppings, Size size, boolean isToasted) {
        this.basePrice = basePrice;
        this.bread = bread;
        this.toppings = toppings;
        this.size = size;
        this.isToasted = false; //default option is not toasted
    }

    public double getBasePrice() {
        switch (size){
            case FOUR_IN -> basePrice = 5.50;
            case EIGHT_IN -> basePrice = 7.00;
            case TWELVE_IN ->  basePrice = 8.50;
        }
    }

    public Bread getBread() {
        return bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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

    public double calculateToppingPrice(){
        double toppingsPrice = 0.0;
        for (Topping topping : toppins){
            toppingsPrice += topping.getPrice();
        }
        return toppingsPrice;
    }

    public double calculateTotalPrice(){
        return basePrice + calculateToppingPrice();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("Toppings:\n");
        for (Topping topping : toppings){
            sb.append("- ").append(topping.getName()).append("\n");
        }
        sb.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        sb.append("Price: $").append(calculateTotalPrice()).append("\n");
        return sb.toString();
    }

}

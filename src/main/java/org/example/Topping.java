package org.example;

public class Topping {
    private String name;
    private boolean isMeat;
    private boolean isCheese;
    private double price;

    public Topping(String name, boolean isMeat, boolean isCheese, double price) {
        this.name = name;
        this.isMeat = isMeat;
        this.isCheese = isCheese;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPremium(){
        return isMeat || isCheese;
    }
}

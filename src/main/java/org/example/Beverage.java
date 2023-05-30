package org.example;

public class Beverage {
    private DrinkSizeType size;
    private double price;
    private DrinkType type;

    // ctor
    public Beverage(DrinkSizeType size, double price, DrinkType type) {
        this.size = size;
        this.price = price;
        this.type = type;
    }

    public DrinkSizeType getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public DrinkType getType() {
        return type;
    }
}

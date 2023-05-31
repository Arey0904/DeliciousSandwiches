package org.example;

class Chip {
    private String type;
    private double price;

    public Chip(String type, double price) {
        this.type = type;
        this.price = 1.50;
    }

    public String getType() {
        return type;
    }

    public double getChipPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Chip: " + type + ", Price: $" + price;
    }
}








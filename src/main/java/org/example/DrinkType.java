package org.example;

public enum DrinkType {COKE("Coke"), SPRITE("Sprite"), DR_PEPPER("Dr Pepper"), ORANGE_FANTA("Orange Fanta"), STRAWBERRY_FANTA("Strawberry Fanta"), WATER("Water");

    private String name;

    DrinkType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

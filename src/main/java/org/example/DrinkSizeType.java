package org.example;

public enum DrinkSizeType {SMALL("Small"), MEDIUM("Medium"), LARGE("Large");
    private String name;

    DrinkSizeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

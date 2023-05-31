package org.example;

public class Topping {
    private String name;
    private boolean isMeat;
    private boolean isCheese;
    private double smallPrice;
    private double medPrice;
    private double lgPrice;

    public Topping(String name, boolean isMeat, boolean isCheese, double smallPrice, double medPrice, double lgPrice) {
        this.name = name;
        this.isMeat = isMeat;
        this.isCheese = isCheese;
        this.smallPrice = smallPrice;
        this.medPrice = medPrice;
        this.lgPrice = lgPrice;
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

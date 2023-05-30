package org.example;

import java.util.ArrayList;

public class Drinks {
    Drinks drinks = new Drinks();


    private ArrayList<Beverage> beverageList = new ArrayList<>();


public void Drink(){
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.WATER));
    this.beverageList.add( new Beverage(DrinkSizeType.SMALL, 2.00, DrinkType.SODA));
    this.beverageList.add( new Beverage(DrinkSizeType.MEDIUM, 2.50, DrinkType.SODA));
    this.beverageList.add( new Beverage(DrinkSizeType.LARGE, 3.00, DrinkType.SODA));
}

    public double findPrice(DrinkSizeType size, DrinkType type) {
        double value = 0.0;
        for (Beverage b : beverageList) {
            if (b.getSize() == size && b.getType() == type) value = b.getPrice();
        }
        return value;
    }



    double order(DrinkType beverage, DrinkSizeType size) {
        double price = 0.0;

        price = findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }

}
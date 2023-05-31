package org.example;

public class OrderFileManager {
    public void generateReceipt(Order order){
        StringBuilder receipt = new StringBuilder();
        int sandwichCount = 1;

        for (Sandwich s : order.getSandwiches()) {
            receipt.append("Custom Sandwich ").append(sandwichCount).append(":\n");
            receipt.append("Bread: ").append(bread).append("\n");
            receipt.append("Size: ").append(size).append("\n");
            receipt.append("Toppings:\n");
            for (Topping topping : toppings) {
                receipt.append("- ").append(topping.getName()).append("\n");
            }
            receipt.append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
            receipt.append("Price: $").append(getPrice()).append("\n");
            sandwichCount += 1;
        }

        receipt.append("\n");
        for (Drink d : order.getDrinks()) {
            receipt.append(d.getSize).append(" - ").append(d.getType).append("  $").append(d.getPrice).append("\n\n");
        }

        receipt.append("\n");
        for (Chip c : order.getChips()) {
            receipt.append(c.getType).append("  $").append(c.getPrice).append("\n\n");
        }

        receipt.append("Total Cost: $").append(order.calculateTotalPrice());

        System.out.println(receipt);
    }

    public void saveReceipt(){

    }
}

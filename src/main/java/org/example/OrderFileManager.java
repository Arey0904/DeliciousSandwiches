package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class OrderFileManager {
    public void generateReceipt(Order order){
        StringBuilder receipt = new StringBuilder();
        int sandwichCount = 1;

        for (Sandwich s : order.getSandwiches()) {
            receipt.append("Custom Sandwich ").append(sandwichCount).append(":\n");
            receipt.append("Bread: ").append(s.getBread()).append("\n");
            receipt.append("Size: ").append(s.getSandwichSize()).append("\n");
            receipt.append("Toppings:\n");
            for (Topping topping : s.getToppings()) {
                receipt.append("- ").append(topping.getName()).append("\n");
            }
            receipt.append("Toasted: ").append(s.isToasted() ? "Yes" : "No").append("\n");
            receipt.append("Price: $").append(s.getTotalSandwichPrice()).append("\n");
            sandwichCount += 1;
        }

        receipt.append("\n");
        for (Drink d : order.getDrinks()) {
            receipt.append(d.getSize()).append(" - ").append(d.getType()).append("  $").append(d.getPrice()).append("\n\n");
        }

        receipt.append("\n");
        for (Chip c : order.getChips()) {
            receipt.append(c.getType()).append("  $").append(c.getPrice()).append("\n\n");
        }

        receipt.append("Total Cost: $").append(order.calculateTotalPrice());

        saveReceipt(receipt);

        System.out.println(receipt);
    }

    public void saveReceipt(StringBuilder receipt){
        String filename = LocalDate.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + ".txt";
        File record = new File("/DeliciousSandwiches/Receipts/" + filename);

        try (FileWriter fileWriter = new FileWriter(filename)){
            fileWriter.write(String.valueOf(receipt));

            System.out.println("Receipt on " + LocalDate.now() + "-" + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + "saved to Receipts folder successfully!");
        } catch (IOException e) {
            System.err.println("Error saving receipt to folder");
        }
    }
}

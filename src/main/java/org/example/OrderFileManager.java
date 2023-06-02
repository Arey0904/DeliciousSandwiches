package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {
    public String finalReceipt;
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
            receipt.append(d.getSize()).append(" - ").append(d.getType()).append("  $").append(d.getPrice()).append("\n");
        }

        receipt.append("\n");
        for (Chip c : order.getChips()) {
            receipt.append(c.getType()).append(" Chips  $").append(c.getPrice()).append("\n\n");
        }

        receipt.append("Total Cost: $").append(order.calculateTotalPrice()).append("\n");

        finalReceipt = receipt.toString();
        System.out.println(finalReceipt);
    }

    public void createReceipt() {
        String fileName = generateFileName();
        String folderPath = "Receipts";
        String filePath = folderPath + File.separator + fileName;

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(finalReceipt);
            writer.close();

            // Write the receipt to the file
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(finalReceipt);
            fileWriter.close();
            System.out.println("Receipt created: " + fileName);
        } catch (IOException e) {
            System.out.println("Error creating receipt: " + fileName);
        }
    }

    private String generateFileName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String timestamp = now.format(formatter);
        return timestamp + ".txt";
    }
}

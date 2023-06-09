package org.example;

class Chip {
    //Hold type of chip using the ChipType enum
    private ChipType type;
    //set price for all chips
    private double price = 1.50;

    public Chip(String type) {
        if (type.equals("Regular")){
            this.type = ChipType.REGULAR;
        } else if (type.equals("Kettle")){
            this.type = ChipType.KETTLE;
        } else {
            this.type = ChipType.TORTILLA;
        }
    }

    public ChipType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Chip: " + type + ", Price: $" + price;
    }
}








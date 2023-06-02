# DeliciousSandwiches

## Description

This project allows the user to order an entry from a Deli Shop called DELI-cious Sandwiches.

The shop holds multiple files and uses it help the user order from the shop.

Each order option contains the following data:

- Sandwiches
- Drinks
- Chips
- Checkout
- Cancel order

Each order receipt is saved into seperate files in a Receipts folder with the following file name:
- yyyyMMdd-hhmmss.txt -> 20230329-121523.txt 

## Features

There are three (3) screens in the application:

- Home screen
- Order Screen
- Checkout Screen

## Home Screen

Will display the options below:
- Create a new order
- Exit the application

## Order Screen

The order screen will display multiple menu options for the user to add to their order.

### Add a Sandwich
- The user has to select option "1" it will prompt the user to create a sandwich of their chooising with multiple options.
  - Bread Selection : 
    - White, Wheat, Rye, Wrap 
  - Size Selection :
    - 4 inches, 8 inches, 12 inches
  - Topping selctions :
    -  meats, cheeses, and sauces. 

### Add a Drink 
- The user has to select option "3" it will prompt the user to select a drink of their choosing with multiple options with flavors included..
  - Drink Type :
    - Water, Soda, Juice
  - Size Selection :
    - Small, Medium, Large

### Add Chip
- The user has to select option "3" it will prompt the user to select a chip flavor of their chooising
  - Kettle, Tortilla, Regular

### Checkout
- Once the user is done ordering, option "4" will allow them to checkout. 
  #### Checkout Screen
  - The user will have the option to confirm their order or cancel the order.
    - Confirming the order allows the user to see their order in detail and creates a receipt which is then saved to the Receipts folder.
    - Cancelling the order allows the user to return back to the home screen where they can create another order or exit the application.

## Delicious Sandwich Application Screens
### Home Screen
![image](https://github.com/Arey0904/DeliciousSandwiches/assets/129906864/260abbdd-0ed1-4fa2-b2ef-3d30e1e9875f)
### Order Screen
![image](https://github.com/Arey0904/DeliciousSandwiches/assets/129906864/21e480f2-e5f1-42c4-891a-0849c8175eb0)
### Checkout Screen

## Interesting peice of code
```
 public double getToppingPrice(Topping t, SandwichSize sandwichSize) {
        //multiplies the base topping prices by 2 or 3 depending on the sandwich size to get the right price
        double price = 0;
        if (sandwichSize == SandwichSize.FOUR_IN){
            price = t.basePrice;
        }else if (sandwichSize == SandwichSize.EIGHT_IN) {
            price = t.basePrice * 2;
        }else {
            price = t.basePrice * 3;
        }
        return price;
    }
```









## Credits/Team Members
Aaron Rey
Heralda Lamarre
A'sha Shepard
Cristi Savca

# DeliciousSandwiches

## Description

This Java project allows the user to create an order from a Deli Shop called DELI-cious Sandwiches.

The shop holds multiple files and uses it help the user order from the shop.

Each order can contain the following options:

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
<img width="460" alt="image" src="https://github.com/Arey0904/DeliciousSandwiches/assets/58373811/045bc8ce-18e5-40e9-bc47-f69115344789">

### Order Screen
<img width="416" alt="image" src="https://github.com/Arey0904/DeliciousSandwiches/assets/58373811/4b72a4d8-d561-4372-9f88-4afaa00e2229">

### Toppings Menu
<img width="312" alt="image" src="https://github.com/Arey0904/DeliciousSandwiches/assets/58373811/65a57991-aad2-48ed-a9b7-46c23e0ff6f1">

### Checkout Screen
<img width="85" alt="image" src="https://github.com/Arey0904/DeliciousSandwiches/assets/58373811/72555a85-cf0a-4d39-9d11-12aca8a997c6">

### Receipts
<img width="305" alt="image" src="https://github.com/Arey0904/DeliciousSandwiches/assets/58373811/f263b1ce-a6d5-428f-98b8-24747a7a43f1">

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

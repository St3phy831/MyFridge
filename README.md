# MyFridge
App Description: Creating an app that helps keep track of items in refrigerator.

#### Disclaimer:
Since I was a part of CodePath's Android University, I decided to create this app to practice what I learned and to learn new 
Android Development concepts. I appreciate any help or advice on how to make this application/code work better and any help
on the challenges I'm facing. This app is currently *unfinished*, but I will try my best to continue working on it to get a finished product.
My main goal is to learn more about Android Development!

## Below is my progress so far:

#### App Features:

- [x] Bottom Navigation between three Fragments (ToBuy List, card view of Refrigerator items, and Compose Fragment)
- [x] A Simple ToBuy List to add items the user would like to buy
- [x] A card view of the different categories of food products in a refrigerator
- [x] Implementing logic on Compose Fragment so it will directly add the users Refrigerator item and be displayed
- [x] When clicked on card each card view you can items added

#### Currently working on:
- Allow Users to use a Calendar to set the expiration date of Item


#### Features I would like to add:
- Allow user to view items added through the card view
- Add a notification for when item is expired

#### Challenges:
- I was stuck on how to pass the item added by the user to the Refrigerator Fragment to be able to add and save data to be displayed,
so I used a bundle to pass the data and open the Activity so the user could se that their item was added (currently with a preset expiration
date, which is what I'm working on now)
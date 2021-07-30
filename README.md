# MyFridge
App Description: An app that helps keep track of items in refrigerator (or any household food products)
in order to prevent wasting food and maintain kitchen cleanliness.

Message: Since I was a part of CodePath's Android University, I decided to create this app to practice
what I learned and to learn new Android Development concepts. I appreciate any help or advice on how
to make this application/code work better!


## Instructions to Run:
(Make sure Android Studio is already Installed) - Fork Repository -> git clone Repository -> Go to
Android Studio and open an existing Android Studio Project -> Run it on emulator


## App Features:
- [x] Bottom Navigation between three Fragments (Shopping List fragment, card view of Refrigerator items, and Compose Fragment)
- [x] A Simple List to add items the user would like to buy
- [x] User is able to click on and update items they would like to buy
- [x] A card view of the different categories of food products in a refrigerator
- [x] Allow the users to add refrigerator items and their expiration date 
- [x] Allow user to view items added through the card view in their refrigerator
- [x] User gets notification on the day of the item's expiration date at 8 A.M. (this is so people
can evaluate its condition and decide whether to use it or discard it)


## GIFS:
#### Shopping List Fragment
  <img src="shoppingList.gif" title="Shopping List Walkthrough" width="250px"/>
  
#### Refrigerator Fragment
  <img src="refrigerator.gif" title="Refrigerator Walkthrough" width="250px"/>
  
#### Compose Fragment
  <img src="compose.gif" title="Compose Walkthrough" width="250px"/>

#### Notification
  <img src="notification.gif" title="Notification Example" width="250px"/>


### Challenges:
- I was stuck on how to pass the item added by the user to the Refrigerator Fragment to be able to
add and save data to be displayed, so I used a bundle to pass the data and open the Activity so the
user could se that their item was added.

- Another challenge I had was reusing my Refrigerator Activity, so I had to send a bundle from the
Refrigerator Fragment with a keyword of its designated category. This allowed me to save the items
and expiration dates of a particular category in their specified text files.

- I was also stuck on creating a notification at a specific date. I watched various videos and read
Android Documentation to understand how notifications work. I tested it out in my project in a variety
of different ways. Eventually, I came upon a video that facilitated the whole process using someone's
created library (<a href="https://github.com/jakebonk/NotifyMe">NotifyMe</a>). (Resource:
https://www.youtube.com/watch?v=oLngUva-Ves&t=187s)

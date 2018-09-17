Feature: User Signup from Facebook 
User can signup successfully into Facebook.

Scenario Outline: User Signup.
Given  user on signup page
When   i entred "<firstName>", "<lastName>", "<email>", "<password>", "<day>","<month>","<year>" "<gender>" 
And    I click on signup button
Then   Confirm page dispalyed successfully
Examples:
| firstName | lastName | email | password | day | month | year| gender|
| Ali | Ahmed | mohaploiuyyh@gmail.com | P@ssw0rd | 5 | Mar | 1980| male|


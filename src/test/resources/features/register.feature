Feature: Register user

Scenario: Successfull register
Given I am on the home page
Then I click signin button
Then I click on register
When I populate register form 
Then I click save register button
Then I should be navigated to my account

Scenario: Unsuccessfull register
Given I am on the home page
Then I click signin button 
Then I click on register
When I populate register form with already used email
Then I click save register button
Then I should get message for unsuccessfull register

Feature: Checkout Functionality

	Scenario: Signin User and Checkout Product
		Given I am on the home page
		Then I click signin button
		When I enter my username and password
		When I click the signin button
		Then I should be signed in
		When I open category
		When I open subcategory
		When I open product page
		Then I select size
		Then I click colour
		Then I fill quantity
		Then I click add to cart
		Then I click proceed to checkout
		Then I increase quantity
		Then I click proceed to checkout
		Then I click Continue New Address
		Then I click Continue Delivery option
		Then I click Payment Option
		Then I check Terms and Conditions
		Then I click Place Order
		Then I click logout
		Then I should be logged out
		
	Scenario: Checkout Without Login
			Given I am on the home page
			And I open category ART
			And I open product page in ART category
			Then I click dimension
			Then I fill quantity
			Then I click add to cart
			Then I click proceed to checkout
			Then I click proceed to checkout
			When I click Order as a guest
			And I populate register form on checkout page
			Then I click Continue Personal Information
			When I populate New Address Form
			Then I click Continue New Address
			Then I click Continue Delivery option
			Then I click Payment Option
			Then I check Terms and Conditions
			Then I click Place Order
			Then I should get order confirmation message
			
			
			
			
Feature: Cart

	Scenario: Add product to cart after signin
		Given I am on the home page
		Then I click signin button
		When I enter my username and password
		When I click the signin button
		Then I should be signed in
		When I open category
		When I open product page
		Then I select size
		Then I click colour
		Then I fill quantity
		Then I click add to cart
		Then I click continue shopping
		Then I click logout
		Then I should be logged out
		
		Scenario: Add product to cart without signin
		Given I am on the home page
		When I open category
		When I open product page
		Then I select size
		Then I fill quantity
		Then I click add to cart
		Then I click continue shopping
		Then I click signin button
		Then I am in my account page
		
		Scenario: Add product in cart without selecting color after signin
		Given I am on the home page
		Then I click signin button
		When I enter my username and password
		When I click the signin button
		Then I should be signed in
		When I open category
		When I open product page
		Then I click add to cart
		Then I click proceed to checkout
		Then I click logout
		Then I should be logged out

		Scenario: Add product in cart without selecting quantity and signin after
		Given I am on the home page
		When I open category
		When I open product page
		Then I click add to cart
		Then I click proceed to checkout
		Then I click signin button
		When I enter my username and password
		When I click the signin button
		Then I should be signed in
		
		Scenario: Add product in cart and remove product from cart
		Given I am on the home page
		When I open category
		When I open subcategory
		When I open product page
		Then I select size
		Then I fill quantity
		Then I click add to cart
		Then I click proceed to checkout
		Then I am in the cart page
		Then I click remove product
		Then I click proceed to checkout
		Then I should get empty cart 
		
		Scenario: Add product in cart and increase quantity
		Given I am on the home page
		When I open category
		When I open subcategory
		When I open product page
		Then I select size
		Then I fill quantity
		Then I click add to cart
		Then I click proceed to checkout
		Then I am in the cart page
		Then I increase quantity
		Then I verify the quantity increased
		
		Scenario: Add product in cart and decrease quantity
		Given I am on the home page
		When I open category
		When I open subcategory
		When I open product page
		Then I select size
		Then I fill quantity
		Then I click add to cart
		Then I click proceed to checkout
		Then I am in the cart page
		Then I decrease quantity
		Then I verify the quantity decreased
		
		
Feature: Home Page

  Scenario: Verify HomePage Title
	    Given I am on the home page
	    Then I should verify the title of the page
    
  Scenario: Verify Forgot Password
		  Given I am on the home page
		  Then I click signin button
		  When I click forgot your password button
		  Then I get verification message
  
  Scenario: Search product without signin
	    Given I am on the home page
	    Then I fill the search field with product name
	    When I click "Enter"
	    Then I verify new page with title of product name

	    
	Scenario: Search product with signin
	    Given I am on the home page
	    Then I click signin button
	    Then I fill the search field with product name
	    When I click "Enter"
	    Then I verify new page with title of product name
	    
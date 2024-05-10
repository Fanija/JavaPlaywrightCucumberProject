Feature: Login Functionality

  Scenario: Successful Login
		    Given I click signin button
		    When I enter my username and password
		    When I click the signin button
		    Then I should be signed in
		    
	 Scenario: Login With Empty Password
			  Given I click signin button
		    When I enter my username and empty password
		    When I click the signin button
		    Then I should not be signed in and get message
		    
		    Scenario: Logout
			  Given I click signin button
		    When I enter my username and password
		    When I click the signin button
		    Then I should be signed in
		    When I click the logout button
		    Then I should be logged out and get message

		    
		    
			
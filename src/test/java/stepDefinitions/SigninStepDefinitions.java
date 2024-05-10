package stepDefinitions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.*;
import utils.*;
import locators.*;

public class SigninStepDefinitions extends PageUtil {

	HomePage HomePage = new HomePage(page);
	Signin Signin =  new Signin(page);;
	Register Register = new Register(page);
	homePageLocators homePageLocators = new homePageLocators(page);
	registerLocators registerLocators = new registerLocators(page);
	signinLocators signinLocators = new signinLocators(page);
	
	
	@When("I enter my username and password")
	public void login() {
		try {
			System.out.println("test 2 " + homePageLocators.SigninButton());
			homePageLocators.SigninButton().click();
		} catch (NullPointerException e) {
			System.out.println("test");
		}
		
		assertThat(page).hasTitle("Login");	
		signinLocators.EmailSignin().fill("test@testing.com");
		signinLocators.PasswordSignin().fill("Testovski123");
	}

	@When("I click the signin button")
	public void clicksignin() {
		signinLocators.SigninButton().click();
	}

	@Then("I should be signed in")
	public void loggedIn() {
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
	}
	
	@When("I enter my username and empty password")
	public void loginWithEmptyPassword() {
		homePageLocators.SigninButton().click();
		assertThat(page).hasTitle("Login");	
		signinLocators.EmailSignin().fill("test@testing.com");
		signinLocators.PasswordSignin().fill("");
	}
	
	@Then("I should not be signed in and get message")
	public void getVerificationMessage() {
		assert (page.locator("//a[contains(., \"Forgot your password?\")]")).getByText("Forgot your password?") != null;
	}
	
	@When("I click the logout button")
	public void clickLogout  () {
		homePageLocators.LogoutButton().click();
	}
	
	@Then("I should be logged out and get message")
	public void loggedOut() {
		assert (page.locator("//a[contains(., \"Log in to your customer account\")]")).getByText("Log in to your customer account") != null;
	}
	
}
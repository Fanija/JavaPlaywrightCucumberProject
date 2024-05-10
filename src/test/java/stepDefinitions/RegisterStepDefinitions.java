package stepDefinitions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.*;
import utils.*;
import locators.*;

public class RegisterStepDefinitions extends PageUtil {
	
	HomePage homePage = new HomePage(page);
	Signin signin =  new Signin(page);;
	Register register = new Register(page);
	homePageLocators homePageLocators = new homePageLocators(page);
	registerLocators registerLocators = new registerLocators(page);
	signinLocators signinLocators = new signinLocators(page);
	Common common = new Common();
	
		
		@Then("I click on register")
		public void clickRegisterButton() {
			register.clickRegister();
		}
		
		@When("I populate register form")
		public void populateRegisterForm() {
			registerLocators.SocialTitle().check();
	    	registerLocators.FirstName().fill(common.generateRandomFirstName());
	    	registerLocators.LastName().fill(common.generateRandomLastName());
	    	registerLocators.Email().fill(common.generateRandomEmail());
	    	registerLocators.Password().fill(common.generateRandomPassword());
			register.checkSpecialOffers();
			register.checkTermsAndConditions();
			register.checkNewsletter();
			register.checkDataPrivacy();
		}
		
		@Then("I click save register button")
		public void clickSaveRegisterButton() {
			register.clickSaveRegisterButton();
		}
		
		@Then("I should be navigated to my account")
		public void navigatedToMyAccount() {
			assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		}
		
		@When("I populate register form with already used email")
		public void populateRegisterFormWithAlreadyUsedEmail() {
			registerLocators.SocialTitle().check();
	    	registerLocators.FirstName().fill("Test");
	    	registerLocators.LastName().fill("Testing");
	    	registerLocators.Email().fill("test@testing.com");
	    	registerLocators.Password().fill("Testovski123");
			register.checkSpecialOffers();
			register.checkTermsAndConditions();
			register.checkNewsletter();
			register.checkDataPrivacy();
		}
		
		@Then("I should get message for unsuccessfull register")
		public void seeErrorMessage() {
			assert (page.locator("//li[@class=\"alert alert-danger\"]")).getByText("The email is already used, please choose another one or sign in") != null;
		}
	}
	


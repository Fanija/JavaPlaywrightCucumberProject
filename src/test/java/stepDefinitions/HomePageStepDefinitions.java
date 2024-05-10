package stepDefinitions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.homePageLocators;
import locators.registerLocators;
import locators.signinLocators;
import pages.*;
import utils.*;



	public class HomePageStepDefinitions  extends PageUtil {

		HomePage homePage = new HomePage(page);
		Signin signin =  new Signin(page);;
		Register register = new Register(page);
		homePageLocators homePageLocators = new homePageLocators(page);
		registerLocators registerLocators = new registerLocators(page);
		signinLocators signinLocators = new signinLocators(page);
		Common common = new Common();
		
		
	    @Given("I am on the home page")
	    public void navigateToHomePage() {
	    	homePage.navigateToHomePage();
	    }

	    @Then("I should verify the title of the page")
	    public void verifyTitle() {
	    	String actualTitle = homePage.getHomePageTitle();
			Assert.assertEquals(actualTitle, "My Store");
			assertThat(page).hasTitle("My Store");
		}
	    
	    @Then("I click signin button")
	    public void clickSigninButton() {
	    	homePageLocators.SigninButton().click();
		}
	    
	    @When("I click forgot your password button")
	    public void clickForgotYourPassword() {
	    	signinLocators.ForgotPassword().click();
	    	signinLocators.ForgotEmailAddress().click();
	    	signinLocators.ForgotEmailAddress().fill(common.generateRandomEmail());
	    	signinLocators.ResetLink().click();
	    }
	    
	    @Then("I get verification message") 
	    public void getVerificationMessage() {
	    	signin.verifyMessageForgotPassword();
		}
	    
	    @Then("I fill the search field with product name")
	    public void clickSearchField() {
	    	homePageLocators.SearchField().fill("tshirt");
	    }
	    
	    @When("I click \"Enter\"")
	    public void clickEnter() {
	    	homePage.pressEnterSearch();
	    }
	    
	    @Then("I verify new page with title of product name")
	    public void verifyNewPage() {
	    	assertThat(page.locator("//h2[@class=\"h3 product-title\"]")).containsText("t-shirt");
			Assert.assertTrue(homePage.TshirtisVisible());
	    }
	   
	    }
	



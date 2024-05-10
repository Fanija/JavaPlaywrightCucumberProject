package stepDefinitions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import pages.*;
import utils.*;
import locators.*;

public class CheckoutStepDefinitions extends PageUtil {
	
	HomePage homePage = new HomePage(page);
	Signin signin =  new Signin(page);;
	Register register = new Register(page);
	Cart cart = new Cart(page);
	PLP plp = new PLP(page);
	PDP pdp = new PDP(page);
	Checkout checkout = new Checkout(page);
	homePageLocators homePageLocators = new homePageLocators(page);
	registerLocators registerLocators = new registerLocators(page);
	signinLocators signinLocators = new signinLocators(page);
	cartLocators cartLocators = new cartLocators(page);
	plpLocators plpLocators = new plpLocators(page);
	pdpLocators pdpLocators = new pdpLocators(page);
	checkoutLocators checkoutLocators = new checkoutLocators(page);
	Common common = new Common();

	
	@Then("I click Continue New Address")
	public void clickContinueNewAddress() {
		checkout.clickContinueNewAddress();
	}
	
	@Then("I fill Order comment")
	public void fillOrderComment() {
		checkoutLocators.OrderComment().fill("This is my order");
	}
	
	@Then("I click Continue Delivery option")
	public void ContinueDeliveryOption() {
		checkout.clickContinueDeliveryOption();
	}
	
	@Then("I click Payment Option")
	public void clickPaymentOption() {
		checkout.clickPaymentOption();
	}
	
	@Then("I check Terms and Conditions")
	public void checkTermsAndConditions() {
		checkout.checkTermsAndCondiitions();
	}
	
	@Then("I click Place Order")
	public void clickPlaceOrder() {
		checkoutLocators.PlaceOrderButton().click();
	}
	
	@Then("I should get order confirmation message")
	public void getOrderConfirmationMessage() {
		assertThat(page).hasTitle("Order confirmation");
	}
	
	@And("I open product page in ART category")
	public void openProductPage() {
		pdpLocators.openProduct("Today is a good day Framed...").click();
	}
	
	@And("I open category ART")
	public void openCategory() {
		pdpLocators.openCategory("Art").click();
	}
	
	@Then("I click dimension")
	public void clickDimension() {
		plpLocators.Dimension().click();
	}
	
	@When("I click Order as a guest")
	public void clickOrderasaguest() {
		checkout.clickOrderasaguest();
	}
	
	@Then("I click Continue Personal Information")
	public void clickContinuePersonalInformation() {
		checkout.clickContinuePersonalInformation();
	}
	
	@When("I populate New Address Form")
	public void populateNewAddressForm() {
		checkoutLocators.NewAddressAddress().fill(common.generateRandomNewAddress());
    	checkoutLocators.NewAddressCity().fill(common.generateRandomNewCity());
    	checkoutLocators.NewAddressState().selectOption("5");
    	checkoutLocators.NewAddressZip().fill("98765");
    	checkoutLocators.NewAddressCountry().selectOption("21");
    }
	
	@And("I populate register form on checkout page")
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
	
}

package stepDefinitions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.*;
import utils.*;
import locators.*;

public class CartStepDefinitions extends PageUtil {
	
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
	
	
	@When("I open category")
	public void openCategory() {
		pdpLocators.openCategory("Clothes").click();
	}
	
	@When("I open product page")
	public void openProductPage() {
		pdpLocators.openProduct("Hummingbird printed t-shirt").click();
	}
	
	@Then("I select size")
	public void selectSize() {
		plpLocators.Size().selectOption("1");
	}
	
	@Then("I click colour")
	public void selectColour() {
		plpLocators.Color().click();
	}
	
	@Then("I fill quantity")
	public void selectQuantity() {
		plpLocators.Quantity().fill("4");
	}
	
	@Then("I click add to cart")
	public void clickAddToCartButton() {
		plpLocators.AddToCartButton().click();
	}
	
	@Then("I click continue shopping")
	public void clickContinueShoppingButton() {
		plpLocators.ContinueShoppingButton().click();
	}
	
	@Then("I click logout")
	public void clickLogoutButton() {
		homePageLocators.LogoutButton().click();
	}
	
	@Then("I should be logged out")
	public void loggedOut() {
		assert (page.locator("//a[contains(., \"Log in to your customer account\")]")).getByTitle("Log in to your customer account") != null;
	}
	
	@Then("I am in my account page")
	public void inAccountPage() {
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
	}
	
	@Then("I click proceed to checkout")
	public void clickProceedToCheckoutButton() {
		cartLocators.ProceedToCheckout().click();
	}
	
	@When("I open subcategory")
	public void openSubcategory() {
		pdpLocators.openSubCategory("Men");	
	}
	
	@Then("I am in the cart page")
	public void inCartPage() {
		assert (page.locator("//a[contains(., \"Hummingbird printed t-shirt\")]")).isVisible();
	}
	
	@Then("I click remove product")
	public void clickRemoveProductButton() {
		cartLocators.RemoveProduct().click();
	}
	
	@Then("I should get empty cart")
	public void emptyCart() {
		assertThat(page.locator("//div[@class=\"card cart-container\"][contains(., \"There are no more items in your cart\")]")).isVisible();
	}
	
	@Then("I increase quantity")
	public void increaseQuantity() {
		cartLocators.IncreaseQuantityFromCart().click();
	}
	
	@Then("I verify the quantity increased")
	public void quantityIncreased() {
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("5");
	}
	
	@Then("I verify the quantity decreased")
	public void quantityDecreased() {
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("3");
	}
	
	@Then("I decrease quantity")
	public void decreaseQuantity() {
		cartLocators.DecreaseQuantityFromCart().click();
	}
		
}
	
	
	
	


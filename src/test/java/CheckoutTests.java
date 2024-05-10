import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.*;
import utils.*;
import locators.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.Random;


class CheckoutTests {

	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	Random rand = new Random();
	
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	Cart Cart;
	PLP PLP;
	PDP PDP;
	Checkout Checkout;
	homePageLocators homePageLocators;
	signinLocators signinLocators;
	registerLocators registerLocators;
	plpLocators plpLocators;
	pdpLocators pdpLocators;
	checkoutLocators checkoutLocators;
	cartLocators cartLocators;
	
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
		Cart = new Cart(page);
		PLP = new PLP(page);
		PDP = new PDP(page);
		Checkout = new Checkout(page);
		
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	@Test
	public void SigninUserandCheckoutProduct() {
		HomePage.navigateToHomePage();
		
		if (HomePage.getHomePageTitle().equals("My Store")) {
            System.out.println("Element does not exist.");
        } else {
            System.out.println("Element exists.");
        }
		homePageLocators.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		//assertThat(page).hasTitle("View my customer account");
		assertThat(page.locator("//a[@class=\"account\"][@title= \"View my customer account\"]")).isVisible();
		
		pdpLocators.openCategory("Clothes").click();
		pdpLocators.openSubCategory("Men");
		pdpLocators.openProduct("Hummingbird printed t-shirt").click();
		plpLocators.Size().selectOption("1");
		plpLocators.Quantity().fill("4");
		plpLocators.AddToCartButton().click();
		cartLocators.ProceedToCheckout().click();
		//assert (page.locator("//a[contains(., \"Hummingbird printed t-shirt\")]").isVisible());
		
		cartLocators.IncreaseQuantityFromCart().click();
		//assertThat(page.locator("//input[@type=\"number\"]")).hasValue("5");
		cartLocators.ProceedToCheckout().click();
		Checkout.clickContinueNewAddress();
		checkoutLocators.OrderComment().fill("This is my order");
		Checkout.clickContinueDeliveryOption();
		Checkout.clickPaymentOption();
		Checkout.checkTermsAndCondiitions();
		checkoutLocators.PlaceOrderButton().click();
		//assertThat(page).hasTitle("Order confirmation");
		//assertThat(page.getByText("YOUR ORDER IS CONFIRMED")).isVisible();
		
		homePageLocators.LogoutButton().click();
		//assertThat(page).hasTitle("Log in to your customer account");
		//assertThat(page.getByText("Sign in")).isVisible();
	}
	
	@Test
	
	public void CheckoutProductWithoutLogin() {
		HomePage.navigateToHomePage();
		if (HomePage.getHomePageTitle().equals("My Store")) {
            System.out.println("Element does not exist.");
        } else {
            System.out.println("Element exists.");
        }
		
		pdpLocators.openCategory("Art").click();
		pdpLocators.openProduct("Today is a good day Framed...").click();
		plpLocators.Dimension().click();
		plpLocators.Quantity().fill("4");
		plpLocators.AddToCartButton().click();
		cartLocators.ProceedToCheckout().click();
		cartLocators.ProceedToCheckout().click();
		Checkout.clickOrderasaguest();
		//assertThat (page.locator("//a[contains(., \"Today is a good day Framed...\")]")).isVisible();
		Register.populateRegisterForm(common.generateRandomFirstName(), common.generateRandomLastName(), common.generateRandomEmail(), common.generateRandomPassword());
		Checkout.clickContinuePersonalInformation();
		//assertThat(page).hasTitle("Addresses");
		
		Checkout.populateNewAddressForm(common.generateRandomNewAddress(), common.generateRandomNewCity());
		Checkout.clickContinueNewAddress();
		//assertThat(page).hasTitle("Shipping Method");
		
		checkoutLocators.OrderComment().fill("My Order Comment");
		Checkout.clickContinueDeliveryOption();
		//assertThat(page).hasTitle("Payment");
		
		Checkout.clickPaymentOption();
		Checkout.checkTermsAndCondiitions();
		checkoutLocators.PlaceOrderButton().click();
		assertThat(page).hasTitle("Order confirmation");
		homePageLocators.LogoutButton().click();
		
	
}

	
}

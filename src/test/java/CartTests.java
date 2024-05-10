import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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

class CartTests {
	
	Playwright playwright;
	Browser browser;
	Page page;
	
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
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
		Cart = new Cart(page);
		PLP = new PLP(page);
		PDP = new PDP(page);
		homePageLocators = new homePageLocators(page);
		signinLocators = new signinLocators(page);
		registerLocators = new registerLocators(page);
		plpLocators = new plpLocators(page);
		pdpLocators = new pdpLocators(page);
		checkoutLocators = new checkoutLocators(page);
		cartLocators = new cartLocators(page);
		
	}
	
	@AfterEach
	public void tearDown() {
//		page.close();
//		browser.close();
		playwright.close();
	}

	@Test
	public void AddProducInCart() {
		homePageLocators.SigninButton().click();
                        Signin.Login("test@testing.com", "Testovski123");
                        assertThat(page.locator("//a[@class=\"account\"][@title= \"View my customer account\"]")).isVisible();
                        pdpLocators.openCategory("Clothes").click();
                        pdpLocators.openProduct("Hummingbird printed t-shirt").click();
                        plpLocators.Size().selectOption("1");
                        plpLocators.Color().click();
                        plpLocators.Quantity().fill("4");
                        plpLocators.AddToCartButton().click();
                        plpLocators.ContinueShoppingButton().click();
						//assertThat(page.locator("//a[contains(., \"Hummingbird printed t-shirt\")]")).isVisible();
						homePageLocators.LogoutButton();
                        
	} 
	
	@Test	
	public void AddProducInCartWithoutLogin() {
		pdpLocators.openCategory("Clothes").click();
							pdpLocators.openProduct("Hummingbird printed sweater").click();
					        plpLocators.Size().selectOption("2");
					        plpLocators.Quantity().fill("2");
					        plpLocators.AddToCartButton().click();
					        plpLocators.ContinueShoppingButton().click();
							//assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]")).isVisible();
							homePageLocators.SigninButton().click();
							assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
                        
    }
	
	@Test
	public void AddProducInCartWithoutSelectingColor() {
		
		homePageLocators.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		pdpLocators.openCategory("Home Accessories").click();
		pdpLocators.openProduct("Mountain fox cushion").click();
        plpLocators.AddToCartButton().click();
        cartLocators.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Mountain fox cushion\")]").isVisible());
		homePageLocators.LogoutButton().click();
		assert (page.locator("//a[contains(., \"Log in to your customer account\")]")).getByTitle("Log in to your customer account") != null;
	}
	
	
	@Test
	public void AddProducInCartWithoutSelectingQuantityWithoutLoginAndProceedToCheckoutAndLogoutAndLoginAndProceedToCheckout() {
		
		pdpLocators.openCategory("Art").click();
		pdpLocators.openProduct("Mountain fox - Vector graphics").click();
		plpLocators.AddToCartButton().click();
		cartLocators.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Mountain fox - Vector graphics\")]").isVisible());
		homePageLocators.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		cartLocators.ProceedToCheckout().click();
		assert (page.locator("//h1[contains(., \"Personal Information\")]").isVisible());
	}
	
	@Test
	public void AddProductinCartAndRemoveProductFomCart() {
		
		pdpLocators.openCategory("Clothes").click();
		pdpLocators.openSubCategory("Men");
		pdpLocators.openProduct("Hummingbird printed sweater").click();
        plpLocators.Size().selectOption("2");
        plpLocators.Quantity().fill("4");
        plpLocators.AddToCartButton().click();
        cartLocators.ProceedToCheckout().click();
		assertThat(page.locator("//a[contains(., \"Hummingbird printed sweater\")]")).isVisible();
		//assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		cartLocators.RemoveProduct().click();
		assertThat(page.locator("//div[@class=\"card cart-container\"][contains(., \"There are no more items in your cart\")]")).isVisible();
		
	}
	
	@Test
	public void AddProductinCartAndIncreaseQuantity() {
		
		pdpLocators.openCategory("Clothes").click();
		pdpLocators.openSubCategory("Men");
		pdpLocators.openProduct("Hummingbird printed sweater").click();
		plpLocators.Size().selectOption("3");
		plpLocators.Quantity().fill("2");
		plpLocators.AddToCartButton().click();
		cartLocators.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		cartLocators.IncreaseQuantityFromCart().click();
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("3");
	}
	
	@Test
	public void AddProductinCartAndDecreaseQuantity() {
		pdpLocators.openCategory("Clothes").click();
		pdpLocators.openProduct("Hummingbird printed sweater").click();
		plpLocators.Size().selectOption("2");
		plpLocators.Quantity().fill("3");
		plpLocators.AddToCartButton().click();
		cartLocators.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		cartLocators.DecreaseQuantityFromCart().click();
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("2");
	}
}

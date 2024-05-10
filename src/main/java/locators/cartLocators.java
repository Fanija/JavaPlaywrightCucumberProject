package locators;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;
import pages.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class cartLocators {
	//private final Page page;
	
	//Playwright playwright = Playwright.create();
	//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PDP PDP;
	PLP PLP;
	Checkout Checkout;

    public cartLocators(Page page) {
        this.page = page;
    }

	public Locator ProductInCart() {
		Locator ProductInCart = page.locator("//a[contains(., \"Cart\")]");
		return ProductInCart;
	}
	
	public Locator RemoveProduct() {
		Locator RemoveProduct = page.locator("//a[@class=\"remove-from-cart\"]");
		return RemoveProduct;
	}
	
	public Locator ContinueShopping() {
		Locator ContinueShopping = page.locator("//a[contains(., \"Continue shopping\")]");
		return ContinueShopping;
	}
	
	public Locator ProceedToCheckout() {
		Locator ProceedToCheckout = page.locator("//a[contains(., \"Proceed to checkout\")]");
		return ProceedToCheckout;
	}
	
	public Locator EmptyCart() {
		Locator EmptyCart = page.locator("//a[contains(., \"Empty cart\")]");
		return EmptyCart;
	}
	
	public Locator IncreaseQuantityFromCart() {
		Locator IncreaseQuantityFromCart = page.locator("//button/i[@class=\"material-icons touchspin-up\"]");
		return IncreaseQuantityFromCart;
	}
	
	public Locator DecreaseQuantityFromCart() {
		Locator DecreaseQuantityFromCart = page.locator("//button/i[@class=\"material-icons touchspin-down\"]");
		return DecreaseQuantityFromCart;
	}

}

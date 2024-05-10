package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import pages.*;

public class plpLocators {
	//private final Page page;
//	
//		Playwright playwright = Playwright.create();
//		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page;
    	Common common;
    	
    	HomePage HomePage;
    	Signin Signin;
    	Register Register;
    	PDP PDP;
		PLP PLP;	
    	plpLocators plpLocators;
    	
    	
    	public plpLocators(Page page) {
    		this.page = page;
    }
    	
    	public Locator Size() {
    		Locator Size = page.locator("//select[@id=\"group_1\"]");
    		return Size;
    	}
    	
    	public Locator Color() {
    		Locator Color = page.locator("//input[@title=\"White\"]");
    		return Color;
    	}
    	
    	public Locator Dimension() {
    		Locator Dimension = page.locator("//select[@id=\"group_3\"]");
    		return Dimension;
    	}
    	
    	public Locator MoreQuantity() {
    		Locator MoreQuantity = page.locator("//button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-up\"]");
    		return MoreQuantity;
    	}
    	
    	public Locator LessQuantity() {
    		Locator LessQuantity = page.locator("//button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-down\"]");
    		return LessQuantity;
    	}
    	
    	public Locator Quantity() {
    		Locator Quantity = page.locator("//input[@id=\"quantity_wanted\"]");
    		return Quantity;
    	}
    	
    	public Locator AddToCartButton() {
    		Locator AddToCartButton = page.locator("//button[contains(., \"Add to cart\")]");
    		return AddToCartButton;
    	}
    	
    	public Locator ContinueShoppingButton() {
    		Locator ContinueShoppingButton = page.locator("//button[contains(., \"Continue shopping\")]");
    		return ContinueShoppingButton;
    	}
    	
    	
    	public Locator AddToWishlistButton() {
    		Locator AddToWishlistButton = page.locator("//a[@class=\"wishlist-button-add wishlist-button-product\"]");
    		return AddToWishlistButton;
    	}
    	
    	public void clickWriteYourReview() {
    		Locator WriteYourReview = page.locator("//button[contains(., \"Write your review\")]");
    		WriteYourReview.click();
    	}
    	
    	public Locator Title() {
    		Locator Title = page.locator("//input[@id=\"comment_title\"]");
    		return Title;
    	}
    	
    	public Locator Review() {
    		Locator Review = page.locator("//textarea[@id=\"comment_content\"]");
    		return Review;
    	}
}
   
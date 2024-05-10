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

public class homePageLocators {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PDP PDP;
	PLP PLP;
	Checkout Checkout;

    public homePageLocators(Page page) {
        this.page = page;
    }
    
    public Locator SigninButton() {
    	Locator SigninButton = page.locator("//div[@class=\"user-info\"]/a[@title=\"Log in to your customer account\"]");
    return SigninButton;
    }
    
    public Locator LogoutButton() {
    	Locator LogoutButton = page.locator("//div[@class=\"user-info\"]/a[@class=\"logout hidden-sm-down\"]");
    return LogoutButton;
    }
    
    public Locator SearchField() {
		Locator SearchField = page.locator("//input[@name=\"s\"]");
		return SearchField;
	}
}
    
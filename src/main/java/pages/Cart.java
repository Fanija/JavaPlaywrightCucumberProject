package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import utils.*;
import pages.*;
import locators.*;


public class Cart {
	//private final Page page;
	
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
	cartLocators cartLocators;

    public Cart(Page page) {
        this.page = page;
    }
}

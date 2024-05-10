package pages;

import utils.*;
import pages.*;
import locators.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;


public class Register {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	registerLocators registerLocators;
	
	//private final Page page;

    public Register(Page page) {
        this.page = page;
    }
    
    public void clickRegister() {
		Locator Register = page.locator("//div[@class=\"no-account\"]/a");
		Register.click();
	} 
    
    public void populateRegisterForm(String firstName, String lastName, String email, String password) {
    	registerLocators.SocialTitle().check();
    	registerLocators.FirstName().fill(common.generateRandomFirstName());
    	registerLocators.LastName().fill(common.generateRandomLastName());
    	registerLocators.Email().fill(common.generateRandomEmail());
    	registerLocators.Password().fill(common.generateRandomPassword());
		checkSpecialOffers();
		checkTermsAndConditions();
		checkNewsletter();
		checkDataPrivacy();
		//clickSaveRegisterButton();
    }
    
	public void checkSpecialOffers() {
		Locator specialOffers = page.locator("//input[@name=\"optin\"]");
		specialOffers.check();
	}
	
	public void checkTermsAndConditions() {
		Locator TermsAndConditions = page.locator("//*[@name=\"psgdpr\"]");
		TermsAndConditions.check();
	} 
	
	public void checkNewsletter() {
		Locator newsletter = page.locator("//*[@name=\"newsletter\"]");
		newsletter.check();
	}
	
	public void checkDataPrivacy() {
		Locator DataPrivacy = page.locator("//*[@name=\"customer_privacy\"]");
		DataPrivacy.check();
	}
	
	public void clickSaveRegisterButton() {
		Locator SaveRegisterButton = page.locator("//button[@data-link-action=\"save-customer\"]");
		SaveRegisterButton.click();
	}

}

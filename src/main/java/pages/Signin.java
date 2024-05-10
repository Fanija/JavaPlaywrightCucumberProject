package pages;

import utils.*;
import pages.*;
import locators.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;

public class Signin {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Register Register;
	signinLocators signinLocators;
	
	//private final Page page;

	public Signin(Page page) {
		this.page = page;
		
	}

	public void Login(String email, String password){
		
		signinLocators.EmailSignin().fill("test@testing.com");
		signinLocators.PasswordSignin().fill("Testovski123");
		signinLocators.SigninButton().click();
	}
	

    public void ForgotYourPassword() {
    	signinLocators.ForgotPassword().click();
    	signinLocators.ForgotEmailAddress().click();
    	signinLocators.ForgotEmailAddress().fill(common.generateRandomEmail());
    	signinLocators.ResetLink().click();
    }
    
	public void verifyMessageForgotPassword() {
		Locator MessageResetPassword = page.locator("//p[contains(., \"If this email address has been registered in our store, you will receive a link to reset your password\")]");
		MessageResetPassword.isVisible();
	}
	
}

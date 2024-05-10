package locators;

import utils.*;
import pages.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;


public class signinLocators {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	signinLocators signinLocators;
	
	//private final Page page;

    public signinLocators(Page page) {
        this.page = page;
    }
    
    public Locator EmailSignin() {
        Locator EmailSignin = page.locator("//input[@id=\"field-email\"]");
        return EmailSignin;
	}
	
	public Locator PasswordSignin() {
		Locator PasswordSignin = page.locator("//input[@id=\"field-password\"]");
		return PasswordSignin;
	}
	
	public Locator EmptyPassword() {
		return page.locator("//input[@id=\"field-password\"]");
	}
	
    public Locator SigninButton() {
    	Locator SigninButton = page.locator("//button[@id=\"submit-login\"]");
    	return SigninButton;
    }
    
    public Locator ForgotPassword() {
		Locator ForgotPassword = page.locator("//div[@class=\"forgot-password\"]/a");
		return ForgotPassword;
	}
	
	public Locator ForgotEmailAddress() {
        Locator ForgotEmailAddress = page.locator("//input[@id=\"email\"]");
        return ForgotEmailAddress;
	}
	
	public Locator ResetLink() {
		Locator ResetLink = page.locator("//button[@id=\"send-reset-link\"]");
		return ResetLink;
	}
	
}

package locators;

import utils.*;
import pages.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;


public class registerLocators {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	
	//private final Page page;

    public registerLocators(Page page) {
        this.page = page;
    }
    
    public Locator SocialTitle() {
		Locator socialTitle = page.locator("//input[@id=\"field-id_gender-1\"]");
		return socialTitle;
	}
	
	public Locator FirstName() {
		Locator FirstName = page.locator("//*[@id=\"field-firstname\"]");
		return FirstName;
	}

	public Locator LastName() {
		Locator LastName = page.locator("//*[@id=\"field-lastname\"]");
		return LastName;
	}
	

	public Locator Email() {
        Locator Email = page.locator("//*[@id=\"field-email\"]");
        return Email;
	}
	
            
    public Locator Password() {
    	 Locator Password = page.locator("//*[@id=\"field-password\"]");
    	 return Password;
    }
    
	public Locator BirthDay() {
		Locator BirthDay = page.locator("//*[@id=\"days\"]");
		return BirthDay;
	}
	
	public Locator BirthMonth() {
		Locator BirthMonth = page.locator("//*[@id=\"months\"]");
		return BirthMonth;
	}
	
	public Locator BirthYear() {
		Locator BirthYear = page.locator("//*[@id=\"years\"]");
		return BirthYear;
	}

	
}
    
    
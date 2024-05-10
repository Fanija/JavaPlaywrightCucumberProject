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

public class checkoutLocators {
	
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

    public checkoutLocators(Page page) {
        this.page = page;
    }
    
    public Locator EmailPersonalInformation() {
		Locator EmailPersonalInformation = page.locator("//form[@class=\"js-customer-form\"]//input[@id=\"field-email\"]");
		return EmailPersonalInformation;
	}
	
	public Locator PasswordPersonalInformation() {
		Locator PasswordPersonalInformation = page.locator("//form[@class=\"js-customer-form\"]//input[@id=\"field-password\"]");
		return PasswordPersonalInformation;
	}
	
	public Locator AddNewAddressButton() {
		Locator AddNewAddressButton = page.locator("//p[@class=\"add-address\"]/a[contains(., \"add new address\")]");
		return AddNewAddressButton;
	}
	
	public Locator NewAddressFirstName() {
		Locator NewAddressFirstName = page.locator("//input[@id=\"field-firstname\"]");
		return NewAddressFirstName;
	}
	
	public Locator NewAddressLastName() {
		Locator NewAddressLastName = page.locator("//input[@id=\"field-lastname\"]");
		return NewAddressLastName;
	}
	
	public Locator NewAddressAddress() {
		Locator NewAddressAddress = page.locator("//input[@id=\"field-address1\"]");
		return NewAddressAddress;
	}
	
	public Locator NewAddressCity() {
		Locator NewAddressCity = page.locator("//input[@id=\"field-city\"]");
		return NewAddressCity;
	}
	
	public Locator NewAddressZip() {
		Locator NewAddressZip = page.locator("//input[@id=\"field-postcode\"]");
		return NewAddressZip;
	}
	
	public Locator NewAddressPhone() {
		Locator NewAddressPhone = page.locator("//input[@id=\"field-phone\"]");
		return NewAddressPhone;
	}
	
	
	public Locator NewAddressState() {
		Locator NewAddressState = page.locator("//select[@id=\"field-id_state\"]");
		return NewAddressState;
	}
	
	public Locator NewAddressCountry() {
		Locator NewAddressCountry = page.locator("//select[@id=\"field-id_country\"]");
		return NewAddressCountry;
	}
	
	public Locator OrderComment() {
		Locator OrderComment = page.locator("//textarea[@id=\"delivery_message\"]");
		return OrderComment;
	}
	
	public Locator PlaceOrderButton() {
		Locator PlaceOrderButton = page.locator("//button[contains(., \"Place order\")]");
		return PlaceOrderButton;
	}
	

}

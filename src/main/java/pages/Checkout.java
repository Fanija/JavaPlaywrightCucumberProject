package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import pages.*;
import locators.*;


public class Checkout {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PDP PDP;
	PLP PLP;
	Cart Cart;
	checkoutLocators checkoutLocators; 

    public Checkout(Page page) {
        this.page = page;
    }
    
    public void clickOrderasaguest() {
    	Locator Orderasaguest = page.locator("//a[contains(., \"Order as a guest\")]");
    	Orderasaguest.click();
    }
    
    public void clickPersonalInformations() {
    	Locator PersonalInformations = page.locator("//section[@id=\"checkout-personal-information-step\"][contains(., \" Personal Information\")]");
    	PersonalInformations.click();
    }
      
    public void populateNewAddressForm(String newAddress, String newCity) {
    	checkoutLocators.NewAddressAddress().fill(common.generateRandomNewAddress());
    	checkoutLocators.NewAddressCity().fill(common.generateRandomNewCity());
    	checkoutLocators.NewAddressState().selectOption("5");
    	checkoutLocators.NewAddressZip().fill("98765");
    	checkoutLocators.NewAddressCountry().selectOption("21");
    }
    
	public void SocialTitlePersonalInformation() {
		Locator SocialTitle = page.locator("//input[@value=\"2\"]");
		SocialTitle.click();
	}
	
	public void checkTermsAndConditionsPersonalInformation() {
		Locator TermsAndConditionsPersonalInformation = page.locator("//input[@name=\"psgdpr\"]");
		TermsAndConditionsPersonalInformation.check();
	}
	
	public void checkCustomerDataPrivacyPersonalInformation() {
		Locator CustomerDataPrivacyPersonalInformation = page.locator("//input[@name=\"customer_privacy\"]");
		CustomerDataPrivacyPersonalInformation.check();
	}
	
	
	public void clickContinuePersonalInformation() {
		Locator ContinuePersonalInformation = page.locator("//button[@data-link-action=\"register-new-customer\"]");
		ContinuePersonalInformation.click();
	}
	
	public void checkShippingAddress() {
		Locator ShippingAddress = page.locator("//input[@name=\"id_address_delivery\" and @value=\"7\"]");
		ShippingAddress.check();
	}
	
	public void EditShippingAddress() {
		Locator EditShippingAddress = page.locator("//footer[@class=\"address-footer\"]/a[contains(., \"Edit\")]");
		EditShippingAddress.click();
	}
	
	
	public void DeleteShippingAddress() {
		Locator DeleteShippingAddress = page.locator("//footer[@class=\"address-footer\"]/a[contains(., \"Delete\")]");
		DeleteShippingAddress.click();
	}

	public void clickContinueNewAddress() {
		Locator ContinueNewAddress = page.locator("//button[@name=\"confirm-addresses\"]");
		ContinueNewAddress.click();
	}
	
	public void clickDeliveryOption() {
		Locator DeliveryOption = page.locator("id=\"delivery_option_2\"");
		DeliveryOption.click();
	}

	
	public void clickContinueDeliveryOption() {
		Locator ContinueDeliveryOption = page.locator("//button[@name=\"confirmDeliveryOption\"]");
		ContinueDeliveryOption.click();
	}
	
	public void clickPaymentOption() {
		Locator PaymentOption = page.locator("//input[@id=\"payment-option-3\"]");
		PaymentOption.click();
	}
	
	public void checkTermsAndCondiitions() {
		Locator TermsAndCondiitions = page.locator("//input[@id=\"conditions_to_approve[terms-and-conditions]\"]");
		TermsAndCondiitions.check();
	}
	  
}
package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import locators.*;

public class HomePage {
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	
	Signin Signin;
	Register Register;
	homePageLocators homePageLocators;
	
	//private final Page page;
	

    public HomePage(Page page) {
        this.page = page;
    }
    
    public void navigateToHomePage() {
        page.navigate("https://testcommerce.churlinoski.mk/");
    }
    
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Home Page Title: " + "My Store");
		return title;
	}

    
	public void clickForgotPassword() {
		Locator ForgotPassword = page.locator("//a[contains(.,\"Forgot your password?\")]");
		ForgotPassword.click();
	}

	public void clickHome() {
		Locator Home = page.locator("//section[@id=\"wrapper\"]//a[contains(.,\"Home\")]");
		Home.click();
	}

	public void clickContactUs() {
		Locator ContactUs = page.locator("//a[contains(.,\"Contact us\")]");
		ContactUs.click();
	}

	public void clickCart() {
		Locator Cart = page.locator("//a[contains(.,\"Cart\")]");
		Cart.click();
	}

	public void clickWishlist() {
		Locator Wishlist = page.locator("//a[contains(.,\"Wishlist\")]");
		Wishlist.click();
	}

	public void clickCompare() {
		Locator Compare = page.locator("//a[contains(.,\"Compare\")]");
		Compare.click();
	}

	public void clickBrands() {
		Locator Brands = page.locator("//a[contains(.,\"Brands\")]");
		Brands.click();
	}

	public void clickGiftVouchers() {
		Locator GiftVouchers = page.locator("//a[contains(.,\"Gift Vouchers\")]");
		GiftVouchers.click();
	}

	public void clickAffiliate() {
		Locator Affiliate = page.locator("//a[contains(.,\"Affiliate\")]");
		Affiliate.click();
	}

	public void clickSpecials() {
		Locator Specials = page.locator("//a[contains(.,\"Specials\")]");
		Specials.click();
	}

	public void clickMyAccount() {
		Locator MyAccount = page.locator("//a[contains(.,\"My Account\")]");
		MyAccount.click();
	}

	public void clickNewsletter() {
		Locator Newsletter = page.locator("//a[contains(.,\"Newsletter\")]");
		Newsletter.click();
	}

	public void clickRegister() {
		Locator Register = page.locator("//a[contains(.,\"Register\")]");
		Register.click();
	}

	public void clickLogin() {
		Locator Login = page.locator("//a[contains(.,\"Login\")]");
		Login.click();
	}

	public void clickBrandsMenu() {
		Locator BrandsMenu = page.locator("//a[contains(.,\"Brands\")]");
		BrandsMenu.click();
	}

	public void clickGiftVouchersMenu() {
		Locator GiftVouchersMenu = page.locator("//a[contains(.,\"Gift Vouchers\")]");
		GiftVouchersMenu.click();
	}

	public void clickAffiliateMenu() {
		Locator AffiliateMenu = page.locator("//a[contains(.,\"Affiliate\")]");
		AffiliateMenu.click();
	}
	
	
	public void pressEnterSearch() {
		Locator EnterSearch = page.locator("//input[@name=\"s\"]");
		EnterSearch.press("Enter");
	}

	public boolean TshirtisVisible() {
		Locator Tshirt = page.locator("//h2[@class=\"h3 product-title\"]");
		return Tshirt.isVisible();
	}
}


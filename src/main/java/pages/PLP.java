package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

public class PLP {
	//private final Page page;
//		Playwright playwright = Playwright.create();
//		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page;
    	Common common;
    	
    	HomePage HomePage;
    	Signin Signin;
    	Register Register;
    	PDP PDP;
    	
    	
    	public PLP(Page page) {
    		this.page = page;
    }
   
	
	public void clickSend() {
		Locator Send = page.locator("//button[contains(., \"Send\")]");
		Send.click();
	}
	
	public void clickClosePageOK() {
		Locator ClosePageOK = page.locator("//button[contains(., \"OK\")]");
		ClosePageOK.click();
	}
	
	public void clickQuickViewProduct() {
		Locator QuickViewProduct = page.locator("//i[@class=\"material-icons zoom-in\"]");
		QuickViewProduct.click();
	}
	
	public void clickCloseQuickView() {
		Locator CloseQuickView = page.locator("//aside[@id=\"thumbnails\"]");
		CloseQuickView.click();
	}

}

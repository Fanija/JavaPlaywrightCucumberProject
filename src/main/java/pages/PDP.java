package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import locators.*;

public class PDP {
	
	//private final Page page;
	
//	Playwright playwright = Playwright.create();
//	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PLP PLP;
	pdpLocators pdpLocators;

    public PDP(Page page) {
        this.page = page;
    }
    
}

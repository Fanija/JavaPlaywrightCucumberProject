package stepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.*;
import utils.*;
import locators.*;

public class CommonTestDefinitions {
	
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page;
	Common common;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	homePageLocators homePageLocators;
	signinLocators signinLocators;
	registerLocators registerLocators;
	
	@Before
	public void setUp() {
		
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
	}
	
	@After
	public void tearDown() {
//		page.close();
//		browser.close();
		playwright.close();
	}
		
	}



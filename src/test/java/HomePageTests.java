import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import utils.*;
import pages.*;
import locators.*;

import org.junit.jupiter.api.Test;

public class HomePageTests {

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
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	@Test
	public void getHomePageTitle() {
		HomePage.navigateToHomePage();
		String actualTitle = HomePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "My Store");
		assertThat(page).hasTitle("My Store");
	}
	
	@Test
	public void forgotPassword() {
		HomePage.navigateToHomePage();
		homePageLocators.SigninButton().click();
		Signin.ForgotYourPassword();
		Signin.verifyMessageForgotPassword();
	}
	
	@Test
	public void searchProductWithoutSignin() {
		HomePage.navigateToHomePage();
		homePageLocators.SearchField().fill("tshirt");
		HomePage.pressEnterSearch();
		assertThat(page.locator("//h2[@class=\"h3 product-title\"]")).containsText("t-shirt");
		Assert.assertTrue(HomePage.TshirtisVisible());
		
	}
	
	@Test
	public void searchProductWithSignin() {
		homePageLocators.SigninButton().click();
		try {
			Signin.Login("test@testing.com", "Testovski123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePageLocators.SearchField().fill("tshirt");
		HomePage.pressEnterSearch();
		assertThat(page.locator("//h2[@class=\"h3 product-title\"]")).containsText("t-shirt");
		Assert.assertTrue(HomePage.TshirtisVisible());
	}

}

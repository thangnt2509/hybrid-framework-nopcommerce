package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {


	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");

		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		validPassword = "123456";	
		
		log.info("Pre-condition - Step 01: Navigate to Register page");		
		registerPage = homePage.openRegisterPage();
		
		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'" );
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'" );
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to email textbox with value is '" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05: Enter to password textbox with value is '" + validPassword + "'" );
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 06: Enter to confirm password textbox with value is '" + validPassword + "'" );
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-condition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Pre-condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Pre-condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		
		log.info("Pre-condition - Step 01: Enter to email textbox with value is '" + emailAddress + "'" );
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 02: Enter to password textbox with value is '" + validPassword + "'" );
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Pre-condition - Step 03: Click to Login button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void Search_01_Name() {
			
	}

	@Test
	public void Search_01_Address() {
		
	}

	//Afterclass bị skip khi before class bị fail
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();	
	}
	
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, emailAddress, validPassword;
}

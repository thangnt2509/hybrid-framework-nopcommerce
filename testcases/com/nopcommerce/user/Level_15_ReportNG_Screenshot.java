package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
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

public class Level_15_ReportNG_Screenshot extends BaseTest {


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
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register page");		
		registerPage = homePage.openRegisterPage();
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'" );
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'" );
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to email textbox with value is '" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Register - Step 05: Enter to password textbox with value is '" + validPassword + "'" );
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Register - Step 06: Enter to confirm password textbox with value is '" + validPassword + "'" );
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();	
	}

	@Test
	public void User_01_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login - Step 01: Enter to email textbox with value is '" + emailAddress + "'" );
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 02: Enter to password textbox with value is '" + validPassword + "'" );
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 03: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 04: Verify 'My Account' link is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 05: Navigate to My Account page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 06: Verify 'Customer Infor' page is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass 
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, emailAddress, validPassword;
}

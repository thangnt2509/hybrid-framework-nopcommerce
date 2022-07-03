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

public class Level_18_Pattern_Object extends BaseTest {

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
		date = "10";
		month = "August";
		year = "1998";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
		
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		
		log.info("Register - Step 04: Enter to email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		log.info("Register - Step 05: Enter to password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Register - Step 06: Enter to confirm password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);
		
		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {	
		log.info("Login - Step 01: Navigate to Login page");
		// log.info("Register - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 01: Enter to email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login - Step 02: Enter to password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Login - Step 03: Click to Login button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 04: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		
	}

	@Test
	public void User_03_My_Account() {	
		log.info("My Account - Step 01: Navigate to My Account page");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("My Account - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
		
		log.info("My Account - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);
		
		
		log.info("My Account - Step 03: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);
		
		log.info("My Account - Step 03: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);
		
	}
	
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
	private String date, month, year;
}

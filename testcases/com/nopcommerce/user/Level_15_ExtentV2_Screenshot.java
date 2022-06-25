package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManager;

public class Level_15_ExtentV2_Screenshot extends BaseTest {

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
	public void User_01_Register(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register page");
//		registerPage = homePage.openRegisterPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
//		registerPage.inputToFirstnameTextbox(firstName);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
//		registerPage.inputToLastNameTextbox(lastName);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to email textbox with value is '" + emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to password textbox with value is '" + validPassword + "'");
//		registerPage.inputToPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to confirm password textbox with value is '" + validPassword + "'");
//		registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//		ExtentTestManager.endTest();

	}

	@Test
	public void User_01_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
//
//		homePage = registerPage.clickToLogoutLink();
//		loginPage = homePage.openLoginPage();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 01: Enter to email textbox with value is '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to password textbox with value is '" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 03: Click to Login button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 04: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 05: Navigate to My Account page");
//		customerInforPage = homePage.clickToMyAccountLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Login - Step 06: Verify 'Customer Infor' page is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	String firstName, lastName, emailAddress, validPassword;
}

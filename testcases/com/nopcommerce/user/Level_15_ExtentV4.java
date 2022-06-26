package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV4 extends BaseTest {

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
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);

		
		registerPage.inputToLastNameTextbox(lastName);

		
		registerPage.inputToEmailTextbox(emailAddress);

		
		registerPage.inputToPasswordTextbox(validPassword);

		
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		
		registerPage.clickToRegisterButton();

		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		

	}

	@Test
	public void User_01_Login(Method method) {
		
		

		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		
		loginPage.inputToEmailTextbox(emailAddress);

		
		loginPage.inputToPasswordTextbox(validPassword);

		
		homePage = loginPage.clickToLoginButton();

		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		
		customerInforPage = homePage.clickToMyAccountLink();

		
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
		
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

package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		// Không bị lỗi nullPointer, khởi tạo ở từng TC
		// Nhược điểm: Không đảm bảo được tính encapsulation (Tính đóng gói của OOP)

		// 1

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@afc.com@vn";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.vn";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
		validPassword = "123456";
		incorrectPassword = "654321";

		System.out.println("Pre-condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		// Click register link -> nhảy qua trang Register
		// 2
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-condition - Step 02: Input valid data");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-condition - Step 03: Click to Register link");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();

		// Click logout thì business nó sẽ quay về trang HomePage
		// 3
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Login button");
		homePage.clickToLoginButton();

		// Từ trang Home > Click login link > Sang trang Login
		// 4
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01_Empty_Datan - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginButton();

		// 5
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginButton();
		// 6
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginButton();
		// 7
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginButton();
		// 8
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		homePage.clickToLoginButton();
		// 9
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();

		// Login thành công > Về trang homepage
		// 10
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass // Customer close browser/ driver
	public void afterClass() {
		driver.quit();
	}

}

package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {


	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");

		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		System.out.println(emailAddress);
		validPassword = "123456";


		
	}

	@Test
	public void User_01_Register() {		
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();	

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void User_04_Switch_Page() {
		//Customer Infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);
		
		//Address -> My product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		//My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		//Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		//Address -> Reward Point 
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		//Reward Point  -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		//My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
		
		customerInforPage = addressPage.openCustomerInforPage(driver);
		//openCustomerInforPage
	}
	
	@Test
	public void User_05_Switch_Role() {
		//Role User -> Role Admin
		
		//Role Admin -> Role User
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
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;
}

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

public class Level_09_Dynamic_Locator extends BaseTest {


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
	public void User_01_Register_Login() {		
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();	

		loginPage = homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_Page() {
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
		
	}
	@Test
	public void User_03_Dynamic_Page_01() {
		//My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		
		//Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountPageByName(driver, "Addresses");
		
		//Address -> Reward Point 
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		
		//Reward Point  -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		
		//My Product Review -> Customer Info
		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Customer info");
	}
	
	@Test
	public void User_03_Dynamic_Page_02() {
		//Customer Infor -> //My Product Review 
		customerInforPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		//My Product Review -> Reward Point
		myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
				
		//Reward Point -> Address
		rewardPointPage.openPagesAtMyAccountPageByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		//Address -> Reward Point 
		addressPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		//Reward Point  -> My Product Review
		rewardPointPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		//My Product Review -> Customer Info
		myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
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

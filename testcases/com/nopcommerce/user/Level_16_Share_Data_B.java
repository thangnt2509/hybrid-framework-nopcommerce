package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_16_Share_Data_B extends BaseTest {


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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}


	@Test
	public void Search_01_Empty_Data() {
		

	}
	@Test
	public void Search_02_Relative_Product_Name() {
		
		
	}
	@Test
	public void Search_03_Absolute_Product_Name() {
		
		
	}
	@Test
	public void Search_04_Parent_Category() {
		
	}
	
	@Test
	public void Search_05_Incorrect_Manufacturer() {
		
	}
	
	@Test
	public void Search_06_Correct_Manufacturer() {
			
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

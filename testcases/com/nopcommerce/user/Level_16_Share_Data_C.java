package com.nopcommerce.user;


import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_16_Share_Data_C extends BaseTest {

	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");

		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.password;
		
		log.info("Pre-condition - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		
		log.info("Pre-condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookie);
		for (Cookie cookie : Common_01_Register_Cookie.loggedCookie) {
			System.out.println("Cookie at C Class: " + cookie);		
		}
		loginPage.refreshCurrentPage(driver);
		
		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
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
//		driver.quit();
	}
	
	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, emailAddress, validPassword;
}

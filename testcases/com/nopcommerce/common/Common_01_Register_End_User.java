package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new common user for all Classes Test")
	public void User_01_Register(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";	
		
	
		log.info("Pre-condition - Step 01: Navigate to Register page");		
		registerPage = homePage.openRegisterPage();
		
		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'" );
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'" );
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - Step 04: Enter to email textbox with value is '" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05: Enter to password textbox with value is '" + password + "'" );
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 06: Enter to confirm password textbox with value is '" + password + "'" );
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre-condition - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-condition - Step 08: Verify register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();	
		driver.quit();
	}

	private WebDriver driver;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName;
	//Biến static thuộc Class quản lí/ không thuộc instance quản lý
	//Nên class mà run xong thì các biến instance tự động hủy nhưng biến static vẫn còn tồn tại
	//Khi nào máy ảo Java nó ko còn chạy nữa (tất cả các class đều được run xong) thì các biến static mới bị hủy đi
	public static String emailAddress, password;
}

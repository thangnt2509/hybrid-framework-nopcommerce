package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {


	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get(GlobalConstants.PORTAL_DEV_URL);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userEmailAddress = "thangnt@gmail.com";
		userPassword = "123456";
	
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {		
		userLoginPage = userHomePage.openLoginPage();
		
		//Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		//Home page -> Customer Info
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		
		//Customer Info -> click Logout -> Home page
		userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);
		
		//User Home page -> open Admin page -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login as Admin role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		//Dashboard Page -> Click Logout -> Login Page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		//Login Page (Admin) -> Open User URL -> Home page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		//Home Page -> Login Page (User)
		userLoginPage = userHomePage.openLoginPage();
		
		//Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Infor() {

	}

	@Test
	public void User_04_Switch_Page() {
		//Customer Infor -> Address
	
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

	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
}

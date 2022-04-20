package com.liveguru.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {


	@Parameters("browser")
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		driver.get("http://live.techpanda.org/");

		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		email = "thangnt" + generateFakeNumber() + "@gmail.com";
		existingEmail = "thangnt@gmail.com";
		password = "123456";
			
	}

	@Test
	public void User_01_Register_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		
		registerPage = loginPage.clickToCreateAccountButton();
		
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(email);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		myDashboardPage = registerPage.clickToRegisterButton();
		
		Assert.assertEquals(myDashboardPage.getSuccessfullRegisterMessage(), "Thank you for registering with Main Website Store.");

		myDashboardPage.clickToAccountLabel();
		homePage = myDashboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToMyAccountLink();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		
		Assert.assertEquals(myDashboardPage.getWelcomeMessage(), "Hello, " + firstName + " " + lastName + "!");
	}


	@AfterClass 
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
	private String firstName, lastName, email, existingEmail, password;

}

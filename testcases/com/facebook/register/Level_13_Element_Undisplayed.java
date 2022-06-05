package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		// driver.get(appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		
		//Nếu 1 hàm chỉ mong đợi để verify element displayed thôi - kết hợp cả wait + isDisplayed
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	
	}

	@Test
	public void TC_01_Verify_Element_Undisplayed_In_DOM() {
		//Nếu như mình mong đợi 1 hàm vừa verify displayed/ undisplayed thì không được kết hợp wait
		//Verify True - mong đợi Confirm Email Displayed (true)
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		
		//Verify False - cho hàm trả về là Undisplayed (false)
		//isDisplayed: bản chất ko kiểm tra 1 element ko có trong DOM được
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
//		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
//		Case 2 - Element in DOM but not visible/ displayed
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
	}

	@Test
	public void TC_01_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);
		
//		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
//		Case 3 - Element not in DOM
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
		
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



}

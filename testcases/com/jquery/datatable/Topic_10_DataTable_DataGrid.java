package com.jquery.datatable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.jQuery.HomePageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Topic_10_DataTable_DataGrid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({"browser", "url"})
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		driver.get(appUrl);

		homePage = pageObject.jQuery.PageGeneratorManager.getHomePage(driver);
		
	}

	
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		
		homePage.openPagingByPageNumber("20");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("20"));
		
		homePage.openPagingByPageNumber("8");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("8"));
	}

	
	public void Table_02_Enter_To_Header() {
//		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Armenia");
		homePage.enterToHeaderTextboxByLabel("Females", "15999");
		homePage.enterToHeaderTextboxByLabel("Males", "32487");
		homePage.enterToHeaderTextboxByLabel("Total", "32487");
		sleepInSecond(3);
		
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		sleepInSecond(3);
		
	}
//	@Test
	public void Table_03() {
		//Đọc dữ liệu của file country.txt ra
		//Lưu vào 1 List<String> = Expected value = expectedAllCountryValues
		
		//Actual 
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	
	@Test
	public void Table_04_Action_At_Any_Row() {	
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);
		
		//Value để nhập liệu - Tham số 1
		//Row number: Tại row nào
		//Ex: Nhập vào textbox tại dòng số 3/ 5/ 2
		//Column name: tại cột nào
		//Ex: Album, Artist, Year, Origin
//		homePage.enterToTextboxByColumnNameAtRowNumber("Album", "2", "Since 1999");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "4", "Anna");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Year", "3", "1997");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Price", "1", "150");	
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "5", "Japan");
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Hong Kong");
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "US");
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
//		
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(1);
		
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
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
	
	private WebDriver driver;

	
}

package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObject.jQuery.uploadFiles.HomePageObject;
import pageObject.jQuery.uploadFiles.PageGeneratorManager;

public class Topic_11_Upload_Files extends BaseTest {
	HomePageObject homePage;

	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String rubyFileName = "Ruby.png";

	String[] multipleFileName = { csharpFileName, javaFileName, rubyFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		// driver.get(appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, csharpFileName);

		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));

		// Step 03 - Click to Start button
		homePage.clickToStartButton();

		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));

		// Step 04 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		// Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, multipleFileName);

		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		// Step 03 - Click to Start button
		homePage.clickToStartButton();

		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		// Step 04 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));

	}

	// @Test
	public void Table_03() {

	}

	public void Table_04_Action_At_Any_Row() {

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

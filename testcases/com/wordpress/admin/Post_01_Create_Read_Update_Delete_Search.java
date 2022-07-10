package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearhPO;
import pageObjects.wordpress.admin.PageGeneratorManager;


public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String adminUsername = "thangnt";
	String adminPassword = "Thang25091993@";
	String searchPostUrl;
	String postTitleValue = "";
	String postBodyValue = "";
	
	@Parameters({"browser", "urlAdmin"})
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		driver = getBrowserDriver(browserName, adminUrl);
//		driver.get("https://demo.nopcommerce.com/");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value '" + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value '" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminLoginPage.clickToLoginButton();
		
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
		
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		searchPostUrl = "";
		
		adminDashboardPage.clickToPostMenuLink();
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		
		log.info("Create_Post - Step 02: Click to 'Add New' button");
		adminPostSearchPage.clickToAddNewButton();	
		adminPostAddNewPage = PageGeneratorManager.getAdminPostAddNewPage(driver);
		
		log.info("Create_Post - Step 03: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);
		
		log.info("Create_Post - Step 03: Enter to post body");
		adminPostAddNewPage.enterToAddNewPostBody(postBodyValue);
		
		log.info("Create_Post - Step 04: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 05: Verify 'Post published.' message is displayed");
		adminPostAddNewPage.isPostPublishMessageDisplayed("Post published.");
	}

	@Test
	public void Post_02_Search_Post() {	
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		//Open searchPostUrl
		adminPostSearchPage = PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}

	@Test
	public void Post_03_View_Post() {	
		
	}
	@Test
	public void Post_04_Edit_Post() {	
		
	}
	@Test
	public void Post_05_Delete_Post() {	
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();	
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearhPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
}

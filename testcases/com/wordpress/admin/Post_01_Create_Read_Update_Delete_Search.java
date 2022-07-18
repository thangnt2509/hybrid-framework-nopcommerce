package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearhPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;


public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String adminUsername = "thangnt";
	String adminPassword = "Thang25091993@";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body" + randomNumber;
	String authorName = "thangnt";
	String adminUrl, endUserUrl;
	String currentDate = getCurrentDate();
	
	@Parameters({"browser", "urlAdmin", "endUserUrl"})
	@BeforeClass // Multiple browsers
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and Admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		
		driver = getBrowserDriver(browserName, this.adminUrl);
//		driver.get("https://demo.nopcommerce.com/");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value '" + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value '" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
			
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
			
		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();	
			
		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Enter to post body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create_Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {	
		log.info("Search_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);		
		
		log.info("Search_Post - Step 02: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPageButton();
		
		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));
		
		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));
		
		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Search_Post - Step 07: Verify Post infor displayed at Home Page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		//Đổi múi giờ về UTC+7
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDate(postTitle, currentDate));
		
		log.info("Search_Post - Step 08: Click to Post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post - Step 09: Verify Post infor displayed at Post Detail Page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostCurrentDate(postTitle, currentDate));
	}


//	@Test
	public void Post_03_Edit_Post() {	
		
	}
//	@Test
	public void Post_04_Delete_Post() {	
		
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
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
}

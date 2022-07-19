package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		//click
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		
		//sendkey
		waitForElementVisible(driver,  AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
		
	}
	
	public void enterToEditPostBody(String postBodyValue) {
		//click
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		
		//sendkey
		waitForElementVisible(driver,  AdminPostAddNewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
		
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
	}
	
	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearhPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
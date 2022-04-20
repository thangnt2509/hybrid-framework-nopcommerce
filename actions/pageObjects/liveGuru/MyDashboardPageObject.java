package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessfullRegisterMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.SUCCESSFUL_REGISTER_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.SUCCESSFUL_REGISTER_MESSAGE);
	}

	public String getWelcomeMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.WELCOME_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.WELCOME_MESSAGE);
	}
	
	public void clickToAccountLabel() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_LABEL);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LABEL);	
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);
	}

}

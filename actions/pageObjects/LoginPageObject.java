package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToPasswordTextbox(String password) {
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSUCCESSFUL_ERROR_MESSAGE);
	}

}

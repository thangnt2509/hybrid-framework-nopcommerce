package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}
}
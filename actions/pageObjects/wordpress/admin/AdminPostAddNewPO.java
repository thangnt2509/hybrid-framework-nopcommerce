package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminPostAddNewPO extends BasePage{
	WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}
}
package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;
	
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
}

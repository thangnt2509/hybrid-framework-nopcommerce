package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP extends SeleniumWebDriver {
	public long shortTimeout = 15;
	protected long longTimeout = 45;
	private WebDriver driver;

	public BaseOOP() {
		System.out.println("Constructor tại class cha");
	}
	
	public BaseOOP(String name) {
		System.out.println("Constructor tại class cha " + name);
	}
	
	public BaseOOP(int number) {
		System.out.println("Constructor tại class cha " + number);
	}
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}

}

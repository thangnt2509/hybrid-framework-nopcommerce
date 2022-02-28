package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Topic_01_Template {
	static WebDriver driver = null;

	public static void main(String[] args) {
		
		System.out.println();
		WebElement logginButton = driver.findElement(By.xpath("//button[@name='login']"));
		WebElement nameTextBox = driver.findElement(By.cssSelector(""));
		
		Assert.assertTrue(false);
	}

}

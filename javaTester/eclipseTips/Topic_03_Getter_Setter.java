package eclipseTips;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_03_Getter_Setter {
	// Global
	WebDriver driver;
	String address = new String("HCM");

	@Test // Dev A
	public void Login_01_Email_Empty() {

	}

	@Test // Dev B
	public void login_02_email_invalid() {
		// Local
		WebDriver driver = null;

		driver.get("");

		this.driver.get("");
	}

	@Test // Dev C
	public void Login_02_EmailIncorrect() {
	}
}

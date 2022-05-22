package javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionType {
	FirefoxDriver driver;

//	public static void main(String[] args) {
//		System.out.println("Step 01");
//		String name = "10";
//		int number = Integer.parseInt(name);
//		
//		System.out.println("Step 02");
//		System.out.println(number);
//		
//		System.out.println("Step 03");
//		float f = Float.parseFloat("4.5a");
//	}
	
//	public static void main(String[] args) throws IOException {
//		File file = new File("D:\\testing.txt");
//		FileReader fr = new FileReader(file);
//		fr.close();
//	}

	@Test
	public void TC_01() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("http://live.techpanda.org/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Automation Testing']")).click();	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

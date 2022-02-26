package javaBasic;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Parameters("browser")
	//@Test
	public void TC_01(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);

		driver.quit();
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;		
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;		
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;		
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input correct the browser name!");
			break;
		}
		return driver;
	}
	
	//@Test
	public void TC_02() {
		int month = scanner.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 hoặc 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		default:
			System.out.println("Vui lòng nhập tháng từ 1 ~ 12");
			break;
		}	
	}
	
	//@Test
	public void TC_03() {
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:			
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Vui lòng nhập tháng từ 1 ~ 12");
			break;
		}	
	}
	
//	@Test
//	public void TC_04() {
//		//Only convertible int values, strings or enum variables are permitted
//		
//		int grade = scanner.nextInt();
//		
//		//enum variable = constant
//		//Chỉ nhận int/ string/ enum
//		//Không dùng được các toán tử trong case: < > != ==
//		switch (grade) {
//		case 10:
//			
//			break;
//
//		default:
//			break;
//		}
//		
//		//Nhược điểm:
//		//Khó để dọc code (readable)
//		//Không check trùng lặp
//		
//		if (grade <= 10 && grade >= 8.5) {
//			System.out.println(grade + " là điểm xếp hạng A");
//		} else if (grade < 8.5 && grade >= 7.5) {
//			System.out.println(grade + " là điểm xếp hạng B");
//		} else if (grade < 7.5 && grade >= 5) {
//			System.out.println(grade + " là điểm xếp hạng C");
//		} else if (grade < 5 && grade >= 0){
//			System.out.println(grade + " là điểm xếp hạng D");			
//		} else {
//			System.out.println("Vui lòng nhập lại điểm trong khoảng từ 0 ~ 10");
//		}
	
	@Test
	public void TC_04() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = " + (firstNumber + secondNumber));
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;
		case "*":
			System.out.println("A * B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;
		case "%":
			System.out.println("A % B = " + (firstNumber % secondNumber));
			break;
		default:
			break;
		}

	}
}

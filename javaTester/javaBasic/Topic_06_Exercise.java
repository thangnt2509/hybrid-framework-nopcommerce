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

public class Topic_06_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01() {
		int number = scanner.nextInt();
		System.out.println(number);

		if (number % 2 == 0) {
			System.out.println("Số : " + number + " là số chẵn");
		} else {
			System.out.println("Số : " + number + " là số lẻ");
		}
	}

	// @Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		if (numberA > numberB) {
			System.out.println(numberA + " lớn hơn " + numberB);
		} else if (numberA == numberB) {
			System.out.println(numberA + " bằng " + numberB);
		} else {
			System.out.println(numberA + " nhỏ hơn " + numberB);
		}
	}

	// @Test
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();

		// Kiểu tham chiếu reference type: String
		// Kiểm tra value của biến
		// Kiểm tra vị trí của biến trong vùng nhớ
		if (firstStudent.equals(secondStudent)) {
			System.out.println("2 sinh viên có tên giống nhau");
		} else {
			System.out.println("2 sinh viên có tên khác nhau");
		}

		// Kiểu nguyên thủy primitive type
		if (firstStudent == secondStudent) {
			System.out.println("2 sinh viên có tên giống nhau");
		} else {
			System.out.println("2 sinh viên có tên khác nhau");
		}
	}

	// @Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();

		if (numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " là số lớn nhất");
			// } else if (numberB > numberA && numberB > numberC) {
		} else if (numberB > numberC) {
			System.out.println(numberB + " là số lớn nhất");
		} else {
			System.out.println(numberC + " là số lớn nhất");
		}
	}

	// @Test
	public void TC_05() {
		int numberA = scanner.nextInt();

		if (10 < numberA && numberA < 100) {
			System.out.println(numberA + " nằm trong khoảng 10 ~ 100 ");
		} else {
			System.out.println(numberA + " nằm ngoài khoảng 10 ~ 100 ");

		}
	}

	//@Test
	public void TC_06() {
		float grade = scanner.nextFloat();

		if (grade <= 10 && grade >= 8.5) {
			System.out.println(grade + " là điểm xếp hạng A");
		} else if (grade < 8.5 && grade >= 7.5) {
			System.out.println(grade + " là điểm xếp hạng B");
		} else if (grade < 7.5 && grade >= 5) {
			System.out.println(grade + " là điểm xếp hạng C");
		} else if (grade < 5 && grade >= 0){
			System.out.println(grade + " là điểm xếp hạng D");			
		} else {
			System.out.println("Vui lòng nhập lại điểm trong khoảng từ 0 ~ 10");
		}
	}
	
	@Test
	public void TC_07() {
		int month = scanner.nextInt();
		//1 3 5 7 8 10 12
		if (month == 1 || month == 3|| month == 5|| month == 7|| month == 8|| month == 10|| month == 12) {
			System.out.println("Tháng này có 31 ngày");
		} else if (month == 2){
			System.out.println("Tháng này có 28 hoặc 29 ngày");
		} else if (month == 4 || month == 6|| month == 9|| month == 11){
			System.out.println("Tháng này có 30 ngày");
		}
	}
}

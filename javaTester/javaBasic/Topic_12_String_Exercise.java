package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	String courseName = "Automation Testing Tutorials Advanced Online 24";

	// @Test
	public void TC_01_Ex1() {
		char courseNameArr[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		for (char character : courseNameArr) {
			// Uppercase
			if (character <= 'Z' && character >= 'A') {
				countUpper++;
				System.out.println(character);
			}

			// LowserCase
			if (character <= 'z' && character >= 'a') {
				countLower++;
				System.out.println(character);
			}

			// Number
			if (character <= '9' && character >= '0') {
				countNumber++;
				System.out.println(character);
			}
		}
		System.out.println("Sum of uppercase = " + countUpper);
		System.out.println("Sum of lowsercase = " + countLower);
		System.out.println("Sum of number = " + countNumber);
	}

	// @Test
	public void TC_02_Ex2() {
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char c : courseNameArr) {
			if (c == 'a') {
				count++;
			}
		}
		System.out.println(count);

		System.out.println("Chuỗi có chứa từ Testing = " + courseName.contains("Testing"));
		System.out.println("Chuỗi bắt đầu = " + courseName.startsWith("Automation"));
		System.out.println("Chuỗi kết thúc = " + courseName.endsWith("Online"));
		System.out.println("Vị trí của từ  = " + courseName.indexOf("Tutorials"));
		System.out.println("Thay thế Online thành Offline  = " + courseName.replace("Online", "Offline"));

		int countNumber = 0;

		for (char c : courseNameArr) {
			if (c <= '9' && c >= '0') {
				countNumber++;
			}
		}
		System.out.println(countNumber);
	}

	@Test
	public void TC_03_Ex3() {
		char courseNameArr[] = courseName.toCharArray();

		System.out.println(courseNameArr.length);
		for (int i = courseNameArr.length - 1; i >= 0; i--) {
			System.out.println(courseNameArr[i]);
		}

	}

}

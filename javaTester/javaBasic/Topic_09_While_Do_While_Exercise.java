package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_Do_While_Exercise {
	Scanner scanner = new Scanner(System.in);

	// @Test
	public void TC_01_For() {
		System.out.println("Nhập vào một số");
		int number = scanner.nextInt();

		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

	// @Test
	public void TC_02_While() {
		System.out.println("Nhập vào một số");
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		}
	}

	// @Test
	public void TC_03_Do_While() {
		System.out.println("Nhập vào một số");
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		} while (number < 100);

	}

	// @Test
	public void TC_04_Ex2() {
		System.out.println("Nhập vào hai số");
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		while (numberA < numberB) {
			if (numberA % 3 == 0 && numberA % 5 == 0) {
				System.out.println(numberA);
				// nếu để numberA++ ở đây thì bị sai. Ví dụ nhập 15 > cộng thành 16 > quay lại if so sánh ko thỏa mãn >> ko thoát đc khỏi vòng lặp
			}
			numberA++;
		}
	}

	// @Test
	public void TC_05_Ex3() {
		System.out.println("Nhập vào một số");
		int number = scanner.nextInt();
		int result = 0;

		while (number > 0) {
			if (number % 2 != 0) {
				System.out.println(number);
				result += number;
				// result = result + number;

			}
			number--;
		}
		System.out.println(result);
	}

	// @Test
	public void TC_06_Ex3() {
		System.out.println("Nhập vào một số");
		int number = scanner.nextInt();
		int i = 0;
		int result = 0;

		while (i <= number) {
			if (i % 2 != 0) {
				System.out.println(i);
				result += i;
			}
			i++;
		}
		System.out.println(result);
	}

	// @Test
	public void TC_04_Ex4() {
		System.out.println("Nhập vào hai số");
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		while (numberA < numberB) {
			if (numberA % 3 == 0) {
				System.out.println(numberA);

			}
			numberA++;
		}
	}

	// @Test
	public void TC_05_Ex5() {
		System.out.println("Nhập vào một số");
		int numberA = scanner.nextInt();
		int i = 1;

		while (numberA > 0) {
			i = i * numberA;
			numberA--;
		}
		System.out.println(i);
	}

	// @Test
	public void TC_06_Ex5() {
		System.out.println("Nhập vào một số");
		int numberA = scanner.nextInt();
		int i = 1;
		int result = 1;
		while (i <= numberA) {
			result = result * i;
			i++;
		}
		System.out.println(result);
	}

	@Test
	public void TC_07_Ex5() {
		int numberA;
		do {
			System.out.println("Nhập vào một số: ");
			numberA = scanner.nextInt();
			System.out.println("Số vừa nhập là " + numberA);
		} while (numberA != 0);
		System.out.println("Kết thúc");
	}
}

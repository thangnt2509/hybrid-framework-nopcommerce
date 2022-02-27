package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_Foreach_Exercise {
	Scanner scanner = new Scanner(System.in);
	//@Test
	public void TC_01() {
		int number = scanner.nextInt();
		
		for (int i = 1; i <= number; i++) {
			System.out.println(i);
		}
	}
	
	//@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		for (int i = numberA; i <= numberB; i++) {
			System.out.println(i);
		}
	}
	
	//@Test
	public void TC_03() {
		
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " là số chẵn");				
			}
		}
	}
	
	//@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int result = 0;
		for (int i = numberA; i <= numberB; i++) {
			result = result + i;
		}
		System.out.println(result);
	}
	
	//@Test
	public void TC_05() {
		int number = scanner.nextInt();
		int result = 0;
		
		for (int i = 0; i <= number; i++) {
			if (i % 2 != 0) {
				result = result + i;
			}
		}
		System.out.println(result);
	}
	
	//@Test
	public void TC_06() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		for (int i = numberA; i <= numberB; i++) {
			if (i % 3 == 0) {
			System.out.println(i);
			}
		}
	}
	
	@Test
	public void TC_07() {
		int number = scanner.nextInt();
		int result = 1;
		for (int i = 1; i <= number; i++) {
			result = result*i;
		}
		System.out.println(result);

	}
}

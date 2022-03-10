package javaBasic;

import java.util.Scanner;

public class Topic_09_While_Do_While {
	Scanner scanner = new Scanner(System.in);

	// Class
	public static void main(String[] args) {
		int i = 0;

		// Block code
		for (i = 0; i < 5; i++) {// Biến i này chỉ sử dụng trong vòng for
			System.out.println("For: " + i);
		}
		System.out.println("Biến i sau khi done vòng for: " + i);

		// i = 5 không thỏa mãn điều kiện
		while (i < 5) {
			System.out.println("While: " + i);
			i++;
		}

		// Chạy ít nhất 1 lần rồi kiểm tra điều kiện
		do {
			System.out.println("Do-While: " + i);
			i++;
		} while (i < 5);
	}
}

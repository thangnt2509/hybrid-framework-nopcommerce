package javaBasic;

import java.util.Arrays;

public class Topic_11_Array_Exercise {

	// @Test
	public void TC_01_Ex1_Find_Max_Number_Cach_1() {
		int[] arr = { 2, 7, 6, 8, 9, 4 };
		Arrays.sort(arr);

		System.out.println("Phần tử lớn nhất mảng là: " + arr[arr.length - 1]);
	}

	// @Test
	public void TC_01_Ex1_Find_Max_Number_Cach_2() {
		int[] arr = { 2, 7, 6, 8, 9 };
		int x = 0;

		for (int i = 0; i < arr.length; i++) {
			if (x < arr[i]) {
				x = arr[i];
			}
		}
		System.out.println("Max number is: " + x);
	}

	// @Test
	public void TC_02_Ex2_Sum_First_And_Last_Number() {
		int[] arr = { 2, 7, 6, 8, 9 };

		System.out.println("First number is : " + arr[0]);
		System.out.println("First number is : " + arr[arr.length - 1]);
		System.out.println("Tổng phần tử đầu tiên và cuối cùng là: " + (arr[0] + arr[arr.length - 1]));
	}

	// @Test
	public void TC_03_Ex3_Cach_1() {
		int[] arr = { 2, 7, 6, 8, 9, 16, 17, 20 };

		for (int i : arr) {
			if (i % 2 == 0) {
				System.out.println("Các số chẵn là: " + i);
			}
		}
	}

	// @Test
	public void TC_03_Ex3_Cach_2() {
		int[] arr = { 2, 7, 6, 8, 9, 16, 17, 20 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println("Các số chẵn là: " + arr[i]);
			}
		}
	}

	// @Test
	public void TC_04_Ex4() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int result = 0;

		// Cách 1
		// for (int item : arr) {
		// if (item > 0 && item % 2 != 0) {
		// result = result + item;
		// }
		// }
		// System.out.println(result);

		// Cách 2
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] % 2 != 0) {
				result = result + arr[i];
			}
		}
		System.out.println(result);
	}

	// @Test
	public void TC_05_Ex5_Cach_1() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };

		for (int i : arr) {
			if (i >= 0 && i <= 10) {
				System.out.println("Các số từ 0 đến 10 trong mảng là : " + i);
			}
		}
	}

	// @Test
	public void TC_05_Ex5_Cach_2() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] <= 10) {
				System.out.println("Các số từ 0 đến 10 trong mảng là : " + arr[i]);
			}
		}
	}

	// @Test
	public void TC_06_Ex6_Cach_1() {
		int[] arr = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		// 43
		float result = 0;

		for (int i : arr) {
			result = result + i;
		}

		System.out.println("Tổng các phần tử là: " + result);
		System.out.println("Trung bình cộng các phần tử là: " + result / arr.length);
	}

	// @Test
	public void TC_06_Ex6_Cach_2() {
		int[] arr = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			// sum = sum + arr[i];
		}
		System.out.println("Tổng các phần tử là: " + sum);

		float average = sum / arr.length;
		System.out.println("Trung bình cộng average các phần tử là: " + average);
	}

	// @Test
	public void TC_07_Ex7() {
		int[] stdID = { 001, 002, 003 };
		String[] stdName = { "Nam", "Long", "An" };
		int[] stdAge = { 18, 19, 20 };
		double[] stdScore = { 6.5, 8.0, 7.5 };

	}

}

package javaException;

import java.util.Iterator;

public class TryCatchException {

	public static void main(String[] args) {
//		int number = 10;
//		
//		try {
//			//Đúng: Chạy hết đoạn code trong try và không qua catch
//			//Sai: Gặp exception - nhảy qua catch
//			number = number / 0;
//		} catch (Exception e) {
//			//e.printStackTrace();
//		}
//		
//		System.out.println(number);
//		
//		String[] browserName = {"Chrome", "Firefox", "Safari"};
//		
//		try {
//			browserName[0] = "Edge Chromium";
//			browserName[3] = "IE";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		for (String browser : browserName) {
//			System.out.println(browser);
//		}
		
		try {
			int array[] = new int[10];
			array[10] = 30 / 1;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Không thể chia cho 0");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Index vượt ngoài độ dài của mảng");
		}
	}

}

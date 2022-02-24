package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {
	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		
		System.out.println("Tổng = " + (a+b));
		System.out.println("Hiệu = " + (a-b));
		System.out.println("Tích = " + (a*b));
		System.out.println("Thương = " + (a/b));
	}
	
	@Test
	public void TC_02() {
		float height = 7.5f;
		float width = 3.8f;
		
		System.out.println("Diện tích hình chữ nhật = " + (height*width));		
	}
	
	@Test
	public void TC_03() {

		String name = "Hello Automation Testing";
		System.out.println(name);
	}
	
}
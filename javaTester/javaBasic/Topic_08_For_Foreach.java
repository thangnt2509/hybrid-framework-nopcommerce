package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
	WebDriver driver;

	// @Test
	public void TC_01_For() {
		// In ra 5 lần
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		// Vế 1: biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
		// Dùng để so sánh với tổng giá trị
		// Vế 2: So sánh với tổng
		// Vế 3: Tăng i lên 1 đơn vị sau khi chạy vào thân vòng for

		// Lần 1:
		// i = 0
		// 0 < 5: đúng
		// System.out.println(0);
		// i++: tăng lên 1 đơn vị (i = 1)

		// Lần 2:
		// i = 1
		// 1 < 5: đúng
		// System.out.println(1);
		// i++: tăng lên 1 đơn vị (i = 2)

		// Lần 3:
		// i = 2
		// 2 < 5: đúng
		// System.out.println(2);
		// i++: tăng lên 1 đơn vị (i = 3)

		// Lần 4:
		// i = 3
		// 3 < 5: đúng
		// System.out.println(3);
		// i++: tăng lên 1 đơn vị (i = 4)

		// Lần 5:
		// i = 4
		// 4 < 5: đúng
		// System.out.println(4);
		// i++: tăng lên 1 đơn vị (i = 5)

		// Lần 6:
		// i = 5
		// 5 < 5: sai
		System.out.println("====================");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}

//		List<WebElement> links = driver.findElements(By.id(""));
//		links.size();

		// Array
		String[] cityName = { "Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho" };

		// Array/ List/ Set/ Queue (index): tính từ 0

		// For kết hợp với if: Thỏa mãn điều kiện mới action
		// Biến đếm - dùng để điều kiện để filter
		for (int i = 0; i < cityName.length; i++) {
			if (cityName[i].equals("Da Nang")) {
				// Action
				System.out.println("Do action");
				break;// Tìm thấy điều kiện rồi thì thoát khỏi vòng lặp
			}
		}

		System.out.println("====================");

		for (int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
		}

		System.out.println("====================");

		// Dùng để chạy qua hết tất cả các giá trị
		for (String city : cityName) {
			System.out.println(city);
		}

//		int y = 0;
//		for (String city : cityName) {
//			if (cityName[y].equals("Da Nang")) {
//				System.out.println("Do action");
//				System.out.println(city);
//				break;
//			}
//			y++;
//		}	
	}

	@Test
	public void TC_02_For_Nguoc_Mang() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}
	}
	
	//@Test
	public void TC_03_Foreach() {
		String[] cityName = { "Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho" };//Array
		for (String city : cityName) {// Biến tạm city: gán từng thành phố vào city
			System.out.println(city);
		}

		// Java Collection
		// Class: ArrayList/ LinkedList/ Vector/..
		// Interface: List/ Set/ Queue
		List<String> cityAddress = new ArrayList<String>();//Collectiom
		System.out.println(cityAddress.size());

		// Compile (Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sa Pa");

		System.out.println(cityAddress.size());

		// Runtime (Running)
		for (String city : cityName) {
			cityAddress.add(city);
		}

		System.out.println(cityAddress.size());
		
		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}
		
		//Java Generic
		List<WebElement> links = driver.findElements(By.xpath(""));
		
		//Xử lý dữ liệu / get text/ value/ css/ attribute
		for (WebElement link : links) {
			//Chuyển page
			//Refresh DOM/ HTML
			//Không còn tồn tại
			//Fail -> StaleElementException
		}
		
		//Sort
	}
}

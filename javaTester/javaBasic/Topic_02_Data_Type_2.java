package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type_2 {
	// Primitive type/ value type: nguyên thủy
	//số nguyên không dấu: 12, 100, 10000
	byte bNumber = 127;
	short sNumber = 1500;
	int iNumber = 65000;
	long lNumber = 65000;
	
	//số thực có dấu: 8.5, 15.9
	float fNumber = 15.89F;
	double dNumber = 15.89d;
	
	char cChar = '1';
	boolean bStatus = false;
	//Khi khởi tạo thì chiếm vùng nhớ trong ram 
	//1 bit = 32 số, 8 bit = 256 số
	//1 byte = 8 bit
	
	
	//Reference type: Tham chiếu

	//String
	String address = "Ho Chi Minh";
	
	//Array
	String[] studentAddress = {address, "Ha Noi", "Da Nang"};
	Integer[] studentNumber = {15, 20, 50};
	
	//Tupe: nhét đc nhiều kiểu dữ liệu trong 1 mảng được
	
	//Class
	Topic_02_Data_Type_2 topic;
	
	//Interface
	WebDriver driver;
	
	//Object
	Object aObject;
	
	//Collection
	//List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	//Kiểu nguyên thủy không có các hàm đi theo, kiểu tham chiếu thì có
	//Cách thức lưu trữ dữ liệu
	public void clickToElement() {
		address.trim();
		studentAddress.clone();
		driver.getCurrentUrl();
		aObject.toString();
		homePageLinks.size();	
		allWindows.clear();
		
	}
	
	
	public static void main(String[] args) {

	}
	
}

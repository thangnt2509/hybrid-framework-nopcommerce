package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_This_Super extends BaseOOP{
	private WebDriver driver;
	private long shortTimeout = 15;
	private long longTimeout = 45;
	
	private int firstNumber;
	private int secondNumber;
	
	public Topic_05_This_Super() {
		//Luôn luôn gọi qua Constructor của class cha
		super("Chrome");
		System.out.println("Constructor của class con");
	}
	
	public void setImplicitWait() {
		long shortTimeout = 15;
		
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);
		
		System.out.println(super.browserName);
	}
	
	public void clickToElement() {
		//Không dùng super nó sẽ gọi qua hàm ở Class con (hiện tại)
		setImplicitWait();
		super.setImplicitWait();
	}
	
	//Nếu không có constructor bên dưới thì trình biên dịch sẽ tự động tạo ra 1 constructor mặc định ko tham số + không có phần thân
//	public Topic_05_This_Super() {
//		
//	}
	
//	public Topic_05_This_Super() {
//		//Gọi qua constructor bên dưới
//		//Bắt buộc phải đứng đầu tiên
//		this(10, 15);
//		System.out.println("Demo");
//	}
	
	//Constructor
	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	
	public static void main(String[] args) {
//		Topic_05_This_Super topic = new Topic_05_This_Super(15, 7);
//		topic.sumNumber();
		
		Topic_05_This_Super topic2 = new Topic_05_This_Super();
		
	}

}

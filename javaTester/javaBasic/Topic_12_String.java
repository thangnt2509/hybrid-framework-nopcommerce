package javaBasic;

public class Topic_12_String {

	public static void main(String[] args) {
		// System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// String: Chuỗi kí tự
		String s1 = "Cat";
		s1 = "Dog";
		String s2 = s1;
		String s3 = new String("Cat");

		// ==: So sánh giá trị và vùng nhớ (dùng cho kiểu nguyên thủy)
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s2 == s3);

		// Equals: So sánh giá trị chứ không so sánh vùng nhớ (dùng cho kiểu tham chiếu)
		System.out.println(s2.equals(s3));

		String schoolName = "Automation Testing";
		String courseName = schoolName.toLowerCase();
		String schoolAddress = "Ho Chi Minh city";

		System.out.println("Độ dài = " + schoolName.length());

		System.out.println("Lấy ra 1 kí tự = " + schoolName.charAt(0));
		System.out.println("Lấy ra 1 kí tự = " + schoolName.charAt(1));

		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);

		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(courseName));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing Advanced"));

		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));

		// startsWith/ endsWith/ contains
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("T"));

		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("A"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Automation"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Testing"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.contains("Advanced"));

		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.endsWith("g"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.endsWith("Testing"));
		System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolName.endsWith("Advanced"));

		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("Automation"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("A"));
		System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.indexOf("Testing"));

		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11));
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi = " + schoolName.substring(11, 15));

		// Split: Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
		// Alert
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");

		for (String string : results) {
			System.out.println(string);
		}
		System.out.println(results[1]);

		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);// Kiểu string

		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);// Kiểu float

		productPrice = String.valueOf(productPriceF);// Chuyển float sang string
		System.out.println(productPrice);

		// String osName = System.getProperty("os.Name");
		// System.out.println(osName);
		// Windows 10
		// Handle multiple OS: MAC/ Windows (Actions - keys - Ctrl/ Command)

		// if (osName.toLowerCase().contains("windows")) {
		// Keys key = Keys.CONTROL;
		// } else {
		// Keys key = Keys.COMMAND;
		// }

		// Multiple browser: toUpperCase
		// firefox = FIREFOX (Enum)

		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);
		// // FirefoxDriver: firefox on WINDOWS (77f3c4e7-6ad1-4830-ac72-1c0c0e4d80c3)
		// //Close browser/ driver
		// if (driverInstanceName.contains("internetexplorer")) {
		// //Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		// }

		// Khoảng trắng/ xuống dòng/ tab
		String helloWorld = "  \n  \t Hello World!     ";
		System.out.println(helloWorld);
		System.out.println(helloWorld.trim());

		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		System.out.println("Blank = " + helloWorld.isBlank());

		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id = '%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));
	}

}

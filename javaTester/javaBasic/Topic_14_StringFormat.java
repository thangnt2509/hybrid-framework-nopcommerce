package javaBasic;

public class Topic_14_StringFormat {
	public static String ADDRESS_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	public static String MY_REWARD_POINT_LINK = "//div[@class='listbox']//a[text()='Reward points']";
	public static String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	
	//1 biến cho cả 14 page hoặc n page (format giống nhau - chỉ khác nhau bởi tên page)
	public static String DYNAMIC_SIDEBAR_LINK = "//div[@class='listbox']//a[text()='%s']";
	
	//1 locator để đại diện cho các page (Header/ Sidebar/ Footer)
	public static String DYNAMIC_LINK_BY_NAME = "//div[@class='%s']//a[text()='%s']";
	
	public static void main(String[] args) {
		clickToLink(ADDRESS_LINK);
		clickToLink(MY_PRODUCT_REVIEW_LINK);
		clickToLink(MY_REWARD_POINT_LINK);
		clickToLink(CUSTOMER_INFOR_LINK);
		
		clickToLink(DYNAMIC_SIDEBAR_LINK, "Addresses");
		clickToLink(DYNAMIC_SIDEBAR_LINK, "My product reviews");
		clickToLink(DYNAMIC_SIDEBAR_LINK, "Reward points");
		clickToLink(DYNAMIC_SIDEBAR_LINK, "Customer info");
		
		clickToLink(DYNAMIC_LINK_BY_NAME, "listbox", "Addresses");
		clickToLink(DYNAMIC_LINK_BY_NAME, "footer-upper", "Search");
		clickToLink(DYNAMIC_LINK_BY_NAME, "header-upper", "My account");
	}
	
	public static void clickToLink(String locator) {
		System.out.println("Click to: " + locator);
	}
	
	//1 tham số động
//	public static void clickToLink(String dynamicLocator, String pageName) {
//		//dynamicLocator = //div[@class='listbox']//a[text()='%s']
//		//pageName = Addresses
//		String locator = String.format(dynamicLocator, pageName);
//		//%s: pattern để thay thế cho 1 tham số kiểu String
//		System.out.println("Click to: " + locator);	
//	}
	
	//2 tham số động
//	public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
//		
//		String locator = String.format(dynamicLocator, areaName, pageName);
//		System.out.println("Click to: " + locator);	
//	}
	
	//1-n tham số động
	public static void clickToLink(String dynamicLocator, String... params) {
		//Ép kiểu -> Không cần dùng 2 hàm trên nữa
		String locator = String.format(dynamicLocator,(Object[]) params);
		System.out.println("Click to: " + locator);	
	}
	
}

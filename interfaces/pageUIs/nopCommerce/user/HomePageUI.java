package pageUIs.nopCommerce.user;

public class HomePageUI {
	// Biến static cho phép truy cập trực tiếp từ tên class và có thể chia sẻ dữ liệu giữa nhiều luồng (thread) khác nhau -> Parallel testing
	// Biến constant hằng số: 1 giá trị không được phép thay đổi - luôn luôn cố định (static final)
	// Convention: VIẾT_HOA phân cách bởi dấu gạch nối
	public static final String REGISTER_LINK = "Css=a[class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";

}

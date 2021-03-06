package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	//public static final String CUSTOMER_INFOR_HEADER = "//div[@class='page-title']//h1[text()='My account - Customer info']";
//	public static final String ADDRESS_LINK = "//div[@class='listbox']//a[text()='Addresses']";
//	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
//	public static final String MY_REWARD_POINT_LINK = "//div[@class='listbox']//a[text()='Reward points']";
//	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
//	public static final String LOGOUT_LINK_AT_USER = "//a[@class='ico-logout']";
//	public static final String LOGOUT_LINK_AT_ADMIN = "//a[text()='Logout']";
//	public static final String AJAX_BUSY = "//div[@id='ajaxBusy']";
	public static final String ADDRESS_LINK = "Xpath=//div[@class='listbox']//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPATH=//div[@class='listbox']//a[text()='My product reviews']";
	public static final String MY_REWARD_POINT_LINK = "Xpath=//div[@class='listbox']//a[text()='Reward points']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[@class='listbox']//a[text()='%s']";
	
	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String AJAX_BUSY = "xpath=//div[@id='ajaxBusy']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(), '%s')]/following-sibling::input";
	
	public static final String DYNAMIC_TEXT_BOX_ATTRIBUTE_VALUE_BY_ID = "xpath=//input[@id='%s']";
}

package commons;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.BasePageUI;

//Common class
public class BasePage {

	// Nhiệm vụ mở 1 URL bất kỳ ra
	// Common function

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
		// driver.switchTo().alert().accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	// Chỉ đúng cho duy nhất 2 tab/ windows
	protected void switchToTabByID(WebDriver driver, String expectedID) {
		// Lấy hết tất cả ID của tab/ window đang có
		Set<String> allTabIDs = driver.getWindowHandles();

		// Dùng vòng lặp để duyệt qua từng ID một
		for (String id : allTabIDs) { // id: là một biến tạm dùng để duyệt (so sánh)
			// ID nào mà khác với expectedID truyền vào thì switch qua
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;// break khỏi vòng lặp khi thỏa mãn điều kiện
			}
		}

	}

	// Đúng cho tất cả trường hợp: 2 hoặc nhiều hơn 2 đều đúng

	protected void switchToTabByTitle(WebDriver driver, String expectedTitle) {
		// Lấy hết tất cả ID của tab/ window đang có
		Set<String> allTabIDs = driver.getWindowHandles();

		// Dùng vòng lặp để duyệt qua từng ID một
		for (String id : allTabIDs) { // id: là một biến tạm dùng để duyệt (so sánh)
			// Switch vào từng tab trước rồi kiểm tra sau
			driver.switchTo().window(id);

			// Lấy ra title của tab vừa switch vào
			String actualTitle = driver.getTitle();

			// Kiểm tra nếu title bằng với title mong muốn
			if (actualTitle.equals(expectedTitle)) {
				// Thoát khỏi vòng lặp
				break;
			}
		}

	}

	protected void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		// Get hết ra các id đang có
		Set<String> allWindowIDs = driver.getWindowHandles();

		// Duyệt qua các giá trị trong all windows
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

//	private By getByXpath(String xpathLocator) {
//		return By.xpath(xpathLocator);
//	}
	
	//locatorType: id=/ css=/ xpath=/ name=/ class=
	//locatorType: ID=/ CSS=/ XPATH=/ NAME=/ CLASS=
	//locatorType: Id=/ Css=/ Xpath=/ Name=/ CLASS=
	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("Locator type = " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		}else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		}else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else{
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}
	//Nếu như truyền vào locator type là xpath = đúng
	//Truyền vào loại locator khác thì sai
	private String getDynacmicXpath(String locatorType, String...values ) {
		System.out.println("Locator Type Before = " + locatorType);
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=") ){
			locatorType = String.format(locatorType, (Object[]) values);		
		}
		for (String value : values) {
			System.out.println("Value map to Locator = " + value);
		}
		System.out.println("Locator Type After = " + locatorType);
		return locatorType;
	}

//	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
//		return driver.findElement(getByXpath(xpathLocator));
//	}
	
	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

//	private List<WebElement> getListElements(WebDriver driver, String xpathLocator) {
//		return driver.findElements(getByXpath(xpathLocator));
//	}
	
	private List<WebElement> getListElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

//	protected void clickToElement(WebDriver driver, String xpathLocator) {
//		getWebElement(driver, xpathLocator).click();
//	}
	protected void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		//getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).click();
		locatorType = getDynacmicXpath(locatorType, dynamicValues);
		getWebElement(driver, locatorType).click();
	}

//	protected void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
//		WebElement element = getWebElement(driver, xpathLocator);
//		element.clear();
//		element.sendKeys(textValue);
//	}
	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

//	protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
//		Select select = new Select(getWebElement(driver, xpathLocator));
//		select.selectByValue(textItem);
//	}
	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)));
		select.selectByValue(textItem);
	}

//	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
//		Select select = new Select(getWebElement(driver, xpathLocator));
//		return select.getFirstSelectedOption().getText();
//	}
	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

//	protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
//		Select select = new Select(getWebElement(driver, xpathLocator));
//		return select.isMultiple();
//	}
	protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

//	protected void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
//		
//		// jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(parentXpath + "/ancestor::div[@class='row']")));
//		// sleepInSecond(2);
//		// jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(parentXpath)));
//		getWebElement(driver, parentXpath).click();
//		sleepInSecond(2);
//		
//		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
//		
//		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
//		
//		List<WebElement> childItems = driver.findElements(getByXpath(childXpath));
//		System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());
//		
//		for (WebElement tempElement : childItems) {
//			System.out.println("Item text = " + tempElement.getText());
//			if (tempElement.getText().trim().equals(expectedItemText)) {
//				if (tempElement.isDisplayed()) {
//					System.out.println("Click by Selenium - " + tempElement.getText());
//					tempElement.click();
//					sleepInSecond(1);
//				} else {
//					System.out.println("Click by Javascript - " + tempElement.getText());
//					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
//					sleepInSecond(1);
//					jsExecutor.executeScript("arguments[0].click();", tempElement);
//					sleepInSecond(1);
//				}
//				
//				break;
//			}
//			
//		}
//		
//	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {

		// jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(parentXpath + "/ancestor::div[@class='row']")));
		// sleepInSecond(2);
		// jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(parentXpath)));
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		List<WebElement> childItems = driver.findElements(getByLocator(childXpath));
		System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());

		for (WebElement tempElement : childItems) {
			System.out.println("Item text = " + tempElement.getText());
			if (tempElement.getText().trim().equals(expectedItemText)) {
				if (tempElement.isDisplayed()) {
					System.out.println("Click by Selenium - " + tempElement.getText());
					tempElement.click();
					sleepInSecond(1);
				} else {
					System.out.println("Click by Javascript - " + tempElement.getText());
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
					sleepInSecond(1);
					jsExecutor.executeScript("arguments[0].click();", tempElement);
					sleepInSecond(1);
				}

				break;
			}

		}

	}

//	protected void selectItemInEditableDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
//		getWebElement(driver, parentXpath).clear();
//		sleepInSecond(1);
//		getWebElement(driver, parentXpath).sendKeys(expectedItemText);
//		sleepInSecond(2);
//		
//		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
//		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
//		
//		List<WebElement> childItems = driver.findElements(getByXpath(childXpath));
//		System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());
//		
//		for (WebElement tempElement : childItems) {
//			System.out.println("Item text = " + tempElement.getText());
//			if (tempElement.getText().trim().equals(expectedItemText)) {
//				tempElement.click();
//				sleepInSecond(3);
//				break;
//			}
//			
//		}
//		
//	}
	
	protected void selectItemInEditableDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
		getWebElement(driver, parentXpath).clear();
		sleepInSecond(1);
		getWebElement(driver, parentXpath).sendKeys(expectedItemText);
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		List<WebElement> childItems = driver.findElements(getByLocator(childXpath));
		System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());

		for (WebElement tempElement : childItems) {
			System.out.println("Item text = " + tempElement.getText());
			if (tempElement.getText().trim().equals(expectedItemText)) {
				tempElement.click();
				sleepInSecond(3);
				break;
			}

		}

	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
//		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
//	}
	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

//	protected String getElementText(WebDriver driver, String xpathLocator) {
//		return getWebElement(driver, xpathLocator).getText();
//	}
	protected String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	protected String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).getText();
	}

//	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
//		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
//	}
	protected String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

//	protected int getElementSize(WebDriver driver, String xpathLocator) {
//		return getListElements(driver, xpathLocator).size();
//	}
	protected int getElementSize(WebDriver driver, String locatorType) {
		return getListElements(driver, locatorType).size();
	}
	protected int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListElements(driver, getDynacmicXpath(locatorType, dynamicValues)).size();
	}

//	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
//		WebElement element = getWebElement(driver, xpathLocator);
//		if (!element.isSelected()) {
//			element.click();
//		}
//	}
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

//	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
//		WebElement element = getWebElement(driver, xpathLocator);
//		if (element.isSelected()) {
//			element.click();
//		}
//	}
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

//	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
//		return getWebElement(driver, xpathLocator).isDisplayed();
//	}
	protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	protected boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).isDisplayed();
	}

//	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
//		return getWebElement(driver, xpathLocator).isEnabled();
//	}
	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

//	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
//		return getWebElement(driver, xpathLocator).isSelected();
//	}
	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

//	protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {
//		driver.switchTo().frame(getWebElement(driver, xpathLocator));
//	}
	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

//	protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
//		Actions action = new Actions(driver);
//		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
//	}
	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

//	protected void highlightElement(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		WebElement element = getWebElement(driver, xpathLocator);
//		String originalStyle = element.getAttribute("style");
//		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
//		sleepInSecond(1);
//		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
//	}
	protected void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

//	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
//	}
	protected void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

//	protected void scrollToElement(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
//	}
	protected void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

//	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
//	}
	protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

//	public WebElement getShadowDOM(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		WebElement element = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", getWebElement(driver, xpathLocator));
//		return element; 
//	}
	public WebElement getShadowDOM(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", getWebElement(driver, locatorType));
		return element; 
	}
	
//	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
//	}
	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

//	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
//		if (status) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	protected boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

//	protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
//		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
//		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
//	}
	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	protected void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}

//	protected void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
//		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
//		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
//	}
	protected void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

//	protected void waitForElementInvisible(WebDriver driver, String xpathLocator) {
//		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
//		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
//	}
	protected void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

//	protected void waitForAllElementsInvisible(WebDriver driver, String xpathLocator) {
//		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
//		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, xpathLocator)));
//	}
	protected void waitForAllElementsInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locatorType)));
	}

//	protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
//		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
//		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
//	}
	protected void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}
	
	//Tối ưu ở bài học Level_07_Switch_Page
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.MY_REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	//Tối ưu ở bài học Level_09_Dynamic_Locator
	public BasePage openPagesAtMyAccountPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);//Return không cần break
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);

		default:
			throw new RuntimeException("Invalid page name at My account area.");
		}
	}
	
	
	
	//Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementInvisible(driver, BasePageUI.AJAX_BUSY);
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	private long longTimeout = 30;
	// private long shortTimeout = 5;

}

package commons;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByClassName;
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
import pageObjects.wordpress.UserHomePO;
import pageUI.jQuery.uploadFiles.BasePageJQueryUI;
import pageUI.jQuery.uploadFiles.HomePageUI;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

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

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);		
		}
		sleepInSecond(3);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
		// driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	// Chỉ đúng cho duy nhất 2 tab/ windows
	public void switchToTabByID(WebDriver driver, String expectedID) {
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

	public void switchToTabByTitle(WebDriver driver, String expectedTitle) {
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

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
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

	// public By getByXpath(String xpathLocator) {
	// return By.xpath(xpathLocator);
	// }

	// locatorType: id=/ css=/ xpath=/ name=/ class=
	// locatorType: ID=/ CSS=/ XPATH=/ NAME=/ CLASS=
	// locatorType: Id=/ Css=/ Xpath=/ Name=/ CLASS=
	public By getByLocator(String locatorType) {
		By by = null;
//		System.out.println("Locator type = " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	// Nếu như truyền vào locator type là xpath = đúng
	// Truyền vào loại locator khác thì sai
	public String getDynacmicXpath(String locatorType, String... values) {
		System.out.println("Locator Type Before = " + locatorType);
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}
		for (String value : values) {
			System.out.println("Value map to Locator = " + value);
		}
		System.out.println("Locator Type After = " + locatorType);
		return locatorType;
	}

	// public WebElement getWebElement(WebDriver driver, String xpathLocator) {
	// return driver.findElement(getByXpath(xpathLocator));
	// }

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	// public List<WebElement> getListElements(WebDriver driver, String xpathLocator) {
	// return driver.findElements(getByXpath(xpathLocator));
	// }

	public List<WebElement> getListElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	// public void clickToElement(WebDriver driver, String xpathLocator) {
	// getWebElement(driver, xpathLocator).click();
	// }
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		// getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).click();
		locatorType = getDynacmicXpath(locatorType, dynamicValues);
		getWebElement(driver, locatorType).click();
	}

	// public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
	// WebElement element = getWebElement(driver, xpathLocator);
	// element.clear();
	// element.sendKeys(textValue);
	// }
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	// public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
	// Select select = new Select(getWebElement(driver, xpathLocator));
	// select.selectByValue(textItem);
	// }
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	// public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
	// Select select = new Select(getWebElement(driver, xpathLocator));
	// return select.getFirstSelectedOption().getText();
	// }
	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	// public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
	// Select select = new Select(getWebElement(driver, xpathLocator));
	// return select.isMultiple();
	// }
	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	// public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
	//
	// // jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(parentXpath + "/ancestor::div[@class='row']")));
	// // sleepInSecond(2);
	// // jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(parentXpath)));
	// getWebElement(driver, parentXpath).click();
	// sleepInSecond(2);
	//
	// WebDriverWait explicitWait = new WebDriverWait(driver, 30);
	//
	// explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
	//
	// List<WebElement> childItems = driver.findElements(getByXpath(childXpath));
	// System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());
	//
	// for (WebElement tempElement : childItems) {
	// System.out.println("Item text = " + tempElement.getText());
	// if (tempElement.getText().trim().equals(expectedItemText)) {
	// if (tempElement.isDisplayed()) {
	// System.out.println("Click by Selenium - " + tempElement.getText());
	// tempElement.click();
	// sleepInSecond(1);
	// } else {
	// System.out.println("Click by Javascript - " + tempElement.getText());
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
	// sleepInSecond(1);
	// jsExecutor.executeScript("arguments[0].click();", tempElement);
	// sleepInSecond(1);
	// }
	//
	// break;
	// }
	//
	// }
	//
	// }

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {

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

	// public void selectItemInEditableDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
	// getWebElement(driver, parentXpath).clear();
	// sleepInSecond(1);
	// getWebElement(driver, parentXpath).sendKeys(expectedItemText);
	// sleepInSecond(2);
	//
	// WebDriverWait explicitWait = new WebDriverWait(driver, 30);
	// explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
	//
	// List<WebElement> childItems = driver.findElements(getByXpath(childXpath));
	// System.out.println("Tổng số lượng item trong dropdown = " + childItems.size());
	//
	// for (WebElement tempElement : childItems) {
	// System.out.println("Item text = " + tempElement.getText());
	// if (tempElement.getText().trim().equals(expectedItemText)) {
	// tempElement.click();
	// sleepInSecond(3);
	// break;
	// }
	//
	// }
	//
	// }

	public void selectItemInEditableDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItemText) {
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

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
	// return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	// }
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	// public String getElementText(WebDriver driver, String xpathLocator) {
	// return getWebElement(driver, xpathLocator).getText();
	// }
	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).getText();
	}

	// public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
	// return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	// }
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	// public int getElementSize(WebDriver driver, String xpathLocator) {
	// return getListElements(driver, xpathLocator).size();
	// }
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListElements(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListElements(driver, getDynacmicXpath(locatorType, dynamicValues)).size();
	}

	// public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
	// WebElement element = getWebElement(driver, xpathLocator);
	// if (!element.isSelected()) {
	// element.click();
	// }
	// }
	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	// public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
	// WebElement element = getWebElement(driver, xpathLocator);
	// if (element.isSelected()) {
	// element.click();
	// }
	// }
	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	// public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
	// return getWebElement(driver, xpathLocator).isDisplayed();
	// }
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			//Tìm thấy element: 
			//Case 1: Displayed - trả về True
			//Case 2: Undisplayed - trả về false
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			//Case 3: Undisplayed - trả về false
			return false;
		}
	}
	
	//Case 2 + 3
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
//		System.out.println("Start time = " + new Date().toString());
		
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListElements(driver, locator);
		
		//Sau khi tìm xong thì gán lại wait = 30 để các step khác (findElement/ findElements) không bị ảnh hưởng
		overrideImplicitTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
//			System.out.println("Case 3 - Element not in DOM");
//			System.out.println("End time = " + new Date().toString());
			return true;
			//Nó có kích thước = 1 (có trong DOM)
			//Không được hiển thị
		}else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
//			System.out.println("Case 2 - Element in DOM but not visible/ displayed");
//			System.out.println("End time = " + new Date().toString());
			return true;
		}else{
//			System.out.println("Case 1 - Element in DOM and visible");
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	// public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
	// return getWebElement(driver, xpathLocator).isEnabled();
	// }
	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	// public boolean isElementSelected(WebDriver driver, String xpathLocator) {
	// return getWebElement(driver, xpathLocator).isSelected();
	// }
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	// public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
	// driver.switchTo().frame(getWebElement(driver, xpathLocator));
	// }
	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
	// Actions action = new Actions(driver);
	// action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	// }
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	// public void highlightElement(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// WebElement element = getWebElement(driver, xpathLocator);
	// String originalStyle = element.getAttribute("style");
	// jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
	// sleepInSecond(1);
	// jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	// }
	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	// public void clickToElementByJS(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	// }
	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	// public void scrollToElement(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	// }
	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}
	
	
	public String getElementValueByJSXpath(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	// public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	// }
	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
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

	// public WebElement getShadowDOM(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// WebElement element = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", getWebElement(driver, xpathLocator));
	// return element;
	// }
	public WebElement getShadowDOM(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", getWebElement(driver, locatorType));
		return element;
	}

	// public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	// }
	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	// public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
	// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	// boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" &&
	// arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
	// if (status) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynacmicXpath(locatorType, dynamicValues)));
		// if (status) {
		// return true;
		// } else {
		// return false;
		// }
		return status;
	}

	// public void waitForElementVisible(WebDriver driver, String xpathLocator) {
	// WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
	// explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	// }
	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}

	// public void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
	// WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
	// explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	// }
	public void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}
	
	// public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
	// WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
	// explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	// }
	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	/*
	 * Wait for element undisplayed in DOM or not in DOM and override 
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}

	// public void waitForAllElementsInvisible(WebDriver driver, String xpathLocator) {
	// WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
	// explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, xpathLocator)));
	// }
	public void waitForAllElementsInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locatorType)));
	}
	
	public void waitForAllElementsInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, getDynacmicXpath(locatorType, dynamicValues))));
	}

	// public void waitForElementClickable(WebDriver driver, String xpathLocator) {
	// WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
	// explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	// }
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynacmicXpath(locatorType, dynamicValues))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		// Đường dẫn của thư mục uploadFiles: WIN/ MAC/ LINUX
		String filePath = GlobalConstants.UPLOAD_FILE;

		// Đường dẫn của tất cả các file

		// 1 file: java.png
		// nhiều files: String[] fileNames = {"java.png", "CSharp.png", "Python.png" };
		String fullFileName = "";
		for (String file : fileNames) {
			// fullFileName: "" + D:\Fullstack Selenium in Java\03 - Java Hybrid Framework\ uploadFiles + java.png + "\n";
			// + /n để load lên các file ko bị dính vào nhau
			fullFileName = fullFileName + filePath + file + "\n";
		}
		// Dùng trim để cắt /n ở cuối
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	// Tối ưu ở bài học Level_07_Switch_Page
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		clickToElement(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_REWARD_POINT_LINK);
		clickToElement(driver, BasePageNopCommerceUI.MY_REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	// Tối ưu ở bài học Level_09_Dynamic_Locator
	public BasePage openPagesAtMyAccountPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);// Return không cần break
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

	//Pattern Object
	/**Enter to dynamic Text Box by ID
	 * @author ThangNT
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}
	
	/**Enter to dynamic Button by Text
	 * @author ThangNT
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	
	/**Select item in dropdown by Name attribute
	 * @author ThangNT
	 * @param driver
	 * @param dropdownAttributeName
	 * @param itemValue
	 */
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
	}
	
	/**Click to dynamic radio by label name
	 * 
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
	}
	
	/**Click to dynamic checkbox by label name
	 * 
	 * @param driver
	 * @param checkboxLabelName
	 */
	public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
	}
	
	/**Get value in textbox by textboxID
	 * 
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXT_BOX_ATTRIBUTE_VALUE_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageNopCommerceUI.DYNAMIC_TEXT_BOX_ATTRIBUTE_VALUE_BY_ID, "value", textboxID);
	}
	
	// Level_08_Switch_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementInvisible(driver, BasePageNopCommerceUI.AJAX_BUSY);
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUrl(driver, endUserUrl);
		return pageObjects.wordpress.PageGeneratorManager.getUserHomePage(driver);
	}
	
	public long longTimeout = GlobalConstants.LONG_TIMEOUT;
	public long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

}

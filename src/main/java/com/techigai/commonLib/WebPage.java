package com.techigai.commonLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class WebPage {
	
	protected WebDriver driver;
	private WebDriver[] multiDrivers;
	ExtentReports extent;
	public ExtentTest test;
	
	
	public static Logger logger = LogManager.getLogger(WebPage.class);

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setExtentTestObj(ExtentTest test) {
		this.test = test;
	}
	
	/**
	 * Launches Chrome browser
	 */
	public void launchBrowser(String browser) {
		if(browser == "Chrome") {
			driver = new ChromeDriver();
			logger.info("Launched Chrome browser successfully");
//			test.pass("Launched Chrome browser successfully");
		} 
		else if(browser == "Firefox") {
			driver = new FirefoxDriver();
			logger.info("Launched Firefox browser successfully");
//			test.pass("Launched Firefox browser successfully");
		} else {
			logger.error("Invalid browser name");
//			test.fail("Invalid browser name");
		}
		logger.info("Thread id: "+Thread.currentThread().getId());
	}
	
	/**
	 * Opens the provided URL in the current 
	 * @param url
	 */
	public void openURL(String url) {
		driver.get(url);
		logger.info("Opened "+ url +" URL");
		test.pass("Opened "+ url +" URL");
	}
	
	/**
	 * Maximizes the Browser Window
	 */
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
		logger.info("Maximized browser window");
//		test.pass("Maximized browser window");
	}
	
	/**
	 * Displays the current URL
	 */
	public void displayCurrentURL() {
		String currentURL = driver.getCurrentUrl();
		logger.info("Current url: "+ currentURL);
		test.pass("Current url: "+ currentURL);
	}
	
	/**
	 * Closes the current browser window
	 */
	public void close() {
		driver.close();
		logger.info("Closed the current browser window");
//		test.pass("Closed the current browser window");
	}
	
	/**
	 * Closes all browser windows
	 */
	public void quit() {
		driver.quit();
		logger.info("Closed all browser windows");
//		test.pass("Closed all browser windows");
	}
	
	/**
	 * Displays the current page title 
	 */
	public void displayPageTitle() {
		String pageTitle = driver.getTitle();
		logger.info("Page Title: "+ pageTitle);
		test.pass("Page Title: "+ pageTitle);
	}
	
	/**
	 * Get the page title
	 * @return  page title
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * Verifies the page title is as expected
	 */
	public void verifyPageTitle(String expectedPageTitle) {
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}	
	
	/**
	 * Click links with provided visible text
	 * @param visibleText
	 */
	public void clickLink(String visibleText) {
		driver.findElement(By.linkText(visibleText)).click();
		logger.info("Clicked link with visible text '" + visibleText + "'");
		test.pass("Clicked link with visible text '" + visibleText + "'");
	}
	
	/**
	 * Clicks the provided element
	 * @param selector
	 */
	public void clickElement(By selector) {
		WebElement element = driver.findElement(selector);
		element.click();
		logger.info("Clicked element "+ selector);
		test.pass("Clicked element "+ selector);
	}
	
	/**
	 * Select drop down option by provided visible text
	 * @param dropDownSelc
	 * @param visibleText
	 */
	public void selectDropDownByVisibleText(By selector, String visibleText) {
		WebElement element = driver.findElement(selector);
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(visibleText);
		logger.info("Selected dropdown '"+visibleText+"' by visible text");
		test.pass("Selected dropdown '"+visibleText+"' by visible text");
	}
	
	/**
	 * Select drop down option by provided index
	 * @param dropDownSelc
	 * @param index
	 */
	public void selectDropDownByIndex(By selector, int index) {
		WebElement element = driver.findElement(selector);
		Select dropDown = new Select(element);
		dropDown.selectByIndex(index);
		logger.info("Selected dropdown '"+index+"' by index");
		test.pass("Selected dropdown '"+index+"' by index");
	}
		
	/**
	 * Select drop down option by provided value
	 * @param dropDownSelc
	 * @param value
	 */
	public void selectDropDownByValue(By selector, String value) {
		WebElement element = driver.findElement(selector);
		Select dropDown = new Select(element);
		dropDown.selectByValue(value);
		logger.info("Selected dropdown '"+value+"' by value");
		test.pass("Selected dropdown '"+value+"' by value");
	}
	
	/**
	 * Verifies the element is visible on the page
	 * @param selector
	 */
	public void verifyElementIsVisible(By selector) {
		WebElement element = driver.findElement(selector);
		Assert.assertTrue(element.isDisplayed(), "Element " + selector + " is expected to be visible but not visible on the page");
	}
	
	/**
	 * Verifies the element is not visible on the page
	 * @param selector
	 */
	public void verifyElementIsNotVisible(By selector) {
		WebElement element = driver.findElement(selector);
		Assert.assertFalse(element.isDisplayed(), "Element " + selector + " is expected to be not displayed but displayed on the page");
	}
	
	/**
	 * Verifies the text displayed is as expected at provided selector
	 * @param selector
	 * @param expectedText
	 */
	public void verifyTextDisplayed(By selector, String expectedText) {
		WebElement element = driver.findElement(selector);
		String actualText = element.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	/**
	 * Enters the text in the provided selector
	 * @param selector
	 * @param text
	 */
	public void enterText(By selector, String text) {
		WebElement element = driver.findElement(selector);
		element.sendKeys(text);
		test.pass("Entered " + text + "in the input field");
	}
	
	/**
	 * Verifies the css value is as expected for the provided selector 
	 * @param selector
	 * @param cssAttributeToVerify
	 * @param expectedValue
	 */
	public void verifyCssValue(By selector, String cssAttributeToVerify, String expectedValue) {
		WebElement element = driver.findElement(selector);
		String actualValue = element.getCssValue(cssAttributeToVerify);
		Assert.assertEquals(actualValue, expectedValue);	
	}
	
	/**
	 * Accepts the alert 
	 */
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.info("Accepted the alert successfully");
			test.pass("Accepted the alert successfully");
		} catch(Exception ec) {
			logger.error(ec);
			test.fail(ec);
		}	
	}
	
	/**
	 * Displays the alert text
	 */
	public void displayAlertText() {
		
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			logger.info("Alert text displayed"+ alertText);
			test.pass("Alert text displayed"+ alertText);
		} catch(Exception ec) {
			logger.error(ec);
			test.fail(ec);
		}	
	
	}
	
	/**
	 * Dismiss the alert
	 */
	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			logger.info("Clicked on the alert cancel successfully");
			test.pass("Clicked on the alert cancel successfully");
		} catch(Exception ec) {
			logger.error(ec);
			test.fail(ec);
		}	
	}
	
	/**
	 * Hovers on the provided selector
	 * @param selector
	 */
	public void hoverElement(By selector) {
		WebElement element = driver.findElement(selector);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		logger.info("Moved to element " + selector);
		test.pass("Moved to element " + selector);
	}
	
	/**
	 * double clicks the given element
	 * @param selector
	 */
	public void doubleClick(By selector) {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(selector); 
		act.doubleClick(ele).perform();
		logger.info("Performed double click on " + selector);
		test.pass("Performed double click on " + selector);
	}
	
	/**
	 * Navigates the browser to previous page
	 */
	public void navigateBack() {
		driver.navigate().back();
		logger.info("Navigated back");
		test.pass("Navigated back");
		displayCurrentURL();
	}
	
	/**
	 * Navigates the browser to forward page 
	 */
	public void navigateforward() {
		driver.navigate().forward();
		logger.info("Navigated forward");
		test.pass("Navigated forward");
		displayCurrentURL();
	}
	
	/**
	 * Deletes all cookies of the browser
	 */
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		  try {
			Thread.sleep(7000); //wait 7 seconds to clear cookies.
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  } 
		  logger.info("Deleted all cookies"); 
	}
	
	/**
	 * Creates multiple browser instances
	 */
	public void createMultipleBrowserInstances() {
		System.out.println("Enter the number of browser instances to create");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.close();
		multiDrivers = new WebDriver[count];
		for(int i=0; i<count; i++) {
			multiDrivers[i] = new ChromeDriver();
		}
	}
	
	/**
	 * Closes multiple browser instances
	 */
	public void closeAllBrowserInstances() {
		int count = multiDrivers.length;
		for(int i=0; i<count; i++) {
			multiDrivers[i].close();
		}
	}
	
	/**
	 * Gets the screenshot and returns the screenshot path
	 */
	public String getScreenShot(String ScreenShotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+ScreenShotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}
}

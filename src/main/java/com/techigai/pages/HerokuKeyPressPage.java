package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.techigai.commonLib.*;

/**
 * Heroku Key Press Page
 * @author chandrakala.bara
 *
 */
public class HerokuKeyPressPage extends WebPage{
	
	private WebDriver driver;
	
	public HerokuKeyPressPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h3");
	By txtBox = By.cssSelector("input#target");
	By lblResult = By.cssSelector("p#result");
	
	/**
	 * Performs double click on Page Header
	 */
	public void performDoubleClick() {
		doubleClick(pageHeader);
	}
	
	/**
	 * Hits the Enter key and verifies the validation text displayed
	 */
	public void verifyEnterKey() {
		WebElement textbox = driver.findElement(txtBox);
		textbox.sendKeys(Keys.ENTER);
		verifyTextDisplayed(lblResult, "You entered: ENTER");
	}
	
	/**
	 * Hits the back space key and verifies the validation text displayed
	 */
	public void verifyBackSpaceKey() {
		WebElement textbox = driver.findElement(txtBox);
		textbox.sendKeys(Keys.BACK_SPACE);
		verifyTextDisplayed(lblResult, "You entered: BACK_SPACE");
	}
	
	/**
	 * Hits the Tab key and verifies the validation text displayed
	 */
	public void verifyTabKey() {
		WebElement textbox = driver.findElement(txtBox);
		textbox.sendKeys(Keys.TAB);
		verifyTextDisplayed(lblResult, "You entered: TAB");
	}
	
}
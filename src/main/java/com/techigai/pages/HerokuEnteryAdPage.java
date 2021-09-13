package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techigai.commonLib.*;

/**
 * Heroku Entry Ad Page 
 * @author chandrakala.bara
 *
 */
public class HerokuEnteryAdPage extends WebPage{
	
	private WebDriver driver;

	public HerokuEnteryAdPage (WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("div.example>h3");
	By modal = By.cssSelector("div.modal");
	By modalClose = By.cssSelector("div.modal-footer p");
	By lnkClickHere = By.cssSelector("a#restart-ad");

	/**
	 * Verifies the page header
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "Entry Ad");
	}

	/**
	 * If the modal window appears, clicks on close else click on "click here" again.
	 * Repeats the above steps for about 30 times
	 */
	public void verifyModalWindow() {
		
		for(int count=1; count<=30; count++) {
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			if(!driver.findElement(modal).isDisplayed()) {
				driver.findElement(lnkClickHere).click();
			}
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(modalClose));
			wait.until(ExpectedConditions.elementToBeClickable(modalClose));
			clickElement(modalClose);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(lnkClickHere)));
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(lnkClickHere)));
		    action.moveToElement(driver.findElement(lnkClickHere));
		    driver.findElement(lnkClickHere).click();
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(modal)));
			
		}
		
	}	
	
}
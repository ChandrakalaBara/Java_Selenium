package com.techigai.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

public class HerokuHoversPage extends WebPage{
	
	private WebDriver driver;
	
	public HerokuHoversPage (WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h3");
	By figure = By.xpath("//div[@class='figure']");
	
	/**
	 * Verifies the page header
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "Hovers");
	}

	/**
	 * Hovers on each image and verifies the text
	 */
	public void verifyEachFigure() {
		
		List<WebElement> images = driver.findElements(figure);
		int imagesCount = images.size();
		
		for(int index=1; index<=imagesCount; index++) {
			By selector = By.xpath("//div[@class='figure']["+ index + "]");
			hoverElement(selector);
			By imgUsername = By.xpath("//div[@class='figure']["+ index + "]//h5");
			verifyElementIsVisible(imgUsername);
			By imgLink = By.xpath("//div[@class='figure']["+ index + "]//a");
			verifyElementIsVisible(imgLink);
		}
		
	}	
}
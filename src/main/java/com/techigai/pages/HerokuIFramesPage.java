package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

/**
 * Heroku Iframes page
 * @author chandrakala.bara
 *
 */
public class HerokuIFramesPage extends WebPage{
	
	private WebDriver driver;
	
	public HerokuIFramesPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By txtAreaContent = By.cssSelector("body>p");
	
	/**
	 * Switch to the text area iframe and displays the text present in text area
	 */
	public void displayTextInTextArea() {
		driver.switchTo().frame("mce_0_ifr");
		WebElement element = driver.findElement(txtAreaContent);
		logger.info("Text in text area: "+ element.getText());
		test.info("Text in text area: "+ element.getText());
	}

}
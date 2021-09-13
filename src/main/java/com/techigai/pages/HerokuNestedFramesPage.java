package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

/**
 * Heroku Nested Frames Page
 * @author chandrakala.bara
 *
 */
public class HerokuNestedFramesPage extends WebPage{
	
	private WebDriver driver;
	
	public HerokuNestedFramesPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By frame = By.tagName("frame");
	By bodyTag  = By.tagName("body");
	
	/**
	 * Switches to each frame and prints the text 
	 */
	public void printEachFrameText() {
		int size = driver.findElements(frame).size();			
		for(int index = 0; index < size; index++) {
			driver.switchTo().frame(index);
			int innerFrameSize = driver.findElements(frame).size();
			if(innerFrameSize>1) {
				for(int innerFrameIndex = 0; innerFrameIndex < innerFrameSize; innerFrameIndex++) {
					driver.switchTo().frame(innerFrameIndex);
					WebElement ele = driver.findElement(bodyTag);
					String text = ele.getText();
					logger.info("Text in Frame: "+ text);
					test.info("Text in Frame: "+ text);
					driver.switchTo().parentFrame();
				}
			}else {
				WebElement ele = driver.findElement(bodyTag);
				String text = ele.getText();
				logger.info("Text in Frame: "+ text);
				test.info("Text in Frame: "+ text);
			}
			driver.switchTo().parentFrame();	
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement ele = driver.findElement(bodyTag);
		String text = ele.getText();
		logger.info("Text in Frame: "+ text);
		test.info("Text in Frame: "+ text);
	}
}
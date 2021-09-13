package com.techigai.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

/**
 * Heroku File Download Page
 * 
 * @author chandrakala.bara
 *
 */
public class HerokuFileDownloadPage extends WebPage{

	private WebDriver driver;
	
	/**
	 * Constructor - sets the browser driver
	 * @param driver
	 */
	public HerokuFileDownloadPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h3");
	By lnksDownload = By.xpath("//div[@class='example']/a");
	
	String fileDowloadPageHeader = "File Downloader";
	
	/**
	 * Verifies the page header displayed is as expected
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, fileDowloadPageHeader);
	}
	
	/**
	 * Downloads the random file displayed in the page
	 */
	public void downloadFile() {
		int count = driver.findElements(lnksDownload).size();
		if(count<1) {
			logger.error("No links available to perform download");
			test.fail("No links available to perform download");
		}	
		Random random = new Random();
		int randomNum = random.nextInt(count);  
		WebElement element = driver.findElements(lnksDownload).get(randomNum); 
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
}
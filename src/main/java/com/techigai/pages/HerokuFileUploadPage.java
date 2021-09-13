package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

public class HerokuFileUploadPage extends WebPage{

	private WebDriver driver;
	
	public HerokuFileUploadPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h3");
	By btnChooseFile = By.cssSelector("input#file-upload");
	By btnUpload = By.cssSelector("input#file-submit");
	
	/**
	 * Verifies the page header
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "File Uploader");
	}
	
	/**
	 * Uploads the file from the location
	 */
	public void uploadFile() {
		WebElement uploadElement = driver.findElement(btnChooseFile);
		String currentDir = System.getProperty("user.dir");
		uploadElement.sendKeys(currentDir+"\\resources\\documents\\fileupload.html");
		clickElement(btnUpload);
		verifyTextDisplayed(pageHeader, "File Uploaded!");
	}	
	
}
package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techigai.commonLib.*;

public class HerokuFormPage extends WebPage{
	
	private WebDriver driver;
	
	public HerokuFormPage(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h2");
	By txtUserName = By.cssSelector("input#username");
	By txtPassword = By.cssSelector("input#password");
	By btnLogin = By.cssSelector("button[type=submit]");
	By validationMsg = By.cssSelector("div.flash");
	
	final String greenColor = "rgba(93, 164, 35, 1)";
	
	/**
	 * Verifies page header
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "Login Page");
	}
	
	/**
	 * Enters the username in user name field
	 * @param username
	 */
	public void enterUserName(String username) {
		enterText(txtUserName, username);
	}
	
	/**
	 * Enters password in the password field
	 * @param password
	 */
	public void enterPassword(String password) {
		enterText(txtPassword, password);
	}
	
	/**
	 * Clicks on login button
	 */
	public void clickLoginButton() {
		clickElement(btnLogin);
	}
	
	/**
	 * Verifies the login successful validation message displayed
	 */
	public void loginSuccessfulValidationMsg() {
		verifyValidationMsg(validationMsg, "You logged into a secure area!");
	}
	
	/**
	 * Verifies the logout success validation message displayed
	 */
	public void logoutSuccessValidationMsg() {
		verifyValidationMsg(validationMsg, "You logged out of the secure area!");
	}
	
	/**
	 * Verifies the validation message is displayed as expected
	 * @param selector
	 * @param expectedText
	 */
	public void verifyValidationMsg(By selector, String expectedText) {
		WebElement element = driver.findElement(selector);
		String actualText = element.getText().trim();
		actualText = actualText.substring(0, actualText.length()-1);
		if(expectedText.trim().equals(actualText.trim())) {
			logger.info("Text displayed at selector "+ selector +" is as expected: "+ expectedText);
			test.pass("Text displayed at selector "+ selector +" is as expected: "+ expectedText);
		} else {
			logger.error("Text displayed at selector "+ selector +" is not as expected. "+ 
					"Expected text: "+ expectedText +
					"Actual text displayed: "+ actualText);
			test.fail("Text displayed at selector "+ selector +" is not as expected. "+ 
					"Expected text: "+ expectedText +
					"Actual text displayed: "+ actualText);
		}
	}

	/**
	 * Verifies the border color displayed for success message
	 */
	public void verifySuccessMsgBorderColor() {
		verifyCssValue(validationMsg, "background-color", greenColor);
	}
	
}
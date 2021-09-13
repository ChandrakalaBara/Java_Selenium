package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techigai.commonLib.*;

public class HerokuJsAlertsPage extends WebPage{

	
	public HerokuJsAlertsPage (WebDriver driver) {
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("h3");
	By btnJsAlert = By.cssSelector("button[onclick='jsAlert()']");
	By btnJsAlertConfirm = By.cssSelector("button[onclick='jsConfirm()']");
	
	/**
	 * Verifies the page header displayed
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "JavaScript Alerts");
	}
	
	/**
	 * Clicks the Alert Button
	 */
	public void clickJsAlertButton() {
		clickElement(btnJsAlert);
	}
	
	/**
	 * Clicks Alert confirm button
	 */
	public void clickJsConfirmButton() {
		clickElement(btnJsAlertConfirm);
	}
	
}
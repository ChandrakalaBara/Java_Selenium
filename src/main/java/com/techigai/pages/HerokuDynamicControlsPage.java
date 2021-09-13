package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techigai.commonLib.*;

public class HerokuDynamicControlsPage extends WebPage {
	
	public HerokuDynamicControlsPage(WebDriver driver) {
		setDriver(driver);
	}
	
	By pageHeader = By.cssSelector("div.example>h4:nth-child(1)");
	By chkbxValidationMsg = By.cssSelector("form#checkbox-example p#message");
	By chckBx = By.cssSelector("input[type=checkbox]");
	By removeBtn = By.xpath("//button[text()='Remove']");
	By addBtn = By.xpath("//button[text()='Add']");
	By enableBtn = By.xpath("//button[text()='Enable']");
	By disableBtn = By.xpath("//button[text()='Disable']");
	By inputValidationMsg = By.cssSelector("form#input-example p#message");
	
	/**
	 * Verifies page header displayed
	 */
	public void verifyPageHeader() {
		verifyTextDisplayed(pageHeader, "Dynamic Controls");
	}
	
	/**
	 * verifies the checkbox validation message displayed
	 * @param expectedMsg
	 */
	public void verifyChkbxValidationMsg(String expectedMsg) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyTextDisplayed(chkbxValidationMsg, expectedMsg);
	}
	
	/**
	 * verifies checkbox is visible 
	 */
	public void verifyCheckbxIsVisible() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyElementIsVisible(chckBx);
	}
	
	/**
	 * Verifies the checkbox is not visible
	 */
	public void verifyCheckbxIsNotVisible() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyElementIsNotVisible(chckBx);
	}
	
	/**
	 * Clicks on remove button
	 */
	public void clickRemoveButton() {
		clickElement(removeBtn);
	}

	/**
	 * Clicks on Add button
	 */
	public void clickAddButton() {
		clickElement(addBtn);
	}
	
	/**
	 * Clicks on Enable button
	 */
	public void clickEnableBtn() {
		clickElement(enableBtn);
	}
	
	/**
	 * Clicks on disable button
	 */
	public void clickDisableBtn() {
		clickElement(disableBtn);
	}
	
	/**
	 * Verifies the validation message displayed is as expected
	 * @param expectedMsg
	 */
	public void verifyInputValidationMsg(String expectedMsg) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyTextDisplayed(inputValidationMsg, expectedMsg);
	}
	
}
package com.techigai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.techigai.commonLib.*;

public class HerokuDropDownPage extends WebPage{
	
	public HerokuDropDownPage(WebDriver driver) {
		setDriver(driver);
	}
	
	By select = By.xpath("//select");
	
	/**
	 * Select drop down by index
	 * @param index
	 */
	public void selectFromDdListByIndex(int index) {
		selectDropDownByIndex(select, 1);
	}
	
	/**
	 * Select drop down by visible text
	 * @param visibleText
	 */
	public void selectDdByVisibleText(String visibleText) {
		selectDropDownByVisibleText(select, visibleText);
	}
	
	/**
	 * Select drop down by value
	 * @param value
	 */
	public void selectDdByValue(String value) {
		selectDropDownByValue(select, value);
	}
}
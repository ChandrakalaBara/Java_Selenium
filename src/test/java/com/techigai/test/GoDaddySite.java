package com.techigai.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techigai.applib.Parent;

public class GoDaddySite extends Parent{
	
	String goDaddyURL = "https://www.godaddy.com/";
   
	@BeforeMethod
	public void openUrl() {
		test = extent.createTest("TestCase 1", "Veifies Go Daddy site");
		wp.setExtentTestObj(test);
		wp.openURL(goDaddyURL);
	}
  
	@Test(groups= {"godaddySite","regression"})
	public void printPageTitle() {
		wp.displayPageTitle();
	}
  
	@Test(groups= {"godaddySite","regression"})
	public void printCurrentURL() {
		wp.displayCurrentURL();
	}
  
 }
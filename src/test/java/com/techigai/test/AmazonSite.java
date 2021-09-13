package com.techigai.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techigai.applib.Parent;

public class AmazonSite extends Parent{
	  
	  String amazonURL = "http://www.amazon.in";
	  
	  @BeforeMethod
	  public void openUrl() {
		  test = extent.createTest("TestCase 2", "Veifies Amazon site menu navigation");
		  wp.setExtentTestObj(test);
		  wp.openURL(amazonURL);
	  }
	  
	  @Test(groups={"amazonSite", "regression"})
	  public void testCase2() {
		  wp.displayPageTitle();
		  wp.displayCurrentURL();
		  wp.clickLink("Amazon Pay");
		  wp.displayCurrentURL();
		  wp.verifyPageTitle("Amazon Pay");
		  wp.clickLink("Best Sellers");
		  wp.displayCurrentURL();
		  wp.verifyPageTitle("Amazon.in Bestsellers: The most popular items on Amazon");
		  wp.clickLink("Mobiles1");
		  wp.displayCurrentURL();
		  wp.verifyPageTitle("Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
		  wp.clickLink("Fashion");
		  wp.displayCurrentURL();
		  wp.verifyPageTitle("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids");
		  wp.clickLink("Electronics");
		  wp.displayCurrentURL();
		  wp.verifyPageTitle("Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in");
	  }
	  
}
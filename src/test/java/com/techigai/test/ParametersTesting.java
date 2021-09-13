package com.techigai.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTesting {
	
	@Parameters({"url"})
	@Test 
	public void test1(@Optional("https://google.com") String url) throws Exception {
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
		
		driver.close();
	}

}

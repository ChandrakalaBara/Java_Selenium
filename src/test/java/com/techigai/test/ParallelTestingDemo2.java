package com.techigai.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingDemo2 {
	
	@Test
	public void test1() throws Exception {
		System.out.println("I am inside class 2 test1 - "+ Thread.currentThread().getId());
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test
	public void test2() throws Exception {
		System.out.println("I am inside class 2 test2 - "+ Thread.currentThread().getId());
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test
	public void test3() throws Exception {
		System.out.println("I am inside class 2 test3 - "+ Thread.currentThread().getId());
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		
		driver.close();
	}
}

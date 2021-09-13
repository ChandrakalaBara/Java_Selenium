package com.techigai.applib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.techigai.commonLib.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parent extends WebPage{
	
	 protected WebDriver driver;
	 protected WebPage wp;
	 protected ExtentReports extent;
	 protected ExtentTest test;
	
	@BeforeSuite
	public void setUp() {	
	  ExtentReporter er = new ExtentReporter();
	  extent = er.InitializeExtentReporter();
	  WebDriverManager.chromedriver().setup();	
	  logger.info("Set up the chrome driver");
	  wp = new WebPage();
    }
	  
	@BeforeTest
	public void launchChromeBrowser() {
		wp.launchBrowser("Chrome");
		driver = wp.getDriver();
	 }
	
	@BeforeClass
	public void maximizeWindow() {
		wp.maximizeBrowserWindow();
	}
	
	@AfterMethod(alwaysRun=true)
	public void deleteCookies() {
		wp.deleteAllCookies();
	}
//	
	@AfterClass(alwaysRun=true)
	public void closeCurrentBrowser() {
		wp.close();
	}
	  
	@AfterTest(alwaysRun=true)
	public void quitBrowser() {
		wp.quit();
		extent.flush();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws Exception {
		
		if(result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "Test case failed "+ result.getName());
//			test.log(Status.FAIL, "Test case failed "+ result.getThrowable());
			
			String screenshotPath = wp.getScreenShot(result.getName());
			
			test.fail("Test case failed "+ result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
		}
	}

}
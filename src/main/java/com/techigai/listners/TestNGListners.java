package com.techigai.listners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.techigai.commonLib.WebPage;



public class TestNGListners extends WebPage implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("---------Test Started: "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("---------Test Success: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("---------Test Failure: "+result.getName());
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("---------Test Skipped: "+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("---------Test Finished: "+context.getName());
	}
	
}

package com.techigai.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {

	public static void main(String[] args) {
		
		ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("extentsReport.html");
        extent.attachReporter(htmlReport); 
        
        ExtentTest test1 = extent.createTest("Sample Test", "This is a sample test");
        
        test1.pass("This test is passed");
        test1.fail("This test failed");
        
        extent.flush();

	}

}

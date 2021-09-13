package com.techigai.commonLib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporter {
	
	public ExtentReports InitializeExtentReporter() {
		ExtentReports extent = new ExtentReports();
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("extentsReport.html");
        extent.attachReporter(htmlReport); 
        return extent;
	}

}

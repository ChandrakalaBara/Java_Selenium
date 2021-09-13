package com.techigai.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techigai.applib.Parent;
import com.techigai.commonLib.WebPage;
import com.techigai.pages.HerokuDropDownPage;
import com.techigai.pages.HerokuDynamicControlsPage;
import com.techigai.pages.HerokuEnteryAdPage;
import com.techigai.pages.HerokuFileDownloadPage;
import com.techigai.pages.HerokuFileUploadPage;
import com.techigai.pages.HerokuFormPage;
import com.techigai.pages.HerokuHoversPage;
import com.techigai.pages.HerokuIFramesPage;
import com.techigai.pages.HerokuJsAlertsPage;
import com.techigai.pages.HerokuKeyPressPage;
import com.techigai.pages.HerokuNestedFramesPage;

public class HerokuSite extends Parent{
	  String herokuURL = "https://the-internet.herokuapp.com";
	  HerokuDropDownPage dropdownPage;
	  
	  @BeforeMethod
	  public void openUrl() {
		  wp.openURL(herokuURL);
	  }
	  
	  @Test(invocationCount=3,timeOut=2000, description="This verifies the site page title and url", groups= {"regression", "smoke", "heroku"})
	  public void verifyPageTitle() {
		  wp.displayPageTitle();
	  }
	  
	  @Test(groups={"smoke", "heroku"})
	  public void displaySiteURL() {
		  wp.displayCurrentURL();
	  }
	    
	  @Test(dependsOnMethods = "displaySiteURL", priority=1, groups= {"heroku", "regression"})
	  public void testCase3() {
		  test = extent.createTest("TestCase 3", "Veifies Heroku site drop down page");
		  wp.setExtentTestObj(test);
		  System.out.println("Thread id "+ Thread.currentThread().getId());
		  wp.clickLink("Dropdown");
		  HerokuDropDownPage dropdownPage = new HerokuDropDownPage(driver);
		  dropdownPage.selectFromDdListByIndex(1);
		  dropdownPage.selectDdByVisibleText("Option 2");
		  dropdownPage.selectDdByValue("1");
	  }
	  
	  @Test(dependsOnMethods = "displaySiteURL", alwaysRun=true, priority=2, groups= {"heroku", "regression"})
	  public void testCase4() {
		  test = extent.createTest("TestCase 4", "Veifies Heroku site dynamic controls page");
		  wp.setExtentTestObj(test);
		  logger.info("Thread id "+ Thread.currentThread().getId());
		  wp.clickLink("Dynamic Controls");
		  HerokuDynamicControlsPage dynamicCtrlsPage = new HerokuDynamicControlsPage(driver);
		  dynamicCtrlsPage.verifyPageHeader();
		  dynamicCtrlsPage.verifyCheckbxIsVisible();
	      dynamicCtrlsPage.clickRemoveButton();
		  dynamicCtrlsPage.verifyCheckbxIsNotVisible();
		  dynamicCtrlsPage.verifyChkbxValidationMsg("It's gone!");
		  dynamicCtrlsPage.clickAddButton();
		  dynamicCtrlsPage.verifyCheckbxIsVisible();
		  dynamicCtrlsPage.verifyChkbxValidationMsg("It's back!");
		  dynamicCtrlsPage.clickEnableBtn();
		  dynamicCtrlsPage.verifyInputValidationMsg("It's enabled!");
		  dynamicCtrlsPage.clickDisableBtn();
		  dynamicCtrlsPage.verifyInputValidationMsg("It's disabled!");
	  }
	  
	  @Test(groups= {"heroku", "regression"})
	  public void testCase5() {
		  test = extent.createTest("TestCase 5", "Veifies Heroku site form authentication");
		  wp.setExtentTestObj(test);
		  wp.clickLink("Form Authentication");
		  HerokuFormPage formPage = new HerokuFormPage(driver);
		  formPage.verifyPageHeader();
		  formPage.enterUserName("tomsmith");
		  formPage.enterPassword("SuperSecretPassword!");
		  formPage.clickLoginButton();
		  formPage.loginSuccessfulValidationMsg();
		  wp.clickLink("Logout");
		  formPage.logoutSuccessValidationMsg();
		  formPage.verifySuccessMsgBorderColor();
	  }
	  
	  @Test(groups= {"heroku", "regression"})
	  public void testCase6() {
		  test = extent.createTest("TestCase 6", "Veifies Heroku site Java script alerts");
		  wp.setExtentTestObj(test);
		  wp.clickLink("JavaScript Alerts");
		  HerokuJsAlertsPage alertsPage = new HerokuJsAlertsPage(driver);
		  alertsPage.verifyPageHeader();
		  alertsPage.clickJsAlertButton();
		  wp.acceptAlert();
		  alertsPage.clickJsConfirmButton();
		  wp.displayAlertText();
		  wp.dismissAlert();
		  alertsPage.clickJsConfirmButton();
		  wp.acceptAlert();
	  }
	  
	  @Test(groups= {"heroku", "regression"})
	  public void testCase7() {
		  wp.clickLink("Hovers");	
		  HerokuHoversPage hoversPage = new HerokuHoversPage(driver);
		  hoversPage.verifyPageHeader();
	      hoversPage.verifyEachFigure();
	  }
	  
	  @Test(groups= {"heroku", "regression"})
	  public void testCase8() {
		  test = extent.createTest("TestCase 8", "Veifies Heroku site Entry ad page");
		  wp.setExtentTestObj(test);
		  String lnkTextEntryAd = "Entry Ad";
		  wp.clickLink(lnkTextEntryAd);
		  HerokuEnteryAdPage entryAdPage = new HerokuEnteryAdPage(driver);
		  entryAdPage.verifyPageHeader();
		  entryAdPage.verifyModalWindow();
	  }
	  
	  @Test(groups= {"heroku", "regression"})
	  public void testCase9() {
		  test = extent.createTest("TestCase 9", "Veifies Heroku site file upload page");
		  wp.setExtentTestObj(test);
			String url = "https://the-internet.herokuapp.com/";
		    String lnkFileUpload = "File Upload";
			String lnkFileDownload = "File Download";
			String lnkKeyPresses = "Key Presses";
			String lnkFrames = "Frames";
			String lnkNestedFrames = "Nested Frames";
			String lnkIFrame = "iFrame";
			
			WebPage wp = new WebPage();
			wp.openURL(url);
			WebDriver driver = wp.getDriver();
			wp.maximizeBrowserWindow();
			
			wp.clickLink(lnkFileUpload);
			HerokuFileUploadPage fileUploadPage = new HerokuFileUploadPage(driver);
			fileUploadPage.verifyPageHeader();
			fileUploadPage.uploadFile();
			
			wp.openURL(url);
			wp.clickLink(lnkFileDownload);
			HerokuFileDownloadPage fileDownloadPage = new HerokuFileDownloadPage(driver);
			fileDownloadPage.verifyPageHeader();
			fileDownloadPage.downloadFile();
			
			wp.openURL(url);
			wp.clickLink(lnkKeyPresses);
			HerokuKeyPressPage keyPressPage = new HerokuKeyPressPage(driver);
			keyPressPage.performDoubleClick();
			keyPressPage.verifyEnterKey();
			keyPressPage.verifyBackSpaceKey();
			keyPressPage.verifyTabKey();
			
			wp.openURL(url);
			wp.clickLink(lnkFrames);
			wp.clickLink(lnkNestedFrames);
			HerokuNestedFramesPage nestedFrames = new HerokuNestedFramesPage(driver);
			nestedFrames.printEachFrameText();
			
			wp.navigateBack();
			wp.clickLink(lnkIFrame);
			HerokuIFramesPage iframePage = new HerokuIFramesPage(driver);
			iframePage.displayTextInTextArea();
	  }
	  
}

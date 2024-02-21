//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.Pages.login.LoginPage;
import com.bhumi.SampleMaven.base.BaseTest;
import com.bhumi.SampleMaven.utilities.Constants;
import com.bhumi.SampleMaven.utilities.PropertiesUtility;

public class TC01 extends BaseTest{
	BaseTest base = new BaseTest();
	
	//protected Logger BaseFirebasetlog = LogManager.getLogger();
	//protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();
	
	@Test
	public void loginErrorMessage1() {
		
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		//String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");	
		extentReport.logTestInfo("username and password extracted from properties file");
		
		
		//step1
		
		//goToUrl("https://login.salesforce.com");
		LoginPage loginPage=new LoginPage(driver);
		
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(loginPage.getTitleOfThePage(), expectedTitle,"Page Title not Displayed correctly");
		extentReport.logTestInfo("Login Page Title Verified");
		Reporter.log("Login Page Title Verified");
		
		
		//step2
		
		loginPage.enterUserName(userName);
		Assert.assertEquals(loginPage.getUserName(),userName,"UserName not Entered correctly");
		extentReport.logTestInfo("UserName entry verified");
		Reporter.log("UserName entry verified");
		
		loginPage.clearPassword();
		Assert.assertEquals(loginPage.getPassword(),"","Password not cleared");
		extentReport.logTestInfo("Password field clear verified");
		Reporter.log("Password field clear verified");
		driver=loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.loginErrorDisplayed(), true,"Error not Displayed for no password");
		Assert.assertEquals(loginPage.getErrorMessage(), "Please enter your password.","Error not Displayed for no password with correct text");
		extentReport.logTestInfo("Error message for login page missing password verified");
		Reporter.log("Error message for login page missing password verified");
		
		//driver.quit();
		
		
	}

}

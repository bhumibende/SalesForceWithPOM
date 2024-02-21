//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.Pages.login.LoginPage;
import com.bhumi.SampleMaven.base.BaseTest;

public class TC04 extends BaseTest{
	BaseTest base = new BaseTest();
	
	
	@Test
	public void loginErrorMessage3() throws InterruptedException {
		//step1
		
		//goToUrl("https://login.salesforce.com");
		String userName="123";
		String passWord="22131";		
		
		
		LoginPage loginPage=new LoginPage(driver);
		
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(loginPage.getTitleOfThePage(), expectedTitle,"Page Title not Displayed correctly");
		extentReport.logTestInfo("Login Page Title Verified");
		Reporter.log("Login Page Title Verified");
		
		
		
		//step2
		//Thread.sleep(5000);
		extentReport.logTestInfo("Entering UserName & Password and login to salesforce");
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		driver=loginPage.clickLoginButton();
		String passError = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(loginPage.loginErrorDisplayed(), true,"Error not Displayed for no password");
		Assert.assertEquals(loginPage.getErrorMessage(), passError,"Error not Displayed for wrong password with correct text");
		extentReport.logTestInfo("Error message for login page with incorrect credentials verified");
		Reporter.log("Error message for login page with incorrect credentials verified");
		
		//driver.quit();
		
		
	}

}

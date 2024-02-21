//Login Error Message - 1
package com.bhumi.SampleMaven.AutomationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bhumi.SampleMaven.Pages.home.HomePage;
import com.bhumi.SampleMaven.Pages.login.LoginPage;
import com.bhumi.SampleMaven.base.BaseTest;
import com.bhumi.SampleMaven.utilities.Constants;
import com.bhumi.SampleMaven.utilities.PropertiesUtility;

public class TC02 extends BaseTest{
	BaseTest base = new BaseTest();
	
	
	@Test
	public void loginErrorMessage2() throws InterruptedException {
		//step1
		
		//goToUrl("https://login.salesforce.com");
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");	
		extentReport.logTestInfo("username and password extracted from properties file");
		
		LoginPage loginPage=new LoginPage(driver);
		
		String expectedTitle = "Login | Salesforce";
		Assert.assertEquals(loginPage.getTitleOfThePage(), expectedTitle,"Page Title not Displayed correctly");
		extentReport.logTestInfo("Login Page Title Verified");
		Reporter.log("Login Page Title Verified");
		
		
		//step2
		HomePage homePage = new HomePage(driver);
		
		loginPage.loginSalesForce(userName, passWord);
		expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(homePage.getPageTitle(), expectedTitle,"Page Title not displayed as expected post login");
		extentReport.logTestInfo("Login verified. Salesforce Home Page Title Verified post login.");
		Reporter.log("Login verified. Salesforce Home Page Title Verified post login.");
		
		
	}

}

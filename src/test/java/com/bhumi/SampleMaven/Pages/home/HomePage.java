package com.bhumi.SampleMaven.Pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.bhumi.SampleMaven.Pages.base.BasePage;
import com.bhumi.SampleMaven.base.BaseTest;

public class HomePage extends BasePage {
	 BaseTest baseTest = new BaseTest();
	
	@FindBy(id="userNavButton") WebElement salesForceUserMenuElement;
	@FindBy(xpath="//*[@id='userNavMenu']//a[@title='Logout']") WebElement salesForceLogoutButtonElement;



	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getTitleOfThePage() {
		//waitUntilPageLoads();
		return getPageTitle();
	}

	public void logout_SalesForce() {
		
		salesForceUserMenuElement.click();
		baseTest.waitUntilElementToBeClickable(salesForceLogoutButtonElement, 10);
		salesForceLogoutButtonElement.click();
		Reporter.log("Logout Successfull");
		//Thread.sleep(10000);
		baseTest.waitUntilPageLoads() ;
	}




	//	public String getTextFromStudentRegistrationFormText() {
	//		
	//	
	//	}
}

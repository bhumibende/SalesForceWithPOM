package com.bhumi.SampleMaven.Pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bhumi.SampleMaven.Pages.base.BasePage;
import com.bhumi.SampleMaven.base.BaseTest;

public class LoginPage extends BasePage{
	@FindBy(id="username") WebElement userNameElement;
	@FindBy(id="password") WebElement passwordElement;
	@FindBy(id="Login") WebElement loginButtonElement;
	@FindBy(id="error") WebElement loginErrorMessageElement;
	@FindBy(id="rememberUn") WebElement rememberUserNameCheckboxElement;
	@FindBy(xpath="//span[contains(@id,'identity')]") WebElement userNameRememberedTextElement;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		enterText(userNameElement, data, "Username textbox");
		//extentReport.logTestInfo("username data is entered in username field");
	}
	public void enterPassword(String data) {
		enterText(passwordElement, data, "password field");
	}
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	public String getTitleOfThePage() {
		//waitUntilPageLoads();
		return getPageTitle();
	}
	
	
	public String getUserName() {
		//userNameElement.sendKeys(data);
		return userNameElement.getAttribute("value");
		//extentReport.logTestInfo("username data is entered in username field");
	}
	public String getPassword() {
		return passwordElement.getAttribute("value");
	}
	
	public void clearPassword() {
		passwordElement.clear();
	}
	
	public boolean loginErrorDisplayed() {
		return loginErrorMessageElement.isDisplayed();
	}
	
	public String getErrorMessage() {
		return loginErrorMessageElement.getText();
	}

	public void loginSalesForce(String username,String password) {
		this.enterUserName(username);
		this.enterPassword(password);
		this.loginButtonElement.click();
		new BaseTest().waitUntilPageLoads();
		
	}
	
	public void checkrememberUserNameCheckbox() {
		rememberUserNameCheckboxElement.click();
	}
	public String getRememberedUserName() {
		//userNameElement.sendKeys(data);
		return userNameRememberedTextElement.getText();
		//extentReport.logTestInfo("username data is entered in username field");
	}

	public WebElement getUserNameRememberedTextElement() {
		return userNameRememberedTextElement;
	}

	
	
	
}

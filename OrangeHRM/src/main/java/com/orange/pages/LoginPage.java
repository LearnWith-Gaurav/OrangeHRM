package com.orange.pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.base.CommonFunctions;
import com.orange.base.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	HomePage homepage;
	
	//Web Elements
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement passwordTxtBox;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	private WebElement HRMlogo;
	
	protected WebDriver driver;
	private ExtentTest logger = ExtentReportManager.getLogger();

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
		
	}
	
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePageLogo() {
		return CommonFunctions.isElementExist(driver, HRMlogo);
	}

	
	public boolean validateUsernameField() {
			return CommonFunctions.ElementExistsInAnyFrame(driver, CommonFunctions.makeFresh(driver, username));
		}
	
	
	public boolean validatePasswordField() {
		return CommonFunctions.ElementExistsInAnyFrame(driver, CommonFunctions.makeFresh(driver, passwordTxtBox));
	}
	
	public boolean validateLoginButton() {
		return CommonFunctions.ElementExistsInAnyFrame(driver, CommonFunctions.makeFresh(driver, loginBtn));
	}
	
	public LoginPage enterUsername(String userId) {
		 CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, username)).sendKeys(userId);;
		 return new LoginPage(driver);
	}
	
	public LoginPage enterPassword(String password) {
		 CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, passwordTxtBox)).sendKeys(password);;
		 return new LoginPage(driver);
	}
	
	//Login
	public <T> T clickLogInBtn(Class<T> pomClass) {
		 CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, loginBtn)).click();
		
		 try {
			Constructor<T> constructor = pomClass.getConstructor(WebDriver.class);
			 return constructor.newInstance(driver);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	
	public HomePage clickLogInBtn() {
		CommonFunctions.waitForElement(driver, loginBtn).click();
		return new HomePage(driver);
	}
}

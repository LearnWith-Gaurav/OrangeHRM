package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.base.CommonFunctions;
import com.orange.base.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RecruitmentPage {
	
	protected WebDriver driver;
	private ExtentTest logger = ExtentReportManager.getLogger();
	
	//webObjects
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement addButton;
	
	@FindBy(xpath="//h1[@id='addCandidateHeading']")
	private WebElement addCandidateHeader;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//span[@class='validation-error'])[1]")
	private WebElement validationErrorMsg1;
	
	@FindBy(xpath="(//span[@class='validation-error'])[2]")
	private WebElement validationErrorMsg2;
	
	@FindBy(xpath="(//span[@class='validation-error'])[3]")
	private WebElement validationErrorMsg3;
	
	@FindBy(xpath="//input[@id='addCandidate_appliedDate']")
	private WebElement appliedDate;
	
	

	//constructor
	public RecruitmentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public RecruitmentPage clickSaveBtn(){
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, saveButton));
		saveButton.click();
		logger.log(LogStatus.PASS, "Clicked Save button");
		return new RecruitmentPage(driver);
	}
	
	public RecruitmentPage clickAddBtn(){
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, addButton));
		addButton.click();
		logger.log(LogStatus.PASS, "Clicked Add button");
		return new RecruitmentPage(driver);
	}
	
	public boolean validationMsgFirstName() {
		return CommonFunctions.isElementExist(driver, validationErrorMsg1);
	}
	
	public boolean validationMsgLastName() {
		return CommonFunctions.isElementExist(driver, validationErrorMsg2);
	}
	
	public boolean validationMsgEmail() {
		return CommonFunctions.isElementExist(driver, validationErrorMsg3);
	}
	
	
}

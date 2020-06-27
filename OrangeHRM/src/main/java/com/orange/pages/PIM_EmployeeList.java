package com.orange.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.base.CommonFunctions;
import com.orange.base.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import okhttp3.Cookie;

public class PIM_EmployeeList {

	private WebDriver driver;
	private ExtentTest logger = ExtentReportManager.getLogger();


	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']")
	private WebElement employeeListTab;
	
	@FindBy(xpath="//input[@type='checkbox']/following::td[1]/a")
	private List<WebElement> empIds;
	
	@FindBy(xpath="(//ul[@id='sidenav']/li/a)[7]")
	private WebElement salaryTab;
	
	@FindBy(xpath="//select[@id='salary_sal_grd_code']")
	private WebElement payGradeTab;
	
	@FindBy(xpath="//select[@id='salary_currency_id']")
	private WebElement currencyTab;
	
	@FindBy(xpath="//input[@id='salary_basic_salary']")
	private WebElement amountTab;
	
	@FindBy(xpath="//span[text()='Should be within Min/Max values']")
	private WebElement minMaxValidationMsg;
	
	@FindBy(xpath="//input[@id='addSalary']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@id='btnSalarySave']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='salary_salary_component']")
	private WebElement salComp;
	
	public PIM_EmployeeList(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public PIM_EmployeeList clickEmpListTab() {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, employeeListTab));
		employeeListTab.click();
		logger.log(LogStatus.PASS, "Clicked Employee List tab");
		return new PIM_EmployeeList(driver);
	}
	
	public PIM_EmployeeList clickEmpId(String emp_id) {
		
		for(WebElement id : empIds) 
		{
		//	System.out.println("emp id---  "+id.getText());
			CommonFunctions.waitForElement(driver, id);
			if(id.getText().contains(emp_id)) {				
				id.click();
		
				System.out.println("found");
				logger.log(LogStatus.PASS, "Clicked on emp id ");
			}
		}
		
		return new PIM_EmployeeList(driver);
		
	}
	
	public PIM_EmployeeList salaryTabValidationMinMaxValue(String paygrade, String currency, String amount) {
		
		try {
			CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, salaryTab)).click();
			logger.log(LogStatus.PASS, "Clicked Salary tab");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, addBtn)).click();
		logger.log(LogStatus.PASS, "Clicked Add button");
		
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, payGradeTab));
		CommonFunctions.selectFromDropdown(driver, paygrade, payGradeTab);
		logger.log(LogStatus.PASS, "Selected value from PayGrade dropdown");
		
		CommonFunctions.waitForElement(driver, currencyTab);
		CommonFunctions.selectFromDropdown(driver, currency, currencyTab);
		logger.log(LogStatus.PASS, "Selected value from Currency dropdown");
		
		CommonFunctions.makeFresh(driver, amountTab).sendKeys(amount);
		logger.log(LogStatus.PASS, "Entered value in Amount field");
		
		CommonFunctions.makeFresh(driver, salComp).sendKeys("12");
		logger.log(LogStatus.PASS, "Entered value in Salary Component field");
		
		CommonFunctions.makeFresh(driver, saveBtn).click();;
		logger.log(LogStatus.PASS, "Clicked Save button");
		
		return new PIM_EmployeeList(driver);
	}
	
	public PIM_EmployeeList clearInputBox() {
		
		CommonFunctions.makeFresh(driver, CommonFunctions.waitForElement(driver, amountTab)).clear();
		logger.log(LogStatus.PASS, "Cleared Amount input field");
		
		return new PIM_EmployeeList(driver);
	}
	
	public boolean minMaxValidationMsgVisibility() {
		CommonFunctions.waitForElement(driver, minMaxValidationMsg);
		return CommonFunctions.isElementExist(driver, minMaxValidationMsg);
	}
}

package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.base.CommonFunctions;
import com.orange.base.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	WebElement dashboardLabel;

	@FindBy(xpath="//a[contains(text(),'Welcome Admin')]")
	private static WebElement welcomeAdminLabel;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private static WebElement logoutLink;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	private WebElement adminTab;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	private WebElement pimTab;
	
	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveModule']")
	private WebElement leaveTab;
	
	@FindBy(xpath = "//a[@id='menu_time_viewTimeModule']")
	private WebElement timeTab;
	
	@FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']")
	private WebElement recruitmentTab;
	
	@FindBy(xpath = "//a[@id='menu__Performance']")
	private WebElement performanceTab;
	
	@FindBy(xpath = "//a[@id='menu_directory_viewDirectory']")
	private WebElement directoryTab;
	
	@FindBy(xpath = "//a[@id='menu_maintenance_purgeEmployee']")
	private WebElement maintenanceTab;
	
	protected WebDriver driver;
	private ExtentTest logger = ExtentReportManager.getLogger();

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	
	public boolean validateDashboardLabelPresence() {
			return CommonFunctions.ElementExistsInAnyFrame(driver, CommonFunctions.makeFresh(driver, dashboardLabel));
		}

	public boolean validateWelcomeLabelPresence() {
		return CommonFunctions.ElementExistsInAnyFrame(driver, CommonFunctions.makeFresh(driver, welcomeAdminLabel));
	}
	
	public boolean adminTabVisibility() {
		return CommonFunctions.isElementExist(driver, adminTab);
	}
	
	public boolean pimTabVisibility() {
		return CommonFunctions.isElementExist(driver, pimTab);
	}
	
	public boolean leaveTabVisibility() {
		return CommonFunctions.isElementExist(driver, leaveTab);
	}
	
	public boolean timeTabVisibility() {
		return CommonFunctions.isElementExist(driver, timeTab);
	}
	
	public boolean RecruitmentTabVisibility() {
		return CommonFunctions.isElementExist(driver, recruitmentTab);
	}
	
	public boolean PerformanceTabVisibility() {
		return CommonFunctions.isElementExist(driver, performanceTab);
	}
	
	public boolean DirectoryTabVisibility() {
		return CommonFunctions.isElementExist(driver, directoryTab);
	}
	
	public boolean MaintenanceTabVisibility() {
		return CommonFunctions.isElementExist(driver, maintenanceTab);
	}
	
	
	public AdminPage tabsVisibility() {
		return new AdminPage(driver);
	}
	
	public AdminPage clickAdminT() {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, adminTab)).click();
		return new AdminPage(driver);
	}
	
	public RecruitmentPage clickRecruitmentT() {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, recruitmentTab)).click();
		return new RecruitmentPage(driver);
	}
	
	public PIM_EmployeeList clickPIMT() {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, pimTab)).click();
		return new PIM_EmployeeList(driver);
	}
	
	public LoginPage validateLogoutFunctionality() {
		logger.log(LogStatus.PASS, "Logging out...");
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, welcomeAdminLabel)).click();
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, logoutLink)).click();
		logger.log(LogStatus.PASS, "Log out successfull...");

		return new LoginPage(driver);
	} 
	
	public static LoginPage logout(WebDriver driver) {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, welcomeAdminLabel)).click();
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, logoutLink)).click();
		return new LoginPage(driver);
	}
	
}

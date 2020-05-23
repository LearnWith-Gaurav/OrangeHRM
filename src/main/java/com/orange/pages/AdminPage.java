package com.orange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.base.CommonFunctions;
import com.orange.base.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminPage {
	
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	private WebElement adminTab;
	
	@FindBy(xpath = "//div[@id='systemUser-information']/a")
	private WebElement systemUsersHeader;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	private WebElement addBtn;
	
	@FindBy(xpath = "//input[@id='btnDelete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//input[@id='searchBtn']")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	private WebElement usernameTxtBox;
	
	@FindBy(xpath = "//tbody/tr/td[2]/a")
	private WebElement searchResultGrid;
		
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
	
	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
	private WebElement userMgmtOpt;

	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	private WebElement usersOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_Job']")
	private WebElement adminJobOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewJobTitleList']")
	private WebElement jobTitlesOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewPayGrades']")
	private WebElement payGradesOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_employmentStatus']")
	private WebElement empStatusOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_jobCategory']")
	private WebElement jobCatOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_workShift']")
	private WebElement workShiftOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_Organization']")
	private WebElement organisationOpt;
	
	
	@FindBy(xpath = "//a[@id='menu_admin_viewOrganizationGeneralInformation']")
	private WebElement organizationGeneralInformationOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewLocations']")
	private WebElement locationOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewCompanyStructure']")
	private WebElement companyStructureOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_Qualifications']")
	private WebElement qualificationOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewSkills']")
	private WebElement skillsOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewEducation']")
	private WebElement educationOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewLicenses']")
	private WebElement licensesOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewLanguages']")
	private WebElement languagesOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_membership']")
	private WebElement membershipOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_nationality']")
	private WebElement nationalityOpt;
	
	@FindBy(xpath = "//a[@id='menu_admin_Configuration']")
	private WebElement configurationOpt;
	
	protected WebDriver driver;
	private ExtentTest logger = ExtentReportManager.getLogger();

	
	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
	public boolean admintab() {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, adminTab)).click();
		logger.log(LogStatus.PASS, "Clicked Admin tab.");
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, systemUsersHeader));
		return CommonFunctions.isElementExist(driver, systemUsersHeader);
	}
	
	public void addRecord() {
		
	}
	
	public void buttonsVisibility() {
		
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

	
	public AdminPage searchResult(String name) {
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, usernameTxtBox)).sendKeys(name);
		
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, SearchBtn)).click();
		logger.log(LogStatus.PASS, "Clicked on Search Button");
		
		CommonFunctions.waitForElement(driver, CommonFunctions.makeFresh(driver, searchResultGrid));
		logger.log(LogStatus.PASS, "Search result displaying");
		
		return new AdminPage(driver);
	}
	
	public boolean validateSearchResults() {
		logger.log(LogStatus.PASS, "Search results displayed...");
		return CommonFunctions.isElementExist(driver, searchResultGrid);
	}

	public boolean usersOptVisibility() {
		return CommonFunctions.isElementExist(driver, usersOpt);
	}
	
	public boolean adminJobOptVisibility() {
		return CommonFunctions.isElementExist(driver, adminJobOpt);
	}
	
	public boolean jobTitlesOptVisibility() {
		return CommonFunctions.isElementExist(driver, jobTitlesOpt);
	}
	
	public boolean payGradesOptVisibility() {
		return CommonFunctions.isElementExist(driver, payGradesOpt);
	}
	
	public boolean empStatusOptVisibility() {
		return CommonFunctions.isElementExist(driver, empStatusOpt);
	}
	
	public boolean jobCatOptVisibility() {
		return CommonFunctions.isElementExist(driver, jobCatOpt);
	}
	
	public boolean workShiftOptVisibility() {
		return CommonFunctions.isElementExist(driver, workShiftOpt);
	}
	
	public boolean organisationOptVisibility() {
		return CommonFunctions.isElementExist(driver, organisationOpt);
	}
	
	public boolean organizationGeneralInformationOptVisibility() {
		CommonFunctions.hover(driver, organisationOpt);
		return CommonFunctions.isElementExist(driver, organizationGeneralInformationOpt);
	}
	
	public boolean locationOptVisibility() {
		CommonFunctions.hover(driver, organisationOpt);
		return CommonFunctions.isElementExist(driver, locationOpt);
	}
	
	public boolean companyStructureOptVisibility() {
		CommonFunctions.hover(driver, organisationOpt);
		return CommonFunctions.isElementExist(driver, companyStructureOpt);
	}
	
	public boolean qualificationOptVisibility() {
		return CommonFunctions.isElementExist(driver, qualificationOpt);
	}
	
	public boolean skillsOptVisibility() {
		CommonFunctions.hover(driver, qualificationOpt);
		return CommonFunctions.isElementExist(driver, skillsOpt);
	}
	
	public boolean educationOptOptVisibility() {
		CommonFunctions.hover(driver, qualificationOpt);
		return CommonFunctions.isElementExist(driver, educationOpt);
	}
	
	public boolean licensesOptVisibility() {
		CommonFunctions.hover(driver, qualificationOpt);
		return CommonFunctions.isElementExist(driver, licensesOpt);
	}
	
	public boolean languagesOptVisibility() {
		CommonFunctions.hover(driver, qualificationOpt);
		return CommonFunctions.isElementExist(driver, languagesOpt);
	}
	
	public boolean membershipOptVisibility() {
		CommonFunctions.hover(driver, qualificationOpt);
		return CommonFunctions.isElementExist(driver, membershipOpt);
	}
	
	public boolean nationalityOptVisibility() {
		return CommonFunctions.isElementExist(driver, nationalityOpt);
	}
	
	public boolean configurationOptOptVisibility() {
		return CommonFunctions.isElementExist(driver, configurationOpt);
	}
	
	
	
}

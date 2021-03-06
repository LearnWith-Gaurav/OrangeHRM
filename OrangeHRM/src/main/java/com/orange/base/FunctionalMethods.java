package com.orange.base;

import org.openqa.selenium.WebDriver;

import com.orange.pages.AdminPage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.PIM_EmployeeList;
import com.orange.pages.RecruitmentPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FunctionalMethods {
	
	AdminPage adminpage;
	HomePage homepage;
	RecruitmentPage recruitmentpage;
	PIM_EmployeeList pim_EmployeeList;

	private ExtentTest logger = ExtentReportManager.getLogger();
	
	public LoginPage openPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "opening login page");
		return new LoginPage(driver);
	}
	
	 @SuppressWarnings("unchecked")
     public <T> T loginToPortal(LoginPage loginPage, String username, String password, Class<T> loginBtn) {
             Object obj = loginPage.enterUsername(username).enterPassword(password).clickLogInBtn(loginBtn);
             
             CommonFunctions.removeLiveUI(loginPage.getDriver());
             logger.log(LogStatus.PASS, "Logging in to Pega Site");
             return (T) obj;
     }
	 
	 public HomePage loginToPortal(LoginPage loginPage, String username, String password) {
		 homepage = loginPage.enterUsername(username).enterPassword(password).clickLogInBtn();
		 return homepage;
	 }
	 
	 public AdminPage tabsVisibility(HomePage homepage) {
		 adminpage = homepage.tabsVisibility();
		 logger.log(LogStatus.PASS, "Checking tabs vibility on Homepage..");
		 return adminpage;
	 }
	 
	 public HomePage elementVisibility(HomePage homepage) {
		
		 return homepage;
	 }
	 
	 public AdminPage clickAdminTab(HomePage homepage) {
		 adminpage = homepage.clickAdminT();
		 logger.log(LogStatus.PASS, "Navigating to Admin Tab");
		 return adminpage;
	 }
	 
	 public RecruitmentPage clickRecruitmentTab(HomePage homepage) {
		 recruitmentpage = homepage.clickRecruitmentT();
		 logger.log(LogStatus.PASS, "Navigating to Recruitment Tab");
		 return recruitmentpage;
	 }
	
	 public PIM_EmployeeList clickPIMtTab(HomePage homepage) {
		 pim_EmployeeList = homepage.clickPIMT();
		 logger.log(LogStatus.PASS, "Navigating to PIM page");
		return pim_EmployeeList;
	 }
}

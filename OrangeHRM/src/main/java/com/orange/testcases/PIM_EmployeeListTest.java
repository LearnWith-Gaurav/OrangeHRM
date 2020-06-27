package com.orange.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.orange.base.CommonFunctions;
import com.orange.base.CoreTestCase;
import com.orange.base.FunctionalMethods;
import com.orange.base.GlobalDataProvider;
import com.orange.base.InputEnvironmentDetails;
import com.orange.base.InputTestDetails;
import com.orange.pages.AdminPage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.NavigationClass;
import com.orange.pages.PIM_EmployeeList;
import com.orange.pages.RecruitmentPage;

public class PIM_EmployeeListTest extends CoreTestCase{

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_checkEmpId(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
	
		LoginPage loginpage;
		HomePage homepage;
		AdminPage adminpage;
		RecruitmentPage recruitmentpage; 
		NavigationClass navigationClass;
		PIM_EmployeeList pimEmpList;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		
		//opening login portal
		loginpage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());
			
		//verify login page is displayed
		assertTrue(loginpage.validatePageLogo(), "Login unsuccessfull");
		System.out.println("login page Logo Displayed");
		
		homepage = functionalMethods.loginToPortal(loginpage, testData.getTestdata()[0], testData.getTestdata()[1]);
			
		pimEmpList = functionalMethods.clickPIMtTab(homepage);
		
		pimEmpList = pimEmpList.clickEmpListTab();
		
		try {
			pimEmpList = pimEmpList.clickEmpId(testData.getTestdata()[2]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		pimEmpList = pimEmpList.salaryTabValidationMinMaxValue(testData.getTestdata()[3], testData.getTestdata()[4], testData.getTestdata()[5]);
		
		assertTrue(pimEmpList.minMaxValidationMsgVisibility(), "Validation message not displayed");
		
		pimEmpList.clearInputBox();
		
		pimEmpList = pimEmpList.salaryTabValidationMinMaxValue(testData.getTestdata()[3], testData.getTestdata()[4], testData.getTestdata()[8]);
		
		assertTrue(pimEmpList.minMaxValidationMsgVisibility(), "Validation message not displayed");
		
		pimEmpList.clearInputBox();
		
	}
}

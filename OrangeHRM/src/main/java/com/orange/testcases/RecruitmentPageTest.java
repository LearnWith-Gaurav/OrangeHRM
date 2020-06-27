package com.orange.testcases;

import static com.orange.base.CommonFunctions.assertTrue;

import org.testng.annotations.Test;

import com.orange.base.CoreTestCase;
import com.orange.base.FunctionalMethods;
import com.orange.base.GlobalDataProvider;
import com.orange.base.InputEnvironmentDetails;
import com.orange.base.InputTestDetails;
import com.orange.pages.AdminPage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.NavigationClass;
import com.orange.pages.RecruitmentPage;

public class RecruitmentPageTest extends CoreTestCase{

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_validationMsgs(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
	
		LoginPage loginpage;
		HomePage homepage;
		AdminPage adminpage;
		RecruitmentPage recruitmentpage; 
		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		
		//opening login portal
		loginpage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());
			
		//verify login page is displayed
		assertTrue(loginpage.validatePageLogo(), "Login unsuccessfull");
		System.out.println("login page Logo Displayed");
		
		homepage = functionalMethods.loginToPortal(loginpage, testData.getTestdata()[0], testData.getTestdata()[1]);
			
		recruitmentpage = functionalMethods.clickRecruitmentTab(homepage);
		
		recruitmentpage = recruitmentpage.clickAddBtn();
		
		recruitmentpage = recruitmentpage.clickSaveBtn();
		
		assertTrue(recruitmentpage.validationMsgFirstName(), "Validation Msg 1 not displayed");
		
		assertTrue(recruitmentpage.validationMsgLastName(), "Validation Msg 2 not displayed");
		
		assertTrue(recruitmentpage.validationMsgEmail(), "Validation Msg 3 not displayed");
	}
}

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

public class AdminPageTest extends CoreTestCase{

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_searchAdmin(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
		LoginPage loginpage;
		HomePage homepage;
		AdminPage adminpage;
		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		
		//opening login portal
		loginpage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());
			
		//verify login page is displayed
		assertTrue(loginpage.validatePageLogo(), "Login unsuccessfull");
		System.out.println("login page Logo Displayed");
		
		homepage = functionalMethods.loginToPortal(loginpage, testData.getTestdata()[0], testData.getTestdata()[1]);
			
	//	assertTrue(loginpage.validatePageLogo(),"Admin tab not displayed");
		
		adminpage = functionalMethods.clickAdminTab(homepage);

		adminpage = adminpage.searchResult(testData.getTestdata()[2]);
		
		assertTrue(adminpage.validateSearchResults(), "Results not matched");
	}
	

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_visiblityOfAdminSubTabs(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
		LoginPage loginpage;
		HomePage homepage;
		AdminPage adminpage;
		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		
		//opening login portal
		loginpage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());
			
		//verify login page is displayed
		assertTrue(loginpage.validatePageLogo(), "Login unsuccessfull");
		System.out.println("login page Logo Displayed");
		
		homepage = functionalMethods.loginToPortal(loginpage, testData.getTestdata()[0], testData.getTestdata()[1]);
	
		adminpage = functionalMethods.tabsVisibility(homepage);
		
		assertTrue(adminpage.admintab(),"Admin tab success");
		
		assertTrue(adminpage.organisationOptVisibility(), "Organisation option not visible...");
		
		assertTrue(adminpage.locationOptVisibility(), "Location option not visible...");
		
		assertTrue(adminpage.companyStructureOptVisibility(), "Company Structure option not visible...");
		
		assertTrue(adminpage.qualificationOptVisibility(), "Qualification option not visible...");
		
		assertTrue(adminpage.skillsOptVisibility(), "Skill option not visible...");
		
		assertTrue(adminpage.educationOptOptVisibility(), "Education option not visible...");
		
		assertTrue(adminpage.licensesOptVisibility(), "Licences option not visible...");
		
		assertTrue(adminpage.languagesOptVisibility(), "Languages option not visible...");
		
		assertTrue(adminpage.membershipOptVisibility(), "Membership option not visible...");
		
		assertTrue(adminpage.nationalityOptVisibility(), "Nationality option not visible...");
		
		assertTrue(adminpage.configurationOptOptVisibility(), "Configuration option not visible...");
	}
}

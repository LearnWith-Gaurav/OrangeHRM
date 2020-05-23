package com.orange.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orange.base.CommonFunctions;
import com.orange.base.CoreTestCase;
import com.orange.base.ExtentReportManager;
import com.orange.base.FunctionalMethods;
import com.orange.base.GlobalDataProvider;
import com.orange.base.InputEnvironmentDetails;
import com.orange.base.InputTestDetails;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.NavigationClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends CoreTestCase{

	
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_dashboard(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
		LoginPage loginpage;
		HomePage homepage;
		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		
		//opening login portal
		loginpage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());
	
		//verify login page is displayed
		assertTrue(loginpage.validatePageLogo(), "Login unsuccessfull");
		System.out.println("login page Logo Displayed");
		
		functionalMethods.loginToPortal(loginpage, testData.getTestdata()[0], testData.getTestdata()[1], LoginPage.class);
	
	}
}

package com.orange.testcases;

import static com.orange.base.CommonFunctions.assertTrue;
import static com.orange.base.CommonFunctions.assertFalse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orange.base.CoreTestCase;
import com.orange.base.GlobalDataProvider;
import com.orange.pages.HomePage;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;

public class LoginPageTest extends CoreTestCase{

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test1() {
	HomePage hp2;
	
	}
}

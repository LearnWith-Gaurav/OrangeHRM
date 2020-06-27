package com.orange.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static com.orange.base.GlobalThings.listOfBrowser;
import static com.orange.base.GlobalThings.listOfEnv;
import static com.orange.base.GlobalThings.listOfTestSkipped;
import static com.orange.base.CommonFunctions.curDir;

public class ExtentReportManager {

	 static ExtentReports extentReports;
     private static Map<Long, ExtentTest> mapExtentTests = new HashMap<>();

     private ExtentReportManager() {

     }
     /**

     * Author : Gaurav Description : Initialization of Extent Report

     */

     public static void createExtentReport() {
            // File Location where the Report is generated

            extentReports = new ExtentReports(curDir + "/Extent_Report.html");

            // Load Config XML file

            extentReports.loadConfig(new File(GlobalThings.extentConfigFile));
     }


     public static synchronized ExtentTest getLogger() {

            return mapExtentTests.get(Thread.currentThread().getId());
     }
 
     public static synchronized ExtentTest startTest(String testName, String description) {

            ExtentTest test = extentReports.startTest(testName, description);

            mapExtentTests.put(Thread.currentThread().getId(), test);

            return test;

     }

     public static synchronized void endTest() {

            extentReports.endTest(mapExtentTests.get(Thread.currentThread().getId()));
     }

     public static void getSystemInfoForExtentReport() {

            // Add Environment Details to the System Info

            for (InputEnvironmentDetails e : listOfEnv) {

                   extentReports.addSystemInfo("Environment", e.getEnvironment());

            }

            // Add Browser Details to the System Info

            for (InputBrowserDetails b : listOfBrowser) {

                   extentReports.addSystemInfo("Browser", b.getBrowserName());

            }

     }

     public static void addSkippedTestCasesToReport() {

            for (InputTestDetails e : listOfTestSkipped) {

                   startTest(e.getFunctionality(), e.getTestCaseDescription());

                   getLogger().log(LogStatus.SKIP, "Skipped Test Case");

                   extentReports.endTest(getLogger());

            }

     }


}

package com.orange.base;

import static com.orange.base.GlobalThings.startTime_Excution;
import static com.orange.base.GlobalThings.listOfsuite;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		startTime_Excution = System.currentTimeMillis();
		CommonFunctions.createReportDirectory();
		CommonFunctions.getEnvironemtToBeExecuted();
		CommonFunctions.getEmailAddresses();
		CommonFunctions.getSuiteToBeExecuted();
		CommonFunctions.getBrowserToBeExecuted();
		for (InputSuiteDetails suite : listOfsuite) {
			CommonFunctions.getTestsToBeExecuted(suite.getModule().toString());
		}
		XML.createXMLFile();
		XML.saveXml();
		XML.triggerXml();
		System.exit(0);
	
	}

}

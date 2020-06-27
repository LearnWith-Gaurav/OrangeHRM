package com.orange.base;

public class InputTestDetails {

	 private String testCaseID, functionality, functionalityFlow, testCaseDescription, module, execute, environment;

     private String[] testdata;

     private String[] expectedResult;



     public InputTestDetails() {

            this.testCaseID = "";

            this.functionality = "";

            this.testCaseDescription = "";

            this.module = "";

            this.functionalityFlow = "";

            this.execute = "N";

     }



     public String getTestCaseID() {

            return testCaseID;

     }



     public void setTestCaseID(String testCaseID) {

            this.testCaseID = testCaseID;

     }



     public String getEnvironment() {

            return environment;

     }



     public void setEnvironment(String environment) {

            this.environment = environment;

     }



     public String getTestCaseDescription() {

            return testCaseDescription;

     }



     public void setTestCaseDescription(String description) {

            this.testCaseDescription = description;

     }



     public String getModule() {

            return module;

     }



     public void setModule(String module) {

            this.module = module;

     }



     public String getExecute() {

            return execute;

     }



     public void setExecute(String execute) {

            this.execute = execute;

     }



     public String getFunctionality() {

            return functionality;

     }



     public void setFunctionality(String functionality) {

            this.functionality = functionality;

     }



     public String getFunctionalityFlow() {

            return functionalityFlow;

     }



     public void setfunctionalityFlow(String functionalityFlow) {

            this.functionalityFlow = functionalityFlow;

     }



     public String[] getTestdata() {

            return testdata;

     }



     public void setTestdata(String[] testdata) {

            this.testdata = testdata;

     }



     public String[] getExpectedResult() {

            return expectedResult;

     }



     public void setExpectedResult(String[] expectedResult) {

            this.expectedResult = expectedResult;

     }
}

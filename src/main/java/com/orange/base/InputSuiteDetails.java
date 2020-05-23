package com.orange.base;

public class InputSuiteDetails {

	 private String suiteID, suiteDescription, module, execute;

	 

     public InputSuiteDetails() {

            this.suiteID = "";

            this.suiteDescription = "";

            this.module = "";

            this.execute = "N";



     }



     public String getsuiteID() {

            return suiteID;

     }



     public void setsuiteID(String testCaseID) {

            this.suiteID = testCaseID;

     }



     public String getsuiteDescription() {

            return suiteDescription;

     }



     public void setsuiteDescription(String description) {

            this.suiteDescription = description;

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


}

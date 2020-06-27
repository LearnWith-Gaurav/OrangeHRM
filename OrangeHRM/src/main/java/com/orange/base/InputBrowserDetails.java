package com.orange.base;

public class InputBrowserDetails {

	  private String browserName, execute;
	  
      public InputBrowserDetails() {
              this.browserName = "";
              this.execute = "N";
      }

      public String getBrowserName() {
              return browserName;
      }

      public void setBrowserName(String countryName) {
              this.browserName = countryName;
      }

      public String getExecute() {
              return execute;
      }

      public void setExecute(String execute) {
              this.execute = execute;
      }
}

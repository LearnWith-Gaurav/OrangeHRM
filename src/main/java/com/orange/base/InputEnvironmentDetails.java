package com.orange.base;

public class InputEnvironmentDetails {

	   private String ID, Environment, Url, Username, Password, Execute;

	   

       public InputEnvironmentDetails() {

              this.ID = "";

              this.Environment = "";

              this.Url = "";

              this.Execute = "N";

              this.Username = "";

              this.Password = "";

       }

 

       public String getID() {

              return ID;

       }

 

       public void setID(String ID) {

              this.ID = ID;

       }

 

       public String getEnvironment() {

              return Environment;

       }

 

       public void setEnvironment(String Environment) {

              this.Environment = Environment;

       }

 

       public String getUrl() {

              return Url;

       }

 

       public void setUrl(String Url) {

              this.Url = Url;

       }

 

       public String getUsername() {

              return Username;

       }

 

       public void setUsername(String Username) {

              this.Username = Username;

       }

 

       public String getPassword() {

              return Password;

       }

 

       public void setPassword(String Password) {

              this.Password = Password;

       }

 

       public String getExecute() {

              return Execute;

       }

 

       public void setExecute(String Execute) {

              this.Execute = Execute;

       }
}

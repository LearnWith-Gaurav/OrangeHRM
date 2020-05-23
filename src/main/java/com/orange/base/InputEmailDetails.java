package com.orange.base;

public class InputEmailDetails {

	private String emailType, sendEmail;

    private String[] emailAddress;



    public InputEmailDetails() {

           this.emailType = "";

           this.sendEmail = "N";

    }



    public String getEmailType() {

           return emailType;

    }



    public void setEmailType(String emailType) {

           this.emailType = emailType;

    }



    public String[] getEmailAddress() {

           return emailAddress;

    }



    public void setEmailAddress(String[] emailAddress) {

           this.emailAddress = emailAddress;

    }



    public String getSendEmail() {

           return sendEmail;

    }



    public void setSendEmail(String sendEmail) {

           this.sendEmail = sendEmail;

    }
}

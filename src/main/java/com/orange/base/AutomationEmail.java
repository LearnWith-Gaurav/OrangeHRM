package com.orange.base;

import static com.orange.base.CoreTestCase.failedCount;
import static com.orange.base.GlobalThings.listOfEmail;
import static com.orange.base.GlobalThings.testResultReports;
import static com.orange.base.GlobalThings.timeForExecution;
import static com.orange.base.GlobalThings.totalTestCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class AutomationEmail {


    public static void sendEmail() throws Exception {

           try {

                  // Set Message Details

                  String mailFrom = "learnwithgauravwani@gmail.com";

                  String MailSubject = "Automation - Result Report";

                  String fileAttachmentPath = CommonFunctions.curDir + "/TestReport.xls";

                  String extentReportPath = CommonFunctions.curDir + "/Extent_Report.html";

                  List<String> mailTos = new ArrayList<String>();

                  List<String> mailCCs = new ArrayList<String>();

                  List<String> mailBCCs = new ArrayList<String>();



                  addEmailAddressesToLists(mailTos, mailCCs, mailBCCs);



                  // Set Message Body

                  Multipart multipart = new MimeMultipart();

                  multipart.addBodyPart(getMessageBodyPart());

                  multipart.addBodyPart(getMessageAttachmentPart(fileAttachmentPath, "TestReport.xls"));

                  multipart.addBodyPart(getMessageAttachmentPart(extentReportPath, "Extent Report.html"));



                  Message message = defineMessage(mailFrom, mailTos, mailCCs, mailBCCs, MailSubject, multipart);



                  // Send the message

                  Transport.send(message);

           } catch (Exception e) {

           }

    }



    public static void sendFailedTCEmail(String SSpath, String exceptionError, String testCaseId,

                  String testCaseDescription, String flow) throws Exception {

           try {

                  // Set Message Details

                  String mailFrom = "learnwithgauravwani@gmail.com";

                  String MailSubject = "Automation - Failed Test Case Report";

                  List<String> mailTos = new ArrayList<String>();

                  List<String> mailCCs = new ArrayList<String>();

                  List<String> mailBCCs = new ArrayList<String>();



                  addEmailAddressesToLists(mailTos, mailCCs, mailBCCs);



                  // Set Message Body

                  Multipart multipart = new MimeMultipart();

                  multipart.addBodyPart(getFailedTCMessageBodyPart(exceptionError, testCaseId, testCaseDescription, flow));

                  multipart.addBodyPart(getFailedTCMessageAttachmentPart(SSpath, testCaseId));



                  Message message = defineMessage(mailFrom, mailTos, mailCCs, mailBCCs, MailSubject, multipart);



                  // Send the message

                  Transport.send(message);

           } catch (Exception e) {

           }

    }



    private static Message defineMessage(String mailFrom, List<String> mailTos, List<String> mailCCs,

                  List<String> mailBCCs, String MailSubject, Multipart multipart)

                  throws MessagingException, AddressException {

           // Define message

           Message message = new MimeMessage(getSession());

           message.setFrom(new InternetAddress(mailFrom));

           for (String mailTo : mailTos) {

                  if (!mailTo.isEmpty())

                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));

           }

           for (String mailCC : mailCCs) {

                  if (!mailCC.isEmpty())

                        message.addRecipient(Message.RecipientType.CC, new InternetAddress(mailCC));

           }

           for (String mailBCC : mailBCCs) {

                  if (!mailBCC.isEmpty())

                        message.addRecipient(Message.RecipientType.BCC, new InternetAddress(mailBCC));

           }

           message.setSubject(MailSubject);

           message.setContent(multipart);

           return message;

    }



    private static Session getSession() {

           Properties properties = System.getProperties();

           properties.setProperty("mail.smtp.host", "smtp.gmail.com");

           Session session = Session.getDefaultInstance(properties);

           return session;

    }



    private static BodyPart getMessageBodyPart() throws MessagingException {

           BodyPart messageBodyPart = new MimeBodyPart();

           String mailBody = "Total Number of test cases Executed: " + testResultReports.size()

                        + "\n\nTotal Number of test cases Failed: " + failedCount

                        + "\n\nHealth of System (Passing percentage): "

                        + ((float) (totalTestCases - failedCount) / totalTestCases) * 100 + " %" + "\n\nTime for execution is "

                        + (timeForExecution / 1000) / 60 + " Minute(s) " + (timeForExecution / 1000) % 60 + " Second(s)"

                        + "\n\nThe detailed test report is attached herewith.";



           messageBodyPart.setText(mailBody);

           return messageBodyPart;

    }



    private static BodyPart getFailedTCMessageBodyPart(String excpError, String testCaseId, String testCaseDes,

                  String flow) throws MessagingException {

           BodyPart messageBodyPart = new MimeBodyPart();

           String mailBody = "Test Case Id: " + testCaseId + "\n\nTest Case Description: " + testCaseDes

                        + "\n\nFunctional Flow: " + flow + "\n\nCause Of Failure: " + excpError

                        + "\n\nThe Screen Shot is attached herewith.";

           messageBodyPart.setText(mailBody);

           return messageBodyPart;

    }



    private static BodyPart getFailedTCMessageAttachmentPart(String fileAttachmentPath, String testCaseId)

                  throws MessagingException {

           File fileAddress = new File(fileAttachmentPath);

           BodyPart messageBodyPart;

           messageBodyPart = new MimeBodyPart();

           DataSource source = new FileDataSource(fileAddress);

           messageBodyPart.setDataHandler(new DataHandler(source));

           messageBodyPart.setFileName(testCaseId + ".png");

           return messageBodyPart;

    }



    private static BodyPart getMessageAttachmentPart(String fileAttachmentPath, String fileName)

                  throws MessagingException {

           File fileAddress = new File(fileAttachmentPath);

           BodyPart messageBodyPart;

           messageBodyPart = new MimeBodyPart();

           DataSource source = new FileDataSource(fileAddress);

           messageBodyPart.setDataHandler(new DataHandler(source));

           messageBodyPart.setFileName(fileName);

           return messageBodyPart;

    }



    private static void addEmailAddressesToLists(List<String> mailTos, List<String> mailCCs, List<String> mailBCCs) {

           try {

                  for (InputEmailDetails e : listOfEmail) {

                        if (e.getEmailType().equals("To") && (e.getEmailAddress() != null)) {

                               Collections.addAll(mailTos, e.getEmailAddress());

                        } else if (e.getEmailType().equals("CC") && (e.getEmailAddress() != null)) {

                               Collections.addAll(mailCCs, e.getEmailAddress());

                        } else if (e.getEmailType().equals("BCC") && (e.getEmailAddress() != null)) {

                               Collections.addAll(mailBCCs, e.getEmailAddress());

                        }

                  }

           } catch (Exception e) {

                  throw new RuntimeException("Please configure at least one Email Address");

           }

    }


}

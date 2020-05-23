package com.orange.base;

import static com.orange.base.CoreTestCase.failedCount;
import static com.orange.base.GlobalThings.testResultReports;
import static com.orange.base.GlobalThings.timeForExecution;
import static com.orange.base.GlobalThings.totalTestCases;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailSSLWithAttachment {

	public static void sendEmail() {

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication("learnwithgauravwani@gmail.com", "life7rules");

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("learnwithgauravwani@gmail.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("learnwithgauravwani@gmail.com"));
            
                        // Add the subject link
			message.setSubject("Orange HRM Automation Report");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("");
			

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = CommonFunctions.curDir + "/Extent_Report.html";

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
			
			multipart.addBodyPart(getMessageBodyPart());

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
	
	private static BodyPart getMessageBodyPart() throws MessagingException {

        BodyPart messageBodyPart1 = new MimeBodyPart();

        String mailBody = "Total Number of test cases Executed: " + testResultReports.size()

                     + "\n\nTotal Number of test cases Failed: " + failedCount

                     + "\n\nHealth of System (Passing percentage): "

                     + ((float) (totalTestCases - failedCount) / totalTestCases) * 100 + " %" + "\n\nTime for execution is "

                     + (timeForExecution / 1000) / 60 + " Minute(s) " + (timeForExecution / 1000) % 60 + " Second(s)"

                     + "\n\nThe detailed test report is attached herewith.";



        messageBodyPart1.setText(mailBody);

        return messageBodyPart1;

 }

}

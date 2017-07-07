package com.synergy.insurance.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void sendEmail(int applicationId, String toEmail) {
		final String fromEmail = "wong.kar.eric@gmail.com";
		final String password = "tempPassword";
		String uri = "http://localhost:8080/insurance-bank/webapi/fileUpload?applicationId=" + applicationId;
		String messageBody = "Please visit the following link and upload the necessary documents: " + uri;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail,password);
				}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("File Upload");
			message.setText(messageBody);
			Transport.send(message);
		}
		catch(MessagingException e) {
			
		}
	}
}

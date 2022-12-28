package com.email.service;

import java.util.Properties;

import javax.mail.Authenticator;
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
	public boolean sendEmail(String subject, String msg, String to) throws MessagingException
	{
		boolean f=false;
		String from="jadhav.govardhan11@gmail.com";
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		System.out.println("Properties"+properties);
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		Session session=
		Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("jadhav.govardhan11@gmail.com","Govdhan@1993");
			}
			
		
		});
		session.setDebug(true);
		MimeMessage mimeMessage=new MimeMessage(session);
		mimeMessage.setFrom(from);
		mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(msg);
		Transport.send(mimeMessage);
		System.out.println("msg has been send Sucessfully");
		f=true;
		return f;
	}

}

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
	public boolean sendEmail(String sunbject, String msg, String to) throws MessagingException
	{
		boolean f=false;
		String from="newpan20222607@gmail.com";
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		System.out.println("Properties"+properties);
		
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		Session session=
		Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("newpan20222607@gmail.com","Govardhan@1993");
			}
			
		
		});
		session.setDebug(true);
		MimeMessage mimeMessage=new MimeMessage(session);
		mimeMessage.setFrom(from);
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mimeMessage.setText(msg);
		mimeMessage.setSubject(sunbject);
		
		Transport.send(mimeMessage);
		System.out.println("msg has been send Sucessfully");
		f=true;
		return f;
	}

}

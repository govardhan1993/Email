package com.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailModel;
import com.email.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping()
	public String Welcome()
	{
		return "Welcom";
	}
	
	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody EmailModel model) throws MessagingException
	{
		System.out.println(model);
			boolean result=this.emailService.sendEmail(model.getTo(),model.getMsg(), model.getSunbject());
		
		if(result)
		{
			return ResponseEntity.ok("Email Send Sucess");
		}else
		{
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Email not Send");
		}
		
	}
}

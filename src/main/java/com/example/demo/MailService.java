package com.example.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String to, String subject, String text, AbstractResource file) {
		MimeMessage msg = sender.createMimeMessage();
		boolean issent = false;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, file!=null);
			helper.setTo(to);
			helper.setSubject(subject);
			if (text != null) {
			helper.setText(text);	
			}
			if(file!=null) {
			helper.addAttachment(file.getFilename(), file);
			}
			sender.send(msg);
			issent = true;
			
		} catch (MessagingException e) {
			issent = false;
			e.printStackTrace();
		}
		return issent;
	}
	
	public boolean send(String to, String subject) {
		return send(to, subject, null, null);
	}
	
	public boolean send(String to, String subject, String text) {
		return send(to, subject, text, null);
	}

}

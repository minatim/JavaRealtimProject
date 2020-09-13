package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
@Autowired
private MailService service;
	
	@Override
	public void run(String... args) throws Exception {
//FileSystemResource file = new FileSystemResource("C:\\Users\\ASUS\\Pictures\\ss.jpg");
boolean sent = service.send("minati.mahapatra12@gmail.com", "test", "neww", null);
if(sent) {
	System.out.println("done"); }
else {
	System.out.println("failed");
	}
	}
}

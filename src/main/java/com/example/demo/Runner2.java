package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class Runner2 implements CommandLineRunner {
@Autowired
private MailService service;

@Autowired
private PdfGenerator gene;

	@Override
	public void run(String... args) throws Exception {
EmailRequest req = new EmailRequest();
List<String> list = new ArrayList<>();
list.add("7204706926");
req.setTo("mini@gmail.com"); req.setSubject("pdftest"); req.setMobNumber(list);
req.setCustName("bubuminu"); req.setBody("success"); req.setEnrollNo("834205");

String fileName = gene.generate(req);
System.out.println(fileName);

FileSystemResource file = new FileSystemResource("E:\\AMBC-Boot\\Boot-Mail\\src\\main\\resources\\pdf"+ fileName);
boolean sent = service.send("minati.mahapatra12@gmail.com", "test", "neww", file);
if(sent) {
	System.out.println("done");	
	System.out.println(gene.deletePdf(fileName));
}
else {
	System.out.println("failed");
	}
	}
}

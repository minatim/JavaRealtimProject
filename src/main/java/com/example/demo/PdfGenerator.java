package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public String generate(EmailRequest req) {
		Document doc = new Document(PageSize.A4, 20, 20, 10, 10);
		//String filePath = context.getRealPath("/resources");
    String filePath = "E:\\AMBC-Boot\\Boot-Mail\\src\\main\\resources\\pdf";
		File filePdf = new File(filePath);		
		boolean exists = new File(filePath).exists();
		System.out.println(exists);
		if(!exists) {
			new File(filePath).mkdirs();
		}
		String pdfName = req.getEnrollNo()+"enroll"+".pdf"	;
		
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(filePdf +pdfName));			
			doc.open();
			Font headingfont = FontFactory.getFont("Arial",20, BaseColor.RED);
			Paragraph para = new Paragraph("Enrollment Details", headingfont);
			para.setAlignment(100); para.setAlignment(1);
			para.setIndentationLeft(25);
			para.setIndentationRight(25);
			para.setSpacingAfter(5.2f);
			doc.add(para);
			
			Font mainfont = FontFactory.getFont("Arial",15, BaseColor.ORANGE);
			Paragraph para2 = new Paragraph("Download the SBI Card App on your smartphone from Play Store & App Store and access your card account details on the go. SBI Card Mobile App is one of the highest rated in its category, both on Android and iOS; and is completely secure. You can register directly via the App or access your account using convenient login options like MPIN or Touch ID or online credentials.",
												mainfont);
			para2.setAlignment(100); para.setAlignment(1);
			para2.setIndentationLeft(25);
			para2.setIndentationRight(25);
			para2.setSpacingAfter(5.2f);
			doc.add(para2);
		
			PdfPTable  table = new PdfPTable(3);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10);
			table.setSpacingAfter(10);
			
			Font tableHeader = FontFactory.getFont("Arial", 15, BaseColor.BLUE);
			Font tableBody = FontFactory.getFont("Arial" , 10, BaseColor.BLACK);
			
			float[] columnwidth = {2f, 2f, 2f};
			table.setWidths(columnwidth);
			
			PdfPCell name = new PdfPCell(new Paragraph("Name", tableHeader));
			name.setBorderColor(BaseColor.GREEN);
			name.setPadding(10);
			name.setHorizontalAlignment(Element.ALIGN_CENTER);
			name.setVerticalAlignment(Element.ALIGN_CENTER);
			name.setBackgroundColor(BaseColor.GRAY);
			name.setExtraParagraphSpace(5f);
			table.addCell(name);
			
			PdfPCell mobile = new PdfPCell(new Paragraph("Mobile No", tableHeader));
			mobile.setBorderColor(BaseColor.GREEN);
			mobile.setPadding(10);
			mobile.setHorizontalAlignment(Element.ALIGN_CENTER);
			mobile.setVerticalAlignment(Element.ALIGN_CENTER);
			mobile.setBackgroundColor(BaseColor.GRAY);
			mobile.setExtraParagraphSpace(5f);
			table.addCell(mobile);
			
			PdfPCell enrollNo = new PdfPCell(new Paragraph("Enrollment No", tableHeader));
			enrollNo.setBorderColor(BaseColor.GREEN);
			enrollNo.setPadding(10);
			enrollNo.setHorizontalAlignment(Element.ALIGN_CENTER);
			enrollNo.setVerticalAlignment(Element.ALIGN_CENTER);
			enrollNo.setBackgroundColor(BaseColor.GRAY);
			enrollNo.setExtraParagraphSpace(5f);
			table.addCell(enrollNo);
			
			PdfPCell nameValue = new PdfPCell(new Paragraph(req.getCustName(), tableBody));
			nameValue.setBorderColor(BaseColor.GREEN);
			nameValue.setPadding(10);
			nameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			nameValue.setVerticalAlignment(Element.ALIGN_CENTER);
			nameValue.setBackgroundColor(BaseColor.WHITE);
			nameValue.setExtraParagraphSpace(5f);
			table.addCell(nameValue);
			
			PdfPCell mobileValue = new PdfPCell(new Paragraph(req.getMobNumber().get(0), tableBody));
			mobileValue.setBorderColor(BaseColor.GREEN);
			mobileValue.setPadding(10);
			mobileValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			mobileValue.setVerticalAlignment(Element.ALIGN_CENTER);
			mobileValue.setBackgroundColor(BaseColor.WHITE);
			mobileValue.setExtraParagraphSpace(5f);
			table.addCell(mobileValue);
			
			PdfPCell enrollNoValue = new PdfPCell(new Paragraph(req.getEnrollNo(), tableBody));
			enrollNoValue.setBorderColor(BaseColor.GREEN);
			enrollNoValue.setPadding(10);
			enrollNoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			enrollNoValue.setVerticalAlignment(Element.ALIGN_CENTER);
			enrollNoValue.setBackgroundColor(BaseColor.WHITE);
			enrollNoValue.setExtraParagraphSpace(5f);
			table.addCell(enrollNoValue);
			
			doc.add(table);
			doc.close();
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return pdfName;

	}
	public boolean deletePdf(String pdfName) {
		boolean flag = false;
		try {
			return flag = Files.deleteIfExists(Paths.get("E:\\AMBC-Boot\\Boot-Mail\\src\\main\\resources\\pdf" + pdfName));
		} catch (IOException e) {
			e.printStackTrace();
			return flag;
		}
	}
	
}

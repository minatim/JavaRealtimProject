/**
 *@Copyright CitiBank Pvt Ltd. All rights are reserved 2020,
 * You should not disclose the information outside 
 *otherwise Terms and Conditions will apply
 */
package com.example.demo;

import java.util.List;

/**
 * @author ASUS, 12-Jun-2020
 *
 * @Description :
 */
public class EmailRequest {
	private String from;
	private String toBcc;
	private String toCc;
	private String to;	
	private String body;
	private String subject;
	private String enrollNo;
	private String custName;
	private List<String> mobNumber;
	private String attachment;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getToBcc() {
		return toBcc;
	}
	public void setToBcc(String toBcc) {
		this.toBcc = toBcc;
	}
	public String getToCc() {
		return toCc;
	}
	public void setToCc(String toCc) {
		this.toCc = toCc;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEnrollNo() {
		return enrollNo;
	}
	public void setEnrollNo(String enrollNo) {
		this.enrollNo = enrollNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public List<String> getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(List<String> mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}

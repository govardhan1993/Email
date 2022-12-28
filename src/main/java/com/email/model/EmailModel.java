package com.email.model;


public class EmailModel {

	private String to;
	private String msg;
	private String sunbject;
	public EmailModel(String to, String msg, String sunbject) {
		super();
		this.to = to;
		this.msg = msg;
		this.sunbject = sunbject;
	}
	public EmailModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSunbject() {
		return sunbject;
	}
	public void setSunbject(String sunbject) {
		this.sunbject = sunbject;
	}
	@Override
	public String toString() {
		return "EmailModel [to=" + to + ", msg=" + msg + ", sunbject=" + sunbject + "]";
	}
	
	
	
}
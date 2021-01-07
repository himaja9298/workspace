package com.nt.vo;

public class CustomerVO {
	private String cname;
	private String cadd;
	private String pamt;
	private String rate;
	private String time;
	
	
	//getter methods
	public String getCname() {
		return cname;
	}
	public String getCadd() {
		return cadd;
	}
	public String getPamt() {
		return pamt;
	}
	public String getRate() {
		return rate;
	}
	public String getTime() {
		return time;
	}
	//setter methods
 	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public void setPamt(String pamt) {
		this.pamt = pamt;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public void setTime(String time) {
		this.time = time;
	}
	}

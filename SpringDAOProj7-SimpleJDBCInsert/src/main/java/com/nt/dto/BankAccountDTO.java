package com.nt.dto;

import java.io.Serializable;

public class BankAccountDTO implements Serializable {

	private Double actno;
	private String cname;
	private Float balamnt;
	
	//setters&getters
	public Double getActno() {
		return actno;
	}
	public void setActno(Double actno) {
		this.actno = actno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Float getBalamnt() {
		return balamnt;
	}
	public void setBalamnt(Float balamnt) {
		this.balamnt = balamnt;
	}
	
	//toString()
	@Override
	public String toString() {
		return "BankAccountBO [actno=" + actno + ", cname=" + cname + ", balamnt=" + balamnt + "]";
	}
	
	


}

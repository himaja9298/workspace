package com.nt.bo;

public class BankAccountBO {
	private double actno;
	private String cname;
	private float balamnt;
	
	//setters&getters
	public double getActno() {
		return actno;
	}
	public void setActno(double actno) {
		this.actno = actno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public float getBalamnt() {
		return balamnt;
	}
	public void setBalamnt(float balamnt) {
		this.balamnt = balamnt;
	}
	
	//toString()
	@Override
	public String toString() {
		return "BankAccountBO [actno=" + actno + ", cname=" + cname + ", balamnt=" + balamnt + "]";
	}
	

}

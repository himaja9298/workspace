package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class Person {
	private int pno;
	private String pname;
	private String padd;
	
	//setters
	@Required
	public void setPno(int pno) {
		this.pno = pno;
	}
	@Required
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPadd(String padd) {
		this.padd = padd;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Person [pno=" + pno + ", pname=" + pname + ", padd=" + padd + "]";
	}

}

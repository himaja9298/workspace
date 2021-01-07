package com.nt.beans;

import java.util.Date;

public class Department {
	private int dno;
	private String dname;
	private Date dos;
	
	//3-param constructor
	public Department(int dno, String dname, Date dos) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dos = dos;
	}

	//toString()
	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", dos=" + dos + "]";
	}
	
	

}

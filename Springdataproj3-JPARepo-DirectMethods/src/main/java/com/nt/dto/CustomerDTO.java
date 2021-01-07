package com.nt.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class CustomerDTO {
	private Integer cno;
	private String cname;
	private String cadd;
	private Double billAmt;

	
    

	/*public CustomerDTO(Integer cno ) {
		this.cno=cno;
	}*/

	

	//setter methods
	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	
    //getter methods
	public Integer getCno() {
		return cno;
	}

	public String getCname() {
		return cname;
	}

	public String getCadd() {
		return cadd;
	}

	public Double getBillAmt() {
		return billAmt;
	}

	//toString()
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
	}



}

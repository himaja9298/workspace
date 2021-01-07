package com.nt.dto;

public class StudentDTO {
 private int sno;
 private String sname;
 private String saddrs;
 
 
 public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

public String getSname() {
	return sname;
}

public void setSname(String sname) {
	this.sname = sname;
}

public String getSaddrs() {
	return saddrs;
}

public void setSaddrs(String saddrs) {
	this.saddrs = saddrs;
}

//3-param constructor
public StudentDTO(int sno, String sname, String saddrs) {
	super();
	this.sno = sno;
	this.sname = sname;
	this.saddrs = saddrs;
}

//toString()
@Override
public String toString() {
	return "StudentDTO [no=" + sno + ", name=" + sname + ", addrs=" + saddrs + "]";
}

 

 
}

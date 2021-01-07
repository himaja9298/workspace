package com.nt.model;

import java.util.Arrays;
import java.util.Date;

public class Person {
	private String name;
	private String addrs;
	private Long mobileNo;
	
	//setters&getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Person [name=" + name + ", addrs=" + addrs + ", mobileNo=" + mobileNo + "]";
	}
	

	
}

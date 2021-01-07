package com.nt.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Person {
	private String name;
	private String addrs;
	private Long mobileNo;
	private String gender="male";
	private String[] hobbies= new String[]{"sleeping","roaming"};
	private String qlfy="MCA";
	private String[] colors=new String[] {"red","white"};
	private Date dob;
	private Date doj=new Date();
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getQlfy() {
		return qlfy;
	}
	public void setQlfy(String qlfy) {
		this.qlfy = qlfy;
	}
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getdoj() {
		return doj;
	}
	public void setdoj(Date doj) {
		this.doj = doj;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Person [name=" + name + ", addrs=" + addrs + ", mobileNO=" + mobileNo + ", gender=" + gender
				+ ", hobbies=" + Arrays.toString(hobbies) + ", qlfy=" + qlfy + ", colors=" + Arrays.toString(colors)
				+ ", dob=" + dob + ", doj=" + doj + "]";
	}

	
}

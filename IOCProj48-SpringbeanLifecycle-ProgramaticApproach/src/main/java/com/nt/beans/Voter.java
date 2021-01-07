package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Voter implements InitializingBean,DisposableBean {
	private int age;
	private String name;
	private Date vdate;

	// setter methods
	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}

	//bussiness logic
	public String getVoterDetails() {
		return "Mr/Ms "+name+" U r elegible for voting from"+vdate;
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Voter.afterPropertiesSet()");
		vdate=new Date();
		boolean flag=false;
		if(name==null) {
			System.out.println("Name must not be null");
		    flag=true;
		}
		if(age<0) {
			age=age*(-1);
		}
		if(age>100) {
			System.out.println("age must be <100 and >=0");
			flag=false;
		}
		if(flag) {
			throw new IllegalArgumentException("Please provide correct details"); 
		}
	}
			
		@Override
		public void destroy() throws Exception {
			System.out.println("Voter.destroy()");
			  name=null;
			  age=0;
			  vdate=null;

		
		}	
	}
	
	


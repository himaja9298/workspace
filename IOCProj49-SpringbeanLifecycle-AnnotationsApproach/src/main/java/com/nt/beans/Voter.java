package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("vt")
public class Voter{
	@Value("30")
	private int age;
	@Value("mahi")
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
	@PostConstruct
	public void myInitanno() {
	  System.out.println("Voter.myInitanno()");
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
			
	   @PreDestroy
		public void myDestroyanno()  {
			System.out.println("Voter.myDestroyanno()");
			  name=null;
			  age=0;
			  vdate=null;

		
		}


	}
	
	


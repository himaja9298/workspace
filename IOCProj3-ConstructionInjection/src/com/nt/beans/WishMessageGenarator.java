package com.nt.beans;

import java.util.Date;

public class WishMessageGenarator {
	
	static{
	  System.out.println("WishMessageGenarator::static block");
	}
	//create date variable 
	private Date date;
	int hour=0;
	
	//setter method
	public void setDate(Date date) {
		System.out.println("WishMessageGenarator::setter property");
		this.date = date;
	}
	public WishMessageGenarator() {
		System.out.println("WishMessageGenarator::0-param construtor");
	    
	}
	
	
	//create 1-param constructor
	public WishMessageGenarator(Date date) {
		System.out.println("WishMessageGenarator::1-param construtor");
		this.date=date;
	}
	//bussiness logic
	public String getwishMessage(String user){
		System.out.println(date);
		hour=date.getHours();
		if(hour<12) {
			return "Good Morning"+user;
		}
		else if(hour<16) {
			return "Good Afternoon"+user;
		}
		else if(hour<20) {
			return "Good Evening"+user;
		}
		else 
			return "Good Night"+user;
		
	}//method

}//bean

		
	
	


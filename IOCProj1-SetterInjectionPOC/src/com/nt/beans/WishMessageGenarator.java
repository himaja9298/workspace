package com.nt.beans;

import java.util.Date;

public class WishMessageGenarator {
    //spring bean property
	private Date date;
	int hour=0;
    //setter method
	public void setDate(Date date) {
		this.date = date;
	}
	//bussiness logic
	public String generateMessage(String user) {
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

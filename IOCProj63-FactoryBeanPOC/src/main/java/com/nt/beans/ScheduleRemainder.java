package com.nt.beans;

import java.time.LocalDate;

public class ScheduleRemainder {
	private LocalDate date;
    
	//1-param constructor
	public ScheduleRemainder(LocalDate date) {
		System.out.println("ScheduleRemainder.ScheduleRemainder()");
		this.date = date;
	}
  public String remainder() {
	  LocalDate sysDate=null;
	  sysDate=LocalDate.now();
	  if(date.isEqual(sysDate)) 
		  return "Borad meeting is their";
	  else
	     return "No meetings are their take rest";  
  }
}

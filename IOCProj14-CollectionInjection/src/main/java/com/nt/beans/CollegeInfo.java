package com.nt.beans;

import java.util.Date;
import java.util.List;

public class CollegeInfo {
  private List<String> studNames;
  private List<Date> dateslist;
  //setter mthods
  public void setStudNames(List<String> studNames) {
	this.studNames = studNames;
  }
  public void setDateslist(List<Date> dateslist) {
	this.dateslist = dateslist;
  }
  //toStirng() method
@Override
public String toString() {
	return "CollegeInfo [studNames=" + studNames + ", dateslist=" + dateslist + "]";
}
  
}

package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class UniversityInfo {
	private Map<Integer,String> facultyDetails;
	private Map<String,Date> datesInfo;
	//2-param constructor
	public UniversityInfo(Map<Integer, String> facultyDetails, Map<String, Date> datesInfo) {
		System.out.println(facultyDetails.getClass());
		this.facultyDetails = facultyDetails;
		this.datesInfo = datesInfo;
	}
	//toString() method
	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", datesInfo=" + datesInfo + "]";
	}
	

}

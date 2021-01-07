package com.nt.editors;

import java.beans.PropertyEditorSupport;

import com.nt.beans.LoanAmntDetails;

public class LoanAmntDetailsEditor extends PropertyEditorSupport {
	String info[]=null;
	LoanAmntDetails details=null;
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		float pamnt=0.0f;
		float rate=0.0f;
		float time=0.0f;
		//store data in array by splitting based on comma
		info=text.split(",");
		//get value from info[]
		pamnt=Float.parseFloat(info[0]);
		rate=Float.parseFloat(info[1]);
		time=Float.parseFloat(info[2]);
        //create LoanAmntDetails class object
	    details=new LoanAmntDetails();
	    //set details to LoanAmntDetails
	    details.setAmnt(pamnt);
        details.setRate(rate);
        details.setTime(time);
        //set details object to bean property as value
        setValue(details);
	}

}

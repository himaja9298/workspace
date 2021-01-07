package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("lacalc")
public class LoanAmntCalculator {
	@Autowired
	@Value("50000,2,3")
	private LoanAmntDetails details;
    
	public LoanAmntCalculator(LoanAmntDetails details) {
		System.out.println("LoanAmntCalculator.LoanAmntCalculator()");
		this.details = details;
	}
	
	public float getIntrestAmnt() {
		return details.getAmnt()*details.getTime()*details.getRate()/100;
		
	}
	
	

}

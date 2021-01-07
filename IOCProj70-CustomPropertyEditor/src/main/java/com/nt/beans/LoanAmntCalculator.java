package com.nt.beans;

public class LoanAmntCalculator {
	private LoanAmntDetails details;

	public LoanAmntCalculator(LoanAmntDetails details) {
		System.out.println("LoanAmntCalculator.LoanAmntCalculator()");
		this.details = details;
	}
	
	public float getIntrestAmnt() {
		return details.getAmnt()*details.getTime()*details.getRate()/100;
		
	}
	
	

}

package com.nt.beans;

public class LoanAmntDetails {
	private float amnt;
	private float rate;
	private float time;
	
	//setter method
	public float getAmnt() {
		return amnt;
	}
    public void setAmnt(float amnt) {
		this.amnt = amnt;
	}
    public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}

	//toString()
	@Override
	public String toString() {
		return "LoanAmntDetails [amnt=" + amnt + ", rate=" + rate + ", time=" + time + "]";
	}
	
	

}

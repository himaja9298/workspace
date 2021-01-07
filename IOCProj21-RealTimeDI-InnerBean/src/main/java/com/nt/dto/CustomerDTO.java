
package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private String cname;
	private String cadd;
	private float pamt;

	private float rate;
	private float time;
	
	//setter methods
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public void setPamt(float pamt) {
		this.pamt = pamt;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public void setTime(float time) {
		this.time = time;
	}
	//getter methods
	public String getCname() {
		return cname;
	}
	public String getCadd() {
		return cadd;
	}
	public float getPamt() {
		return pamt;
	}
	public float getRate() {
		return rate;
	}
	public float getTime() {
		return time;
	}
	
}

package com.nt.bo;

public class CricketerBO {
	private String cname;
	private String country;
	private float btavg;
	private float bwavg;
	//setters
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setBtavg(float btavg) {
		this.btavg = btavg;
	}
	public void setBwavg(float bwavg) {
		this.bwavg = bwavg;
	}
	
	//getters
	public String getCname() {
		return cname;
	}
	public String getCountry() {
		return country;
	}
	public float getBtavg() {
		return btavg;
	}
	public float getBwavg() {
		return bwavg;
	}	
}

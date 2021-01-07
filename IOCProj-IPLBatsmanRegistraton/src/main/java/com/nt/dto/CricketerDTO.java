

package com.nt.dto;

import java.io.Serializable;

public class CricketerDTO implements Serializable {
	private String cname;
	private String country;
	private int runs;
	private int wickets;
	private int innings;
	private int notouts;
	//setter methods
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	//getter methods
	public String getCname() {
		return cname;
	}
	public String getCountry() {
		return country;
	}
	public int getRuns() {
		return runs;
	}
	public int getWickets() {
		return wickets;
	}
	public int getInnings() {
		return innings;
	}
	public int getNotouts() {
		return notouts;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public void setNotouts(int notouts) {
		this.notouts = notouts;
	}
	
}

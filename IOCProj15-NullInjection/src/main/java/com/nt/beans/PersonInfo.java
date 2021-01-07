package com.nt.beans;

import java.util.Date;

public class PersonInfo {
	private long ano;
	private String name;
	private Date dob;
	private Date doj;
	private Date dom; 
    //5-param constructor
	public PersonInfo(long ano, String name, Date dob, Date doj, Date dom) {
		super();
		this.ano = ano;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}
	//toString()
	@Override
	public String toString() {
		return "PersonInfo [ano=" + ano + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
}

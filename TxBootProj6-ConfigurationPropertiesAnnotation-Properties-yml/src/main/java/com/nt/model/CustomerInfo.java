package com.nt.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cust.info")
public class CustomerInfo {
	@Autowired
	private Environment env;

	//simple properties
	private Integer cno;
	private String cname;
	//array properties
	private String[] address;
	//list/set properties
	private List<String> nicknames;
	//map style properties
	private Map<String,Integer> phones;
	
	//setter methods
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}
	public void setPhones(Map<String, Integer> phones) {
		this.phones = phones;
	}
	
	//toString()
	@Override
	public String toString() {
		return "CustomerInfo [cno=" + cno + ", cname=" + cname + ", address=" + Arrays.toString(address)
				+ ", nicknames=" + nicknames + ", phones=" + phones + "]";
	}
	
	public void display() {
		System.out.println(env.getProperty("cust.info.cno")+" "+env.getProperty("cust.info.address[0]"));
        System.out.println(env.getRequiredProperty("os.name"));
        System.out.println( "Path environment varaiable "+env.getProperty("path"));
	}
}

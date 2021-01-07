package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("per1")
@ConfigurationProperties(prefix="info.per")
public class Person1 {
	private int pid;
	private String name;
	private String address;
	
	//setters&getters
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Person1 [pid=" + pid + ", name=" + name + ", address=" + address + "]";
	}
	
	
	

}

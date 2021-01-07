package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("person")
@ConfigurationProperties(prefix ="person.info")
public class Person {
	private int pid;
	private String pname;
	private String[]subjects;
	private List<String>address;
	private Set<String>nicknames;
	private Map<String,Long>phones;
	private Job job;
	
	
	//setters&getters
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	
	public Set<String> getNicknames() {
		return nicknames;
	}
	public void setNicknames(Set<String> nicknames) {
		this.nicknames = nicknames;
	}
	public Map<String, Long> getPhones() {
		return phones;
	}
	public void setPhones(Map<String, Long> phones) {
		this.phones = phones;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", subjects=" + Arrays.toString(subjects) + ", address="
				+ address + ", nicknames=" +nicknames  + ", phones=" + phones + ", job=" + job + "]";
	}

	
	}

package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("per")
@ConfigurationProperties(prefix="person.info")
public class Person {
	private int pid;
	private String pname;
    private int[] marks1;	
    private List<Integer>marks2;
    private Set<Integer>marks3;
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
	public int[] getMarks1() {
		return marks1;
	}
	public void setMarks1(int[] marks1) {
		this.marks1 = marks1;
	}
	public List<Integer> getMarks2() {
		return marks2;
	}
	public void setMarks2(List<Integer> marks2) {
		this.marks2 = marks2;
	}
	public Set<Integer> getMarks3() {
		return marks3;
	}
	public void setMarks3(Set<Integer> marks3) {
		this.marks3 = marks3;
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
		return "Person [pid=" + pid + ", pname=" + pname + ", marks1=" + Arrays.toString(marks1) + ", marks2=" + marks2
				+ ", marks3=" + marks3 + ", phones=" + phones + ", job=" + job + "]";
	}
	
    
    
    
}


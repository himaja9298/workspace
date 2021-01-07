package com.nt.beans;

import java.util.Arrays;

public class Job {

	private int jobid;
	private String jobname;
	private float salary;
	private String[] skills;

	//setters&getters
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Job [jobid=" + jobid + ", jobname=" + jobname + ", salary=" + salary + ", skills="
				+ Arrays.toString(skills) + "]";
	}
	
	
	
	


}

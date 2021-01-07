package com.nt.dto;

import java.io.Serializable;

public class ProjectDto implements Serializable {
	//declare variables
	private Integer projid;
	private String projName;
	private String location;
	private Integer teamSize;
	private String company;
	private Double cost;
	
	
	//setter&getter methods
	public Integer getProjid() {
		return projid;
	}

	public void setProjid(Integer projid) {
		this.projid = projid;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projname) {
		this.projName = projname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "[projid=" + projid + ", projName=" + projName + ", location=" + location + ", teamSize="
				+ teamSize + ", company=" + company + ", cost=" + cost + "]";
	}

}

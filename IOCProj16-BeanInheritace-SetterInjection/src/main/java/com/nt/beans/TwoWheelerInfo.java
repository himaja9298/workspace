package com.nt.beans;

public class TwoWheelerInfo {
	private int regNo;
	private int engNo;
	private String color;
	private int engineCC;
	private String model;
	private String company;
	private String fuelType;
	
	//setter methods
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public void setEngNo(int engNo) {
		this.engNo = engNo;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	//toString()
	@Override
	public String toString() {
		return "TwoWheelerInfo [regNo=" + regNo + ", engNo=" + engNo + ", color=" + color + ", engineCC=" + engineCC
				+ ", model=" + model + ", company=" + company + ", fuelType=" + fuelType + "]";
	}
	
	

}

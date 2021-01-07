package com.nt.beans;

public class TwoWheelerInfo {
	private int regNo;
	private int engNo;
	private String color;
	private int engineCC;
	private String model;
	private String company;
	private String fuelType;
	
	//constructor injection
	public TwoWheelerInfo(int regNo, int engNo, String color, int engineCC, String model, String company,
			String fuelType) {
		System.out.println("TwoWheelerInfo:7-param constructor");
		this.regNo = regNo;
		this.engNo = engNo;
		this.color = color;
		this.engineCC = engineCC;
		this.model = model;
		this.company = company;
		this.fuelType = fuelType;
	}
	
	//toString()
	@Override
	public String toString() {
		return "TwoWheelerInfo [regNo=" + regNo + ", engNo=" + engNo + ", color=" + color + ", engineCC=" + engineCC
				+ ", model=" + model + ", company=" + company + ", fuelType=" + fuelType + "]";
	}
	
	

}

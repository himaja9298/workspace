package com.nt.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBean;

@Component("empDTO")
@Scope("prototype")
public class EmployeeDTO extends BaseBean implements Serializable  {
	private String company;
	private Float salary;
	
	//setters&getters
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	//toString()
	@Override
	public String toString() {
		return "EmployeeDTO [company=" + company + ", salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	
	
	

}

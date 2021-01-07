package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("empBo")
@Scope("prototype")
public class EmployeeBO extends BaseBean {
 private float sal;
 private String company;
 private float grosssalary;
 private float netsalary;
 
 //0-param constructor
 public EmployeeBO() {
   System.out.println("EmployeeBO:o-param constructor");
 }
 
//setters&getters
public float getSal() {
	return sal;
}
public void setSal(float sal) {
	this.sal = sal;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public float getGrosssalary() {
	return grosssalary;
}
public void setGrosssalary(float grosssalary) {
	this.grosssalary = grosssalary;
}
public float getNetsalary() {
	return netsalary;
}
public void setNetsalary(float netsalary) {
	this.netsalary = netsalary;
}


//toString()
@Override
public String toString() {
	return "EmployeeBO [sal=" + sal + ", company=" + company + ", grosssalary=" + grosssalary + ", netsalary="
			+ netsalary + ", toString()=" + super.toString() + "]";
}


 
}

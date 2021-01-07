package com.nt.beans;

public class Employee {
	private int eno;
	private String enmae;
	private float salary;
	//3-param constructor
	public Employee(int eno, String enmae, float salary) {
		System.out.println("Employee:3-param constructor");
		this.eno = eno;
		this.enmae = enmae;
		this.salary = salary;
	}

	//toStrin() method
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", enmae=" + enmae + ", salary=" + salary + "]";
	}
	
	

}

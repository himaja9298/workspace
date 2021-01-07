package com.nt.bo;

import java.util.Date;

public class EmployeeBO {
	private int eno;
	private String ename;
	private String desg;
	private float salary;
	private int deptno;
	//setters&getters
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary= salary;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	//toString()
	@Override
	public String toString() {
		return "EmployeeBO [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + ", deptno=" + deptno
				+ "]";
	}
	
	}

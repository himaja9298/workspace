package com.nt.model;


public class Employee {
    private Integer eno;
	private String ename;
	private String desg;
	private Float salary;
	private Integer deptno;
	private String vflag="no";
	
	//setters&getters
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
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
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	public String getVflag() {
		return vflag;
	}
	public void setVflag(String vflag) {
		this.vflag = vflag;
	}
	//toString()
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + ", deptno="
				+ deptno + "]";
	}
	
	
	
}

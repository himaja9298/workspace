package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDTO implements Serializable{
	   private int serialno;
		private int eno;
		private String ename;
		private String desg;
		private float salary;
		private int deptno;
		private float grossSal;
		private float netSal;
		
		//setters&getters
		public int getSerialno() {
			return serialno;
		}
		public void setSerialno(int serialno) {
			this.serialno = serialno;
		}
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
			this.salary = salary;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public float getGrossSal() {
			return grossSal;
		}
		public void setGrossSal(float grossSal) {
			this.grossSal = grossSal;
		}
		public float getNetSal() {
			return netSal;
		}
		public void setNetSal(float netSal) {
			this.netSal = netSal;
		}
		
		//toString()
		@Override
		public String toString() {
			return "EmployeeDTO [serialno=" + serialno + ", eno=" + eno + ", ename=" + ename + ", desg=" + desg
					+ ", salary=" + salary + ", deptno=" + deptno + ", grossSal=" + grossSal + ", netSal=" + netSal + "]";
		}
	}



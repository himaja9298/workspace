package com.nt.beans;
public class Marks{
	private int m1,m2,m3;
   
	//3-param constructor
	public Marks(int m1, int m2, int m3) {
		System.out.println("Marks:3-param constructor");
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}//constructor
	
	// overrided toString method
	@Override
	public String toString() {
		System.out.println("Marks.toString()");
		return "Marks [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}//toString

				
}//class

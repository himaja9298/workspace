package com.nt.beans;

public class A {
 private B b;
//0-param constructor
 public A() {
	System.out.println("A:0-param constructor");
}

 //setter method
public void setB(B b) {
	this.b = b;
}



@Override
public String toString() {
	return "A []";
	
}

 
}

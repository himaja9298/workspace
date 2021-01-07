package com.nt.beans;

public class A {
 private B b;
 public A() {
	System.out.println("A:0-param constructor");
}

 //setter method
public void setB(B b) {
	this.b = b;
}

//1-param constructor 
public A(B b) {
	System.out.println("A.A()");
	this.b = b;
}


@Override
public String toString() {
	return "A []";
	
}

 
}

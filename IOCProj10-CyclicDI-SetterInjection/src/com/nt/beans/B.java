package com.nt.beans;

public class B {
 private A a;
 //0-param constructor
 public B() {
	System.out.println("B:0-param constructor");
}

 //setter method
public void setA(A a) {
	this.a = a;
}



@Override
public String toString() {
	return "B[]";
}

 
}

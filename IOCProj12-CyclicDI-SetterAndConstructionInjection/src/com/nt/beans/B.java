package com.nt.beans;

public class B {
 private A a;

	/*
	 * //setter method public void setA(A a) { this.a = a; }
	 */
//1-param constructor
public B(A a) {
	System.out.println("B:1-param constructor");
	this.a = a;
}


@Override
public String toString() {
	return "B[]";
}

 
}

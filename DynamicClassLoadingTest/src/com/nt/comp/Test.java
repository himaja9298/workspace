package com.nt.comp;

public class Test {
	int a=10;
	int b=20;
	
	//0-param constructor
	public Test() {
		System.out.println("Test.Test()");
	}
	
	//toString()
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	

}

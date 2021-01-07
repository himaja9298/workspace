package com.nt.comp;

public class test {
	private int a,b;
	static {
		System.out.println("test::static block");
		
	}
	public test() {
		System.out.println("test::0-param constructor");
	}
	
	
	  public test(int a, int b) {
		  this.a = a; 
		  this.b = b; 
	}
	 

	@Override
	public String toString() {
		return "Test[a="+a+",b="+b+"]";
	}
	

}

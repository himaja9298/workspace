package com.nt.beans;

public class TestBean {
   private int a,b;
   //0-param constructor 
   public TestBean() {
    System.out.println("TestBean:0-param constructor");
   }
   
   //2-param constructor
   private TestBean(int a, int b) {
	 System.out.println("TestBean:2-param constructor");
	 this.a = a;
	 this.b = b;
   } 
  
   //toString() method
   @Override
   public String toString() {
	  return "TestBean [a=" + a + ", b=" + b + "]";
   }
//nested static class   
private static class InnerBean{
	   private int c;
   //1-param constructor
	public InnerBean(int c) {
		System.out.println("TestBean.InnerBean:1-param constructor");
		this.c = c;
	}
	//toString()
	@Override
	public String toString() {
		return "InnerBean [c=" + c + "]";
	}
	   
   }//inner class
}//outer class

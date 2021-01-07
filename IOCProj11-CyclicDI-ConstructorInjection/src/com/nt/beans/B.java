package com.nt.beans;

  public class B {
   private A a;

  //1-param constructor
  public B(A a) {
		System.out.println("B:1-param construcotr");
		this.a = a;
	}

 
  @Override
  public String toString() {
	return "B[]";
  }


 
}

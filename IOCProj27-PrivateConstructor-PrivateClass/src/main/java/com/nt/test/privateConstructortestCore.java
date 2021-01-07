package com.nt.test;

import java.lang.reflect.Constructor;

import com.nt.beans.TestBean;
public class privateConstructortestCore {
	public static void main(String[] args) {
	Class c=null;
	Constructor cons[]=null;
	TestBean test1=null,test2=null; 
	try {
		//load  the class
		c=Class.forName("com.nt.beans.TestBean");  
	   //get access to cConstructor class constructors 
	   cons=c.getDeclaredConstructors();
	   //create object
	   cons[0].setAccessible(true);
	   test1=(TestBean) cons[0].newInstance();
	   System.out.println(test1);
	   System.out.println("-------------------------------");
	   cons[1].setAccessible(true);
	   //create object
	   test2=(TestBean) cons[1].newInstance(80,20);
	   System.out.println(test2);
	   
	}//try
	catch(Exception e) {
		e.printStackTrace();
	}//catch
	
  }//main
}//class

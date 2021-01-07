package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceTest2 {
	public static void main(String[] args) {
	Class c1=null,c2=null;
	Object obj1=null,obj2=null;
	Constructor cons[]=null;
	try {
		//load the class
		c1=Class.forName(args[0]);
	    //get all constructors of the loaded class
		cons=c1.getDeclaredConstructors();
		//create an object and instantiate the loaded classes
		obj1=cons[0].newInstance(10,20);
		System.out.println(obj1);
		System.out.println("---------------------------------------------------");
		}//try
	catch(InstantiationException ie) {
		ie.printStackTrace();
	}
	catch(ClassNotFoundException cnfe) {
		cnfe.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}//main
}//class

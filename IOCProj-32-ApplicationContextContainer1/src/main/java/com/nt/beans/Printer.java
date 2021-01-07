package com.nt.beans;

public class Printer {
	public static Printer INSTANCE;
	
	//0-param constructor
	private Printer() {
		System.out.println("Printer:0-param constructor");
	}
	//get instance
	public static Printer getInstance() {
		if(INSTANCE==null) 
		   INSTANCE=new Printer();
		   return INSTANCE;
	}
	//get data method
	public static void getData(String msg) {
		System.out.println(msg);
	}
    
}

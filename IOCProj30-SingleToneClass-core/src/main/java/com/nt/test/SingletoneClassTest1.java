package com.nt.test;

import com.nt.standard.Printer;
import com.nt.standard.Printer1;

public class SingletoneClassTest1 {
	
	public static void main(String[] args) {
		Printer pt3=null,pt4=null;	
		pt3=Printer.getInstance();
		pt4=Printer.getInstance();
		System.out.println("pt3 hashCode:: "+pt3.hashCode()+" pt4 hashCode:: "+pt4.hashCode());
		System.out.println("(pt1==pt2)"+(pt3==pt4));
		pt3.getData("hello1");
		pt4.getData("hello2");
	}//main

}//class

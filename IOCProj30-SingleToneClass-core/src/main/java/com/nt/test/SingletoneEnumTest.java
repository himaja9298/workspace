package com.nt.test;

import com.nt.standard.Printer;
import com.nt.standard.Printer1;

public class SingletoneEnumTest {
	
	public static void main(String[] args) {
		Printer1 pt3=null,pt4=null;	
		pt3=Printer1.INSTANCE;
		pt4=Printer1.INSTANCE;
		System.out.println("pt3 hashCode:: "+pt3.hashCode()+" pt4 hashCode:: "+pt4.hashCode());
		System.out.println("(pt1==pt2)"+(pt3==pt4));
		pt3.getData("hello1");
		pt4.getData("hello2");
	}//main

}//class

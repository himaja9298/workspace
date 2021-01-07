package com.nt.test;

import com.nt.comp.Test;

public class NewInstanceTest {
	public static void main(String[] args) {
		Test test=null;
		try {
         Class c= Class.forName(args[0]);
         test=(Test) c.newInstance(); 
         System.out.println(test);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
  }//main
}// class

package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Printer;

public class SingletoneClassTest1 {
	
	public static void main(String[] args) {
		//create container
		ApplicationContext ctx=null;
		Printer pt=null;
		/*
		 * ctx= new FileSystemXmlApplicationContext(
		 * "src/main/java/com/nt/cfgs/applicationContext.xml");
		 */
		ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		pt=ctx.getBean("pr",Printer.class);
		pt.getData("hello");
		((AbstractApplicationContext) ctx).close();
		
	}//main

}//class

package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Properties1;

public class PropertiesTest {
	 
	public static void main(String[] args) {
		Properties1 prps1=null;

		//create container
		ApplicationContext ctx=null;
		ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	    prps1=ctx.getBean("prps",Properties1.class);
	    System.out.println(prps1);
	    
	}

}

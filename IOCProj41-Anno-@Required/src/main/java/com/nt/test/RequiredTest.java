package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Person;

public class RequiredTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Person psn=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Perosn class object
	    psn=ctx.getBean("psn",Person.class);
	    System.out.println(psn);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}

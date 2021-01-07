package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Employee;

public class PandCNameSpacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Employee emp=null;
	  //create container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Employee class object
		emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	 
	}

}

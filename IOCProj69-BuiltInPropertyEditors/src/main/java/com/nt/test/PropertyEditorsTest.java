package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonInfo;

public class PropertyEditorsTest {

	public static void main(String[] args) {
	 ApplicationContext ctx=null;
	 PersonInfo pinfo=null;
	 //create container
	 ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	 //get PersonInfo class object
	  pinfo=ctx.getBean("pInfo",PersonInfo.class); 
	  System.out.println(pinfo);
	}

}

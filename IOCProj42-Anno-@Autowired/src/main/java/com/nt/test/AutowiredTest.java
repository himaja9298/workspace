package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;


public class AutowiredTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Flipkart fpkt=null;
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get flipkart class object
		fpkt=ctx.getBean("fpt", Flipkart.class);
	    System.out.println(fpkt.shopping(new String[] {"rain coat", "umbrella","flutablets"},new float[] {5000,2000,500}));
	    
	}//main

}//class

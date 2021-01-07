package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comp.Courier;
import com.nt.comp.Flipkart;

public class StrategyTest {
	
	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		
		Flipkart fpkt=null;
		//hold applicationContect.xml file
		res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//create beanFactory
		factory=new XmlBeanFactory(res);
		fpkt=factory.getBean("fpt", Flipkart.class);
	    System.out.println(fpkt.shopping(new String[] {"rain coat", "umbrella","flutablets"},new float[] {5000,2000,500}));
	    
	}//main

}//class

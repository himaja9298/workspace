package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenarator;

public class ConstructionInjection {

	public static void main(String[] args) {
		Resource res=null; 
		BeanFactory factory=null;
		Object obj=null;
		WishMessageGenarator wish=null;
		//get location of springBean configuration file
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC container/spring container (beanfactory)
		factory=new XmlBeanFactory(res);
		obj=factory.getBean("wmg");
		//type casting object
		wish=(WishMessageGenarator)obj;
		String result=wish.getwishMessage("raja");
		System.out.println(result);
	}//main

}//class

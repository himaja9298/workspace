package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenarator;

public class SetterInjectionTest {
	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Object obj=null;
		WishMessageGenarator wish=null;
		String result=null;
		//Hold the name and location of springBean cfg file
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//IOC container/spring container(Beanfactory)
		factory=new XmlBeanFactory(res);
		obj=factory.getBean("wmg");
		wish=(WishMessageGenarator)(obj);
		result=wish.generateMessage("Raja");
		System.out.println(result);
	}//main

}//class

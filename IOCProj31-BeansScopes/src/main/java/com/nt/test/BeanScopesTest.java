package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenarator;

public class BeanScopesTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		WishMessageGenarator wish1=null,wish2=null,wish3=null,wish4=null,wish5=null,wish6=null;
		Printer pr=null,pr1=null;
		//get factory for IOC container
		factory=new DefaultListableBeanFactory();
		//load factory for reader object
		reader=new XmlBeanDefinitionReader(factory);
		//load path of configuration file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		/*
		 * wish1=factory.getBean("wmg",WishMessageGenarator.class);
		 * wish2=factory.getBean("wmg",WishMessageGenarator.class);
		 * wish3=factory.getBean("wmg",WishMessageGenarator.class);
		 * System.out.println(wish1.hashCode()+"  "+wish2.hashCode()+"  "+wish3.hashCode
		 * ()); System.out.println(wish1==wish2); System.out.println(wish2==wish3);
		 * System.out.println(wish1==wish3);
		 */
		wish4=factory.getBean("wmg1",WishMessageGenarator.class);
		wish5=factory.getBean("wmg1",WishMessageGenarator.class);
		wish6=factory.getBean("wmg1",WishMessageGenarator.class);
		System.out.println(wish4.hashCode()+"  "+wish5.hashCode()+"  "+wish6.hashCode());
		System.out.println(wish4==wish5);
		System.out.println(wish5==wish6);
		System.out.println(wish4==wish6);
		
		//get Printer class object
		pr=factory.getBean("pr",Printer.class);
		pr1=factory.getBean("pr",Printer.class);
		System.out.println(pr.hashCode()+"  "+pr1.hashCode());
	
	}//main

}//class

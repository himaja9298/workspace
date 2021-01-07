package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class CircularDependencyInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		A a=null;
		B b=null;
	    
		//create factory  
		factory=new DefaultListableBeanFactory();
		//Assign BeanFactory to reader
		reader=new XmlBeanDefinitionReader(factory);
		//make file available to reader
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	    //get bean class object
		a=factory.getBean("a1",A.class);
        System.out.println(a);	
		/*
		 * b=factory.getBean("b1",B.class); System.out.println(b);
		 */  	
	
	}

}

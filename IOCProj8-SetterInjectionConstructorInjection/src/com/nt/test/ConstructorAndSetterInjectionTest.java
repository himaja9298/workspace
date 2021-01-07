package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comp.Student;

public class ConstructorAndSetterInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Student stu=null;
		//create beanfactory
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
	    //get bean class object
		stu=factory.getBean("std",Student.class);
		System.out.println(stu);
	}//main

}//class

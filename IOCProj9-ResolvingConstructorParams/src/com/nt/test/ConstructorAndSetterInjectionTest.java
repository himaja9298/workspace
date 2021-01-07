package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Employee;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class ConstructorAndSetterInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Marks mk=null;
		Employee emp=null;
		Student std=null;
		//create beanfactory
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
	    //get Marks bean class object
		mk=factory.getBean("mrk",Marks.class);
		System.out.println(mk);
		//get Employee bean class object
		emp=factory.getBean("emp",Employee.class);
		System.out.println(emp);
		//get Student bean class object
		std=factory.getBean("std",Student.class);
		System.out.println(std);
	
	}//main

}//class

package com.nt.test;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodTest {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Class c=null;
		Calendar calendar=null;
		Connection con=null;
		Properties props=null;
		String str2=null,str3;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//static factory
		c=factory.getBean("c",Class.class);
		//get Class class object
		System.out.println("c obj class name::  "+c.getClass().getName()+"   "+"c object data::  "+c.toString());;
        System.out.println("-------------------------------------------------");
        
        //get Calendar class object
        calendar=factory.getBean("calendar",Calendar.class);
		System.out.println("calendar obj class name::  "+calendar.getClass().getName()+"   "+"calendar object data::  "+calendar.toString());;
        System.out.println("-------------------------------------------------");
        
        //get Connection Interface object
        con=factory.getBean("driver",Connection.class);
		System.out.println("con obj class name::  "+con.getClass().getName()+"   "+"con object data::  "+con.toString());;
        System.out.println("-------------------------------------------------");
        
        //get System class object       
        props=factory.getBean("system",Properties.class);
		System.out.println("props obj class name::  "+props.getClass().getName()+"   "+"props object data::  "+props.toString());;
        System.out.println("-------------------------------------------------");
	    
        //instance factory
        //get String class object
        str2=factory.getBean("str2",String.class);
		//get Class class object
		System.out.println("str2 obj class name::  "+str2.getClass().getName()+"   "+"str2 object data::  "+str2.toString());;
        System.out.println("-------------------------------------------------");
        
      //get String class object
        str3=factory.getBean("str3",String.class);
		//get Class class object
		System.out.println("str3 obj class name::  "+str3.getClass().getName()+"   "+"str3 object data::  "+str3.toString());;
        System.out.println("-------------------------------------------------");
        
	
	}

}

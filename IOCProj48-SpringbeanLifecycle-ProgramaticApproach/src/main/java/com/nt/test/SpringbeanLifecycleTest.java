package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Voter;

public class SpringbeanLifecycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Voter vt=null;
	   //get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get voter class object
		 vt=ctx.getBean("vt",Voter.class); 
		 System.out.println(vt.getVoterDetails());
	
		 //close container
		 ((AbstractApplicationContext) ctx).close();

	}
	
}

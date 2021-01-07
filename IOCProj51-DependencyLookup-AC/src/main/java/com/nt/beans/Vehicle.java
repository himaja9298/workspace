package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle {
	
	private String beanid;
	//1-param constructor
	public Vehicle(String beanid) {
		System.out.println("vehicle:1-param constructor");
		this.beanid = beanid;
	}
	
	//entertainment()
	public void entertainment() {
		System.out.println("Vehicle.entertainment()");
	}
	
	//soundHorn()
	public void soundHorn() {
		System.out.println("Vehicle.soundHorn()");
	}
	//fillFuel()
	public void fillFuel() {
		System.out.println("Vehicle.fillFuel()");
	}
	public void journey(String Sourceplace,String destplace) {
		ApplicationContext ctx=null;
		//get cintainer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		Engine eng=null;
		// get container
		System.out.println("Extra container");
		//get dependent bean class object
		eng=ctx.getBean(beanid,Engine.class);
		eng.start();
		eng.stop();
	}
	

}

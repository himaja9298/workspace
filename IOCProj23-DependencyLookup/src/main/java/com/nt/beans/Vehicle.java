package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

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
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		Engine eng=null;
		// create factory
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		System.out.println("Extra container");
		//get dependent bean class object
		eng=factory.getBean(beanid,Engine.class);
		eng.start();
		eng.stop();
	}
	

}

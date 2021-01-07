package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vehicle;

public class DependencyLookupTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Vehicle vehicle=null;
		// get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("First container");
		//get target class object
		vehicle=ctx.getBean("vehicle",Vehicle.class);
		//invoke methods
		vehicle.journey("hyd","warangal");
		vehicle.entertainment();
		vehicle.fillFuel();
		vehicle.soundHorn();
		
	}

}

package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Vehicle implements ApplicationContextAware {
	
	private String beanid;
	private ApplicationContext ctx;
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
		Engine eng=null;
		//get dependent bean class object
		eng=ctx.getBean(beanid,Engine.class);
		eng.start();
		System.out.println("Engine started at source place::"+Sourceplace);
		eng.stop();
		System.out.println("Engine stoped at destination place::"+destplace);
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Vehicle.setApplicationContext()");
		this.ctx=ctx;
	}
	

}

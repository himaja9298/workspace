package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	private String beanId;
	
	public WebContainer() {
		System.out.println("WebContainer:0-param constructor");
	}
	
	//setter method
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	
	
   public void processing(String data) {
	   RequestHandler rh=null;
	   System.out.println("WebContainer.processing request eit data "+data+"by giving it to handler");
	   ApplicationContext ctx=null;
	   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	   //get dependent class beanid
	   rh=ctx.getBean(beanId,RequestHandler.class);
	   rh.handleRequest(data);
   }
}

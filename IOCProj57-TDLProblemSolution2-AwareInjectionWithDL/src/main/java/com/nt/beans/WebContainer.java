package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer implements ApplicationContextAware {
	private String beanId;
	ApplicationContext ctx=null;
	
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
	   //get dependent class beanid
	   rh=ctx.getBean(beanId,RequestHandler.class);
	   rh.handleRequest(data);
   }

@Override
public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	this.ctx=ctx;
  }
}

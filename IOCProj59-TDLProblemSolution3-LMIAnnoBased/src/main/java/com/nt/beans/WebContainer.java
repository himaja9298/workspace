package com.nt.beans;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("wc")
public abstract class WebContainer  {
	
	public WebContainer(){
		System.out.println("WebContainer:0-param constructor");
	}
	
	//declare abstract method
	@Lookup("rhandle")
	abstract RequestHandler createRequestHandler();
	//business logic
    public void processing(String data) {
	   RequestHandler rh=null;
	   System.out.println("WebContainer.processing request with data:: " +data+" :by giving it to handler");
	   rh=createRequestHandler();
	   rh.handleRequest(data);
   }

}

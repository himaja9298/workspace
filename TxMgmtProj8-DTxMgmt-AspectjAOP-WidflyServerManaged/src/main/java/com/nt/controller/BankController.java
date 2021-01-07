package com.nt.controller;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/controller")
public class BankController {
    ApplicationContext ctx=null;
	public void init() {
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}
	
	
		public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}
}

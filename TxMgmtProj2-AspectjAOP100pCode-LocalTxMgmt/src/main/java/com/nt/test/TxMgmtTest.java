package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class TxMgmtTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container 
		ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke methods
		
		  try { 
			  System.out.println(proxy.getClass());
		      System.out.println(proxy.trasferMoney(111222333, 222333444, 2000)); 
		     } 
		  catch(Exception e) { 
			  e.printStackTrace(); 
		  }
		  
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}

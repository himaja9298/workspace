package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.manager.AuthenticationManager;
import com.nt.service.IBankService;

public class SecurityAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService proxy=null;
		AuthenticationManager manager=null;
		//create container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get target class,manager class objects
		proxy=ctx.getBean("bankService",IBankService.class);
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//call business methods
		try {
		  manager.signIn("raja", "rani");
		  System.out.println("Withdraw operation::"+proxy.withdraw(111222333, 1000));
		  System.out.println("Deposite operation::"+proxy.deposit(222333444, 50000));
		  manager.signOut();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}

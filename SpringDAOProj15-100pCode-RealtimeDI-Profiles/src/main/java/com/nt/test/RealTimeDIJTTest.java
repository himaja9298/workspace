package com.nt.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nt.config.AppConfig;
import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDIJTTest {

	public static void main(String[] args) {
		CustomerVO vo=null;
		Scanner sc=null;
		String result=null;
		String cname=null,cadd=null,pamt=null,rate=null,time=null;
		MainController controller=null;
		
		sc=new Scanner(System.in);
		System.out.println("enter customer name");
		cname=sc.next();
		System.out.println("enter customer addrs");
		cadd=sc.next();
		System.out.println("enter principleamount");
		pamt=sc.next();
		System.out.println("enter rate of intrest");
		rate=sc.next();
		System.out.println("enter time duration");
		time=sc.next();
		vo=new CustomerVO();
		vo.setCname(cname);
		vo.setCadd(cadd);
		vo.setPamt(pamt);
		vo.setTime(time);
		vo.setRate(rate);
		
		//get empty container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		//get Environment object
		ConfigurableEnvironment env=(ConfigurableEnvironment) ctx.getEnvironment();
		env.setActiveProfiles("test");
		//register configuration class
		ctx.register(AppConfig.class);
		//refresh the container
		ctx.refresh();
		
		//get controller class object
	    controller=ctx.getBean("mainController",MainController.class);
	   //catch and handle the exception
	  		try {
	  			result=controller.processCustomer(vo);
	  			System.out.println(result);
	  		}
	  		catch(Exception e) {
	  			System.out.println("Internal-DB problem");
	  			e.printStackTrace();
	  		}
	  		 ((AbstractApplicationContext) ctx).close();
	}


}

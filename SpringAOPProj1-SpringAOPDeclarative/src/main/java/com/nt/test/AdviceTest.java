package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.IntrestCalculator;

public class AdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrestCalculator icl=null;
		//locate container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxtFactoryBean class object
		icl=ctx.getBean("proxyFactoryBean",IntrestCalculator.class);
		System.out.println(icl.getClass()+" "+icl.getClass().getSuperclass());
		//call bussiness mehtod
		System.out.println(icl.simpleIntrestAmnt(500000, 2, 14));
		System.out.println("-----------------------------------");
		System.out.println(icl.simpleIntrestAmnt(250000, 2, 14));
		
		
		//close container
	((AbstractApplicationContext) ctx).close();
	}

}

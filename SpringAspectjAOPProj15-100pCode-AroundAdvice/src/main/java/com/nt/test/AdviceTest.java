package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.target.IntrestCalculator;

public class AdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrestCalculator icl=null;
		//locate container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxtFactoryBean class object
		icl=ctx.getBean("intrestCal",IntrestCalculator.class);
		System.out.println(icl.getClass()+" "+icl.getClass().getSuperclass());
		//call business method
		System.out.println("Simple intrest"+icl.simpleIntrestAmnt(500000, 2, 14));
		System.out.println("-----------------------------------");
		System.out.println("Compound intrest"+icl.compundIntrestAmnt(500000, 2, 14));
		
		
		//close container
	((AbstractApplicationContext) ctx).close();
	}

}

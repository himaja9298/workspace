package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleRemainder;

public class FactorybeanTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ScheduleRemainder srem=null;
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target class object
		srem=ctx.getBean("sremainder", ScheduleRemainder.class);
		System.out.println(srem.remainder());
	}

}

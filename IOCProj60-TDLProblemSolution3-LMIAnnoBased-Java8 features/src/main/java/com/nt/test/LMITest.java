package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WebContainer;

public class LMITest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WebContainer wc=null;
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target class object
		wc=ctx.getBean("wc",WebContainer.class);
		System.out.println(wc.getClass() +" "+wc.getClass().getSuperclass());
		wc.processing("Hi");
		wc.processing("Hello");
		wc.processing("Gd Mng");
		((AbstractApplicationContext) ctx).close();
	}
 
}

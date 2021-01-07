package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.CarShowRoom;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CarShowRoom csr=null;
		//locate container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxtFactoryBean class object
		csr=ctx.getBean("target",CarShowRoom.class);
		System.out.println(csr.getClass()+" "+csr.getClass().getSuperclass());
		//call business method
		System.out.println(csr.sale("Briza", 1500000, "ramesh"));
		//close container
	((AbstractApplicationContext) ctx).close();
	}

}

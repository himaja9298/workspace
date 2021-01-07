package com.nt.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore str=null;
		//locate container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxtFactoryBean class object
		str=ctx.getBean("shopping",ShoppingStore.class);
		System.out.println(str.getClass()+" "+str.getClass().getSuperclass());
		//call business method
		System.out.println(str.shopping(new String[] {"shirt","saree","kidsware"}, new float[] {1500,35000,3000}));
		//close container
	((AbstractApplicationContext) ctx).close();
	}

}

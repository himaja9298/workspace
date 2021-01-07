package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.target.ShoppingStore;

@SpringBootApplication
public class SpringAspectjAopProj19BootAfterAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ShoppingStore str = null;
		// locate container
		ctx = SpringApplication.run(SpringAspectjAopProj19BootAfterAdviceApplication.class, args);
		// get proxtFactoryBean class object
		str = ctx.getBean("shopping", ShoppingStore.class);
		System.out.println(str.getClass() + " " + str.getClass().getSuperclass());
		// call business method
		System.out.println(
				str.shopping(new String[] { "shirt", "saree", "kidsware" }, new float[] { 1500, 35000, 3000 }));
		// close container
		((AbstractApplicationContext) ctx).close();

	}

}

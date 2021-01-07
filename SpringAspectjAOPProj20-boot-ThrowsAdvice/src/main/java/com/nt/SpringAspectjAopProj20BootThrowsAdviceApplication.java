package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.target.ShoppingStore;

@SpringBootApplication
public class SpringAspectjAopProj20BootThrowsAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ShoppingStore str = null;
		// locate container
		ctx = SpringApplication.run(SpringAspectjAopProj20BootThrowsAdviceApplication.class, args);
		// get proxtFactoryBean class object
		str = ctx.getBean("shopStore", ShoppingStore.class);
		// System.out.println(str.getClass()+" "+str.getClass().getSuperclass());
		// call business method
		System.out.println(
				str.generateBill(new String[] { "shirt", "saree", "kidsware" }, new float[] { 0, 35000, 3000 }));
		// close container
		((AbstractApplicationContext) ctx).close();

	}

}

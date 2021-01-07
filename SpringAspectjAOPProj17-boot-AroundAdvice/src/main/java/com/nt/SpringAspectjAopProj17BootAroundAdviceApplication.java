package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.target.IntrestCalculator;

@SpringBootApplication
public class SpringAspectjAopProj17BootAroundAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		
		ctx=SpringApplication.run(SpringAspectjAopProj17BootAroundAdviceApplication.class, args);
		IntrestCalculator icl=null;
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



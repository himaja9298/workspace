package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.CustomerInfo;

@SpringBootApplication
public class TxBootProjConfigurationPropertiesAnnotationApplication {
   
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerInfo info=null;
		
		//get IOC container
		ctx=SpringApplication.run(TxBootProjConfigurationPropertiesAnnotationApplication.class, args);
	    //getBean
		info=ctx.getBean(CustomerInfo.class);
		System.out.println(info);
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	
	}

}

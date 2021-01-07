package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.BankService;

@SpringBootApplication
public class TxMgmtProj3AspectjAopTxmgmtBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
	    BankService proxy=null;	
	    //get IOC container
	     ctx=SpringApplication.run(TxMgmtProj3AspectjAopTxmgmtBootApplication.class, args);
	     //get service class related proxy object
	     proxy=ctx.getBean("bankService",BankService.class);
	     try {
	    	 System.out.println(proxy.trasferMoney(111222333, 222333444, 2000));
	    	 }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     //close container
	     ((ConfigurableApplicationContext) ctx).close();
	    
	}

}

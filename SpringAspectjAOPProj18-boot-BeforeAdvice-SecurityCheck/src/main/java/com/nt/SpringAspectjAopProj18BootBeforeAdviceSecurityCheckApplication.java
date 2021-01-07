package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.IBankService;

@SpringBootApplication
public class SpringAspectjAopProj18BootBeforeAdviceSecurityCheckApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService proxy=null;
		AuthenticationManager manager=null;
		//create container
		ctx=SpringApplication.run(SpringAspectjAopProj18BootBeforeAdviceSecurityCheckApplication.class, args);
	   
		//get target class,manager class objects
				proxy=ctx.getBean("bankService",IBankService.class);
				manager=ctx.getBean("authManager",AuthenticationManager.class);
				//call business methods
				try {
				  manager.signIn("raja", "rani");
				  System.out.println("Withdraw operation::"+proxy.withdraw(111222333, 1000));
				  System.out.println("Deposite operation::"+proxy.deposit(222333444, 50000));
				  manager.signOut();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				//close container
				((AbstractApplicationContext) ctx).close();
			}

	
	}



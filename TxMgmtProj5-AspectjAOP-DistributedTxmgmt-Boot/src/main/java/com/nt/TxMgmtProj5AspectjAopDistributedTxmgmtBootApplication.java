package com.nt;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import com.nt.service.BankService;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
public class TxMgmtProj5AspectjAopDistributedTxmgmtBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//get IOC container
		ctx=SpringApplication.run(TxMgmtProj5AspectjAopDistributedTxmgmtBootApplication.class, args);
	    //get proxy object
		proxy= ctx.getBean("bankService",BankService.class);
		System.out.println(proxy.getClass().getName()+"  "+proxy.getClass().getSuperclass());
		try {
			//invoke method
			System.out.println(proxy.trasferMoney(777888999, 1003, 1000));
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	   ((ConfigurableApplicationContext) ctx).close();
	}

}

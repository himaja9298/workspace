package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.BankAccountDTO;
import com.nt.service.IAuthService;


public class AuthenticationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IAuthService service=null;
		List<BankAccountDTO>listdto=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("authService",IAuthService.class);
		
		try {
			System.out.println(service.authenticateUser("mahi", "mahi123"));
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();	
		}
		
		
		((AbstractApplicationContext) ctx).close();
	}
}

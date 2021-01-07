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
import com.nt.service.IBankService;


public class BankOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService service=null;
		List<BankAccountDTO>listdto=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("bankService",IBankService.class);
		
		try {
			BankAccountDTO dto=new BankAccountDTO();
			dto.setActno(999666777.d);dto.setCname("mahati");dto.setBalamnt(650000.f);
		    System.out.println(service.registerCustomer(dto));   
		}
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException) 
				System.err.println("Record not found");
			
			else if(dae instanceof BadSqlGrammarException) 
				System.err.println("SQL Query wrong");
			
			else
				System.err.println("Other Internal problems");
			
		}
		
		
		((AbstractApplicationContext) ctx).close();
	}
}

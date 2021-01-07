package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BankAccountDTO;
import com.nt.service.IBankService;


public class BankOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService service=null;
		List<BankAccountDTO>listdto=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("BankService",IBankService.class);
		
		try {
			service.fetchBankAccountsByBalanceRange(20000,70000).forEach(System.out::println);
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();	
		}
		
		System.out.println("-----------------------------------------------");
		try {
			System.out.println(service.fetchDetailsByAccountno(111222333));
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();	
		}
		
		System.out.println("-----------------------------------------------");
		try {
			System.out.println(service.modifyBalmntWithBonus(1000,650000));
		}
		catch(DataAccessException dae) {
		   dae.printStackTrace();	
		}
		
		
		((AbstractApplicationContext) ctx).close();
	}
}

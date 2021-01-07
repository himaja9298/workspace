package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeService;


public class EmployeeOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IEmployeeService service=null;
		List<EmployeeDTO>listdto=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("empService",IEmployeeService.class);
		try {
			System.out.println("Student details:::::"+service.fetchEmployeeByNo(15));
		   }
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException) 
				System.err.println("Record not found");
			
			else if(dae instanceof BadSqlGrammarException) 
				System.err.println("SQL Query wrong");
			
			else
				System.err.println("Other Internal problems");
			
		}
		
		System.out.println("------------------------------------------------------");
		try {
			System.out.println("Employee belonging to teacher,developer,salesman");
			listdto=service.fetchEmployeeByDesg("teacher","developer","salesman");
			listdto.forEach(System.out::println);
		   }
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException) 
				System.err.println("Record not found");
			
			else if(dae instanceof BadSqlGrammarException) 
				System.err.println("SQL Query wrong");
			
			else
				System.err.println("Other Internal problems");
			
		}
		
		System.out.println("------------------------------------------------------");
		try {
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEno(18);dto.setEname("manoj");dto.setDesg("teacher");dto.setSalary(32000.f);
		    System.out.println(service.registerEmployee(dto));   
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

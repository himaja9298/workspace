package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentService;

public class StudentOperationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IStudentService service=null;
		List<StudentDTO>listdto=null;
		
		//get container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("studService",IStudentService.class);
		try {
			System.out.println("Student details:::::"+service.fetchStudentByNo(103));
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
			System.out.println("Student belonging to htd,banglore,mumbai");
			listdto=service.fetchStudentsByCities("hyd","banglore","mumbai");
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
			System.out.println("Student belonging to htd,banglore,mumbai");
			listdto=service.fetchStudentsByCities1("hyd","banglore","mumbai");
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
			
		//close container
	((AbstractApplicationContext) ctx).close();

	}
}
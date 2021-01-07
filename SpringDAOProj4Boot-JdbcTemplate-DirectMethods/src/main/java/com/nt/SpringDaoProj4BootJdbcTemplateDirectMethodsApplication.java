package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeService;

@SpringBootApplication
public class SpringDaoProj4BootJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IEmployeeService service=null;
		ctx=SpringApplication.run(SpringDaoProj4BootJdbcTemplateDirectMethodsApplication.class, args);
		//get service class object
		service=ctx.getBean("empService",IEmployeeService.class);
		try {
			System.out.println("Employee Count:::"+service.fetchEmpCount());
		   }
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-------------------------------------------");
		try {
			System.out.println("103 employe name"+service.fetchEnameByNo(103));
		   }
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-------------------------------------------");
		try {
			System.out.println("104 Employee details"+service.fetchEmpDetailsByNo(104));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-------------------------------------------");
		try {
			System.out.println("teacher,Sales desg emp details::");
			/*service.fetchEmpDetailsByDesgs("teacher", "sales").forEach(map->{
				System.out.println(map);
			});*/
			//service.fetchEmpDetailsByDesgs("teacher", "sales").forEach(map->System.out.println(map));
			service.fetchEmpDetailsByDesgs("teacher", "sales").forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------------------");
		try {
			System.out.println(service.insertEmployee("manasa", "sales", 15000,1));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------------------");
		try {
			System.out.println(service.addBonusToEmployeeByDesg("sales", 5000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-------------------------------------------");
		try {
			System.out.println(service.deleteEmployeeByDesg("sales"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	

	}

}

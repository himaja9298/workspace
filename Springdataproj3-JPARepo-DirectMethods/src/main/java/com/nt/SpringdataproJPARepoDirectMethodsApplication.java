package com.nt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringdataproJPARepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerService service=null;
		CustomerDTO dto=null;
		List<CustomerDTO> listdto=null;
		Customer entity=null,entity1=null;
		//create container
		ctx=SpringApplication.run(SpringdataproJPARepoDirectMethodsApplication.class, args);
        //get service class object	
	     service=ctx.getBean("custService",CustomerService.class);
	     dto=new CustomerDTO();
	     //dto.setBillAmt(900000.0);
	     dto.setCadd("chennai");
	    //service.fecthAllCustomersDetails(dto).forEach(System.out::println);
	     List<Customer>listentities=new ArrayList();
	     entity=new Customer();entity.setBillAmt(150000.0);
	     entity1=new Customer();entity1.setBillAmt(130000.0);
	     listentities.add(entity); listentities.add(entity1);
	     System.out.println(service.deleteGivenCustomes(listentities));
	     
	     //System.out.println(service.deleteAllCustomes());
	     //close container
	    ((ConfigurableApplicationContext) ctx).close();
	}

}

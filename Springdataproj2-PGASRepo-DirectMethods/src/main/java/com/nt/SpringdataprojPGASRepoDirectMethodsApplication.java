package com.nt;

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
public class SpringdataprojPGASRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerService service=null;
		CustomerDTO dto=null,dto1=null,dto2=null;
		List<CustomerDTO> listdto=null;
		//create container
		ctx=SpringApplication.run(SpringdataprojPGASRepoDirectMethodsApplication.class, args);
        //get service class object	
	     service=ctx.getBean("custService",CustomerService.class);
	    //service.fetchAllSortbyProperty(false, "billAmt").forEach(System.out::println);	
	    //service.fetchAllSortbyProperty(true, "cadd","cname","billAmt").forEach(System.out::println); 
	    //service.fecthDatByPageNoAndSize(3,2).forEach(System.out::println);
	     //service.fecthDatByPageNoAndSizeWithSort(1,3,true,"cname").forEach(System.out::println);
	    service.fetchRecordsByPagination(3);
	     
	     //close container
	    ((ConfigurableApplicationContext) ctx).close();
	}

}

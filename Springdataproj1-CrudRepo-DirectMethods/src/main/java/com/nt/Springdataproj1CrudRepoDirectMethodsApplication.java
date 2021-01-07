package com.nt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.service.CustomerService;

@SpringBootApplication
public class Springdataproj1CrudRepoDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerService service=null;
		CustomerDTO dto=null,dto1=null,dto2=null;
		List<CustomerDTO>listdto=null;
		Optional<CustomerDTO> odto=null;
		//create container
		ctx=SpringApplication.run(Springdataproj1CrudRepoDirectMethodsApplication.class, args);
        //get service class object	
	     service=ctx.getBean("custService",CustomerService.class);
	     try {
	    	 dto=new CustomerDTO();
	    	 dto.setCname("manoj");
	    	 dto.setCadd("hyd");
	    	 dto.setBillAmt(900000);
	    	 System.out.println(service.registerCustomer(dto));
	     }
	     catch(DataAccessException dae) {
	    	 dae.printStackTrace();
	     }
	     
	     dto=new CustomerDTO();
    	 dto.setCname("jagdeesh");dto.setCadd("delhi");dto.setBillAmt(350000);
    	 dto1=new CustomerDTO();
    	 dto1.setCname("manohar");dto1.setCadd("hyd");dto1.setBillAmt(150000);
    	 dto2=new CustomerDTO();
    	 dto2.setCname("harsita");dto2.setCadd("kadapa");dto2.setBillAmt(650000);
    	 try {
    	 //System.out.println(service.registerGroupCustomers(Arrays.asList(dto,dto1,dto2)));
         listdto=new ArrayList();
    	 listdto.add(dto);listdto.add(dto1);listdto.add(dto2);	
    	 //System.out.println(service.registerGroupCustomers(listdto));
		}
		
	     catch(DataAccessException dae) {
	    	 dae.printStackTrace();
	     }
	     //System.out.println(service.removeCustomerById(44));
	      //System.out.println(service.removeGivenCustomers(Arrays.asList(new CustomerDTO(41),new CustomerDTO(42),new CustomerDTO(43))));
	      /*listdto=new ArrayList();
	      listdto.add(new CustomerDTO(41));
	      listdto.add(new CustomerDTO(42));
	      listdto.add(new CustomerDTO(43));
	      System.out.println(service.removeGivenCustomers(listdto));
	     */
	     //service.fetchAllCustomers().forEach(System.out::println);
	     
	     //System.out.println(service.CountOfCustomers());
	     /*try {
	     odto=service.fetchCustomerById(20);
	     if(odto!=null) {
	    	 System.out.println(odto);
	     }
	     else
	    	 System.out.println("Record not found");
	     }//try
	    	 
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     */
	     
	     
	     
	     
	     //close container
	      ((ConfigurableApplicationContext) ctx).close();
	}

}

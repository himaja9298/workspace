package com.nt;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.UserDTO;
import com.nt.service.TelcomManagementService;

@SpringBootApplication
public class SpringDataproj10jPARepoAssociationMappingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TelcomManagementService service=null;
		
		//create container
		ctx=SpringApplication.run(SpringDataproj10jPARepoAssociationMappingApplication.class, args);
        //get service class object
		service=ctx.getBean("tmService",TelcomManagementService.class);
		service.getDataByJoins().forEach(row->{
			for(Object obj:row) {
				System.out.println(obj+" ");
			}
		});
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}

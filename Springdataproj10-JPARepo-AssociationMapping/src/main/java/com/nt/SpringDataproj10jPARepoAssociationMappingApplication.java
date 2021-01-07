package com.nt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.PhoneNumberDTO;
import com.nt.dto.UserDTO;
import com.nt.service.TelcomManagementService;

@SpringBootApplication
public class SpringDataproj10jPARepoAssociationMappingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TelcomManagementService service=null;
		UserDTO userdto=null;
		PhoneNumberDTO dto=null,dto1=null,dto2=null;
		Set<PhoneNumberDTO> phones=null;
		//create container
		ctx=SpringApplication.run(SpringDataproj10jPARepoAssociationMappingApplication.class, args);
        //get service class object
		service=ctx.getBean("tmService",TelcomManagementService.class);
		//create dto to add phonenumbers
		dto=new PhoneNumberDTO();
		dto.setMobileNo(5555555L);
		dto.setType("residence");
		dto.setProvider("airtel");
		dto1=new PhoneNumberDTO();
		dto1.setMobileNo(4444444L);
		dto.setType("home");
		dto.setProvider("idea");
		dto2=new PhoneNumberDTO();
		phones=new HashSet();
		phones.add(dto);phones.add(dto1);phones.add(dto2);
		userdto=new UserDTO();
		//insert data to userdto
		userdto.setName("mahi");
		userdto.setAddrs("hyd");
        userdto.setPhones(phones);
		
		//call methods
		System.out.println(service.registerCustomer(userdto));
		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}
